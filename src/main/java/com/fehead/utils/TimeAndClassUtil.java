package com.fehead.utils;

import com.fehead.error.BusinessException;
import com.fehead.error.EmBusinessError;
import com.fehead.service.model.TimetableModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 写代码 敲快乐
 * だからよ...止まるんじゃねぇぞ
 * ▏n
 * █▏　､⺍
 * █▏ ⺰ʷʷｨ
 * █◣▄██◣
 * ◥██████▋
 * 　◥████ █▎
 * 　　███▉ █▎
 * 　◢████◣⌠ₘ℩
 * 　　██◥█◣\≫
 * 　　██　◥█◣
 * 　　█▉　　█▊
 * 　　█▊　　█▊
 * 　　█▊　　█▋
 * 　　 █▏　　█▙
 * 　　 █
 *
 * @author Nightnessss 2019/8/30 17:16
 */
@Component
public class TimeAndClassUtil {

//    private static final Map<Integer, List<Date>> summer = new HashMap<Integer, List<Date>>() {{
//        put(1, new ArrayList<Date>() {{
//            try {
//                add(new SimpleDateFormat("HH:mm").parse("8:00"));
//                add(new SimpleDateFormat("HH:mm").parse("9:50"));
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//        }});
//        put(3, new ArrayList<Date>() {{
//            try {
//                add(new SimpleDateFormat("HH:mm").parse("10:05"));
//                add(new SimpleDateFormat("HH:mm").parse("11:55"));
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//        }});
//        put(5, new ArrayList<Date>() {{
//            try {
//                add(new SimpleDateFormat("HH:mm").parse("14:30"));
//                add(new SimpleDateFormat("HH:mm").parse("16:10"));
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//        }});
//        put(7, new ArrayList<Date>() {{
//            try {
//                add(new SimpleDateFormat("HH:mm").parse("16:25"));
//                add(new SimpleDateFormat("HH:mm").parse("10:00"));
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//        }});
//        put(9, new ArrayList<Date>() {{
//            try {
//                add(new SimpleDateFormat("HH:mm").parse("8:00"));
//                add(new SimpleDateFormat("HH:mm").parse("10:00"));
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//        }});
//        put(11, new ArrayList<Date>() {{
//            try {
//                add(new SimpleDateFormat("HH:mm").parse("8:00"));
//                add(new SimpleDateFormat("HH:mm").parse("10:00"));
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//        }});
//    }};

    private Logger logger = LoggerFactory.getLogger(TimeAndClassUtil.class);

    /**
     * 获取某时间段内上的课的节次
     * @param startTime
     * @param endTime
     * @param timetable
     * @return
     * @throws ParseException
     * @throws BusinessException
     */
    public List<Integer> timeToClasses(Date startTime, Date endTime, int timetable) throws ParseException, BusinessException {

        // 验证开始时间是否在结束时间之前
        if (startTime.after(endTime)) {
            logger.info("EXCEPTION: " + EmBusinessError.PARAMETER_VALIDATION_ERROR.getErrorCode() + " "
                    + "开始时间在结束时间之前");
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "开始时间在结束时间之前");
        }

        List<Integer> classes = new ArrayList<>();
        SimpleDateFormat df = new SimpleDateFormat("HH:mm");
        Date start = df.parse(df.format(startTime));
        Date end = df.parse(df.format(endTime));
        TimetableModel timetableModel = new TimetableModel(timetable);
        if (start.after(timetableModel.getClasses().get(6).get(2))) {
            logger.info("EXCEPTION: " + EmBusinessError.PARAMETER_VALIDATION_ERROR.getErrorCode() + " "
                    + EmBusinessError.PARAMETER_VALIDATION_ERROR.getErrorMsg());
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        if (end.before(timetableModel.getClasses().get(1).get(1))) {
            logger.info("EXCEPTION: " + EmBusinessError.PARAMETER_VALIDATION_ERROR.getErrorCode() + " "
                    + EmBusinessError.PARAMETER_VALIDATION_ERROR.getErrorMsg());
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }

        // 找到改时间段包含课程的节次
        int s = startSearch(timetableModel.getClasses(), start);
        int e = endSearch(timetableModel.getClasses(), end);
        if (start.before(timetableModel.getClasses().get(1).get(1))) {
            s = 1;
        }
        if (end.after(timetableModel.getClasses().get(6).get(2))) {
            e = 6;
        }
        for (int i = s; i <= e; i++) {
            classes.add(i);
//            System.out.println(i);
        }
        return classes;
    }

    public int startSearch(HashMap<Integer, Map<Integer, Date>> map,Date key){
        int low = 1;
        int high = 6;
        int middle = 0;         //定义middle
//        Date s1 = map.get(low).get(1);
//        Date s2 = map.get(high).get(2);
//        boolean f1 = key.before(map.get(low).get(1));
//        boolean f2 = key.after(map.get(high).get(2));
        if(key.before(map.get(low).get(1))|| key.after(map.get(high).get(2)) || low > high){
            return -1;
        }

        while(low <= high){
            middle = (low + high) / 2;
            if(map.get(middle).get(1).after(key)){
                //比关键字大则关键字在左区域
                high = middle - 1;
            }else if(map.get(middle).get(1).before(key)){
                //比关键字小则关键字在右区域
                low = middle + 1;
            } else {
                return middle;
            }
        }
        if (map.get(high).get(2).after(key)) {
            return high;
        } else {
            return low;
        }

    }
    public int endSearch(HashMap<Integer, Map<Integer, Date>> map,Date key){
        int low = 1;
        int high = 6;
        int middle = 0;         //定义middle

        if(key.before(map.get(low).get(1))|| key.after(map.get(high).get(2)) || low > high){
            return -1;
        }

        while(low <= high){
            middle = (low + high) / 2;
            if(map.get(middle).get(2).after(key)){
                //比关键字大则关键字在左区域
                high = middle - 1;
            }else if(map.get(middle).get(2).before(key)){
                //比关键字小则关键字在右区域
                low = middle + 1;
            } else {
                return middle;
            }
        }
        if (map.get(low).get(1).before(key)) {
            return low;
        } else {
            return high;
        }

    }
}
