package com.modern.mentormentee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.modern.database.DatabaseHandler;
import com.modern.model.Student;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    EditText txtFName, txtLName, txtUsername, txtPassword, txtRetypePassword;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        txtFName = (EditText) findViewById(R.id.txtfname);
        txtLName = (EditText) findViewById(R.id.txtlname);
        txtUsername = (EditText) findViewById(R.id.txtusername);
        txtPassword = (EditText) findViewById(R.id.txtpassword);
        txtRetypePassword = (EditText) findViewById(R.id.txtretypepassword);
        btnRegister = (Button) findViewById(R.id.btnRegisterStudent);
        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnRegisterStudent:
                if (txtFName.getText().toString().trim().equals("") || txtLName.getText().toString().trim().equals("") || txtUsername.getText().toString().trim().equals("") || txtPassword.getText().toString().trim().equals("")) {
                    Toast.makeText(this, "Please fill all fields.", Toast.LENGTH_LONG).show();
                } else if (!txtPassword.getText().toString().trim().equals(txtRetypePassword.getText().toString().trim())) {
                    Toast.makeText(this, "Password not matched!", Toast.LENGTH_LONG).show();
                } else {
                    DatabaseHandler databaseHandler = new DatabaseHandler(this.getApplicationContext());
                    Student student = new Student();
                    student.set_STUDENT_FNAME(txtFName.getText().toString());
                    student.set_STUDENT_LNAME(txtLName.getText().toString());
                    student.set_STUDENT_USERID(txtUsername.getText().toString().trim());
                    student.set_STUDENT_PASSWORD(txtPassword.getText().toString().trim());
                    boolean result = databaseHandler.addStudent(student);
                    if (result == true)
                        Toast.makeText(this, "Record Added Sucessfully.", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(this, "Record not Added.", Toast.LENGTH_LONG).show();
                }
                break;
            default:
                break;
        }
    }
}
