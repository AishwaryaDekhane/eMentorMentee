package com.modern.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.modern.database.DatabaseHandler;
import com.modern.mentormentee.R;
import com.modern.model.Teacher;

/**
 * A simple {@link Fragment} subclass.
 */
public class TeacherFragment extends Fragment {

    int teacherId;
EditText txtfname,txtlname,txtpost,txtmobile_no,txtgender;
    public TeacherFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_teacher, container, false);
        DatabaseHandler databaseHandler = new DatabaseHandler(this.getActivity());
        Bundle bundle = this.getArguments();
        teacherId = bundle.getInt("TeacherId");
        Teacher teacher = databaseHandler.getTeacher(teacherId, "", "");
        Toast.makeText(this.getActivity(), teacher.get_TEACHER_FNAME() + "", Toast.LENGTH_LONG).show();
        txtfname=(EditText)rootview.findViewById(R.id.txtfname);
        txtlname=(EditText)rootview.findViewById(R.id.txtlname);
        txtpost=(EditText)rootview.findViewById(R.id.txtpost);
        txtmobile_no=(EditText)rootview.findViewById(R.id.txtmobile_no);
        txtgender=(EditText)rootview.findViewById(R.id.txtgender);
        txtfname.setText(teacher.get_TEACHER_FNAME());
        txtlname.setText(teacher.get_TEACHER_LNAME());
        txtpost.setText(teacher.get_TEACHER_POST());
        txtmobile_no.setText(teacher.get_TEACHER_MOBILE_NO());
        txtgender.setText(teacher.get_TEACHER_GENDER());
        return rootview;
    }

}
