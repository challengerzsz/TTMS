package com.bsb.controller;

import com.bsb.common.Const;
import com.bsb.common.ServerResponse;
import com.bsb.pojo.User;
import com.bsb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/users/")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("login")
    public ServerResponse<User> login(String username, String password, HttpSession session) {

        ServerResponse<User> response = userService.login(username, password);
        if (response.isSuccess()) {
            session.setAttribute(Const.CURRENT_USER, response.getData());
        }
        return response;
    }


    @PostMapping("register")
    public ServerResponse<String> register(User user) {
        ServerResponse<String> response = userService.register(user);
        if (!response.isSuccess()) {
            return ServerResponse.createByErrorMsg("注册失败");
        }

        return response;
    }

    @PostMapping("logout")
    public ServerResponse<String> logout(HttpSession session) {
        session.removeAttribute(Const.CURRENT_USER);
        return ServerResponse.createBySuccess();
    }

    @GetMapping("{id}")
    public ServerResponse<User> getUserInfo(HttpSession session, @PathVariable("id") int id) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user != null) {
            return ServerResponse.createBySuccess(user);
        }
        return ServerResponse.createByErrorMsg("用户未登录，无法获取信息");
    }
}