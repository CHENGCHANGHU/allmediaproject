package com.seu.seumedia.controller;

import com.alibaba.fastjson.JSONObject;
import com.seu.seumedia.entity.User;
import com.seu.seumedia.service.LoginService;
import com.seu.seumedia.service.RegistService;
import com.seu.seumedia.service.UpdateService;
import com.seu.seumedia.service.UserInfoService;
import com.seu.seumedia.utils.HashCode;
import com.seu.seumedia.utils.HttpInfor;
import com.seu.seumedia.utils.SavePicture;
import com.seu.seumedia.utils.getCurrentDate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.ui.Model;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Zhangpenghui
 * @version 1.0
 * @since 2020/11/17
 */
@Controller   /*@RestController*/
@Api(value = "测试")
@RequestMapping("/SEUMedia")
public class Usercontroller {
    @Autowired
    private UserInfoService userService;
    @Autowired
    private RegistService registService;
    @Autowired
    private LoginService loginService;
    @Autowired
    private UpdateService updateService;
   /* @RequestMapping("getUser/{id}")
    public String GetUser(@PathVariable int id){
        return userService.selectByPrimaryKey(id).toString();
    }*/

    /*@RequestMapping("getUser/{id}")
    public Map<String,Object> getUserInfor(@PathVariable long id){
        return userService.selectByPrimaryKey(id);

    }*/
  /*  @RequestMapping("testJS")
    public String testFun() {
        System.out.println(HashCode.getHashCode("Hello world!"));
        return "testJS";
    }
*/
   /* @ApiOperation(value = "自己测试使用，不用管")
    @RequestMapping(value = "regist", method = RequestMethod.GET)
    public String registFromHtml() {
        return "regist";
    }*/

    @ApiOperation(value = "用户注册(给前端使用)  返回值 成功:{message:无错误,status:1}  失败:{message:注册失败,status:0}")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "username", value = "用户名", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "password", value = "密码", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "phone", value = "手机号", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "email", value = "邮箱号", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "userStatus", value = "用户身份 0:普通用户  1:自媒体用户  2:管理员用户", required = true, dataType = "String")
    })
    @RequestMapping(value = "/regist")
    @ResponseBody
//@RequestParam(value="username") String username,@RequestParam(value="password") String password,@RequestParam(value="phone") String phone,@RequestParam(value = "email")String email,
    public String regist(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password, @RequestParam(value = "phone") String phone, @RequestParam(value = "email") String email, @RequestParam(value = "userStatus") String userStatus, HttpServletRequest request, Model model) {
        //String username = request.getParameter("username");
        //String password = request.getParameter("password");
        //String phone = request.getParameter("phone");
        //String email = request.getParameter("email");
        //String userStatus = request.getParameter("userStatus");
        //System.out.println(userStatus);
        Map<String, String> mapHttpHeader = HttpInfor.getHeadersInfo(request);
        JSONObject object = new JSONObject();
        //User user =new User(1,password,username,"wangeu",true,"123456778",new Date(),email,phone,"123","123","123",new Date(),new Date());
        try {
            Date date = getCurrentDate.getCurrentDate();
            User user = new User(1, username, password, email, phone, date, date, (byte) 0, userStatus);
            Map<String, String> map = registService.regist(user, mapHttpHeader);
            model.addAttribute("result", map.get("result"));
            model.addAttribute("message", map.get("message"));
            model.addAttribute("from", "来自注册界面的信息");
            object.put("message", map.get("message"));
            object.put("status", "1");
            return object.toJSONString();
        } catch (Exception e) {
            e.printStackTrace();
            object.put("message", "注册失败");
            object.put("status", "0");
            return object.toJSONString();

        }


    }


   /*@ApiOperation(value = "自己测试使用，不用管")
    @RequestMapping(value = "loginFromHtml", method = RequestMethod.GET)
    public String loginHtml() {
        return "login";
    }*/

    //@RequestParam(value="userStatus",required=true)String userStatus,
    @ApiOperation(value = "用户登录(给前端使用)  返回值 成功:user对象的JSON形式 失败:null ")
    @RequestMapping(value = "/login")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "username", value = "用户名:可以是手机号或邮箱", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "password", value = "密码", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "userStatus", value = "用户身份 0:普通用户  1:自媒体用户  2:管理员用户", required = true, dataType = "String")
    })
    @ResponseBody
    public String login(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password, @RequestParam(value = "userStatus") String userStatus, Model model, HttpServletRequest request) throws Exception {
        /*mod:0 电话登录；mod:1 email登录*/
        //String username = request.getParameter("phone");
        //String password = request.getParameter("password");
        //String userStatus = request.getParameter("userStatus");
        //System.out.println(username);
        //System.out.println(password);
        Map<String, String> mapHttpHeader = HttpInfor.getHeadersInfo(request);
        //Map<String, String> mapHttpHeader = new HashMap<>();
        String mailRex = "^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$";  /*email正则表达式*/
        int mod;            /*记录登录方式 mod:0 电话登录；mod:1 email登录*/
        Pattern pattern = Pattern.compile(mailRex);
        Matcher matcher = pattern.matcher(username);
        if (matcher.matches()) { /*email*/
            mod = 1;
        } else {  /*phone*/
            mod = 0;
        }
        //System.out.println(userStatus);
        /*Map<String, String> map = loginService.login(username, password, userStatus, mod, mapHttpHeader);
        model.addAttribute("result", map.get("result"));
        model.addAttribute("message", map.get("message"));
        model.addAttribute("from", "来自登录界面的信息");*/
        //User user = loginService.login(username, password, userStatus, mod, mapHttpHeader);
        return loginService.login(username, password, userStatus, mod, mapHttpHeader);
        //return JSONUtil.Entity2JSON(user);


    }


    @ApiOperation(value = "自己测试使用，不用管")
    @RequestMapping(value = "/uploadFile", method = RequestMethod.GET)
    public String uploadFileHtml() {
        return "uploadFile";
    }

    @ApiOperation(value = "根据用户id更新用户信息(给前端使用) 返回值 成功:{message:成功},失败:{message:失败}")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "用户id", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "username", value = "用户名", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "password", value = "密码", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "phone", value = "手机号", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "email", value = "邮箱", required = true, dataType = "String")
            //@ApiImplicitParam(paramType = "form", name = "head_portrait", value = "头像", required = true, dataType = "file")
    })
    @ResponseBody
    @RequestMapping(value = "/updateById", headers = "content-type=multipart/form-data", method = RequestMethod.POST)
    public String updateById(@RequestParam(value = "id", required = true) String id, @RequestParam(value = "username") String username, @RequestParam(value = "password") String password, @RequestParam(value = "phone") String phone, @RequestParam(value = "email") String email, @RequestParam(value = "head_portrait", required = true) MultipartFile head_portrait) throws Exception {
        long Id = Long.parseLong(id);
        JSONObject obj = new JSONObject();
        if (head_portrait != null) {
            String fileName = head_portrait.getOriginalFilename();//得到文件的原始名称
            String type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;//得到文件类型
            if (type != null) {
                if ("GIF".equals(type.toUpperCase()) || "PNG".equals(type.toUpperCase()) || "JPG".equals(type.toUpperCase())) {
                    Resource resource = new ClassPathResource("");
                    //String projectPath = resource.getFile().getAbsolutePath() + "\\static\\img";
                    String projectPath = "E:/全媒体/demo/src/main/resources/static/head_portrait/";
                    String pictureName = UUID.randomUUID() + "." + type;
                    String picturePath = projectPath + pictureName;
                    String pictureUrl = "http://223.3.70.19:8080/head_portrait/" +pictureName;
                    password = HashCode.getHashCode(password);
                    if (updateService.updateById(Id, username, password, phone, email, pictureUrl) && SavePicture.SavePictureToDir(picturePath, head_portrait)) {
                        obj.put("message", "修改信息成功");
                    } else {
                        obj.put("message", "修改信息失败");
                    }
                } else {
                    obj.put("message", "失败，头像文件类型不符合要求");
                }
            } else {
                obj.put("message", "失败，头像文件类型为空");
            }
        } else {
            obj.put("message", "失败，头像文件为空");
        }

        return obj.toJSONString();
    }

    @ApiOperation(value = "根据用户id修改用户头像(给前端使用) 返回值 成功:{message:成功},失败:{message:失败}")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "用户id", required = true, dataType = "String")
    })
    @ResponseBody
    @RequestMapping(value = "/updateHpById", headers = "content-type=multipart/form-data", method = RequestMethod.POST)
    public String updateHpById(@Param(value = "id") String id, @RequestParam(value = "head_portrait", required = true) MultipartFile head_portrait) throws Exception {
        long Id = Long.parseLong(id);
        JSONObject obj = new JSONObject();
        if (head_portrait != null) {
            String fileName = head_portrait.getOriginalFilename();//得到文件的原始名称
            String type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;//得到文件类型
            if (type != null) {
                if ("GIF".equals(type.toUpperCase()) || "PNG".equals(type.toUpperCase()) || "JPG".equals(type.toUpperCase())) {
                    String projectPath = "E:/全媒体/demo/src/main/resources/static/head_portrait/";
                    String pictureName = UUID.randomUUID() + "." + type;
                    String picturePath = projectPath + pictureName;
                    String pictureUrl = "http://223.3.70.19:8080/head_portrait/" +pictureName;
                    if (updateService.updateHpById(Id, pictureUrl) && SavePicture.SavePictureToDir(picturePath, head_portrait)) {
                        obj.put("message", "修改信息成功");
                    } else {
                        obj.put("message", "修改信息失败");
                    }

                } else {
                    obj.put("message", "失败，头像文件类型不符合要求");
                }
            } else {
                obj.put("message", "失败，头像文件类型为空");
            }
        } else {
            obj.put("message", "失败，头像文件为空");
        }
        return obj.toJSONString();
    }




    @ApiOperation(value = "根据用户id查找用户信息(给前端使用) 返回值 成功:user对象的JSON形式,失败:null")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "用户id", required = true, dataType = "String")
    })
    @ResponseBody
    @RequestMapping(value = "/selectById", method = RequestMethod.GET)
    public String selectById(HttpServletRequest request) {
        long id = Long.parseLong(request.getParameter("id"));
        //System.out.println(loginService.selectById(id));
        return loginService.selectById(id);
    }






 /*   @RequestMapping("uploadFile")
    public String Upload() {
        return "uploadFile";
    }

    @RequestMapping(value = "/uploadFromHtml", method = RequestMethod.POST)
    public String UploadFromHtml(@RequestParam("picture") MultipartFile picture, Model model) {

        if (picture != null) {
            String fileName = picture.getOriginalFilename();//得到文件的原始名称
            System.out.println(fileName);
            String type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;//得到

            if (type != null) {
                if ("GIF".equals(type.toUpperCase()) || "PNG".equals(type.toUpperCase()) || "JPG".equals(type.toUpperCase())) {
                    //判断图片类型是否为png,jpg和gif
                    if (SavePicture.SavePictureToDir(picture)) {
                        model.addAttribute("result", "图片保存成功");
                        model.addAttribute("message", "图片保存成功");
                        model.addAttribute("from", "来自上传界面的信息");
                    } else {
                        model.addAttribute("result", "服务器异常，保存图片失败");
                        model.addAttribute("message", "服务器异常，保存图片失败");
                        model.addAttribute("from", "来自上传界面的信息");
                        // System.out.println("服务器异常，保存图片失败");
                    }

                } else {
                    model.addAttribute("result", "保存图片失败");
                    model.addAttribute("message", "文件格式错误");
                    model.addAttribute("from", "来自上传界面的信息");
                }
            } else {
                model.addAttribute("result", "保存图片失败");
                model.addAttribute("message", "图片类型不能为空");
                model.addAttribute("from", "来自上传界面的信息");
                // System.out.println("图片类型不正确");
            }


        } else {
            model.addAttribute("result", "文件不能为空！");
            model.addAttribute("message", "文件不能为空！");
            model.addAttribute("from", "来自上传界面的信息");
            //System.out.println("文件不能为空！");
        }
        return "display";
    }
    */

    /*@RequestMapping("getArticlesInfo")
    public String getArticles(HttpServletRequest request,Model model){

    }*/


}