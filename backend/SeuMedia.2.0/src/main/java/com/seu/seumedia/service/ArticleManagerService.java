package com.seu.seumedia.service;

import com.seu.seumedia.entity.Article_detail;
import com.seu.seumedia.entity.Article_Info;
import com.seu.seumedia.entity.Article_picture;
import com.seu.seumedia.entity.Article_vedio;
import java.sql.Timestamp;
import java.util.List;

public interface ArticleManagerService {
    //从作者角度考虑需求
    //保存文章（包括info，detail，图片，视频）
    int saveArticle(Article_Info article_info, Article_detail article_detail, Article_picture article_picture, Article_vedio article_vedio);

//    根据输入的id，version等消息返回实体

    boolean deletedById_verison(long id, long version);
    boolean deletedById(long article_id);
    //更新文章（包括info，detail，图片，视频）
    int updateArticle(Article_Info article_info, Article_detail article_detail, Article_picture article_picture, Article_vedio article_vedio);

    //第三方角度进行查看
    Article_Info selectByAuthorId(int author_id);


    // return all article info from tbl_article_info
    List<Article_Info> getInfoAll();
    // return all article info when id is right
    List<Article_Info> getInfoAllById(long id);
    //return all article info when status from tbl_article_info and category from tbl_article_detail are right
    List<Article_Info> getInfoAllByStatus_user_category_time(int user_id, int status, String category, Timestamp start_timestamp, Timestamp end_timestamp);
    List<Article_Info> getInfoAllByisDeleted();
    List<Article_Info> getInfoAllByTop_5_version();
    List<Article_Info> getInfoAllByStatus(int status);

    Article_Info selectInfoByIdVersion(long id,long version);
    Article_detail selectDetailByIdVersion(long article_id,long article_version);
    List<Article_picture> selectPictureByIdVersion(long article_id,long article_version);
    List<Article_vedio> selectVedioByIdVersion(long article_id,long article_version);

    //    审核状态暂且不动
//    int selectStatus(Long id);   //查看当前最新的version
    boolean updateStatus(long id, long version, int status);
    //    int article_maxid_return();





}
