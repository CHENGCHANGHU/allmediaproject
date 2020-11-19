package com.seu.seumedia.service;

import com.seu.seumedia.entity.MediaUserInfo;

import java.util.List;

public interface ManageMediaUserService {
    List<MediaUserInfo> getMediaUser();
    boolean deleteMediaUserInfo(long id);
}
