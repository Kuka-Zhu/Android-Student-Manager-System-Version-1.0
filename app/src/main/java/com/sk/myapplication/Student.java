package com.sk.myapplication;

public class Student {
    public String name;
    public boolean sex;
    public boolean checked = false;

    public Student() {
    }

    public Student(String name, boolean sex, boolean checked) {
        this.name = name;
        this.sex = sex;
        this.checked = checked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", checked=" + checked +
                '}';
    }
}
