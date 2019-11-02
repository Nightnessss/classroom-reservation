package com.fehead.service;

import com.fehead.controller.vo.ClassroomDisplayVO;
import com.fehead.controller.vo.ClassroomListOrderVO;
import com.fehead.controller.vo.ClassroomListVO;
import com.fehead.dao.dataobject.ClassroomDO;
import com.fehead.error.BusinessException;
import com.fehead.service.model.ClassroomModel;
import com.fehead.service.model.FreeClassroomModel;
import org.springframework.data.domain.Pageable;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

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
 * @author Nightnessss 2019/8/30 16:57
 */
public interface ClassroomService {

    public ClassroomDisplayVO getFreeClassroom(Date startTime, Date endTime, Pageable pageable) throws ParseException, BusinessException;
}
