package com.seu.seumedia.service;


import com.seu.seumedia.model.Content;

public interface ContentReturn_Service {
    Content get_content(long id, long version);
}
