package com.fehead.utils;

import com.fehead.dao.ClassroomMapper;
import com.fehead.dao.FreeClassSimplifyMapper;
import com.fehead.dao.dataobject.ClassroomDO;
import com.fehead.dao.dataobject.ClassroomInfoDO;
import com.fehead.dao.dataobject.FreeClassSimplifyDO;
import com.fehead.service.model.FreeClassroomModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
 * @author Nightnessss 2019/11/1 20:31
 */
@Component
public class CourseUtil {

    @Autowired
    private ClassroomMapper classroomMapper;
    @Autowired
    private FreeClassSimplifyMapper freeClassSimplifyMapper;

    /**
     * 将提取出来的周次信息存入数据库
     * @return
     */
    public List<FreeClassSimplifyDO> freeClassSimplify() {

        List<ClassroomDO> classroomDOS = classroomMapper.selectList(null);
        List<FreeClassSimplifyDO> freeClassSimplifyDOS = new ArrayList<>();
        for (ClassroomDO classroomDO:classroomDOS) {
            FreeClassSimplifyDO freeClassSimplifyDO = new FreeClassSimplifyDO();
            BeanUtils.copyProperties(classroomDO, freeClassSimplifyDO);
            freeClassSimplifyDO.setMon1(String.valueOf(extractMessageByRegular(classroomDO.getMon1())));
            freeClassSimplifyDO.setMon2(String.valueOf(extractMessageByRegular(classroomDO.getMon2())));
            freeClassSimplifyDO.setMon3(String.valueOf(extractMessageByRegular(classroomDO.getMon3())));
            freeClassSimplifyDO.setMon4(String.valueOf(extractMessageByRegular(classroomDO.getMon4())));
            freeClassSimplifyDO.setMon5(String.valueOf(extractMessageByRegular(classroomDO.getMon5())));
            freeClassSimplifyDO.setMon6(String.valueOf(extractMessageByRegular(classroomDO.getMon6())));

            freeClassSimplifyDO.setTue1(String.valueOf(extractMessageByRegular(classroomDO.getTue1())));
            freeClassSimplifyDO.setTue2(String.valueOf(extractMessageByRegular(classroomDO.getTue2())));
            freeClassSimplifyDO.setTue3(String.valueOf(extractMessageByRegular(classroomDO.getTue3())));
            freeClassSimplifyDO.setTue4(String.valueOf(extractMessageByRegular(classroomDO.getTue4())));
            freeClassSimplifyDO.setTue5(String.valueOf(extractMessageByRegular(classroomDO.getTue5())));
            freeClassSimplifyDO.setTue6(String.valueOf(extractMessageByRegular(classroomDO.getTue6())));

            freeClassSimplifyDO.setWed1(String.valueOf(extractMessageByRegular(classroomDO.getWed1())));
            freeClassSimplifyDO.setWed2(String.valueOf(extractMessageByRegular(classroomDO.getWed2())));
            freeClassSimplifyDO.setWed3(String.valueOf(extractMessageByRegular(classroomDO.getWed3())));
            freeClassSimplifyDO.setWed4(String.valueOf(extractMessageByRegular(classroomDO.getWed4())));
            freeClassSimplifyDO.setWed5(String.valueOf(extractMessageByRegular(classroomDO.getWed5())));
            freeClassSimplifyDO.setWed6(String.valueOf(extractMessageByRegular(classroomDO.getWed6())));

            freeClassSimplifyDO.setThur1(String.valueOf(extractMessageByRegular(classroomDO.getThur1())));
            freeClassSimplifyDO.setThur2(String.valueOf(extractMessageByRegular(classroomDO.getThur2())));
            freeClassSimplifyDO.setThur3(String.valueOf(extractMessageByRegular(classroomDO.getThur3())));
            freeClassSimplifyDO.setThur4(String.valueOf(extractMessageByRegular(classroomDO.getThur4())));
            freeClassSimplifyDO.setThur5(String.valueOf(extractMessageByRegular(classroomDO.getThur5())));
            freeClassSimplifyDO.setThur6(String.valueOf(extractMessageByRegular(classroomDO.getThur6())));

            freeClassSimplifyDO.setFri1(String.valueOf(extractMessageByRegular(classroomDO.getFri1())));
            freeClassSimplifyDO.setFri2(String.valueOf(extractMessageByRegular(classroomDO.getFri2())));
            freeClassSimplifyDO.setFri3(String.valueOf(extractMessageByRegular(classroomDO.getFri3())));
            freeClassSimplifyDO.setFri4(String.valueOf(extractMessageByRegular(classroomDO.getFri4())));
            freeClassSimplifyDO.setFri5(String.valueOf(extractMessageByRegular(classroomDO.getFri5())));
            freeClassSimplifyDO.setFri6(String.valueOf(extractMessageByRegular(classroomDO.getFri6())));

            freeClassSimplifyDO.setSat1(String.valueOf(extractMessageByRegular(classroomDO.getSat1())));
            freeClassSimplifyDO.setSat2(String.valueOf(extractMessageByRegular(classroomDO.getSat2())));
            freeClassSimplifyDO.setSat3(String.valueOf(extractMessageByRegular(classroomDO.getSat3())));
            freeClassSimplifyDO.setSat4(String.valueOf(extractMessageByRegular(classroomDO.getSat4())));
            freeClassSimplifyDO.setSat5(String.valueOf(extractMessageByRegular(classroomDO.getSat5())));
            freeClassSimplifyDO.setSat6(String.valueOf(extractMessageByRegular(classroomDO.getSat6())));

            freeClassSimplifyDO.setSun1(String.valueOf(extractMessageByRegular(classroomDO.getSun1())));
            freeClassSimplifyDO.setSun2(String.valueOf(extractMessageByRegular(classroomDO.getSun2())));
            freeClassSimplifyDO.setSun3(String.valueOf(extractMessageByRegular(classroomDO.getSun3())));
            freeClassSimplifyDO.setSun4(String.valueOf(extractMessageByRegular(classroomDO.getSun4())));
            freeClassSimplifyDO.setSun5(String.valueOf(extractMessageByRegular(classroomDO.getSun5())));
            freeClassSimplifyDO.setSun6(String.valueOf(extractMessageByRegular(classroomDO.getSun6())));

//            freeClassSimplifyMapper.insert(freeClassSimplifyDO);
            freeClassSimplifyDOS.add(freeClassSimplifyDO);
            System.out.println(freeClassSimplifyDO.getRoom() + " 完成！");
        }

        return freeClassSimplifyDOS;
    }


    /**
     * 从课程的文字信息中提取课程周次
     * @param s
     * @return
     */
    private List<String> extractMessageByRegular(String s) {
        List<String> list=new ArrayList<String>();
        Pattern p = Pattern.compile("\\((.*?)\\)");
        Matcher m = p.matcher(s);
        while(m.find()){
            list.add(m.group().substring(1, m.group().length()-1));
        }
        List<String> week = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if ((i+1)%3 == 0) {
                String content = list.get(i);
                String[] weeks = content.split(" ");
                week.addAll(Arrays.asList(weeks));
            }
        }
        return week;
    }

    /******************************分割线***************************************************************/


    /**
     * 将 FreeClassSimplify 的数据做字符串转二进制字符串 并存入数据库
     * @throws Exception
     */
    public void convertDatabase() throws Exception {
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
            // 执行get方法获取对象中的所有课时字段
            List<String> test = getClass(classroomInfoDOClass, classroomInfoDO, getMethods);
            List<String> values = new ArrayList<>();

            // 将课时字段的格式转变成二进制字符串的形式
            for (String s: test) {
                values.add(convertString2ByteString(s));
            }

            // 执行set方法赋值
            ClassroomInfoDO res = setClass(classroomInfoDOClass, classroomInfoDO, setMethods, values);
            System.out.println(res);
//            classroomInfoMapper.insert(res);
        }
    }


    /**
     * 将 3-5或19 这类形式转化为 001110000000000000000或 00000000000000000010形式
     * @param str
     * @return
     */
    private String convertString2ByteString(String str) {
        str = str.substring(1, str.length() - 1);
        List<String> list = Arrays.asList(str.split(", "));

//        list.forEach(System.out::println);

        StringBuilder res = new StringBuilder();
        res.append("00000000000000000000");
        for (String s:list) {
            if (s.isEmpty()) continue;
            try {
                int number = Integer.parseInt(s);
                for (int i = 1; i <= 20; i++) {
                    if (i == number) {
                        res.replace(i-1, i, "1");
                    }
                }
            } catch (Exception e) {
                String[] num = s.split("-");
                for (int i = Integer.parseInt(num[0]); i <= Integer.parseInt(num[1]); i++) {
                    res.replace(i-1, i, "1");
                }
            }
        }


        return String.valueOf(res);

    }


    /**
     * 反射
     * @param userClass
     * @param classroomInfoDO
     * @param methods
     * @param targets
     * @return
     * @throws Exception
     */
    public ClassroomInfoDO setClass(Class<?> userClass, ClassroomInfoDO classroomInfoDO, List<String> methods, List<String> targets) throws Exception {
        if (methods.size() == targets.size()) {
            int i = 0;
            for (String method:methods) {
                Method repay = userClass.getMethod(method,String.class);
                repay.invoke(classroomInfoDO,targets.get(i++));
            }
        } else {
            System.out.println("----------------------------------------------error");
        }
        return classroomInfoDO;
    }


    /**
     * 反射
     * @param userClass
     * @param classroomInfoDO
     * @param methods
     * @return
     * @throws Exception
     */
    public List<String> getClass(Class<?> userClass, ClassroomInfoDO classroomInfoDO, List<String> methods) throws Exception {
        List<String> list = new ArrayList<>();
        for (String method:methods) {
            Method repay = userClass.getMethod(method);
            list.add((String) repay.invoke(classroomInfoDO));
        }
        return list;
    }

}
