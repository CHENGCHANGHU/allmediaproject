package com.seu.seumedia.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import com.seu.seumedia.entity.Article_Info;
import com.seu.seumedia.entity.Article_detail;
import com.seu.seumedia.model.Content;
import com.seu.seumedia.service.ArticleManagerService;
import com.seu.seumedia.service.ContentReturn_Service;
import com.seu.seumedia.service.Newsdisplay_Service;
import com.seu.seumedia.model.Newsdisplay;

@Api(value = "Articlecontroller|主要用来操控文章的控制器。包括文章的增删改查")
@Controller
public class Articlecontroller {

    @Autowired
    ArticleManagerService articleManagerService;
    @Autowired
    Newsdisplay_Service newsdisplay_Service;
    @Autowired
    ContentReturn_Service contentReturn_service;

    ////    返回审核的文章   :0 草稿 ，1 待审核， 2审核通过， 3审核失败， 4. 已删除 , 5 全部数据
    @ResponseBody
    @RequestMapping(value = "/search/status", method = RequestMethod.GET)
    @ApiOperation(value = "此接口内容展示和审核状态两个接口共同使用",
            notes = "status = {草稿:0,待审核:1， 审核通过:2， 审核失败:3， 已删除:4 , 全部数据:4, default:5}" +
                    "user_id = {正常用户使用:>0, 代表进入审核状态：-1, default:-1}" +
                    "catgory = {default:全部}" +
                    "start_time = {default:1970-01-01 00:00:00} + end_time = {default:2030-01-01 00:00:00}")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "user_id", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "status", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "category", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "start_time", required = true, dataType = "Timestamp"),
            @ApiImplicitParam(paramType = "query", name = "end_time", required = true,  dataType = "Timestamp")
    })
    public String searchByStatus(@RequestParam(defaultValue = "-1", required = true) int user_id,
                                 @RequestParam(defaultValue = "5", required = true) int status,
                                 @RequestParam(defaultValue = "全部", required = true) String category,
                                 @RequestParam(defaultValue = "1970-01-01 00:00:00", required = true) Timestamp start_time,
                                 @RequestParam(defaultValue =  "2030-01-01 00:00:00", required = true) Timestamp end_time,
                                 Model model){
        List<Article_Info> articleInfoList;
        if(status > 5){
            System.out.print( "status value is error");
        }
        articleInfoList = articleManagerService.getInfoAllByStatus_user_category_time(user_id, status, category, start_time, end_time);
        ObjectMapper ojson = new ObjectMapper();
        String listJson = null;
        try {
            listJson = ojson.writeValueAsString(articleInfoList);
            System.out.print(listJson);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return listJson;
    }

    //     返回5篇已经审核完成的文章，并且是最新版
    @ResponseBody
    @RequestMapping(value = "/search/return_finish_status", method = RequestMethod.GET)
    @ApiOperation(value = "返回新闻展示需要的审核过的所有文章")
    public String get_news(){
        List<Newsdisplay> list = newsdisplay_Service.get_news();
        ObjectMapper ojson = new ObjectMapper();
        String listJson = null;
        try {
            listJson = ojson.writeValueAsString(list);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(listJson);
        return listJson;
    }

    @ResponseBody
    @RequestMapping(value = "/search/return_by_id_version", method = RequestMethod.GET)
    @ApiOperation(value = "根据获取的id和version返回对应的Content对象，包括正文图片视频")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "article_id", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "article_version", required = true, dataType = "Integer")
    })
    public String get_Content_Byidversion(@RequestParam(value = "article_id", required = true) int article_id, @RequestParam(value = "article_version", required = true) int article_version, Model model){
        Content content = contentReturn_service.get_content(article_id, article_version);
        ObjectMapper ojson = new ObjectMapper();
        String json = null;
        try {
            json = ojson.writeValueAsString(content);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.print(json);
        return json;
    }

    @ResponseBody
    @RequestMapping(value = "/delete/deleted_by_Id_version", method = RequestMethod.GET)//删除某篇文章，依据文章id和文章版本信息
    @ApiOperation(value = "删除对应id和version的article")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "article_id", required = true, dataType = "long"),
            @ApiImplicitParam(paramType = "query", name = "article_version", required = true, dataType = "long"),
    })
    public boolean deleteById_version(@RequestParam(value = "article_id", required = true) long id, @RequestParam(value = "article_version", required = true) long version, Model model){
        if(articleManagerService.selectInfoByIdVersion(id ,version) == null){
            model.addAttribute("message", "The article is not exist");
            return false;
        }
        return articleManagerService.deletedById_verison(id, version);
    }

    @ResponseBody
    @RequestMapping(value = "/article_pass", method = RequestMethod.GET)
    @ApiOperation(value = "返回对于审核状态的修改是否成功")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "article_id", required = true, dataType = "long"),
            @ApiImplicitParam(paramType = "query", name = "article_version", required = true, dataType = "long"),
            @ApiImplicitParam(paramType = "query", name = "status", required = true, dataType = "Integer")
    })
    public boolean check_article(@RequestParam(value = "article_id", required = true) long article_id,
                                 @RequestParam(defaultValue = "1", required = true) long article_version,
                                 @RequestParam(value = "status", required = true) int status, Model model){
        if(articleManagerService.updateStatus(article_id,  article_version, status)){
            model.addAttribute("message", "check status is modified successful!!!");
            return true;
        }else {
            model.addAttribute("message", "check status is modified failed !!!");
            return false;
        }
    }
}
