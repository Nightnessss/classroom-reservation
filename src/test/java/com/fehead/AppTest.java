package com.fehead;

import static org.junit.Assert.assertTrue;

import com.fehead.dao.ClassroomInfoMapper;
import com.fehead.dao.FreeClassSimplifyMapper;
import com.fehead.dao.dataobject.ClassroomInfoDO;
import com.fehead.dao.dataobject.FreeClassSimplifyDO;
import com.fehead.error.BusinessException;
import com.fehead.service.model.TimetableModel;
import com.fehead.utils.CourseUtil;
import com.fehead.utils.TimeAndClassUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Unit test for simple App.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class AppTest 
{

    @Autowired
    private CourseUtil courseUtil;
    @Autowired
    private TimeAndClassUtil timeAndClassUtil;
    @Autowired
    private FreeClassSimplifyMapper freeClassSimplifyMapper;
    @Autowired
    private ClassroomInfoMapper classroomInfoMapper;

    @Test
    public void timeAndClassUtilTest() throws ParseException, BusinessException {
        Date startTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-9-1 16:20:00");
        Date endTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-9-1 22:00:00");
        System.out.println("start: " + startTime);
        System.out.println("end: " + endTime);
        System.out.println(startTime.before(endTime));
        SimpleDateFormat week = new SimpleDateFormat("EEEE");
        String w = week.format(startTime);
//        System.out.println(w + ":" + startTime);
        timeAndClassUtil.timeToClasses(startTime, endTime, 1);
    }

    @Test
    public void week() throws Exception {
        String[] sets = {"setMon1", "setMon2", "setMon3", "setMon4", "setMon5", "setMon6",
                "setTue1", "setTue2", "setTue3", "setTue4", "setTue5", "setTue6",
                "setWed1", "setWed2", "setWed3", "setWed4", "setWed5", "setWed6",
                "setThur1", "setThur2", "setThur3", "setThur4", "setThur5", "setThur6",
                "setFri1", "setFri2", "setFri3", "setFri4", "setFri5", "setFri6",
                "setSat1", "setSat2", "setSat3", "setSat4", "setSat5", "setSat6",
                "setSun1", "setSun2", "setSun3", "setSun4", "setSun5", "setSun6"};
        List<String> setMethods = Arrays.asList(sets);
        String[] gets = {"getMon1", "getMon2", "getMon3", "getMon4", "getMon5", "getMon6",
                "getTue1", "getTue2", "getTue3", "getTue4", "getTue5", "getTue6",
                "getWed1", "getWed2", "getWed3", "getWed4", "getWed5", "getWed6",
                "getThur1", "getThur2", "getThur3", "getThur4", "getThur5", "getThur6",
                "getFri1", "getFri2", "getFri3", "getFri4", "getFri5", "getFri6",
                "getSat1", "getSat2", "getSat3", "getSat4", "getSat5", "getSat6",
                "getSun1", "getSun2", "getSun3", "getSun4", "getSun5", "getSun6"};
        List<String> getMethods = Arrays.asList(gets);
        Class<?> classroomInfoDOClass = Class.forName("com.fehead.dao.dataobject.ClassroomInfoDO");

        List<FreeClassSimplifyDO> freeClassSimplifyDOS = freeClassSimplifyMapper.selectList(null);
        for (FreeClassSimplifyDO o : freeClassSimplifyDOS) {
            ClassroomInfoDO classroomInfoDO = (ClassroomInfoDO) classroomInfoDOClass.newInstance();

            BeanUtils.copyProperties(o, classroomInfoDO);
            List<String> test = courseUtil.getClass(classroomInfoDOClass, classroomInfoDO, getMethods);
            List<String> values = new ArrayList<>();
            for (String s: test) {
                values.add(CourseUtil.convertString2ByteString(s));
            }
            ClassroomInfoDO res = courseUtil.setClass(classroomInfoDOClass, classroomInfoDO, setMethods, values);
            System.out.println(res);
//            classroomInfoMapper.insert(res);
        }

    }
}
