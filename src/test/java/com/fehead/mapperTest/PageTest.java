package com.fehead.mapperTest;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fehead.App;
import com.fehead.dao.ClassroomMapper;
import com.fehead.dao.dataobject.ClassroomDO;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collections;
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
 * @author Nightnessss 2019/9/4 20:49
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class PageTest {

    @Autowired
    private ClassroomMapper classroomMapper;

    @Test
    public void pageTest() {


        QueryWrapper<ClassroomDO> wrapper = new QueryWrapper<>();

        wrapper.orderByAsc("id");

        Page<ClassroomDO> page = new Page<>(1, 3);
//        page.setDescs(new ArrayList<>(Collections.singletonList("id")));
        List<ClassroomDO> list = classroomMapper.selectClassroomDOList(page);
//        System.out.println("总页数："+classroomDOIPage.getPages());
//
//        System.out.println("总记录数："+classroomDOIPage.getTotal());
//
        list.forEach(res->{
            System.out.println(new ReflectionToStringBuilder(res));
        });
    }
}
