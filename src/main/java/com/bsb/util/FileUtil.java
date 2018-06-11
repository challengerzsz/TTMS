package com.bsb.util;

import com.bsb.pojo.User;

import java.io.File;

public class FileUtil {

    public static final String USER_IMGS = "/USER_IMGS";


    public static String getPrefix(int userId) {

        return USER_IMGS + "/" + userId;
    }

    /**
     * 初始化对应场景下对学号初始化文件夹
     * @param realPath
     * @return
     */
    public static String initUserDir(String realPath, int userId) {

        String prefix = realPath + getPrefix(userId);

        File prefixDir = new File(prefix);
        if (!prefixDir.exists()) {
            prefixDir.mkdirs();
        }

        return prefix;
    }

    public static String getSavePaths(String serverName, String serverPort, String contextPath, int userId, File targetFileName) {
        return "http://" + serverName + ":" + serverPort + contextPath + getPrefix(userId) + "/" + targetFileName.getName();
    }

    public static File getTargetFile(String saveFilePrefixDir, String originalFilename, User user) {
//        根据上传文件的后缀辨识转换后文件的格式
        String fileSuffix = originalFilename.substring(originalFilename.indexOf("."));
//        创建待转换的文件
        File targetFile = new File(saveFilePrefixDir + "/" + user.getId() + fileSuffix);
        if (!targetFile.exists()) {
            targetFile.mkdir();
        }

        return targetFile;
    }

}