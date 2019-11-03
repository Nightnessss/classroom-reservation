package com.fehead.controller;

import com.fehead.error.BusinessException;
import com.fehead.error.EmBusinessError;
import com.fehead.response.CommonReturnType;
import com.fehead.service.ClassroomService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
 * @author Nightnessss 2019/8/30 16:47
 */
@RestController
@RequestMapping("/reservation/classroom")
@CrossOrigin("*")
public class ClassroomController extends BaseController {

    @Autowired
    private ClassroomService classroomService;

    @GetMapping("/getFreeClassrooms")
    public CommonReturnType getFreeClassrooms(@RequestParam("start_time") String startTime,
                                              @RequestParam("end_time") String endTime,
            @PageableDefault(size = 6,page = 1) Pageable pageable) throws Exception {
        logger.info("PARAM: startTime " + startTime);
        logger.info("PARAM: endTime " + endTime);
        if (StringUtils.isEmpty(startTime) || StringUtils.isEmpty(endTime)) {
            logger.info("EXCEPTION: " + EmBusinessError.PARAMETER_VALIDATION_ERROR.getErrorCode() + " "
                        + "参数为空");
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "参数为空");
        }
        SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm");
        Date start = formatter.parse(startTime);
        Date end = formatter.parse(endTime);

        return CommonReturnType.create(classroomService.getFreeClassroom(start, end, pageable));
    }
}
