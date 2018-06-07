package com.bsb.mapper;

import com.bsb.pojo.Schedule;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IScheduleMapper {

    @Select("SELECT COUNT(1) FROM schedule_table WHERE startTime < #{startTime} AND endTime > #{endTime}")
    int checkValid(String startTime, String endTime);

    int insertSchedule(List<Schedule> schedules);

    @Select("SELECT * FROM schedule_table WHERE id = #{id}")
    List<Schedule> getSchedule(String id);
}
