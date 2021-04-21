package com.example.employeedata.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.employeedata.AddAndUpdate;
import com.example.employeedata.R;
import com.example.employeedata.database.DBHelper;
import com.example.employeedata.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class ViewListAdapter extends RecyclerView.Adapter<ViewListAdapter.ViewHolder>{
    private ArrayList<Employee> listOfEmployees = new ArrayList<>();
    private Context context;
    private DBHelper dbHelper;
    public ViewListAdapter(Context context) {
        this.context = context;
    }

    public void setListOfEmployees(ArrayList<Employee> listOfEmployees) {
        this.listOfEmployees = listOfEmployees;
    }

    @NonNull
    @Override
    public ViewListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_list, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewListAdapter.ViewHolder holder, int position) {

        // source of error : String needed but provided integer, solution String.valueOf() method
        // adding labels
        holder.id.setText("id "+String.valueOf(listOfEmployees.get(position).getId()));

        holder.name.setText("Name: "+listOfEmployees.get(position).getName());
        holder.position.setText("Positios: "+listOfEmployees.get(position).getPosition());
        holder.datehired.setText("Date Hired: "+listOfEmployees.get(position).getDatehired());
        holder.birthday.setText("Birthday: "+listOfEmployees.get(position).getBday());
        holder.address.setText("Address: "+listOfEmployees.get(position).getAddress());
        holder.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent updateActivity = new Intent(context, AddAndUpdate.class);
                updateActivity.putExtra("number", -1);
                updateActivity.putExtra("decided", "update employees");
                updateActivity.putExtra("id", String.valueOf(listOfEmployees.get(position).getId()));
                updateActivity.putExtra("name",listOfEmployees.get(position).getName());
                updateActivity.putExtra("position", listOfEmployees.get(position).getPosition());
                updateActivity.putExtra("date hired", listOfEmployees.get(position).getDatehired());
                updateActivity.putExtra("birthday", listOfEmployees.get(position).getBday());
                updateActivity.putExtra("address", listOfEmployees.get(position).getAddress());
                context.startActivity(updateActivity);
            }
        });
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper = new DBHelper(context);
                if (dbHelper.deleteData(String.valueOf(listOfEmployees.get(position).getId())))
                    Toast.makeText(context, "Successfully Deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(context, "Something Went wrong", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.listOfEmployees.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardViewparent;
        private TextView id, name, position, datehired, birthday, address;
        private Button update, delete;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardViewparent = itemView.findViewById(R.id.cardView);
            id = itemView.findViewById(R.id.employee_id);
            name = itemView.findViewById(R.id.employee_name);
            position = itemView.findViewById(R.id.employee_position);
            datehired = itemView.findViewById(R.id.employee_datehired);
            birthday = itemView.findViewById(R.id.employee_bday);
            address = itemView.findViewById(R.id.employee_address);
            update = itemView.findViewById(R.id.btnUpdate);
            delete = itemView.findViewById(R.id.btnDelete);
        }
    }
}
