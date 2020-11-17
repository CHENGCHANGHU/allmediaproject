package com.seu.seumedia.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.seu.seumedia.entity.ArticleReceived;
import com.seu.seumedia.entity.Article_detail;
import com.seu.seumedia.entity.ReceivedBody;
import com.seu.seumedia.entity.RequestForArticle;
import com.seu.seumedia.service.RichTextService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/10/29 11:30
 */
@Controller
@RequestMapping("/article")
@Api(value = "ArticleController|实现富文本功能的控制器")
public class RichTextcontroller {
    @Autowired
    private RichTextService richTextService;


    @ApiOperation(value="保存富文本编辑器文本", notes="将富文本编辑器需要保存的信息保存到数据库当中。如果数据库中已有此文章，则直接返回。如果是对数据库中已有文章的修改，则保存修改后的文章")
    @PostMapping("/addArticle")
    @ResponseBody
    public String addArticle(@RequestBody ReceivedBody body){
        ArticleReceived article = body.getData();
        System.out.println(article);
        richTextService.addArticle(article);
        return "新增成功";
    }

    @ApiOperation(value="保存修改的文章", notes="将富文本编辑器修改后的信息保存到数据库当中。")
    @PostMapping("/updateArticle")
    @ResponseBody
    public String updateArticle(@RequestBody Article_detail articleDetail){
        try {
            richTextService.updateArticle(articleDetail);
        } catch (Exception e) {
            e.printStackTrace();
            return "修改失败，请与管理员联系";
        }finally {
            System.out.println(articleDetail);
        }
        return "修改成功";
    }

    @ApiOperation(value="返回已有文章", notes="根据文章id和文章版本返回文章")
    @GetMapping("/returnArticle")
    @ResponseBody
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "article_id", value = "文章Id", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "article_version", value = "文章版本", required = true, dataType = "String")
    })
    public String returnArticleByIdAndVer(String article_id, String article_version) throws JsonProcessingException {
        RequestForArticle request = new RequestForArticle();
        request.setArticle_id(article_id);
        request.setArticle_version(article_version);
        Article_detail articleDetail = richTextService.returnArticle(request);
        return new ObjectMapper().writeValueAsString(articleDetail);
    }



//    @ApiOperation(value="测试功能", notes="测试前后端连接")
//    @ApiImplicitParams({
//            @ApiImplicitParam(paramType="query", name = "str", value = "文本内容", required = true, dataType = "String")
//    })
//    @GetMapping("test")
//    @ResponseBody
//    public String test(String str){
//        System.out.println(str);
//        return "连接成功";
//    }

}

