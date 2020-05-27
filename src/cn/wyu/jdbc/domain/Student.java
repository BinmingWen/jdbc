package cn.wyu.jdbc.domain;

import java.util.Date;

public class Student {
    private int id;
    private String name;
    private boolean gender;
    private Date birthday;

    public Student(int id, String name, boolean gender, Date birthday) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
    }

    public Student() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", birthday=" + birthday +
                '}';
    }
}
