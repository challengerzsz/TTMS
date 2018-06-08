package com.bsb.controller;

import com.bsb.common.ServerResponse;
import com.bsb.pojo.Schedule;
import com.bsb.pojo.Ticket;
import com.bsb.service.IScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/schedule")
public class ScheduleController {

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
    public ServerResponse<String> checkValid(String movieId, int hallId, String startTime) {
        return scheduleService.checkValid(movieId, hallId, startTime);
    }

    @GetMapping("/getSchedules/{movieId}")
    public ServerResponse<List<Schedule>> getSchedules(@PathVariable("movieId") String movieId) {
        return scheduleService.getScheduleByMovieId(movieId);
    }

    @GetMapping("/getSchedule/{scheduleId}")
    public ServerResponse<Schedule> getScheduleById(@PathVariable("scheduleId") int scheduleId) {
        return scheduleService.getScheduleById(scheduleId);
    }
}