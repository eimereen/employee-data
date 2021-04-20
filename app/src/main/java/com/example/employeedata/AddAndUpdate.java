package com.example.employeedata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.employeedata.database.DBHelper;

public class AddAndUpdate extends AppCompatActivity implements View.OnClickListener{
    private TextView employee;
    private EditText name, position, datehired, birthday, address;
    private Button undecided;
    private DBHelper dbHelper;
    private Intent decided;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_and_update);

        employee = findViewById(R.id.texttitle);
        name = findViewById(R.id.name);
        position = findViewById(R.id.position);
        datehired = findViewById(R.id.datehired);
        birthday = findViewById(R.id.bday);
        address = findViewById(R.id.address);
        undecided = findViewById(R.id.btnUpdate);

        decided = getIntent();
        String dcd = decided.getStringExtra("decided");
        undecided.setText(dcd.toUpperCase());
        employee.setText(dcd.toUpperCase());
        if (decided.getExtras().getInt("number")==-1){
            String strName = decided.getExtras().getString("name");
            String strPosition = decided.getExtras().getString("position");
            String strDatehired = decided.getExtras().getString("date hired");
            String strBirthday = decided.getExtras().getString("birthday");
            String strAddress = decided.getExtras().getString("address");
            name.setText(strName);
            position.setText(strPosition);
            datehired.setText(strDatehired);
            birthday.setText(strBirthday);
            address.setText(strAddress);
        }


        undecided.setOnClickListener(this);
        dbHelper = new DBHelper(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnUpdate:
                if (decided.getExtras().getInt("number")==1){
                    String stringname = name.getText().toString();
                    String stringposition = position.getText().toString();
                    String stringdatehired = datehired.getText().toString();
                    String stringbirthday = birthday.getText().toString();
                    String stringaddress = address.getText().toString();
                    if (dbHelper.insertData(stringname, stringposition, stringdatehired, stringbirthday, stringaddress)){
                        Toast.makeText(this, "Successfully Added", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    Toast.makeText(this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                }else{
                        String strId = decided.getExtras().getString("id");
                        String strName = name.getText().toString();
                        String strPosition = position.getText().toString();
                        String strDatehired = datehired.getText().toString();
                        String strBirthday = birthday.getText().toString();
                        String strAddress = address.getText().toString();
                        if (dbHelper.updateData(strId, strName, strPosition, strDatehired, strBirthday, strAddress)){
                            Toast.makeText(this, "Successfully Updated", Toast.LENGTH_SHORT).show();
                            Intent goingback = new Intent(this, ViewActivity.class);
                            startActivity(goingback);
                            break;
                        }
                        Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
                }


                break;
        }
    }
}