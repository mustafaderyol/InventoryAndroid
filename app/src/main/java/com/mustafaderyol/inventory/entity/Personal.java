package com.mustafaderyol.inventory.entity;

/**
 * Created by MstfDryl on 24.12.2015.
 */




        import java.util.Date;


/**
 *
 * @author MstfDryl
 */

public class Personal
{

    private Long id;


    private String firstname;


    private String lastname;


    private String email;


    private String password;


    private Boolean sex;


    private Long createDate ;

    public Personal() {
    }

    public Personal(String firstname, String lastname, String email, String password, Boolean sex, Long createDate) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.sex = sex;
        this.createDate = createDate;
    }

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }



}
