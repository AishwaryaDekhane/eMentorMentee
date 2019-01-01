package com.modern.mentormentee;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.modern.database.DatabaseHandler;
import com.modern.model.Student;
import com.modern.model.Teacher;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnSignin, btnReset, btnRegister;
    EditText txtUsername, txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtUsername = (EditText) findViewById(R.id.txtusername);
        txtPassword = (EditText) findViewById(R.id.txtpassword);
        btnSignin = (Button) findViewById(R.id.btnSignin);
        btnReset = (Button) findViewById(R.id.btnReset);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnSignin.setOnClickListener(this);
        btnReset.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
        // save two teachers by default first time app install
        AddTeachers();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSignin:
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                // Creating Bundle object
                Bundle bundle = new Bundle();
                if (txtUsername.getText().toString().trim().equals("admin") && txtPassword.getText().toString().trim().equals("123")) {
                    bundle.putString("LoginType", "Admin");
                    intent.putExtras(bundle);
                    finish();
                    startActivity(intent);
                } else {
                    DatabaseHandler databaseHandler = new DatabaseHandler(this.getApplicationContext());
                    Teacher teacher = databaseHandler.getTeacher(0, txtUsername.getText().toString().trim(), txtPassword.getText().toString().trim());
                    if (teacher != null) {
                        bundle.putString("LoginType", "Teacher");
                        intent.putExtra("Teacher", teacher);
                        intent.putExtras(bundle);
                        finish();
                        startActivity(intent);
                    } else {
                        Student student = databaseHandler.getStudent(txtUsername.getText().toString().trim(), txtPassword.getText().toString().trim());
                        if (student != null) {
                            bundle.putString("LoginType", "Student");
                            intent.putExtra("Student", student);
                            intent.putExtras(bundle);
                            finish();
                            startActivity(intent);
                        } else {
                            Toast.makeText(this, "Invalid Username/Password.", Toast.LENGTH_LONG).show();
                        }
                    }
                }
                break;
            case R.id.btnReset:
                txtUsername.setText("");
                txtPassword.setText("");
                break;
            case R.id.btnRegister:
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                break;
            default:
                break;
        }
    }

    // save two teachers by default
    private void AddTeachers() {
        DatabaseHandler databaseHandler = new DatabaseHandler(this.getApplicationContext());
        if (databaseHandler.getTeachersCount() == 0) {
            Teacher teacher = new Teacher();
            teacher.set_TEACHER_FNAME("Santosh");
            teacher.set_TEACHER_LNAME("Nagargoje");
            teacher.set_TEACHER_MOBILE_NO("7709576376");
            teacher.set_TEACHER_POST("Professor");
            teacher.set_TEACHER_GENDER("Male");
            teacher.set_TEACHER_USERID("santosh.nagargoje");
            teacher.set_TEACHER_PASSWORD("123");
            boolean result = databaseHandler.addTeacher(teacher);

            if (result == false) {
                Toast.makeText(this, "Teachers not found.", Toast.LENGTH_LONG).show();
            } else {
                teacher = new Teacher();
                teacher.set_TEACHER_FNAME("Pranita");
                teacher.set_TEACHER_LNAME("Mokal");
                teacher.set_TEACHER_MOBILE_NO("8379848156");
                teacher.set_TEACHER_POST("Professor");
                teacher.set_TEACHER_GENDER("Female");
                teacher.set_TEACHER_USERID("pranita.mokal");
                teacher.set_TEACHER_PASSWORD("123");
                result = databaseHandler.addTeacher(teacher);

                if (result == false) {
                    Toast.makeText(this, "Teachers not found.", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

}
