package com.modern.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;

import com.modern.adapter.ExpandableListAdapter;
import com.modern.database.DatabaseHandler;
import com.modern.mentormentee.R;
import com.modern.model.Teacher;

import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AdminFragment extends Fragment {

    ExpandableListView teacherList;
    ExpandableListAdapter listAdapter;
    List<Teacher> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    public AdminFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_admin, container, false);
        teacherList = (ExpandableListView) rootview.findViewById(R.id.teacherlist);
        DatabaseHandler databaseHandler = new DatabaseHandler(this.getActivity());
        listDataHeader = databaseHandler.getAllTeacher(); // show all records
        listAdapter = new ExpandableListAdapter(this.getActivity(), listDataHeader);
        teacherList.setAdapter(listAdapter);
        return rootview;
    }

}
