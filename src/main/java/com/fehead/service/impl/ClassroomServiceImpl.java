package com.fehead.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fehead.controller.vo.ClassroomDisplayVO;
import com.fehead.controller.vo.ClassroomListOrderVO;
import com.fehead.controller.vo.ClassroomListVO;
import com.fehead.dao.ClassroomMapper;
import com.fehead.dao.dataobject.ClassroomDO;
import com.fehead.error.BusinessException;
import com.fehead.error.EmBusinessError;
import com.fehead.properties.TotalProperties;
import com.fehead.service.ClassroomService;
import com.fehead.service.model.FreeClassroomModel;
import com.fehead.utils.DateUtil;
import com.fehead.utils.TimeAndClassUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
 * @author Nightnessss 2019/8/30 16:59
 */
@Service
public class ClassroomServiceImpl implements ClassroomService {

    @Autowired
    private DateUtil dateUtil;

    private Logger logger = LoggerFactory.getLogger(ClassroomServiceImpl.class);

//    final static List<String> WINDOWS = new ArrayList<>();
//    static {
//        WINDOWS.add("星期一");
//        WINDOWS.add("星期二");
//        WINDOWS.add("星期三");
//        WINDOWS.add("星期四");
//        WINDOWS.add("星期五");
//        WINDOWS.add("星期六");
//        WINDOWS.add("星期日");
//    }
//    final static List<String> UNIX = new ArrayList<>();
//    static {
//        UNIX.add("Monday");
//        UNIX.add("Tuesday");
//        UNIX.add("Wednesday");
//        UNIX.add("Thursday");
//        UNIX.add("Friday");
//        UNIX.add("Saturday");
//        UNIX.add("Sunday");
//    }

    @Autowired
    Environment env;

    @Autowired
    private TimeAndClassUtil timeAndClassUtil;

    @Autowired
    private TotalProperties totalProperties;

    @Autowired
    private ClassroomMapper classroomMapper;

//    /**
//     * 获得空教室
//     * @param startTime
//     * @param endTime
//     * @return
//     * @throws ParseException
//     * @throws BusinessException
//     */
//    @Override
//    public ClassroomDisplayVO getFreeClassroom(Date startTime, Date endTime, Pageable pageable) throws ParseException, BusinessException {
//
//        if (pageable==null)  return null;
//
//        // 星期几
//        SimpleDateFormat week = new SimpleDateFormat("EEEE");
//        String startWeek = week.format(startTime);
//        String endWeek = week.format(endTime);
//        if (!startWeek.equals(endWeek)) {
//            logger.info("EXCEPTION: " + EmBusinessError.PARAMETER_VALIDATION_ERROR.getErrorCode() + " "
//                    + EmBusinessError.PARAMETER_VALIDATION_ERROR.getErrorMsg());
//            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
//        }
//        logger.info("WEEK: " + startWeek);
//
//        List<Integer> targetClasses = timeAndClassUtil.timeToClasses(startTime, endTime, totalProperties.getTimetableProperties().getTimetable());
//        logger.info("FREE CLASSES: " + Arrays.asList(targetClasses).toString());
//        List<FreeClassroomModel> targetClassrooms = new ArrayList<>();
//
//        QueryWrapper<ClassroomDO> wrapper = new QueryWrapper<>();
//
//        wrapper.orderByAsc("id");
//
//        Page<ClassroomDO> page = new Page<>(pageable.getPageNumber(), pageable.getPageSize());
//
//        IPage<ClassroomDO> classroomDOIPage;
//
//        classroomDOIPage = classroomMapper.selectPage(page, wrapper);
//
//        logger.info("PAGE_TOTAL: " + page.getTotal());
//        logger.info("PAGE_SIZE: " + page.getSize());
//        logger.info("PAGE_CURRENT: " + page.getCurrent());
//
//        for (ClassroomDO classroomDO : classroomDOIPage.getRecords()) {
////            System.out.println("-------------------------------------------");
////            System.out.println("classroomDO: " + classroomDO.getId());
//
//            boolean flag = true;
//            // 当该教室该节次时间段有课时，标记flag=false
//            for (Integer i : targetClasses) {
//                if (!ifNull(i, classroomDO, startWeek)) {
//                    flag = false;
//                }
//            }
//            if (flag) {
//                FreeClassroomModel freeClassroomModel = new FreeClassroomModel();
//                freeClassroomModel.setStartTime(startTime);
//                freeClassroomModel.setEndTime(endTime);
////                freeClassroomModel.setSeats(classroomDO.getSeats());
////                freeClassroomModel.setBuilding(classroomDO.getBuilding());
////                freeClassroomModel.setRoom(classroomDO.getRoom());
////                freeClassroomModel.setId(classroomDO.getId());
////                freeClassroomModel.setCode(classroomDO.getCode());
//                BeanUtils.copyProperties(classroomDO, freeClassroomModel);
//                targetClassrooms.add(freeClassroomModel);
////                System.out.println("free: " + classroomDO.getId());
//
//            }
//        }
//
//        List<ClassroomListOrderVO> classroomListOrderVOS = new ArrayList<>();
//        int listId = (int) ((page.getCurrent() - 1) * page.getSize());
//        for (FreeClassroomModel t:targetClassrooms) {
//
//            ClassroomListVO classroomListVO = freeClassroomModelToClassroomListVO(t);
////            System.out.println(t.getId());
//            ClassroomListOrderVO classroomListOrderVO = new ClassroomListOrderVO(classroomListVO, ++listId);
//            classroomListOrderVOS.add(classroomListOrderVO);
//        }
//        ClassroomDisplayVO classroomDisplayVO = new ClassroomDisplayVO();
//        classroomDisplayVO.setClassroomListOrderVOS(classroomListOrderVOS);
//        classroomDisplayVO.setTotal(page.getTotal());
//        classroomDisplayVO.setCurrent(page.getCurrent());
//
//        return classroomDisplayVO;
//    }
    /**
     * 获得空教室
     * @param startTime
     * @param endTime
     * @return
     * @throws ParseException
     * @throws BusinessException
     */
    @Override
    public ClassroomDisplayVO getFreeClassroom(Date startTime, Date endTime, Pageable pageable) throws ParseException, BusinessException {

        if (pageable==null)  return null;

        // 星期几
        SimpleDateFormat week = new SimpleDateFormat("EEEE");
        String startWeek = week.format(startTime);
        String endWeek = week.format(endTime);
        if (!startWeek.equals(endWeek)) {
            logger.info("EXCEPTION: " + EmBusinessError.PARAMETER_VALIDATION_ERROR.getErrorCode() + " "
                    + EmBusinessError.PARAMETER_VALIDATION_ERROR.getErrorMsg());
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        logger.info("WEEK: " + startWeek);

        // 获取该时间段是哪几节课
        List<Integer> targetClasses = timeAndClassUtil.timeToClasses(startTime, endTime, totalProperties.getTimetableProperties().getTimetable());
        logger.info("FREE CLASSES: " + Arrays.asList(targetClasses).toString());

        QueryWrapper<ClassroomDO> wrapper = new QueryWrapper<>();

        wrapper.orderByAsc("id");
        wrapper.eq("college", "校本部");

        Page<ClassroomDO> page = new Page<>(pageable.getPageNumber(), pageable.getPageSize());

        IPage<ClassroomDO> classroomDOIPage;

        classroomDOIPage = classroomMapper.selectPage(page, wrapper);
        String osName = env.getProperty("os.name");
        logger.info("OS NAME: " + osName);

        logger.info("PAGE_TOTAL: " + page.getTotal());
        logger.info("PAGE_SIZE: " + page.getSize());
        logger.info("PAGE_CURRENT: " + page.getCurrent());
        List<ClassroomListOrderVO> classroomListOrderVOS = new ArrayList<>();
        int listId = (int) ((page.getCurrent() - 1) * page.getSize());
        for (ClassroomDO classroomDO : classroomDOIPage.getRecords()) {
//            System.out.println("-------------------------------------------");
//            System.out.println("classroomDO: " + classroomDO.getId());
            ClassroomListVO classroomListVO = new ClassroomListVO();
            BeanUtils.copyProperties(classroomDO, classroomListVO);
            ClassroomListOrderVO classroomListOrderVO = new ClassroomListOrderVO(classroomListVO, ++listId);
            boolean flag = true;
            // 当该教室该节次时间段有课时，标记flag=false
            for (Integer i : targetClasses) {
                List<String> os = new ArrayList<>();

//                System.out.println(StringUtils.indexOfIgnoreCase("Windows 10 windows", "Windows"));
//                System.out.println(StringUtils.indexOfIgnoreCase("Windows 10", "Unix"));
                if (!ifNull(i, classroomDO, startWeek, osName)) {
                    flag = false;
                }

            }
            if (flag) {
                classroomListOrderVO.setStatus("空闲中");
            } else {
                classroomListOrderVO.setStatus("占用中");
            }
            classroomListOrderVOS.add(classroomListOrderVO);
        }
        ClassroomDisplayVO classroomDisplayVO = new ClassroomDisplayVO();
        classroomDisplayVO.setClassroomListOrderVOS(classroomListOrderVOS);
        classroomDisplayVO.setTotal(page.getTotal());
        classroomDisplayVO.setCurrent(page.getCurrent());

        return classroomDisplayVO;
    }

    /**
     * FreeClassroomModel 转换成 ClassroomListVO
     * @param freeClassroomModel
     * @return
     */
    public ClassroomListVO freeClassroomModelToClassroomListVO(FreeClassroomModel freeClassroomModel) {

        ClassroomListVO classroomListVO = new ClassroomListVO();
        BeanUtils.copyProperties(freeClassroomModel, classroomListVO);

        return classroomListVO;
    }


    private boolean hasCourse(Integer num, ClassroomDO classroomDO, Date time, String osName) {


        return true;
    }


    /**
     * 时间转换为周次
     * @param date
     * @return
     */
    private int Date2Weekly(Date date) throws ParseException, BusinessException {
        SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd");
        Date start = formatter.parse("2019-09-02");
        Date end = formatter.parse("2020-01-12");

        if (date.before(start) || end.after(end)) {
            logger.info("EXCEPTION: " + EmBusinessError.PARAMETER_VALIDATION_ERROR.getErrorCode() + " "
                    + "所选时间非本学期");
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "所选时间非本学期");
        }
        int total = dateUtil.differentDays(start, date);

        return total/7 + 1;
    }

    /**
     * 判断给定条件下的教室是否为空
     * @param num
     * @param classroomDO
     * @param week
     * @return
     */
    private boolean ifNull(Integer num, ClassroomDO classroomDO, String week, String osName) {
//        logger.info("TEST: num " + num);
//        logger.info("TEST: week " + week);
//        System.out.println(env.getDefaultProfiles());
//        final String osName = env.getProperty("os.name");
//
//        if (StringUtils.indexOfIgnoreCase(osName, "windows") != 0) {
//
//        }
        if (StringUtils.indexOfIgnoreCase(osName, "Windows") != -1) {
            switch (week) {
                case "星期一":
                    switch (num) {
                        case 1:
//                            logger.info("CLASSES1: " + classroomDO.getMon1());
//                            logger.info("STATUS: " + classroomDO.getMon1().isEmpty());
                            return classroomDO.getMon1().isEmpty();
                        case 2:
//                            logger.info("CLASSES2: " + classroomDO.getMon2());
//                            logger.info("STATUS: " + classroomDO.getMon2().isEmpty());
                            return classroomDO.getMon2().isEmpty();
                        case 3:
//                            logger.info("CLASSES3: " + classroomDO.getMon3());
//                            logger.info("STATUS: " + classroomDO.getMon3().isEmpty());
                            return classroomDO.getMon3().isEmpty();
                        case 4:
//                            logger.info("CLASSES4: " + classroomDO.getMon4());
//                            logger.info("STATUS: " + classroomDO.getMon4().isEmpty());
                            return classroomDO.getMon4().isEmpty();
                        case 5:
//                            logger.info("CLASSES5: " + classroomDO.getMon5());
//                            logger.info("STATUS: " + classroomDO.getMon5().isEmpty());
                            return classroomDO.getMon5().isEmpty();
                        case 6:
//                            logger.info("CLASSES6: " + classroomDO.getMon6());
//                            logger.info("STATUS: " + classroomDO.getMon6().isEmpty());
                            return classroomDO.getMon6().isEmpty();
                    }
                case "星期二":
                    switch (num) {
                        case 1:
                            return classroomDO.getTue1().isEmpty();
                        case 2:
                            return classroomDO.getTue2().isEmpty();
                        case 3:
                            return classroomDO.getTue3().isEmpty();
                        case 4:
                            return classroomDO.getTue4().isEmpty();
                        case 5:
                            return classroomDO.getTue5().isEmpty();
                        case 6:
                            return classroomDO.getTue6().isEmpty();
                    }
                case "星期三":
                    switch (num) {
                        case 1:
                            return classroomDO.getWed1().isEmpty();
                        case 2:
                            return classroomDO.getWed2().isEmpty();
                        case 3:
                            return classroomDO.getWed3().isEmpty();
                        case 4:
                            return classroomDO.getWed4().isEmpty();
                        case 5:
                            return classroomDO.getWed5().isEmpty();
                        case 6:
                            return classroomDO.getWed6().isEmpty();
                    }
                case "星期四":
                    switch (num) {
                        case 1:
                            return classroomDO.getThur1().isEmpty();
                        case 2:
                            return classroomDO.getThur2().isEmpty();
                        case 3:
                            return classroomDO.getThur3().isEmpty();
                        case 4:
                            return classroomDO.getThur4().isEmpty();
                        case 5:
                            return classroomDO.getThur5().isEmpty();
                        case 6:
                            return classroomDO.getThur6().isEmpty();
                    }
                case "星期五":
                    switch (num) {
                        case 1:
                            return classroomDO.getFri1().isEmpty();
                        case 2:
                            return classroomDO.getFri2().isEmpty();
                        case 3:
                            return classroomDO.getFri3().isEmpty();
                        case 4:
                            return classroomDO.getFri4().isEmpty();
                        case 5:
                            return classroomDO.getFri5().isEmpty();
                        case 6:
                            return classroomDO.getFri6().isEmpty();
                    }
                case "星期六":
                    switch (num) {
                        case 1:
                            return classroomDO.getSat1().isEmpty();
                        case 2:
                            return classroomDO.getSat2().isEmpty();
                        case 3:
                            return classroomDO.getSat3().isEmpty();
                        case 4:
                            return classroomDO.getSat4().isEmpty();
                        case 5:
                            return classroomDO.getSat5().isEmpty();
                        case 6:
                            return classroomDO.getSat6().isEmpty();
                    }
                case "星期日":
                    switch (num) {
                        case 1:
                            return classroomDO.getSun1().isEmpty();
                        case 2:
                            return classroomDO.getSun2().isEmpty();
                        case 3:
                            return classroomDO.getSun3().isEmpty();
                        case 4:
                            return classroomDO.getSun4().isEmpty();
                        case 5:
                            return classroomDO.getSun5().isEmpty();
                        case 6:
                            return classroomDO.getSun6().isEmpty();
                    }
                    break;
            }
        } else {
            switch (week) {
                case "Monday":
                    switch (num) {
                        case 1:
//                            logger.info("CLASSES1: " + classroomDO.getMon1());
//                            logger.info("STATUS: " + classroomDO.getMon1().isEmpty());
                            return classroomDO.getMon1().isEmpty();
                        case 2:
//                            logger.info("CLASSES2: " + classroomDO.getMon2());
//                            logger.info("STATUS: " + classroomDO.getMon2().isEmpty());
                            return classroomDO.getMon2().isEmpty();
                        case 3:
//                            logger.info("CLASSES3: " + classroomDO.getMon3());
//                            logger.info("STATUS: " + classroomDO.getMon3().isEmpty());
                            return classroomDO.getMon3().isEmpty();
                        case 4:
//                            logger.info("CLASSES4: " + classroomDO.getMon4());
//                            logger.info("STATUS: " + classroomDO.getMon4().isEmpty());
                            return classroomDO.getMon4().isEmpty();
                        case 5:
//                            logger.info("CLASSES5: " + classroomDO.getMon5());
//                            logger.info("STATUS: " + classroomDO.getMon5().isEmpty());
                            return classroomDO.getMon5().isEmpty();
                        case 6:
//                            logger.info("CLASSES6: " + classroomDO.getMon6());
//                            logger.info("STATUS: " + classroomDO.getMon6().isEmpty());
                            return classroomDO.getMon6().isEmpty();
                    }
                case "Tuesday":
                    switch (num) {
                        case 1:
                            return classroomDO.getTue1().isEmpty();
                        case 2:
                            return classroomDO.getTue2().isEmpty();
                        case 3:
                            return classroomDO.getTue3().isEmpty();
                        case 4:
                            return classroomDO.getTue4().isEmpty();
                        case 5:
                            return classroomDO.getTue5().isEmpty();
                        case 6:
                            return classroomDO.getTue6().isEmpty();
                    }
                case "Wednesday":
                    switch (num) {
                        case 1:
                            return classroomDO.getWed1().isEmpty();
                        case 2:
                            return classroomDO.getWed2().isEmpty();
                        case 3:
                            return classroomDO.getWed3().isEmpty();
                        case 4:
                            return classroomDO.getWed4().isEmpty();
                        case 5:
                            return classroomDO.getWed5().isEmpty();
                        case 6:
                            return classroomDO.getWed6().isEmpty();
                    }
                case "Thursday":
                    switch (num) {
                        case 1:
                            return classroomDO.getThur1().isEmpty();
                        case 2:
                            return classroomDO.getThur2().isEmpty();
                        case 3:
                            return classroomDO.getThur3().isEmpty();
                        case 4:
                            return classroomDO.getThur4().isEmpty();
                        case 5:
                            return classroomDO.getThur5().isEmpty();
                        case 6:
                            return classroomDO.getThur6().isEmpty();
                    }
                case "Friday":
                    switch (num) {
                        case 1:
                            return classroomDO.getFri1().isEmpty();
                        case 2:
                            return classroomDO.getFri2().isEmpty();
                        case 3:
                            return classroomDO.getFri3().isEmpty();
                        case 4:
                            return classroomDO.getFri4().isEmpty();
                        case 5:
                            return classroomDO.getFri5().isEmpty();
                        case 6:
                            return classroomDO.getFri6().isEmpty();
                    }
                case "Saturday":
                    switch (num) {
                        case 1:
                            return classroomDO.getSat1().isEmpty();
                        case 2:
                            return classroomDO.getSat2().isEmpty();
                        case 3:
                            return classroomDO.getSat3().isEmpty();
                        case 4:
                            return classroomDO.getSat4().isEmpty();
                        case 5:
                            return classroomDO.getSat5().isEmpty();
                        case 6:
                            return classroomDO.getSat6().isEmpty();
                    }
                case "Sunday":
                    switch (num) {
                        case 1:
                            return classroomDO.getSun1().isEmpty();
                        case 2:
                            return classroomDO.getSun2().isEmpty();
                        case 3:
                            return classroomDO.getSun3().isEmpty();
                        case 4:
                            return classroomDO.getSun4().isEmpty();
                        case 5:
                            return classroomDO.getSun5().isEmpty();
                        case 6:
                            return classroomDO.getSun6().isEmpty();
                    }
                    break;
            }
        }

        return false;
    }

}
