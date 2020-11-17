package com.seu.seumedia.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.seu.seumedia.entity.Article_Info;
import com.seu.seumedia.entity.Article_detail;
import com.seu.seumedia.entity.Article_picture;
import com.seu.seumedia.entity.Article_vedio;

import java.util.List;

public class Content {
    @JSONField
    private Article_Content article_content;
    @JSONField
    private List<Article_picture> article_pictureList;
    @JSONField
    private List<Article_vedio> article_vedios;

    public Article_Content getArticle_content() {
        return article_content;
    }
    public void setArticle_content(Article_detail article_detail, Article_Info article_info, String username) {
        Article_Content article_content = new Article_Content();
        if(article_detail.getId() != 0)
            article_content.setId(article_detail.getId());
        if(article_detail.getArticle_version() != 0)
            article_content.setArticle_version(article_detail.getArticle_version());
        if(article_detail.getAbstracts() != null)
            article_content.setAbstracts(article_detail.getAbstracts());
        if(article_detail.getArticle_id() != 0)
            article_content.setArticle_id(article_detail.getArticle_id());
        if(article_detail.getAuthor_id() != 0)
            article_content.setAuthor_id(article_detail.getAuthor_id());
        if(article_detail.getContent() != null)
            article_content.setContent(article_detail.getContent());
        if(article_detail.getKeywords() != null)
            article_content.setKeywords(article_detail.getKeywords());
        if(article_detail.getTopic() != null)
            article_content.setTopic(article_detail.getTopic());
        if(article_detail.getSource() != null)
            article_content.setSource(article_detail.getSource());
        if(article_detail.getTitle() != null)
            article_content.setTitle(article_detail.getTitle());
        if(article_detail.getCategory() != null)
            article_content.setCategory(article_detail.getCategory());
        if(article_detail.getOriginality() != null)
            article_content.setOriginality(article_detail.getOriginality());
        if(article_detail.getCopyright() != null)
            article_content.setCopyright(article_detail.getCopyright());
        if(article_detail.getSubcategory() != null)
            article_content.setSubcategory(article_detail.getSubcategory());
        if(article_detail.getIdDeleted() != 0)
            article_content.setIdDeleted(article_detail.getIdDeleted());
        if(article_info.getCommited_by() != null)
            article_content.setCommited_time(article_info.getCommited_by());
        if(article_info.getLevel() != 0)  //等级设置0以下无效
            article_content.setLevel(article_info.getLevel());
        if(article_info.getPublished_by() != null)
            article_content.setPublished_time(article_info.getPublished_by());
        if(username!= null)
            article_content.setAuthor_name(username);
        this.article_content =article_content;
    }
    public void setArticle_pictureList(List<Article_picture> article_pictureList) {
        this.article_pictureList = article_pictureList;
    }
    public void setArticle_vedios(List<Article_vedio> article_vedios) {
        this.article_vedios = article_vedios;
    }
    public List<Article_picture> getArticle_pictureList() {
        return article_pictureList;
    }
    public List<Article_vedio> getArticle_vedios() {
        return article_vedios;
    }
}
