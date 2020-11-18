package com.seu.seumedia.service.impl;

import com.seu.seumedia.entity.Article_Info;
import com.seu.seumedia.entity.Article_detail;
import com.seu.seumedia.entity.Article_picture;
import com.seu.seumedia.entity.Article_vedio;
import com.seu.seumedia.mapper.AllArticleManagerMapper;
import com.seu.seumedia.service.ArticleManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.*;


@Service
public class ArticleManagerServiceImpl implements ArticleManagerService {

    @Autowired
    AllArticleManagerMapper allArticleManagerMapper;

    @Override
    public int saveArticle(Article_Info article_info, Article_detail article_detail, Article_picture article_picture, Article_vedio article_vedio) {
        int h1 = allArticleManagerMapper.Insert_ArticleInfo(article_info);
//        int h2 =allManagerMapper.Insert_ArticleDetail(article_detail);
//        return h1 & h2;
        return h1;
    }

    @Override
    public int updateArticle(Article_Info article_info, Article_detail article_detail, Article_picture article_picture, Article_vedio article_vedio) {
        return 0;
    }

    @Override
    public Article_Info selectByAuthorId(int author_id) {
        return null;
    }


    @Override
    public List<Article_Info> getInfoAll() {
        return allArticleManagerMapper.selectInfoAll();
    }

    @Override
    public List<Article_Info> getInfoAllById(long id) {
        return allArticleManagerMapper.selectInfoAllById(id);
    }

    @Override
    public List<Article_Info> getInfoAllByStatus_user_category_time(int user_id, int status, String category, Timestamp start_time, Timestamp end_time) {
        List<Article_Info> article_infos = new ArrayList<>();
        if(user_id == -1){
            System.out.print("进入审核状态，则status废弃，改用status=1");
            status = 1;
            List<Article_Info> article_infosC = allArticleManagerMapper.selectInfoAllByStatus(status);
            article_infosC = sort_Dtime(article_infosC, "C");
            return article_infosC;
        }
        if (status == 5) {
            //time is modify_time
//            List<Article_Info> article_infos0 = articleManagerMapper.selectInfoAllByStatusMTime(user_id, 0, start_time, end_time);
//            article_infos = sort_Dtime(article_infos, "M");
            // time is commit time
            List<Article_Info> article_infos1 = allArticleManagerMapper.selectInfoAllByStatusCTime(user_id, 1, start_time, end_time);
            article_infos1 = sort_Dtime(article_infos1, "C");
            // time is publish time
            List<Article_Info> article_infos2 = allArticleManagerMapper.selectInfoAllByStatusPTime(user_id, 2, start_time, end_time);
            article_infos2 = sort_Dtime(article_infos2, "P");
            // time is commit time
            List<Article_Info> article_infos3 = allArticleManagerMapper.selectInfoAllByStatusCTime(user_id, 3, start_time, end_time);
            article_infos3 = sort_Dtime(article_infos3, "C");
            // time is commit time
//            List<Article_Info> article_infos4 = allManagerMapper.selectInfoAllByStatusCTime(user_id,4, start_time, end_time);
//            article_infos.addAll(article_infos0);
            article_infos.addAll(article_infos1);
            article_infos.addAll(article_infos2);
            article_infos.addAll(article_infos3);
//            article_infos.addAll(article_infos4);
        } else {
            if (status == 0) {
                article_infos = allArticleManagerMapper.selectInfoAllByStatusMTime(user_id, status, start_time, end_time);
                article_infos = sort_Dtime(article_infos, "M");
            } else if (status == 2) {
                article_infos = allArticleManagerMapper.selectInfoAllByStatusPTime(user_id, status, start_time, end_time);
                article_infos = sort_Dtime(article_infos, "P");
            } else {
                article_infos = allArticleManagerMapper.selectInfoAllByStatusCTime(user_id, status, start_time, end_time);
                article_infos = sort_Dtime(article_infos, "C");
            }
        }
        if (category.equals("全部")) {
            return article_infos;
        }
        article_infos = check_category(article_infos, category);
        return article_infos;
    }

    @Override
    public List<Article_Info> getInfoAllByisDeleted() {
        int isDeleted = 0;
        return allArticleManagerMapper.selectInfoAllByisDeleted(isDeleted);
    }

    @Override
    public List<Article_Info> getInfoAllByTop_5_version() {
        //only return 5 the article_info where status = 1
        //默认 审核结束后的基本不会更改，所以更改的只会是小部分，可以直接返回所有article_info。
        List<Article_Info> list = allArticleManagerMapper.selectInfoAllByStatus(2);
//        int number = 5;
        for (int i = 0; i < list.size(); i++) {
            if (i < list.size() - 1) {
                if (list.get(i + 1).getId() == list.get(i).getId()) {
                    list.remove(i + 1);
                }
            }
//            //保证只会返回5个article列表
//            number = number - 1;
//            if(number < 0){
//                list.remove(i);
//            }
        }
        return list;
    }

    @Override
    public List<Article_Info> getInfoAllByStatus(int status) {
        return allArticleManagerMapper.selectInfoAllByStatus(status);
    }

    @Override
    public Article_Info selectInfoByIdVersion(long id, long version) {
        return allArticleManagerMapper.SelectInfoByIdVersion(id, version);
    }

    @Override
    public Article_detail selectDetailByIdVersion(long article_id, long article_version) {
        return allArticleManagerMapper.SelectDetailByIdVersion(article_id, article_version);
    }

    @Override
    public List<Article_picture> selectPictureByIdVersion(long article_id, long article_version) {
        return allArticleManagerMapper.SelectPictureByIdVersion(article_id, article_version);
    }

    @Override
    public List<Article_vedio> selectVedioByIdVersion(long article_id, long article_version) {
        return allArticleManagerMapper.SelectVedioByIdVersion(article_id, article_version);
    }

    @Override
    public boolean updateStatus(long id, long version, int status) {
        int modified_status = status + 2;
        Timestamp published_by = new Timestamp(System.currentTimeMillis());
        allArticleManagerMapper.updateStatusById_version(id, version, modified_status);
        allArticleManagerMapper.updatePublished_ById_version(id, version, published_by);
        Article_Info article_info = allArticleManagerMapper.SelectInfoByIdVersion(id, version);
        if (article_info.getStatus() == modified_status && article_info.getPublished_by() == published_by)
            return true;
        return false;
    }


    //删除所有以此id和version作为索引的info,detail,picture,vedio。
    @Override
    public boolean deletedById_verison(long id, long version) {
//        allManagerMapper.DeleteInfoByIdVersion(id ,version);
//        allManagerMapper.DeleteDetailByIdVersion(id ,version);
//        allManagerMapper.DeletePictureByIdVersion(id ,version);
//        allManagerMapper.DeleteVedioByIdVersion(id, version);
//        Article_Info article_info = allManagerMapper.SelectInfoByIdVersion(id ,version);
//        Article_detail article_detail = allManagerMapper.SelectDetailByIdVersion(id, version);
//        List<Article_picture> article_pictureList = allManagerMapper.SelectPictureByIdVersion(id ,version);
//        List<Article_vedio> article_vedioList = allManagerMapper.SelectVedioByIdVersion(id ,version);
//        if(article_info == null && article_detail == null && article_pictureList.size() == 0 && article_vedioList.size() == 0){
//            return true;
//        }
//        return false;
        int modified_status = 4;
        allArticleManagerMapper.updateStatusById_version(id, version, modified_status);
        Article_Info article_info = allArticleManagerMapper.SelectInfoByIdVersion(id, version);
        if (article_info.getStatus() == modified_status) {
            return true;
        } else {
            return false;
        }

    }

    public boolean deletedById(long article_id) {
        allArticleManagerMapper.DeleteInfoById(article_id);
        allArticleManagerMapper.DeleteDetailById(article_id);
        allArticleManagerMapper.DeletePictureById(article_id);
        allArticleManagerMapper.DeleteVedioById(article_id);
        if (allArticleManagerMapper.SelectInfoById(article_id) == null && allArticleManagerMapper.SelectDetailById(article_id) == null && allArticleManagerMapper.SelectPictureById(article_id) == null && allArticleManagerMapper.SelectVedioById(article_id) == null) {
            return true;
        }
        return false;
    }

    private List<Article_Info> check_category(List<Article_Info> article_infos, String category) {
        List<Article_Info> article_infos1 = new ArrayList<Article_Info>();
        for (int i = 0; i < article_infos.size(); i++) {
            long id = article_infos.get(i).getId();
            long version = article_infos.get(i).getVersion();
            Article_detail article_detail = allArticleManagerMapper.SelectDetailByIdVersion(id, version);
            if (article_detail.getCategory().equals(category)) {
                article_infos1.add(article_infos.get(i));
            }
        }
        return article_infos1;
    }

    //按照不同时间进行排序
    private List<Article_Info> sort_Dtime(List<Article_Info> article_infos, String str) {
//        if (str.equals("M")) {
//            article_infos.sort(new Comparator<Article_Info>() {
//                @Override
//                public int compare(Article_Info o1, Article_Info o2) {
//                    Timestamp timestamp1 = o1.getModified_by();
//                    Timestamp timestamp2 = o2.getModified_by();
//                    if (timestamp1.before(timestamp2))
//                        return 1;
//                    else
//                        return -1;
//                }
//            });
//            return article_infos;
//        } else if (str.equals("P")) {
//            article_infos.sort(new Comparator<Article_Info>() {
//                @Override
//                public int compare(Article_Info o1, Article_Info o2) {
//                    Timestamp timestamp1 = o1.getPublished_by();
//                    Timestamp timestamp2 = o2.getPublished_by();
//                    if (timestamp1.before(timestamp2))
//                        return 1;
//                    else
//                        return -1;
//                }
//            });
//            return article_infos;
//        } else{
//            article_infos.sort(new Comparator<Article_Info>() {
//                @Override
//                public int compare(Article_Info o1, Article_Info o2) {
//                    Timestamp timestamp1 = o1.getCommited_by();
//                    Timestamp timestamp2 = o2.getCommited_by();
//                    if (timestamp1.before(timestamp2))
//                        return 1;
//                    else
//                        return -1;
//                }
//            });
        return article_infos;
//        }
    }
}
