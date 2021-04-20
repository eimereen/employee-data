package com.example.employeedata.database;

import android.database.Cursor;

import com.example.employeedata.model.Employee;

import java.util.ArrayList;
import java.util.List;

public interface DatabaseCrud {
    public ArrayList<Employee> getData();
    public Boolean insertData(String name, String position, String datehired, String birthday, String address);
    public Boolean updateData(String id, String name, String position, String datehired, String birthday, String address);
    public Boolean deleteData(String id);
}
