package com.bsb.service.impls;

import com.bsb.common.ServerResponse;
import com.bsb.mapper.IScheduleMapper;
import com.bsb.pojo.Movie;
import com.bsb.pojo.Schedule;
import com.bsb.service.IMoviesService;
import com.bsb.service.IScheduleService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class ScheduleService implements IScheduleService {

    Logger logger = Logger.getLogger(ScheduleService.class);

    @Autowired
    private IScheduleMapper scheduleMapper;
    @Autowired
    private IMoviesService moviesService;

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");


    @Override
    public ServerResponse<String> addSchedules(HashMap<String, ArrayList<Schedule>> newSchedules) {

        ArrayList<Schedule> schedules = newSchedules.get("newSchedules");

        if (schedules.size() == 0) {
            return ServerResponse.createByErrorMsg("新增演出计划为空");
        }

        int resultCount = scheduleMapper.insertSchedule(schedules);
        if (resultCount == 0) {
            return ServerResponse.createByErrorMsg("新建演出计划失败");
        }

        return ServerResponse.createBySuccessMsg("新建演出计划成功");
    }

    @Override
    public ServerResponse<String> checkValid(String movieId, int hallId, String startTime) {

        ServerResponse<Movie> movieServerResponse = moviesService.getMovieInfo(movieId);
        Movie movie = movieServerResponse.getData();
        if (movie == null) {
            return ServerResponse.createByErrorMsg("未找到该影片，添加演出计划失败");
        }


        Date startDate = new Date(startTime);
        long endTimeMil = startDate.getTime() + (movie.getDur() * 60 * 1000) ;
        String endTime = simpleDateFormat.format(new Date(endTimeMil));



        logger.info("startDate" + startTime);
        logger.info("endDate" + endTime);
        logger.info(movie.getDur());

        int validCount = scheduleMapper.checkValid(hallId, startTime, endTime);
        if (validCount > 0) {
            return ServerResponse.createByErrorMsg("演出计划时间与已存在的演出计划重复");
        }

        return ServerResponse.createBySuccessMsg("演出计划时间√");
    }


    @Override
    public ServerResponse<List<Schedule>> getScheduleByMovieId(String movieId) {

        ServerResponse<Movie> movieServerResponse = moviesService.getMovieInfo(movieId);
        if (!movieServerResponse.isSuccess()) {
            return ServerResponse.createByErrorMsg("影片不存在");
        }

        List<Schedule> schedules = scheduleMapper.getScheduleByMovieId(movieId);

        if (schedules.size() == 0) {
            return ServerResponse.createByErrorMsg("获取该影片演出信息为空");
        }

        return ServerResponse.createBySuccess("演出计划查询成功", schedules);
    }

    @Override
    public ServerResponse<Schedule> getScheduleById(int scheduleId) {
        Schedule schedule = scheduleMapper.getScheduleById(scheduleId);
        if (schedule == null) {
            return ServerResponse.createByErrorMsg("无此演出计划");
        }

        return ServerResponse.createBySuccess("查询成功", schedule);
    }

}