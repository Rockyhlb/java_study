package com.hlb.entity;

import java.text.ParseException;

public abstract class AEntity {

    String content;
    abstract void setEntity(Object object) throws ParseException;
 }
