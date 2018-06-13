package com.bsb.service;

import com.bsb.common.ServerResponse;
import com.bsb.pojo.User;

import java.util.List;
import java.util.Map;

public interface IUserService {

    ServerResponse<User> login(String username, String password);

    ServerResponse<String> register(User user);

    ServerResponse<User> queryUserInfo(String userName);

    ServerResponse<String> deleteByUserId(Map<String, List<Integer>> userIdsJson);

    ServerResponse<List<User>> getAllManagers();

    ServerResponse<List<User>> getAllSellers();

}