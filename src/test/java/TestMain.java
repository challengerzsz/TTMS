import com.alibaba.fastjson.JSONObject;
import com.bsb.pojo.Schedule;
import com.bsb.util.MD5Util;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class TestMain {

    Logger logger = Logger.getLogger(TestMain.class);

    @Test
    public void MD5Encoding() {
        logger.info(MD5Util.MD5EncodeUtf8("123456"));
    }

    @Test
    public void parseJson() {
        ArrayList<Schedule> schedules = new ArrayList<>();
        Schedule schedule1 = new Schedule();
        Schedule schedule2 = new Schedule();
        schedule1.setHallId(1);
        schedule1.setMovieId("1139994");
        schedule1.setStartTime("2018-06-10 10:00:00");
        schedule1.setEndTime("2018-06-10 12:00:00");
        schedule2.setHallId(1);
        schedule2.setMovieId("1139994");
        schedule2.setStartTime("2018-06-10 10:00:00");
        schedule2.setEndTime("2018-06-10 12:00:00");


        schedules.add(schedule1);
        schedules.add(schedule2);

        HashMap hashMap = new HashMap();
        hashMap.put("newSchedules", schedules);
        logger.info(JSONObject.toJSON(hashMap).toString());
    }


    @Test
    public void timeTest() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = new Date("2018/06/10 10:00:00");
        logger.info(simpleDateFormat.format(date));
    }
}