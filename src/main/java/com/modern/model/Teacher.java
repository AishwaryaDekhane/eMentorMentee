package com.modern.model;

import java.io.Serializable;

/**
 * Created by planet on 17/10/17.
 */

public class Teacher implements Serializable {

    int _TEACHER_ID;
    String _TEACHER_FNAME;
    String _TEACHER_LNAME;
    String _TEACHER_MOBILE_NO;
    String _TEACHER_POST;
    String _TEACHER_GENDER;
    String _TEACHER_USERID;
    String _TEACHER_PASSWORD;

    public Teacher() {
    }

    public Teacher(int _TEACHER_ID, String _TEACHER_FNAME, String _TEACHER_LNAME, String _TEACHER_MOBILE_NO, String _TEACHER_POST, String _TEACHER_GENDER, String _TEACHER_USERID, String _TEACHER_PASSWORD) {
        this._TEACHER_ID = _TEACHER_ID;
        this._TEACHER_FNAME = _TEACHER_FNAME;
        this._TEACHER_LNAME = _TEACHER_LNAME;
        this._TEACHER_MOBILE_NO = _TEACHER_MOBILE_NO;
        this._TEACHER_POST = _TEACHER_POST;
        this._TEACHER_GENDER = _TEACHER_GENDER;
        this._TEACHER_USERID = _TEACHER_USERID;
        this._TEACHER_PASSWORD = _TEACHER_PASSWORD;
    }

    public String get_TEACHER_GENDER() {
        return _TEACHER_GENDER;
    }

    public void set_TEACHER_GENDER(String _TEACHER_GENDER) {
        this._TEACHER_GENDER = _TEACHER_GENDER;
    }

    public int get_TEACHER_ID() {
        return _TEACHER_ID;
    }

    public void set_TEACHER_ID(int _TEACHER_ID) {
        this._TEACHER_ID = _TEACHER_ID;
    }

    public String get_TEACHER_FNAME() {
        return _TEACHER_FNAME;
    }

    public void set_TEACHER_FNAME(String _TEACHER_FNAME) {
        this._TEACHER_FNAME = _TEACHER_FNAME;
    }

    public String get_TEACHER_LNAME() {
        return _TEACHER_LNAME;
    }

    public void set_TEACHER_LNAME(String _TEACHER_LNAME) {
        this._TEACHER_LNAME = _TEACHER_LNAME;
    }

    public String get_TEACHER_MOBILE_NO() {
        return _TEACHER_MOBILE_NO;
    }

    public void set_TEACHER_MOBILE_NO(String _TEACHER_MOBILE_NO) {
        this._TEACHER_MOBILE_NO = _TEACHER_MOBILE_NO;
    }

    public String get_TEACHER_POST() {
        return _TEACHER_POST;
    }

    public void set_TEACHER_POST(String _TEACHER_POST) {
        this._TEACHER_POST = _TEACHER_POST;
    }

    public String get_TEACHER_USERID() {
        return _TEACHER_USERID;
    }

    public void set_TEACHER_USERID(String _TEACHER_USERID) {
        this._TEACHER_USERID = _TEACHER_USERID;
    }

    public String get_TEACHER_PASSWORD() {
        return _TEACHER_PASSWORD;
    }

    public void set_TEACHER_PASSWORD(String _TEACHER_PASSWORD) {
        this._TEACHER_PASSWORD = _TEACHER_PASSWORD;
    }

    @Override
    public String toString() {
        return get_TEACHER_FNAME() + " " + get_TEACHER_LNAME();
    }

}
