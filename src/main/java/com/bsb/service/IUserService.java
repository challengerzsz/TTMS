package com.bsb.service;

import com.bsb.common.ServerResponse;
import com.bsb.pojo.User;

public interface IUserService {

    ServerResponse<User> login(String username, String password);

    ServerResponse<String> register(User user);
}
