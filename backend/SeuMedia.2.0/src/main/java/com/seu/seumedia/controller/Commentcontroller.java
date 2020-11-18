package com.seu.seumedia.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.seu.seumedia.entity.Comment;
import com.seu.seumedia.entity.ReceivedComment;
import com.seu.seumedia.service.CommentService;
import com.seu.seumedia.utils.IpUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
/**
 * @author liuzijian
 * @version 1.0
 * @since 2020/8/28 20:25
 */
@Controller
@Api(value = "CommentController|实现评论功能的控制器")
@RequestMapping("/comment")
public class Commentcontroller {

    private final static Logger logger = LoggerFactory.getLogger(Commentcontroller.class);
    @Autowired
    private CommentService commentService;

//    @GetMapping("/hello")
//    @ResponseBody
//    @ApiOperation(value="测试连接", notes="测试前后端的连接")
//    public String hello() {
//        return "hello world";
//    }

    @ResponseBody
    @ApiOperation(value="评论添加功能", notes="根据评论内容、评论者id等信息增加评论")
    @PostMapping(value = "/addComment")
//    @RequestMapping(value = "/addComment", method = RequestMethod.GET)
    public String addComment(ReceivedComment comment, HttpServletRequest request) {
        String userIP = IpUtil.getIpAddr(request);
        try {
            commentService.addComment(comment, userIP);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @PostMapping(value = "/showAll")
//    @RequestMapping(value = "/showAll", method = RequestMethod.GET)
    @ApiOperation(value="返回评论功能", notes="根据文章Id返回所有一二级评论", response = String.class)
    @ApiImplicitParam(paramType="query", name = "article_id", value = "文章Id", required = true, dataType = "String")
    @ResponseBody
    public String showAllComment(String article_id) throws JsonProcessingException {
        List<Comment> commentList= commentService.showAllCommentByArticle(article_id);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(commentList);
    }

    @PostMapping(value = "/showUserAll")
//    @RequestMapping(value = "/showUserAll", method = RequestMethod.GET)
    @ApiOperation(value="返回评论功能", notes="根据用户Id返回所有评论", response = String.class)
    @ApiImplicitParam(paramType="query", name = "author_id", value = "用户Id", required = true, dataType = "String")
    @ResponseBody
    public String showUserComment(String author_id) throws JsonProcessingException {
        System.out.println(author_id);
        List<Comment> commentList= commentService.showAllCommentByUser(author_id);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(commentList);
    }
}
