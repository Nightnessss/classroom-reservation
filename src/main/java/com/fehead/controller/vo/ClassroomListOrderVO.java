package com.fehead.controller.vo;

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
 * @author Nightnessss 2019/9/4 20:13
 */
public class ClassroomListOrderVO extends ClassroomListVO {

    private int listId;

    private String status;

    public int getListId() {
        return listId;
    }
    public void setListId(int listId) {
        this.listId = listId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ClassroomListOrderVO(ClassroomListVO classroomListVO, int listId) {
        super();
        this.setId(classroomListVO.getId());
        this.setRoom(classroomListVO.getRoom());
        this.setBuilding(classroomListVO.getBuilding());
        this.setSeats(classroomListVO.getSeats());
        this.listId = listId;
    }
    public ClassroomListOrderVO(ClassroomListVO classroomListVO) {
        super();
        this.setId(classroomListVO.getId());
        this.setRoom(classroomListVO.getRoom());
        this.setBuilding(classroomListVO.getBuilding());
        this.setSeats(classroomListVO.getSeats());
    }
}
