package com.hlb.entity;

import java.text.ParseException;

public class Students_score extends AEntity {

    String score_id;
    String name;
    int Java;
    int CLanguage;
    int DataBase;
    int OS;

    public Students_score() {
    }

    public Students_score(String id, String name, int java, int CLanguage, int dataBase, int OS) {
        this.score_id = id;
        this.name = name;
        Java = java;
        this.CLanguage = CLanguage;
        DataBase = dataBase;
        this.OS = OS;
    }

    public String getScore_id() {
        return score_id;
    }

    public void setScore_id(String score_id) {
        this.score_id = score_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getJava() {
        return Java;
    }

    public void setJava(int java) {
        Java = java;
    }

    public int getCLanguage() {
        return CLanguage;
    }

    public void setCLanguage(int CLanguage) {
        this.CLanguage = CLanguage;
    }

    public int getDataBase() {
        return DataBase;
    }

    public void setDataBase(int dataBase) {
        DataBase = dataBase;
    }

    public int getOS() {
        return OS;
    }

    public void setOS(int OS) {
        this.OS = OS;
    }

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
