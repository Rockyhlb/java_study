package com.hlb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.text.ParseException;

// 由lombok为类提供管理
@Data      //  get/set访问器
@NoArgsConstructor  // 无参构造器
@AllArgsConstructor // 全参构造器
@ToString  // 方法

public class Students_score extends AEntity {
    String score_id;
    String name;
    int Java;
    int CLanguage;
    int DataBase;
    int OS;

    @Override
    public void setEntity(Object object) throws ParseException {

        content = (String)object;
        String[] vals = content.split("\t");

        this.setScore_id(vals[0]);
        this.setName(vals[1]);
        this.setJava(Integer.parseInt(vals[2]));
        this.setCLanguage(Integer.parseInt(vals[3]));
        this.setDataBase(Integer.parseInt(vals[4]));
        this.setOS(Integer.parseInt(vals[5]));
    }
}
