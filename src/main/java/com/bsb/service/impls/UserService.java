package com.bsb.service.impls;

import com.bsb.common.ServerResponse;
import com.bsb.dao.IUserMapper;
import com.bsb.pojo.User;
import com.bsb.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService implements IUserService {

    private Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private IUserMapper userMapper;

    @Override
    public ServerResponse<User> login(String username, String password) {

        logger.info(username);
        logger.info(password);

        int resultCount = userMapper.checkUsername(username);
        if (resultCount == 0) {
            return ServerResponse.createByErrorMsg("用户不存在");
        }

//        String MD5EncodingPassword = MD5Util.MD5EncodeUtf8(password);
        User user = userMapper.login(username, password);
        if (user == null) {
            return ServerResponse.createByErrorMsg("密码错误");
        }

        user.setPassword(StringUtils.EMPTY);

        return ServerResponse.createBySuccess("登陆成功", user);
    }

    @Override
    public ServerResponse<String> register(String username, String password, int type) {

        int resultCode = userMapper.checkUsername(username);
        if (resultCode != 0) {
            return ServerResponse.createByErrorMsg("用户已存在，注册失败");
        }

        int insertResult = userMapper.insertUser(username, password, type);

        if (insertResult == 0) {
            return ServerResponse.createByErrorMsg("注册失败");
        }

        return ServerResponse.createBySuccessMsg("注册成功");

    }



}