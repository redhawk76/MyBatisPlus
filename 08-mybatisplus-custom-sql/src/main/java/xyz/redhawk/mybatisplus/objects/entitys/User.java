package xyz.redhawk.mybatisplus.objects.entitys;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * <p>
 * 
 * </p>
 *
 * @author redhawk
 * @since 2019-11-28
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer id;

    private String userName;

    private String sex;

    private Integer empId;

    private LocalDate entryTime;

    private String address;

    private LocalDate birthday;

    private Float salary;

    private Long annualAlary;

    private Integer dimission;

    private String role;

    private LocalDate calendar;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }
    public LocalDate getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDate entryTime) {
        this.entryTime = entryTime;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }
    public Long getAnnualAlary() {
        return annualAlary;
    }

    public void setAnnualAlary(Long annualAlary) {
        this.annualAlary = annualAlary;
    }
    public Integer getDimission() {
        return dimission;
    }

    public void setDimission(Integer dimission) {
        this.dimission = dimission;
    }
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    public LocalDate getCalendar() {
        return calendar;
    }

    public void setCalendar(LocalDate calendar) {
        this.calendar = calendar;
    }

    @Override
    public String toString() {
        return "User{" +
            "userName=" + userName +
            ", sex=" + sex +
            ", empId=" + empId +
            ", entryTime=" + entryTime +
            ", address=" + address +
            ", birthday=" + birthday +
            ", salary=" + salary +
            ", annualAlary=" + annualAlary +
            ", dimission=" + dimission +
            ", role=" + role +
            ", calendar=" + calendar +
        "}";
    }
}
