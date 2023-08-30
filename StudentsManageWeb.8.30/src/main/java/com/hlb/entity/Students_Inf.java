package com.hlb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// 由lombok为类提供管理
@Data      //  get/set访问器
@NoArgsConstructor  // 无参构造器
@AllArgsConstructor // 全参构造器
@ToString  // 方法

public class Students_Inf extends AEntity{

    String id;
    String name;
    String sex;
    int age;
    Date enter_time;
    String email;

    @Override
    public void setEntity(Object object) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        content = (String)object;
        String[] vals = content.split("\t");

        this.setId(vals[0]);
        this.setName(vals[1]);
        this.setSex(vals[2]);
        this.setAge(Integer.parseInt(vals[3]));
        this.setEnter_time(sdf.parse(vals[4]));
        this.setEmail(vals[5]);
    }
}


