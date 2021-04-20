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

        dbHelper = new DBHelper(this);
        arrayList = new ArrayList<>();
        arrayList.add(new Employee(1, "Junie", "Manager", "hello", "hi", "boom"));
        parent = findViewById(R.id.employee_list);
        adapter = new ViewListAdapter(this);
        adapter.setListOfEmployees(arrayList);
        parent.setLayoutManager(new GridLayoutManager(this, 1));
        parent.setAdapter(adapter);

    }
}