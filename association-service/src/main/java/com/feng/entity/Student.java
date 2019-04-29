package com.feng.entity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author rf
 * @since 2019-04-14
 */
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private String num;
    private String name;
    /**
     * 性别
     */
    private Integer sex;
    private Integer age;
    /**
     * 电子邮箱
     */
    private String email;
    private String phone;
    /**
     * 社团编号
     */
    private Integer clubNum;


    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getClubNum() {
        return clubNum;
    }

    public void setClubNum(Integer clubNum) {
        this.clubNum = clubNum;
    }

    @Override
    public String toString() {
        return "Student{" +
        "num=" + num +
        ", name=" + name +
        ", sex=" + sex +
        ", age=" + age +
        ", email=" + email +
        ", phone=" + phone +
        ", clubNum=" + clubNum +
        "}";
    }
}
