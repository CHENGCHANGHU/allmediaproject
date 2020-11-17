package com.seu.seumedia.service.impl;

import com.seu.seumedia.entity.*;
import com.seu.seumedia.mapper.AllArticleManagerMapper;
import com.seu.seumedia.mapper.UserMapper;
import com.seu.seumedia.model.Content;
import com.seu.seumedia.service.ContentReturn_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ContentReturn_Service_Impl implements ContentReturn_Service{
    @Autowired
    AllArticleManagerMapper allArticleManagerMapper;
    @Autowired
    UserMapper userMapper;
    @Override
    public Content get_content(long id, long version){
        Article_Info article_info = allArticleManagerMapper.SelectInfoByIdVersion(id, version);
        Article_detail article_detail = allArticleManagerMapper.SelectDetailByIdVersion(id,version);
        List<Article_picture> article_pictureList = allArticleManagerMapper.SelectPictureByIdVersion(id, version);
        List<Article_vedio> article_vedioList = allArticleManagerMapper.SelectVedioByIdVersion(id, version);
        String user_name = null;
        long user_id = article_info.getUser_id();
        try {
            User user = userMapper.selectByPrimaryKey(user_id);
            if (user != null)
                user_name = user.getUsername();
        }catch (NullPointerException e){
            System.out.print("java.lang.NullPointerException");
        }
        Content content = new Content();
        content.setArticle_content(article_detail, article_info, user_name);
        content.setArticle_pictureList(article_pictureList);
        content.setArticle_vedios(article_vedioList);
        return content;
    }
}
