package com.njxzc.po;

public class Auser {
    private Integer uid;//主键
    private String uname;
    private String usex;
    private Integer userage;
    private String password;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }


    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUsex() {
        return usex;
    }

    public void setUsex(String usex) {
        this.usex = usex;
    }

    public Integer getUserage() {
        return userage;
    }

    public void setUserage(Integer userage) {
        this.userage = userage;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "MyUser [uid=" + uid + ", uname=" + uname + ", usex=" + usex + ", userage=" + userage + ", password="
                + password + ", getUid()=" + getUid() + ", getUname()=" + getUname() + ", getUsex()=" + getUsex()
                + ", getUserage()=" + getUserage() + ", getPassword()=" + getPassword() + ", getClass()=" + getClass()
                + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
    }
}
