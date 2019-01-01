package com.modern.model;

import java.io.Serializable;

/**
 * Created by planet on 19/10/17.
 */

public class Student implements Serializable {

    int _STUDENT_ID;
    String _STUDENT_FNAME;
    String _STUDENT_LNAME;
    String _STUDENT_YEAR;
    String _STUDENT_BRANCH;
    String _STUDENT_ROLL_NO;
    String _STUDENT_MOBILE_NO;
    String _STUDENT_EMAIL_ID;
    String _STUDENT_ADDRESS;
    String _STUDENT_DOB;
    String _STUDENT_PARENT_FNAME;
    String _STUDENT_PARENT_LNAME;
    String _STUDENT_PARENT_OCCUPATION;
    String _STUDENT_PARENT_OFFICEADDRESS;
    String _STUDENT_PARENT_MOBILENO;
    String _STUDENT_PARENT_EMAILID;
    String _STUDENT_USERID;
    String _STUDENT_PASSWORD;
    int _STUDENT_TEACHER_ID;

    public Student() {
    }

    public Student(int _STUDENT_ID, String _STUDENT_FNAME, String _STUDENT_LNAME, String _STUDENT_YEAR, String _STUDENT_BRANCH, String _STUDENT_ROLL_NO, String _STUDENT_MOBILE_NO, String _STUDENT_EMAIL_ID, String _STUDENT_ADDRESS, String _STUDENT_DOB, String _STUDENT_PARENT_FNAME, String _STUDENT_PARENT_LNAME, String _STUDENT_PARENT_OCCUPATION, String _STUDENT_PARENT_OFFICEADDRESS, String _STUDENT_PARENT_MOBILENO, String _STUDENT_PARENT_EMAILID, String _STUDENT_USERID, String _STUDENT_PASSWORD, int _STUDENT_TEACHER_ID) {
        this._STUDENT_ID = _STUDENT_ID;
        this._STUDENT_FNAME = _STUDENT_FNAME;
        this._STUDENT_LNAME = _STUDENT_LNAME;
        this._STUDENT_YEAR = _STUDENT_YEAR;
        this._STUDENT_BRANCH = _STUDENT_BRANCH;
        this._STUDENT_ROLL_NO = _STUDENT_ROLL_NO;
        this._STUDENT_MOBILE_NO = _STUDENT_MOBILE_NO;
        this._STUDENT_EMAIL_ID = _STUDENT_EMAIL_ID;
        this._STUDENT_ADDRESS = _STUDENT_ADDRESS;
        this._STUDENT_DOB = _STUDENT_DOB;
        this._STUDENT_PARENT_FNAME = _STUDENT_PARENT_FNAME;
        this._STUDENT_PARENT_LNAME = _STUDENT_PARENT_LNAME;
        this._STUDENT_PARENT_OCCUPATION = _STUDENT_PARENT_OCCUPATION;
        this._STUDENT_PARENT_OFFICEADDRESS = _STUDENT_PARENT_OFFICEADDRESS;
        this._STUDENT_PARENT_MOBILENO = _STUDENT_PARENT_MOBILENO;
        this._STUDENT_PARENT_EMAILID = _STUDENT_PARENT_EMAILID;
        this._STUDENT_USERID = _STUDENT_USERID;
        this._STUDENT_PASSWORD = _STUDENT_PASSWORD;
        this._STUDENT_TEACHER_ID = _STUDENT_TEACHER_ID;
    }


    public String get_STUDENT_PARENT_OFFICEADDRESS() {
        return _STUDENT_PARENT_OFFICEADDRESS;
    }

    public void set_STUDENT_PARENT_OFFICEADDRESS(String _STUDENT_PARENT_OFFICEADDRESS) {
        this._STUDENT_PARENT_OFFICEADDRESS = _STUDENT_PARENT_OFFICEADDRESS;
    }

    public int get_STUDENT_ID() {
        return _STUDENT_ID;
    }

    public void set_STUDENT_ID(int _STUDENT_ID) {
        this._STUDENT_ID = _STUDENT_ID;
    }

    public String get_STUDENT_FNAME() {
        return _STUDENT_FNAME;
    }

    public void set_STUDENT_FNAME(String _STUDENT_FNAME) {
        this._STUDENT_FNAME = _STUDENT_FNAME;
    }

    public String get_STUDENT_LNAME() {
        return _STUDENT_LNAME;
    }

    public void set_STUDENT_LNAME(String _STUDENT_LNAME) {
        this._STUDENT_LNAME = _STUDENT_LNAME;
    }

    public String get_STUDENT_YEAR() {
        return _STUDENT_YEAR;
    }

    public void set_STUDENT_YEAR(String _STUDENT_YEAR) {
        this._STUDENT_YEAR = _STUDENT_YEAR;
    }

    public String get_STUDENT_BRANCH() {
        return _STUDENT_BRANCH;
    }

    public void set_STUDENT_BRANCH(String _STUDENT_BRANCH) {
        this._STUDENT_BRANCH = _STUDENT_BRANCH;
    }

    public String get_STUDENT_ROLL_NO() {
        return _STUDENT_ROLL_NO;
    }

    public void set_STUDENT_ROLL_NO(String _STUDENT_ROLL_NO) {
        this._STUDENT_ROLL_NO = _STUDENT_ROLL_NO;
    }

    public String get_STUDENT_MOBILE_NO() {
        return _STUDENT_MOBILE_NO;
    }

    public void set_STUDENT_MOBILE_NO(String _STUDENT_MOBILE_NO) {
        this._STUDENT_MOBILE_NO = _STUDENT_MOBILE_NO;
    }

    public String get_STUDENT_EMAIL_ID() {
        return _STUDENT_EMAIL_ID;
    }

    public void set_STUDENT_EMAIL_ID(String _STUDENT_EMAIL_ID) {
        this._STUDENT_EMAIL_ID = _STUDENT_EMAIL_ID;
    }

    public String get_STUDENT_ADDRESS() {
        return _STUDENT_ADDRESS;
    }

    public void set_STUDENT_ADDRESS(String _STUDENT_ADDRESS) {
        this._STUDENT_ADDRESS = _STUDENT_ADDRESS;
    }

    public String get_STUDENT_DOB() {
        return _STUDENT_DOB;
    }

    public void set_STUDENT_DOB(String _STUDENT_DOB) {
        this._STUDENT_DOB = _STUDENT_DOB;
    }

    public String get_STUDENT_PARENT_FNAME() {
        return _STUDENT_PARENT_FNAME;
    }

    public void set_STUDENT_PARENT_FNAME(String _STUDENT_PARENT_FNAME) {
        this._STUDENT_PARENT_FNAME = _STUDENT_PARENT_FNAME;
    }

    public String get_STUDENT_PARENT_LNAME() {
        return _STUDENT_PARENT_LNAME;
    }

    public void set_STUDENT_PARENT_LNAME(String _STUDENT_PARENT_LNAME) {
        this._STUDENT_PARENT_LNAME = _STUDENT_PARENT_LNAME;
    }

    public String get_STUDENT_PARENT_OCCUPATION() {
        return _STUDENT_PARENT_OCCUPATION;
    }

    public void set_STUDENT_PARENT_OCCUPATION(String _STUDENT_PARENT_OCCUPATION) {
        this._STUDENT_PARENT_OCCUPATION = _STUDENT_PARENT_OCCUPATION;
    }

    public String get_STUDENT_PARENT_MOBILENO() {
        return _STUDENT_PARENT_MOBILENO;
    }

    public void set_STUDENT_PARENT_MOBILENO(String _STUDENT_PARENT_MOBILENO) {
        this._STUDENT_PARENT_MOBILENO = _STUDENT_PARENT_MOBILENO;
    }

    public String get_STUDENT_PARENT_EMAILID() {
        return _STUDENT_PARENT_EMAILID;
    }

    public void set_STUDENT_PARENT_EMAILID(String _STUDENT_PARENT_EMAILID) {
        this._STUDENT_PARENT_EMAILID = _STUDENT_PARENT_EMAILID;
    }

    public String get_STUDENT_USERID() {
        return _STUDENT_USERID;
    }

    public void set_STUDENT_USERID(String _STUDENT_USERID) {
        this._STUDENT_USERID = _STUDENT_USERID;
    }

    public String get_STUDENT_PASSWORD() {
        return _STUDENT_PASSWORD;
    }

    public void set_STUDENT_PASSWORD(String _STUDENT_PASSWORD) {
        this._STUDENT_PASSWORD = _STUDENT_PASSWORD;
    }

    public int get_STUDENT_TEACHER_ID() {
        return _STUDENT_TEACHER_ID;
    }

    public void set_STUDENT_TEACHER_ID(int _STUDENT_TEACHER_ID) {
        this._STUDENT_TEACHER_ID = _STUDENT_TEACHER_ID;
    }
}
