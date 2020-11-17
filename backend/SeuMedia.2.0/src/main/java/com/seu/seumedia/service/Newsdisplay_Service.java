package com.seu.seumedia.service;

import com.seu.seumedia.model.Newsdisplay;
import java.util.List;

public interface Newsdisplay_Service {
    //return all the article_info with user_name in the tbl_user;
    List<Newsdisplay> get_news();
}
