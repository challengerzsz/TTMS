package com.bsb.controller;

import com.bsb.common.Const;
import com.bsb.common.ServerResponse;
import com.bsb.pojo.User;
import com.bsb.service.IUserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value = "/users")
public class UserController {

    Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    @PostMapping("/login")
    public ServerResponse<User> login(@RequestBody Map<String,String> loginJson, HttpSession session) {

        ServerResponse<User> response = userService.login(loginJson.get("username"), loginJson.get("password"));
        if (response.isSuccess()) {
            session.setAttribute(Const.CURRENT_USER, response.getData());
        }
        return response;
    }


    @PostMapping("/register")
    public ServerResponse<String> register(@RequestBody User user) {
        ServerResponse<String> response = userService.register(user);
        if (!response.isSuccess()) {
            return ServerResponse.createByErrorMsg("注册失败");
        }

        return response;
    }

    @PostMapping("/logout")
    public ServerResponse<String> logout(HttpSession session) {
        session.removeAttribute(Const.CURRENT_USER);
        return ServerResponse.createBySuccessMsg("注销成功");
    }

    @GetMapping("/getMyInfo")
    public ServerResponse<User> getOnlineUserInfo(HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user != null) {
            return ServerResponse.createBySuccess(user);
        }
        return ServerResponse.createByErrorMsg("用户未登录，无法获取信息");
    }

    @GetMapping("/queryUser/{userName}")
    public ServerResponse<User> queryUserInfo(@PathVariable("userName") String userName, HttpSession session) {

        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null || user.getType() != 2) {
            return ServerResponse.createByErrorMsg("身份认证失败，请重新登录");
        }

        return userService.queryUserInfo(userName);
    }

    @PostMapping("/delete")
    public ServerResponse<String> deleteUserById(HttpSession session, @RequestBody Map<String,List<Integer>> userIdsJson) {

        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null || user.getType() != 2) {
            return ServerResponse.createByErrorMsg("身份信息认证失败，请重新登录");
        }

        return userService.deleteByUserId(userIdsJson);

    }

    @GetMapping("/managers")
    public ServerResponse<List<User>> getAllManagers(HttpSession session) {

        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null || user.getType() != 2) {
            return ServerResponse.createByErrorMsg("身份信息认证失败，请重新登录");
        }

        return userService.getAllManagers();
    }

    @GetMapping("/sellers")
    public ServerResponse<List<User>> getAllSellers(HttpSession session) {

        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null || user.getType() != 2) {
            return ServerResponse.createByErrorMsg("身份信息认证失败，请重新登录");
        }

        return userService.getAllSellers();
    }

}