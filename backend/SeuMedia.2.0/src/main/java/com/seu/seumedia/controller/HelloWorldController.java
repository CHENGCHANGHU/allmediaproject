package com.seu.seumedia.controller;

import com.seu.seumedia.entity.Article_Info;
import com.seu.seumedia.entity.Article_detail;
import com.seu.seumedia.service.ArticleManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class HelloWorldController {

    @Autowired
    ArticleManagerService articleManagerService;
    @RequestMapping("/hello")
    public String sayHello() {
        return "Hello,World!";
    }

    @RequestMapping("/getDemo")
    public List<Article_Info> getUser() {
        byte a =4;
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Article_Info article_info = new Article_Info();
        Article_Info article_info1 = new Article_Info();
        List<Article_Info> article_infoList = new ArrayList();
        article_info.setId(1);
        article_info.setTitle("Good Student");
        article_info.setLevel(a);
        article_info.setPublished_by(timestamp);
        article_info.setUser_id(3);
        article_info1.setId(1);
        article_info1.setTitle("Good Student");
        article_info1.setLevel(a);
        article_info1.setPublished_by(timestamp);
        article_info1.setUser_id(3);
        article_infoList.add(article_info);
        article_infoList.add(article_info1);
        return article_infoList;
    }
    @RequestMapping("/index")
    public String index(Model model) {
        return "index"; }
    @RequestMapping(value="/modify")
    public String modify(Model model) {
        return "modify";}

    //文章内容的添加
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("message", "Type in info to add Article");
        return "add";
    }

    //    单纯的实现添加对于info表格的插入
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addArticle(@RequestParam(name = "article_id" ,required = true) int article_id,
                             @RequestParam(name = "version" ,required = true) int version,
                             @RequestParam(name = "title" , required = true) String title,
                             @RequestParam(name = "level" , required = true) byte level,
                             @RequestParam(name = "userid" , required = true) long userid,
                             @RequestParam(name = "abstracts" , required = true) String abstracts,
                             @RequestParam(name = "keywords" , required = true) String keywords,
                             @RequestParam(name = "content" , required = true) String content,
                             @RequestParam(name = "source" , required = true) String source,
                             @RequestParam(name = "topic" , required = true) String topic,
                             Model model){
        Article_Info article_info = new Article_Info();
        Article_detail article_detail = new Article_detail();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        article_info.setId(article_id);
        article_info.setUser_id(userid);
        article_info.setLevel(level);
        article_info.setVersion(version);
        article_info.setTitle(title);
        article_info.setCommited_by(timestamp);
        article_info.setModified_by(null);
        article_info.setPublished_by(null);
        article_info.setCreate_by(timestamp);
        article_info.setStatus(1);
        //--------------------------------------------------------------------------------------------
        article_detail.setTitle(title);
        article_detail.setArticle_id(article_id);
        article_detail.setArticle_version(version);
        article_detail.setAuthor_id(userid);
        article_detail.setAbstracts(abstracts);
        article_detail.setKeywords(keywords);
        article_detail.setContent(content);
        article_detail.setSource(source);
        article_detail.setTopic(topic);
        articleManagerService.saveArticle(article_info, article_detail,null,null);
        model.addAttribute("message", "Successfully add one more article");
        return "add";
    }

    //文章的删除操作
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(Model model){
        model.addAttribute("message", "Type in info to delete Article");
        return "delete";
    }

    //文章的查询操作
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(Model model){
        List<Article_Info> article_infos = articleManagerService.getInfoAll();
        model.addAttribute("articleList", article_infos);
        List<Field> fields = Arrays.asList(Article_Info.class.getDeclaredFields());
        model.addAttribute("fields", fields);
        return "search";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchById_version(@RequestParam(value = "id",required = true) long id, Model model){
        if(id==0){
            search(model);
        }
        List<Article_Info> article_infos = articleManagerService.getInfoAllById(id);
        model.addAttribute("articleList", article_infos);
        List<Field> fields = Arrays.asList(Article_Info.class.getDeclaredFields());
        model.addAttribute("fields", fields);
        return "search";
    }
}