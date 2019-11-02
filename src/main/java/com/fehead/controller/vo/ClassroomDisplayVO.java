package com.fehead.controller.vo;

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
 * @author Nightnessss 2019/9/4 23:36
 */
public class ClassroomDisplayVO {

    private List<ClassroomListOrderVO> classroomListOrderVOS;

    private long total;

    private long current;

    public List<ClassroomListOrderVO> getClassroomListOrderVOS() {
        return classroomListOrderVOS;
    }

    public void setClassroomListOrderVOS(List<ClassroomListOrderVO> classroomListOrderVOS) {
        this.classroomListOrderVOS = classroomListOrderVOS;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getCurrent() {
        return current;
    }

    public void setCurrent(long current) {
        this.current = current;
    }
}
