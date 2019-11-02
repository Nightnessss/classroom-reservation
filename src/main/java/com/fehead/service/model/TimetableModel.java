package com.fehead.service.model;



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
 * @author Nightnessss 2019/8/31 11:56
 */
public class TimetableModel {

    private int id;

    // 1为夏令时，0为冬令时
    private int time;

    private HashMap<Integer, Map<Integer, Date>> classes;


//    public TimetableModel(int time) throws ParseException {
//        if (time==1) {
//            this.time = time;
//            this.class12Start = new SimpleDateFormat("HH:mm").parse("8:00");
//            this.class12Send = new SimpleDateFormat("HH:mm").parse("9:50");
//            this.class34Start = new SimpleDateFormat("HH:mm").parse("10:05");
//            this.class34Send = new SimpleDateFormat("HH:mm").parse("11:55");
//            this.class56Start = new SimpleDateFormat("HH:mm").parse("14:30");
//            this.class56Send = new SimpleDateFormat("HH:mm").parse("16:20");
//            this.class78Start = new SimpleDateFormat("HH:mm").parse("16:35");
//            this.class78Send = new SimpleDateFormat("HH:mm").parse("18:25");
//            this.class910Start = new SimpleDateFormat("HH:mm").parse("19:00");
//            this.class910Send = new SimpleDateFormat("HH:mm").parse("20:50");
//            this.class11Start = new SimpleDateFormat("HH:mm").parse("21:05");
//            this.class11Send = new SimpleDateFormat("HH:mm").parse("21:55");
//        } else if (time==0) {
//            this.time = time;
//            this.class12Start = new SimpleDateFormat("HH:mm").parse("8:00");
//            this.class12Send = new SimpleDateFormat("HH:mm").parse("9:50");
//            this.class34Start = new SimpleDateFormat("HH:mm").parse("10:05");
//            this.class34Send = new SimpleDateFormat("HH:mm").parse("11:55");
//            this.class56Start = new SimpleDateFormat("HH:mm").parse("14:00");
//            this.class56Send = new SimpleDateFormat("HH:mm").parse("15:50");
//            this.class78Start = new SimpleDateFormat("HH:mm").parse("16:05");
//            this.class78Send = new SimpleDateFormat("HH:mm").parse("17:55");
//            this.class910Start = new SimpleDateFormat("HH:mm").parse("19:00");
//            this.class910Send = new SimpleDateFormat("HH:mm").parse("20:50");
//            this.class11Start = new SimpleDateFormat("HH:mm").parse("21:05");
//            this.class11Send = new SimpleDateFormat("HH:mm").parse("21:55");
//        }
//    }


    public TimetableModel(int time) throws ParseException {
        if (time == 1) {
            this.time = time;
            this.classes = new HashMap<Integer, Map<Integer, Date>>() {{
                put(1, new HashMap<Integer, Date>() {{
                    put(1, new SimpleDateFormat("HH:mm").parse("8:00"));
                    put(2, new SimpleDateFormat("HH:mm").parse("9:50"));
                }});
                put(2, new HashMap<Integer, Date>() {{
                    put(1, new SimpleDateFormat("HH:mm").parse("10:05"));
                    put(2, new SimpleDateFormat("HH:mm").parse("11:55"));
                }});
                put(3, new HashMap<Integer, Date>() {{
                    put(1, new SimpleDateFormat("HH:mm").parse("14:30"));
                    put(2, new SimpleDateFormat("HH:mm").parse("16:20"));
                }});
                put(4, new HashMap<Integer, Date>() {{
                    put(1, new SimpleDateFormat("HH:mm").parse("16:35"));
                    put(2, new SimpleDateFormat("HH:mm").parse("18:25"));
                }});
                put(5, new HashMap<Integer, Date>() {{
                    put(1, new SimpleDateFormat("HH:mm").parse("19:00"));
                    put(2, new SimpleDateFormat("HH:mm").parse("20:50"));
                }});
                put(6, new HashMap<Integer, Date>() {{
                    put(1, new SimpleDateFormat("HH:mm").parse("21:05"));
                    put(2, new SimpleDateFormat("HH:mm").parse("21:55"));
                }});

            }};
        } else if (time == 0) {
            this.time = time;
            this.classes = new HashMap<Integer, Map<Integer, Date>>() {
                {
                    put(1, new HashMap<Integer, Date>() {{
                        put(1, new SimpleDateFormat("HH:mm").parse("8:00"));
                        put(2, new SimpleDateFormat("HH:mm").parse("9:50"));
                    }});
                    put(2, new HashMap<Integer, Date>() {{
                        put(1, new SimpleDateFormat("HH:mm").parse("10:05"));
                        put(2, new SimpleDateFormat("HH:mm").parse("11:55"));
                    }});
                    put(3, new HashMap<Integer, Date>() {{
                        put(1, new SimpleDateFormat("HH:mm").parse("14:00"));
                        put(2, new SimpleDateFormat("HH:mm").parse("15:50"));
                    }});
                    put(4, new HashMap<Integer, Date>() {{
                        put(1, new SimpleDateFormat("HH:mm").parse("16:05"));
                        put(2, new SimpleDateFormat("HH:mm").parse("17:55"));
                    }});
                    put(5, new HashMap<Integer, Date>() {{
                        put(1, new SimpleDateFormat("HH:mm").parse("19:00"));
                        put(2, new SimpleDateFormat("HH:mm").parse("20:50"));
                    }});
                    put(6, new HashMap<Integer, Date>() {{
                        put(1, new SimpleDateFormat("HH:mm").parse("21:05"));
                        put(2, new SimpleDateFormat("HH:mm").parse("21:55"));
                    }});
                }
            };

        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public HashMap<Integer, Map<Integer, Date>> getClasses() {
        return classes;
    }

    public void setClasses(HashMap<Integer, Map<Integer, Date>> classes) {
        this.classes = classes;
    }
}
