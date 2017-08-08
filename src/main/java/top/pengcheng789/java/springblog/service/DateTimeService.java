package top.pengcheng789.java.springblog.service;

import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

/**
 * 提供时间服务
 *
 * CreateDate:2017-08-06
 *
 * @author pen
 */
@Service
public class DateTimeService {

    /**
     * 返回当前系统时间
     */
    public Date getDate() {
        return new Date();
    }

    /**
     * 返回问候语（根据当前系统时间判断）
     */
    public String getGreetings() {
        String greetings = "Hello,";
        int h = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);

        System.out.println("现在是" + h + '点');

        if (h >= 0 && h < 6) {
            greetings = "已经凌晨了,";
        } else if (h >= 6 && h < 10) {
            greetings = "早上好，";
        } else if (h >= 10 && h < 12) {
            greetings = "忙了一上午了吧，";
        } else if (h >= 12 && h < 14) {
            greetings = "午后休息一下吧，";
        } else if (h >= 14 && h < 18) {
            greetings = "下午好啊，";
        } else if (h >= 18 && h < 24) {
            greetings = "又到了晚上了，";
        }

        return greetings;
    }
}
