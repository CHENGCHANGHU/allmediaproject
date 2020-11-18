package com.seu.seumedia.service.impl;

import com.alibaba.fastjson.JSON;
import com.seu.seumedia.entity.Article_Info;
import com.seu.seumedia.entity.Article_picture;
import com.seu.seumedia.entity.User;
import com.seu.seumedia.mapper.AllArticleManagerMapper;
import com.seu.seumedia.mapper.UserMapper;
import com.seu.seumedia.model.Newsdisplay;
import com.seu.seumedia.service.Newsdisplay_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class Newsdisplay_Service_Impl implements Newsdisplay_Service{

    @Autowired
    AllArticleManagerMapper allArticleManagerMapper;
    @Autowired
    UserMapper userMapper;
    @Override
    public List<Newsdisplay> get_news(){
        List<Newsdisplay> newsdisplays = new ArrayList<>();
        List<Article_Info> article_infos = allArticleManagerMapper.selectInfoAllByStatus(2);
        for(int i=0;i<article_infos.size();i++){
            Newsdisplay news_display = new Newsdisplay();
            long user_id = article_infos.get(i).getUser_id();
            User user = userMapper.selectByPrimaryKey(user_id);
            news_display.setArticle_id(article_infos.get(i).getId());
            news_display.setVersion(article_infos.get(i).getVersion());
            Timestamp timestamp = article_infos.get(i).getPublished_by();
            if(timestamp != null) {
                Date date = new Date(timestamp.getTime());
                String time = JSON.toJSONStringWithDateFormat(date, "yyyy-MM-dd  HH:mm:ss");
                news_display.setPublished_by(time);
            }
            news_display.setTitle(article_infos.get(i).getTitle());
            if(user != null)
                news_display.setAuthor_name(user.getUsername());
            //只获取当前第一个图片
            List<Article_picture> article_pictureList
                    = allArticleManagerMapper.SelectPictureByIdVersion(article_infos.get(i).getId(), article_infos.get(i).getVersion());
            if(article_pictureList.size()!=0) {
                news_display.setPicture(article_pictureList.get(0));
            }
            newsdisplays.add(news_display);
        }
        return newsdisplays;
    }
}
