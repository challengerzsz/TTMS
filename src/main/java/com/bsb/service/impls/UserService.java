package com.bsb.service.impls;

import com.bsb.common.ServerResponse;
import com.bsb.mapper.IUserMapper;
import com.bsb.pojo.User;
import com.bsb.service.IUserService;
import com.bsb.util.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class UserService implements IUserService {

    private Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private IUserMapper userMapper;

    @Override
    public ServerResponse<User> login(String username, String password) {

        int resultCount = userMapper.checkUsername(username);
        if (resultCount == 0) {
            return ServerResponse.createByErrorMsg("用户不存在");
        }

        String MD5EncodingPassword = MD5Util.MD5EncodeUtf8(password);
        User user = userMapper.login(username, MD5EncodingPassword);
        if (user == null) {
            return ServerResponse.createByErrorMsg("密码错误");
        }

        user.setPassword(StringUtils.EMPTY);

        return ServerResponse.createBySuccess("登陆成功", user);
    }

    @Override
    public ServerResponse<String> register(User user) {

        int resultCode = userMapper.checkUsername(user.getUsername());
        if (resultCode != 0) {
            return ServerResponse.createByErrorMsg("用户已存在，注册失败");
        }

        String password = user.getPassword();
        user.setPassword(MD5Util.MD5EncodeUtf8(password));

        int insertResult = userMapper.insertUser(user);

        if (insertResult == 0) {
            return ServerResponse.createByErrorMsg("注册失败");
        }

        return ServerResponse.createBySuccessMsg("注册成功");

    }

    @Override
    public ServerResponse<User> queryUserInfo(String userName) {

        User user = userMapper.queryUserInfo(userName);
        if (user == null) {
            return ServerResponse.createByErrorMsg("不存在该用户");
        }

        return ServerResponse.createBySuccess("查询成功", user);
    }

    @Override
    public ServerResponse<String> deleteByUserId(Map<String, List<Integer>> userIdsJson) {

        List<Integer> userIds = userIdsJson.get("deleteUserIds");
        if (userIds == null) {
            return ServerResponse.createByErrorMsg("待删除的用户id列表为空，删除失败");
        }

        int resultCount = userMapper.deleteByUserId(userIds);
        if (resultCount == 0) {
            return ServerResponse.createByErrorMsg("删除用户失败");
        }

        return ServerResponse.createBySuccessMsg("删除用户成功");
    }


}