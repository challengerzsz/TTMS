package com.bsb.mapper;

import com.bsb.pojo.Schedule;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IScheduleMapper {

    @Select("SELECT COUNT(1) FROM (SELECT startTime, endTime FROM schedule_table WHERE hallId = #{hallId}) son WHERE (son.startTime > #{startTime} AND son.startTime < #{endTime}) OR (son.endTime > #{startTime} AND son.endTime < #{endTime})")
    int checkValid(@Param("hallId") int hallId,
                   @Param("startTime") String startTime,
                   @Param("endTime") String endTime);

    int insertSchedule(List<Schedule> schedules);

    @Select("SELECT * FROM schedule_table WHERE movieId = #{movieId}")
    List<Schedule> getScheduleByMovieId(String movieId);

    @Select("SELECT * FROM schedule_table WHERE id = #{scheduleId}")
    Schedule getScheduleById(int scheduleId);

    int deleteScheduleById(List<Integer> scheduleId);
}