package com.mustafaderyol.inventory.util;

/**
 * Created by MstfDryl on 25.12.2015.
 */
public class LoginItem {
    private String email;
    private String password;

    public LoginItem() {
    }

    public LoginItem(String email, String password) {
        this.email = email;
        this.password = password;
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
}
