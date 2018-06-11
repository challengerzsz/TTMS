package com.bsb.service.impls;

import com.bsb.common.ServerResponse;
import com.bsb.mapper.IFileMapper;
import com.bsb.pojo.User;
import com.bsb.service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileService implements IFileService {

    @Autowired
    private IFileMapper fileMapper;

    @Override
    public ServerResponse<String> saveFilePath(User user, String saveFilePath) {

        if (saveFilePath == null) {
            return ServerResponse.createByErrorMsg("保存至数据库文件路径为空");
        }

        int resultCount = fileMapper.insertSaveFilePath(saveFilePath, user.getId());

        if (resultCount == 0) {
            return ServerResponse.createByErrorMsg("保存文件路径至数据库失败");
        }

        return ServerResponse.createBySuccess("上传文件成功", saveFilePath);
    }

}
