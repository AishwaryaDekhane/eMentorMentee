package com.modern.adapter;

/**
 * Created by planet on 21/10/17.
 */

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.modern.fragment.TeacherFragment;
import com.modern.mentormentee.R;
import com.modern.model.Teacher;

import java.util.HashMap;
import java.util.List;

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context _context;
    private List<Teacher> _listDataHeader; // header titles

    public ExpandableListAdapter(Context context, List<Teacher> listDataHeader) {
        this._context = context;
        this._listDataHeader = listDataHeader;
    }

    @Override
    public Teacher getChild(int groupPosition, int childPosititon) {
        return this._listDataHeader.get(groupPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        //final String childText = (String) getChild(groupPosition, childPosition);
        final int groupPosition1 = groupPosition;
        final List<Teacher> list = this._listDataHeader;
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.child_item, null);
        }

        Button btnViewTeacher = (Button) convertView
                .findViewById(R.id.viewteacher);
        Button btnViewStudent = (Button) convertView
                .findViewById(R.id.viewstudent);

        btnViewTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast.makeText(_context, list.get(groupPosition1).get_TEACHER_FNAME() + "", Toast.LENGTH_LONG).show();
                Bundle bundle = new Bundle();
                bundle.putInt("TeacherId", list.get(groupPosition1).get_TEACHER_ID());
                TeacherFragment fragInfo = new TeacherFragment();
                fragInfo.setArguments(bundle);
                FragmentTransaction transaction = ((AppCompatActivity) _context).getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame, fragInfo);
                transaction.commit();
            }
        });

        btnViewStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast.makeText(_context, list.get(groupPosition1).get_TEACHER_FNAME() + "", Toast.LENGTH_LONG).show();
            }
        });

        //txtListChild.setText(childText);
        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;

    }

    @Override
    public Object getGroup(int groupPosition) {
        return this._listDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this._listDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String headerTitle = ((Teacher) getGroup(groupPosition)).toString();
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.group_item, null);
        }

        TextView lblListHeader = (TextView) convertView
                .findViewById(R.id.names);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}