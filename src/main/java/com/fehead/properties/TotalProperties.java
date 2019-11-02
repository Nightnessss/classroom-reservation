package com.fehead.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

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
 * @author Nightnessss 2019/8/30 17:24
 */
@Component
@ConfigurationProperties(prefix = "fehead")
public class TotalProperties {

    private TimetableProperties timetableProperties = new TimetableProperties();

    public TimetableProperties getTimetableProperties() {
        return timetableProperties;
    }

    public void setTimetableProperties(TimetableProperties timetableProperties) {
        this.timetableProperties = timetableProperties;
    }
}
