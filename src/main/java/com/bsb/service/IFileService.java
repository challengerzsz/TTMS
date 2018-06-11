package com.bsb.service;

import com.bsb.common.ServerResponse;
import com.bsb.pojo.User;

public interface IFileService {

    ServerResponse<String> saveFilePath(User user, String uploadFilesPath);

}
