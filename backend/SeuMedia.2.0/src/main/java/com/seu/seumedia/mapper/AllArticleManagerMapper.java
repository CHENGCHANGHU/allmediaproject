package com.seu.seumedia.mapper;

import com.seu.seumedia.entity.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.sql.Timestamp;
import java.util.List;

@Repository
public interface AllArticleManagerMapper {

    Article_Info SelectInfoByIdVersion(@Param("article_id") long id, @Param("article_version") long version);
    Article_detail SelectDetailByIdVersion(@Param("article_id") long id, @Param("article_version") long version);
    List<Article_picture> SelectPictureByIdVersion(@Param("article_id") long id, @Param("article_version") long version);
    List<Article_vedio> SelectVedioByIdVersion(@Param("article_id") long id, @Param("article_version") long version);
    List<Article_Info> SelectInfoById(@Param("article_id") long id);
    List<Article_detail> SelectDetailById(@Param("article_id") long id);
    List<Article_picture> SelectPictureById(@Param("article_id") long id);
    List<Article_vedio> SelectVedioById(@Param("article_id") long id);

    Article_Info selectByAuthorId(@Param("author_id") long author_id);
    //插入操作
    int Insert_ArticleInfo(Article_Info article_info);
    int Insert_ArticleDetail( Article_detail article_detail);
    int Insert_ArticlePicture( Article_picture article_picture);
    int Insert_ArticleVedio( Article_vedio article_vedio);

    //删除返回结果
    int DeleteInfoByIdVersion(@Param("article_id") long id, @Param("article_version") long version);
    int DeleteDetailByIdVersion(@Param("article_id") long id, @Param("article_version") long version);
    int DeletePictureByIdVersion(@Param("article_id") long id, @Param("article_version") long version);
    int DeleteVedioByIdVersion(@Param("article_id") long id, @Param("article_version") long version);

    int DeleteInfoById(@Param("article_id") long id);
    int DeleteDetailById(@Param("article_id") long id);
    int DeletePictureById(@Param("article_id") long id);
    int DeleteVedioById(@Param("article_id") long id);
    //查找返回list
    List<Article_Info> selectInfoAll();
    List<Article_Info> selectInfoAllById(@Param("id") long id);
    List<Article_Info> selectInfoAllByStatus(int status);
    List<Article_Info> selectInfoAllByisDeleted(int isDeleted);

    //根据状态，时间来返回指定的数据组
    List<Article_Info> selectInfoAllByStatusMTime(@Param("user_id") int user_id, @Param("status") int status, @Param("start_time") Timestamp start_time, @Param("end_time") Timestamp end_time);
    List<Article_Info> selectInfoAllByStatusCTime(@Param("user_id") int user_id, @Param("status") int status, @Param("start_time") Timestamp start_time, @Param("end_time") Timestamp end_time);
    List<Article_Info> selectInfoAllByStatusPTime(@Param("user_id") int user_id, @Param("status") int status, @Param("start_time") Timestamp start_time, @Param("end_time") Timestamp end_time);

    int updatePublished_ById_version(@Param("article_id") long article_id, @Param("article_version") long article_version, @Param("published_by") Timestamp published_by);
    int updateStatusById_version(@Param("article_id") long article_id, @Param("article_version") long article_version, @Param("status") int status);

}