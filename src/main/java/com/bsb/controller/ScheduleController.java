package com.bsb.controller;

import com.bsb.common.ServerResponse;
import com.bsb.pojo.Schedule;
import com.bsb.pojo.Ticket;
import com.bsb.service.IScheduleService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
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
}