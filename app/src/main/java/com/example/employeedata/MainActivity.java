package com.example.employeedata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button addbtn, viewbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addbtn = findViewById(R.id.btnAdd);
        viewbtn = findViewById(R.id.btnView);
        addbtn.setOnClickListener(this);
        viewbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        final String HEADERNAME = "add employee";
        switch (v.getId()){
            case R.id.btnAdd:
                Intent addActivity = new Intent(this, AddAndUpdate.class);
                addActivity.putExtra("number",1);
                addActivity.putExtra("decided", HEADERNAME);
                startActivity(addActivity);
                break;

            case R.id.btnView:
                Intent viewActivity = new Intent (this, ViewActivity.class);
                startActivity(viewActivity);
                break;
        }
    }
}