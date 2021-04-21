package com.example.employeedata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.employeedata.adapter.ViewListAdapter;
import com.example.employeedata.database.DBHelper;
import com.example.employeedata.model.Employee;

import java.util.ArrayList;

public class ViewActivity extends AppCompatActivity {
    private RecyclerView parent;
    private ViewListAdapter adapter;
    private DBHelper dbHelper;
    private ArrayList<Employee> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        
        // db declaration
        dbHelper = new DBHelper(this);
        // arraylist
        arrayList = new ArrayList<>(dbHelper.getData());
        // recycler view
        parent = findViewById(R.id.employee_list);
        // adapter
        adapter = new ViewListAdapter(this);
        // setting up the arraylist in viewlistadapter
        adapter.setListOfEmployees(arrayList);
        // setting up the layout for recyclerview
        parent.setLayoutManager(new GridLayoutManager(this, 1));
        // integrate the adapter in recyclerview
        parent.setAdapter(adapter);

    }
}