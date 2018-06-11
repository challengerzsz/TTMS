package com.bsb.controller;

import com.bsb.common.Const;
import com.bsb.common.ServerResponse;
import com.bsb.pojo.User;
import com.bsb.service.IFileService;
import com.bsb.util.FileUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/file")
public class FileUploadController {

    Logger logger = Logger.getLogger(FileUploadController.class);

    @Autowired
    private IFileService fileService;


    /**
     * 上传用户头像
     * @param session
     * @param request
     * @return
     */
    @PostMapping("/uploadImg")
    public ServerResponse<String> upload(HttpSession session, MultipartHttpServletRequest request) {

//        用户需登录进行操作
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorMsg("未登录");
        }

//        根据type判断是哪个场景 然后根据用户number进行初始化文件夹
        String saveFilePrefixDir = FileUtil.initUserDir(request.getSession().getServletContext().getRealPath("/"), user.getId());



//        从请求中获取需要上传的多文件
        List<MultipartFile> multipartFiles = request.getFiles("file");
        if (multipartFiles.size() == 0) {
            return ServerResponse.createByErrorMsg("文件列表为空，上传文件失败");
        }


//        String serverIp = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + FileUtil.DECLARE_SUBJECT_PATH + "/" + "04163209" + "/" + "1.png";


        String serverName = request.getServerName();
        String serverPort = String.valueOf(request.getServerPort());
        String contextPath = request.getContextPath();

        logger.info(serverName);
        logger.info(serverPort);
        logger.info(contextPath);

        String uploadFilesPath = null;

        for (MultipartFile file : multipartFiles) {


            File targetFile = FileUtil.getTargetFile(saveFilePrefixDir, file.getOriginalFilename(), user);

            try {
                file.transferTo(targetFile);
            } catch (IOException e) {
                return ServerResponse.createByErrorMsg("文件上传失败");
            }

            if (uploadFilesPath == null) {
                uploadFilesPath = FileUtil.getSavePaths(serverName, serverPort, contextPath, user.getId(), targetFile);
            } else {
                uploadFilesPath = uploadFilesPath + "," + FileUtil.getSavePaths(serverName, serverPort, contextPath, user.getId(), targetFile);
            }


        }

        ServerResponse<String> response = fileService.saveFilePath(user, uploadFilesPath);

        return response;
    }
}
