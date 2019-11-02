package com.fehead.service.model;

import java.util.List;
import java.util.Map;

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
 * @author Nightnessss 2019/8/30 16:45
 */
public class ClassroomModel {
    private int id;

    private String code;

    private String room;

    private String building;

    private String college;

    private String type;

    private int seats;

    private Map<String, String> classes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public Map<String, String> getClasses() {
        return classes;
    }

    public void setClasses(Map<String, String> classes) {
        this.classes = classes;
    }

    //    private String mon1;
//
//    private String mon3;
//
//    private String mon5;
//
//    private String mon7;
//
//    private String mon9;
//
//    private String mon11;
//
//    private String tue1;
//
//    private String tue3;
//
//    private String tue5;
//
//    private String tue7;
//
//    private String tue9;
//
//    private String tue11;
//
//    private String wed1;
//
//    private String wed3;
//
//    private String wed5;
//
//    private String wed7;
//
//    private String wed9;
//
//    private String wed11;
//
//    private String thr1;
//
//    private String thr3;
//
//    private String thr5;
//
//    private String thr7;
//
//    private String thr9;
//
//    private String thr11;
//
//    private String fri1;
//
//    private String fri3;
//
//    private String fri5;
//
//    private String fri7;
//
//    private String fri9;
//
//    private String fri11;
//
//    private String sat1;
//
//    private String sat3;
//
//    private String sat5;
//
//    private String sat7;
//
//    private String sat9;
//
//    private String sat11;
//
//    private String sun1;
//
//    private String sun3;
//
//    private String sun5;
//
//    private String sun7;
//
//    private String sun9;
//
//    private String sun11;
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getCode() {
//        return code;
//    }
//
//    public void setCode(String code) {
//        this.code = code;
//    }
//
//    public String getRoom() {
//        return room;
//    }
//
//    public void setRoom(String room) {
//        this.room = room;
//    }
//
//    public String getBuilding() {
//        return building;
//    }
//
//    public void setBuilding(String building) {
//        this.building = building;
//    }
//
//    public String getCollege() {
//        return college;
//    }
//
//    public void setCollege(String college) {
//        this.college = college;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public int getSeats() {
//        return seats;
//    }
//
//    public void setSeats(int seats) {
//        this.seats = seats;
//    }
//
//    public String getMon1() {
//        return mon1;
//    }
//
//    public void setMon1(String mon1) {
//        this.mon1 = mon1;
//    }
//
//    public String getMon3() {
//        return mon3;
//    }
//
//    public void setMon3(String mon3) {
//        this.mon3 = mon3;
//    }
//
//    public String getMon5() {
//        return mon5;
//    }
//
//    public void setMon5(String mon5) {
//        this.mon5 = mon5;
//    }
//
//    public String getMon7() {
//        return mon7;
//    }
//
//    public void setMon7(String mon7) {
//        this.mon7 = mon7;
//    }
//
//    public String getMon9() {
//        return mon9;
//    }
//
//    public void setMon9(String mon9) {
//        this.mon9 = mon9;
//    }
//
//    public String getMon11() {
//        return mon11;
//    }
//
//    public void setMon11(String mon11) {
//        this.mon11 = mon11;
//    }
//
//    public String getTue1() {
//        return tue1;
//    }
//
//    public void setTue1(String tue1) {
//        this.tue1 = tue1;
//    }
//
//    public String getTue3() {
//        return tue3;
//    }
//
//    public void setTue3(String tue3) {
//        this.tue3 = tue3;
//    }
//
//    public String getTue5() {
//        return tue5;
//    }
//
//    public void setTue5(String tue5) {
//        this.tue5 = tue5;
//    }
//
//    public String getTue7() {
//        return tue7;
//    }
//
//    public void setTue7(String tue7) {
//        this.tue7 = tue7;
//    }
//
//    public String getTue9() {
//        return tue9;
//    }
//
//    public void setTue9(String tue9) {
//        this.tue9 = tue9;
//    }
//
//    public String getTue11() {
//        return tue11;
//    }
//
//    public void setTue11(String tue11) {
//        this.tue11 = tue11;
//    }
//
//    public String getWed1() {
//        return wed1;
//    }
//
//    public void setWed1(String wed1) {
//        this.wed1 = wed1;
//    }
//
//    public String getWed3() {
//        return wed3;
//    }
//
//    public void setWed3(String wed3) {
//        this.wed3 = wed3;
//    }
//
//    public String getWed5() {
//        return wed5;
//    }
//
//    public void setWed5(String wed5) {
//        this.wed5 = wed5;
//    }
//
//    public String getWed7() {
//        return wed7;
//    }
//
//    public void setWed7(String wed7) {
//        this.wed7 = wed7;
//    }
//
//    public String getWed9() {
//        return wed9;
//    }
//
//    public void setWed9(String wed9) {
//        this.wed9 = wed9;
//    }
//
//    public String getWed11() {
//        return wed11;
//    }
//
//    public void setWed11(String wed11) {
//        this.wed11 = wed11;
//    }
//
//    public String getThr1() {
//        return thr1;
//    }
//
//    public void setThr1(String thr1) {
//        this.thr1 = thr1;
//    }
//
//    public String getThr3() {
//        return thr3;
//    }
//
//    public void setThr3(String thr3) {
//        this.thr3 = thr3;
//    }
//
//    public String getThr5() {
//        return thr5;
//    }
//
//    public void setThr5(String thr5) {
//        this.thr5 = thr5;
//    }
//
//    public String getThr7() {
//        return thr7;
//    }
//
//    public void setThr7(String thr7) {
//        this.thr7 = thr7;
//    }
//
//    public String getThr9() {
//        return thr9;
//    }
//
//    public void setThr9(String thr9) {
//        this.thr9 = thr9;
//    }
//
//    public String getThr11() {
//        return thr11;
//    }
//
//    public void setThr11(String thr11) {
//        this.thr11 = thr11;
//    }
//
//    public String getFri1() {
//        return fri1;
//    }
//
//    public void setFri1(String fri1) {
//        this.fri1 = fri1;
//    }
//
//    public String getFri3() {
//        return fri3;
//    }
//
//    public void setFri3(String fri3) {
//        this.fri3 = fri3;
//    }
//
//    public String getFri5() {
//        return fri5;
//    }
//
//    public void setFri5(String fri5) {
//        this.fri5 = fri5;
//    }
//
//    public String getFri7() {
//        return fri7;
//    }
//
//    public void setFri7(String fri7) {
//        this.fri7 = fri7;
//    }
//
//    public String getFri9() {
//        return fri9;
//    }
//
//    public void setFri9(String fri9) {
//        this.fri9 = fri9;
//    }
//
//    public String getFri11() {
//        return fri11;
//    }
//
//    public void setFri11(String fri11) {
//        this.fri11 = fri11;
//    }
//
//    public String getSat1() {
//        return sat1;
//    }
//
//    public void setSat1(String sat1) {
//        this.sat1 = sat1;
//    }
//
//    public String getSat3() {
//        return sat3;
//    }
//
//    public void setSat3(String sat3) {
//        this.sat3 = sat3;
//    }
//
//    public String getSat5() {
//        return sat5;
//    }
//
//    public void setSat5(String sat5) {
//        this.sat5 = sat5;
//    }
//
//    public String getSat7() {
//        return sat7;
//    }
//
//    public void setSat7(String sat7) {
//        this.sat7 = sat7;
//    }
//
//    public String getSat9() {
//        return sat9;
//    }
//
//    public void setSat9(String sat9) {
//        this.sat9 = sat9;
//    }
//
//    public String getSat11() {
//        return sat11;
//    }
//
//    public void setSat11(String sat11) {
//        this.sat11 = sat11;
//    }
//
//    public String getSun1() {
//        return sun1;
//    }
//
//    public void setSun1(String sun1) {
//        this.sun1 = sun1;
//    }
//
//    public String getSun3() {
//        return sun3;
//    }
//
//    public void setSun3(String sun3) {
//        this.sun3 = sun3;
//    }
//
//    public String getSun5() {
//        return sun5;
//    }
//
//    public void setSun5(String sun5) {
//        this.sun5 = sun5;
//    }
//
//    public String getSun7() {
//        return sun7;
//    }
//
//    public void setSun7(String sun7) {
//        this.sun7 = sun7;
//    }
//
//    public String getSun9() {
//        return sun9;
//    }
//
//    public void setSun9(String sun9) {
//        this.sun9 = sun9;
//    }
//
//    public String getSun11() {
//        return sun11;
//    }
//
//    public void setSun11(String sun11) {
//        this.sun11 = sun11;
//    }
}
