package com.bsb.service;

import com.bsb.common.ServerResponse;
import com.bsb.pojo.Schedule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface IScheduleService {

    ServerResponse<String> addSchedules(HashMap<String, ArrayList<Schedule>> newSchedules);

    ServerResponse<String> checkValid(String movieId, int hallId, String startTime);

    ServerResponse<List<Schedule>> getScheduleByMovieId(String movieId);

    ServerResponse<Schedule> getScheduleById(int scheduleId);

}