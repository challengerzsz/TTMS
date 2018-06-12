package com.bsb.controller;

import com.bsb.common.Const;
import com.bsb.common.ServerResponse;
import com.bsb.pojo.Schedule;
import com.bsb.pojo.User;
import com.bsb.service.IScheduleService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/schedule")
public class ScheduleController {

    private Logger logger = Logger.getLogger(ScheduleController.class);

    @Autowired
    private IScheduleService scheduleService;


    @PostMapping("/addSchedule")
    public ServerResponse<String> addSchedules(@RequestBody HashMap<String,ArrayList<Schedule>> newSchedules) {
        if (newSchedules == null) {
            return ServerResponse.createByErrorMsg("传入参数为空");
        }

        return scheduleService.addSchedules(newSchedules);
    }

    @PostMapping("/checkValid")
    public ServerResponse<String> checkValid(@RequestBody Map<String,String> uncheckedJson) {

        return scheduleService.checkValid(uncheckedJson.get("movieId"), Integer.parseInt(uncheckedJson.get("hallId")),
                uncheckedJson.get("startTime"));
    }

    @GetMapping("/getSchedules/{movieId}")
    public ServerResponse<List<Schedule>> getSchedules(@PathVariable("movieId") String movieId) {
        return scheduleService.getScheduleByMovieId(movieId);
    }

    @GetMapping("/getSchedule/{scheduleId}")
    public ServerResponse<Schedule> getScheduleById(@PathVariable("scheduleId") int scheduleId) {
        return scheduleService.getScheduleById(scheduleId);
    }

    @PostMapping("/delete")
    public ServerResponse<String> deleteScheduleById(HttpSession session, @RequestBody Map<String,List<Integer>> deleteScheduleJson) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null || user.getType() != 2) {
            return ServerResponse.createByErrorMsg("用户信息认证失败");
        }

        return scheduleService.deleteScheduleById(deleteScheduleJson);
    }
}