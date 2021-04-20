package com.example.employeedata.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.employeedata.model.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper implements DatabaseCrud{

    public DBHelper(Context context) {
        super(context, "employee.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table employeedetails(id INTEGER primary key autoincrement, name TEXT, position TEXT, datehired TEXT, birthday TEXT, address TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists employeedetails");
    }

    @Override
    public ArrayList<Employee> getData() {
        ArrayList<Employee> employees = new ArrayList<>();
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from employeedetails",null);
        int id = cursor.getColumnIndex("id");
        int name = cursor.getColumnIndex("name");
        int position = cursor.getColumnIndex("position");
        int datehired = cursor.getColumnIndex("datehired");
        int bday = cursor.getColumnIndex("birthday");
        int address = cursor.getColumnIndex("address");
        if (cursor.moveToFirst()){
            do{
                Employee employee = new Employee();
                employee.setId(Integer.parseInt(cursor.getString(id)));
                employee.setName(cursor.getString(name));
                employee.setPosition(cursor.getString(position));
                employee.setDatehired(cursor.getString(datehired));
                employee.setBday(cursor.getString(bday));
                employee.setAddress(cursor.getString(address));


                employees.add(employee);
            }while (cursor.moveToNext());
        }
        System.out.println(Arrays.toString(employees.toArray()));
        return employees;

    }

    @Override
    public Boolean insertData( String name, String position, String datehired, String birthday, String address) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("position", position);
        contentValues.put("datehired", datehired);
        contentValues.put("birthday", birthday);
        contentValues.put("address", address);
        long result = DB.insert("employeedetails", null, contentValues);
        return result !=-1;
    }

    @Override
    public Boolean updateData(String id, String name, String position, String datehired, String birthday, String address) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("position", position);
        contentValues.put("datehired", datehired);
        contentValues.put("bday", birthday);
        contentValues.put("address", address);
        Cursor cursor = DB.rawQuery("Select * from employeedetails where id = ?", new String[]{id});
        if (cursor.getCount() > 0) {
            long result = DB.update("employeedetails", contentValues, "name=?", new String[]{id});
            return result !=-1;
        }
        return false;
    }

    @Override
    public Boolean deleteData(String id) {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from employeedetails where id = ?", new String[]{id});
        if (cursor.getCount() > 0) {
            long result = DB.delete("employeedetails", "id=?", new String[]{id});
            return result != 0;
        }
        return false;
    }
}
