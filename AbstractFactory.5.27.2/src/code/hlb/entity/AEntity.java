package code.hlb.entity;

import java.util.Date;

public class AEntity {

    String id;
    String name;
    String sex;
    int age;
    Date enter_time;
    String email;

    public AEntity() {
    }

    public AEntity(String id, String name, String sex, int age, Date enter_time, String email) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.enter_time = enter_time;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getEnter_time() {
        return enter_time;
    }

    public void setEnter_time(Date enter_time) {
        this.enter_time = enter_time;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
