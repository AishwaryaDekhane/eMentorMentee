package com.modern.database;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.modern.model.Student;
import com.modern.model.Teacher;

public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "MentorMentee";

    // Teacher table name
    private static final String TABLE_TEACHER = "Teacher";
    // Student table name
    private static final String TABLE_STUDENT = "Student";

    // Teacher Table Columns names
    private static final String TEACHER_ID = "Id";
    private static final String TEACHER_FNAME = "FName";
    private static final String TEACHER_LNAME = "LName";
    private static final String TEACHER_MOBILE_NO = "MobileNo";
    private static final String TEACHER_POST = "Post";
    private static final String TEACHER_GENDER = "Gender";
    private static final String TEACHER_USERID = "UserId";
    private static final String TEACHER_PASSWORD = "Password";


    // Student Table Columns names
    private static final String STUDENT_ID = "Id";
    private static final String STUDENT_TEACHER_ID = "TeacherId";
    private static final String STUDENT_FNAME = "FName";
    private static final String STUDENT_LNAME = "LName";
    private static final String STUDENT_YEAR = "Year";
    private static final String STUDENT_BRANCH = "Branch";
    private static final String STUDENT_ROLL_NO = "RollNo";
    private static final String STUDENT_MOBILE_NO = "MobileNo";
    private static final String STUDENT_EMAIL_ID = "EmailId";
    private static final String STUDENT_ADDRESS = "Address";
    private static final String STUDENT_DOB = "DOB";
    private static final String STUDENT_USERID = "UserId";
    private static final String STUDENT_PASSWORD = "Password";
    private static final String STUDENT_PARENT_FNAME = "ParentFName";
    private static final String STUDENT_PARENT_LNAME = "ParentLName";
    private static final String STUDENT_PARENT_OCCUPATION = "ParentOccupation";
    private static final String STUDENT_PARENT_OFFICEADDRESS = "ParentOfficeAddress";
    private static final String STUDENT_PARENT_MOBILENO = "ParentMobileNo";
    private static final String STUDENT_PARENT_EMAILID = "ParentEmailId";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TEACHER_TABLE = "CREATE TABLE " + TABLE_TEACHER + "("
                + TEACHER_ID + " INTEGER PRIMARY KEY,"
                + TEACHER_FNAME + " TEXT,"
                + TEACHER_LNAME + " TEXT,"
                + TEACHER_MOBILE_NO + " TEXT,"
                + TEACHER_POST + " TEXT,"
                + TEACHER_GENDER + " TEXT,"
                + TEACHER_USERID + " TEXT,"
                + TEACHER_PASSWORD + " TEXT"
                + ")";
        db.execSQL(CREATE_TEACHER_TABLE);

        String CREATE_STUDENT_TABLE = "CREATE TABLE " + TABLE_STUDENT + "("
                + STUDENT_ID + " INTEGER PRIMARY KEY,"
                + STUDENT_FNAME + " TEXT,"
                + STUDENT_LNAME + " TEXT,"
                + STUDENT_YEAR + " TEXT,"
                + STUDENT_BRANCH + " TEXT,"
                + STUDENT_ROLL_NO + " TEXT,"
                + STUDENT_MOBILE_NO + " TEXT,"
                + STUDENT_EMAIL_ID + " TEXT,"
                + STUDENT_ADDRESS + " TEXT,"
                + STUDENT_DOB + " TEXT,"
                + STUDENT_PARENT_FNAME + " TEXT,"
                + STUDENT_PARENT_LNAME + " TEXT,"
                + STUDENT_PARENT_OCCUPATION + " TEXT,"
                + STUDENT_PARENT_OFFICEADDRESS + " TEXT,"
                + STUDENT_PARENT_MOBILENO + " TEXT,"
                + STUDENT_PARENT_EMAILID + " TEXT,"
                + STUDENT_USERID + " TEXT,"
                + STUDENT_PASSWORD + " TEXT,"
                + STUDENT_TEACHER_ID + " INTEGER"
                //+ "FOREIGN KEY(" + STUDENT_TEACHER_ID + ") REFERENCES "
                //+ TABLE_TEACHER + "(" + TEACHER_ID + ")"
                + ")";
        db.execSQL(CREATE_STUDENT_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TEACHER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENT);
        // Create tables again
        onCreate(db);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            // Enable foreign key constraints
            db.execSQL("PRAGMA foreign_keys=ON;");
        }
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    // Adding new teacher
    public boolean addTeacher(Teacher teacher) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TEACHER_FNAME, teacher.get_TEACHER_FNAME());
        values.put(TEACHER_LNAME, teacher.get_TEACHER_LNAME());
        values.put(TEACHER_MOBILE_NO, teacher.get_TEACHER_MOBILE_NO());
        values.put(TEACHER_POST, teacher.get_TEACHER_POST());
        values.put(TEACHER_GENDER, teacher.get_TEACHER_GENDER());
        values.put(TEACHER_USERID, teacher.get_TEACHER_USERID());
        values.put(TEACHER_PASSWORD, teacher.get_TEACHER_PASSWORD());
        // Inserting Row
        long result = db.insert(TABLE_TEACHER, null, values);
        db.close(); // Closing database connection
        return (result == -1) ? false : true;
    }

    // Adding new student
    public boolean addStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();


        ContentValues values = new ContentValues();
        values.put(STUDENT_FNAME, student.get_STUDENT_FNAME());
        values.put(STUDENT_LNAME, student.get_STUDENT_LNAME());
        values.put(STUDENT_YEAR, student.get_STUDENT_YEAR());
        values.put(STUDENT_BRANCH, student.get_STUDENT_BRANCH());
        values.put(STUDENT_ROLL_NO, student.get_STUDENT_ROLL_NO());
        values.put(STUDENT_MOBILE_NO, student.get_STUDENT_MOBILE_NO());
        values.put(STUDENT_EMAIL_ID, student.get_STUDENT_EMAIL_ID());
        values.put(STUDENT_ADDRESS, student.get_STUDENT_ADDRESS());
        values.put(STUDENT_DOB, student.get_STUDENT_DOB());
        values.put(STUDENT_PARENT_FNAME, student.get_STUDENT_PARENT_FNAME());
        values.put(STUDENT_PARENT_LNAME, student.get_STUDENT_PARENT_LNAME());
        values.put(STUDENT_PARENT_OCCUPATION, student.get_STUDENT_PARENT_OCCUPATION());
        values.put(STUDENT_PARENT_OFFICEADDRESS, student.get_STUDENT_PARENT_OFFICEADDRESS());
        values.put(STUDENT_PARENT_MOBILENO, student.get_STUDENT_PARENT_MOBILENO());
        values.put(STUDENT_PARENT_EMAILID, student.get_STUDENT_PARENT_EMAILID());
        values.put(STUDENT_USERID, student.get_STUDENT_USERID());
        values.put(STUDENT_PASSWORD, student.get_STUDENT_PASSWORD());
        values.put(STUDENT_TEACHER_ID, student.get_STUDENT_TEACHER_ID());

        // Inserting Row
        long result = db.insert(TABLE_STUDENT, null, values);
        db.close(); // Closing database connection
        return (result == -1) ? false : true;
    }

    // Getting single teacher
    public Teacher getTeacher(int id, String userid, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Teacher teacher = null;
        /*Cursor cursor = db.query(TABLE_TEACHER, new String[]{KEY_ID,
                        KEY_NAME, KEY_PH_NO}, KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);*/
        // Select single teacher Query
        String selectQuery = "";

        if (id == 0)
            selectQuery = "SELECT * FROM " + TABLE_TEACHER + " where " + TEACHER_USERID + "='" + userid
                    + "' and " + TEACHER_PASSWORD + "='" + password + "'";
        else
            selectQuery = "SELECT * FROM " + TABLE_TEACHER + " where " + TEACHER_ID + "=" + id;

        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor != null && cursor.moveToFirst()) {
            teacher = new Teacher(Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5),
                    cursor.getString(6), cursor.getString(7));
        }

        // return teacher
        return teacher;
    }

    // Getting single student
    public Student getStudent(String userid, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Student student = null;
        // Select single student Query
        String selectQuery = "SELECT * FROM " + TABLE_STUDENT + " where " + STUDENT_USERID + "='" + userid
                + "' and " + STUDENT_PASSWORD + "='" + password + "'";
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor != null && cursor.moveToFirst()) {
            student = new Student(Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5),
                    cursor.getString(6), cursor.getString(7), cursor.getString(8), cursor.getString(9), cursor.getString(10),
                    cursor.getString(11), cursor.getString(12), cursor.getString(13), cursor.getString(14), cursor.getString(15),
                    cursor.getString(16), cursor.getString(17), Integer.parseInt(cursor.getString(18)));
        }
        // return student
        return student;
    }

    // Getting All Contacts
    public List<Teacher> getAllTeacher() {
        List<Teacher> teacherList = new ArrayList<Teacher>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_TEACHER;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Teacher teacher = new Teacher();
                teacher.set_TEACHER_ID(Integer.parseInt(cursor.getString(0)));
                teacher.set_TEACHER_FNAME(cursor.getString(1));
                teacher.set_TEACHER_LNAME(cursor.getString(2));
                teacher.set_TEACHER_MOBILE_NO(cursor.getString(3));
                teacher.set_TEACHER_POST(cursor.getString(4));
                teacher.set_TEACHER_GENDER(cursor.getString(5));
                teacher.set_TEACHER_USERID(cursor.getString(6));
                teacher.set_TEACHER_PASSWORD(cursor.getString(7));
                // Adding teacher to list
                teacherList.add(teacher);
            } while (cursor.moveToNext());
        }
        // return contact list
        return teacherList;
    }

    // Getting All Student
    public List<Student> getAllStudent() {
        List<Student> studentList = new ArrayList<Student>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_STUDENT;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Student student = new Student();
                student.set_STUDENT_ID(Integer.parseInt(cursor.getString(0)));
                student.set_STUDENT_FNAME(cursor.getString(1));
                student.set_STUDENT_LNAME(cursor.getString(2));
                student.set_STUDENT_YEAR(cursor.getString(3));
                student.set_STUDENT_BRANCH(cursor.getString(4));
                student.set_STUDENT_ROLL_NO(cursor.getString(5));
                student.set_STUDENT_MOBILE_NO(cursor.getString(6));
                student.set_STUDENT_EMAIL_ID(cursor.getString(7));
                student.set_STUDENT_ADDRESS(cursor.getString(8));
                student.set_STUDENT_DOB(cursor.getString(9));
                student.set_STUDENT_PARENT_FNAME(cursor.getString(10));
                student.set_STUDENT_PARENT_LNAME(cursor.getString(11));
                student.set_STUDENT_PARENT_OCCUPATION(cursor.getString(12));
                student.set_STUDENT_PARENT_OFFICEADDRESS(cursor.getString(13));
                student.set_STUDENT_PARENT_MOBILENO(cursor.getString(14));
                student.set_STUDENT_PARENT_EMAILID(cursor.getString(15));
                student.set_STUDENT_USERID(cursor.getString(16));
                student.set_STUDENT_PASSWORD(cursor.getString(17));
                student.set_STUDENT_TEACHER_ID(Integer.parseInt(cursor.getString(18)));
                // Adding teacher to list
                studentList.add(student);
            } while (cursor.moveToNext());
        }
        // return student list
        return studentList;
    }

    // Updating single contact
   /* public int updateContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contact.getName());
        values.put(KEY_PH_NO, contact.getPhoneNumber());

        // updating row
        return db.update(TABLE_CONTACTS, values, KEY_ID + " = ?",
                new String[]{String.valueOf(contact.getID())});
    }

    // Deleting single contact
    public void deleteContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CONTACTS, KEY_ID + " = ?",
                new String[]{String.valueOf(contact.getID())});
        db.close();
    }

*/
    // Getting teachers Count
    public int getTeachersCount() {
        String countQuery = "SELECT * FROM " + TABLE_TEACHER;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        // return count
        return count;
    }

}