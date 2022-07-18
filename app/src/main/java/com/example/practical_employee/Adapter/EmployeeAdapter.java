package com.example.practical_employee.Adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practical_employee.R;
import com.example.practical_employee.database.Employee;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter {
    Activity activity;
    List<Employee> employeeList;

    public EmployeeAdapter(Activity activity, List<Employee> employeeList) {
        this.activity = activity;
        this.employeeList = employeeList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = activity.getLayoutInflater().inflate(R.layout.list_activity, parent, false);
        EmployeeHolder employeeHolder = new EmployeeHolder(itemView);
        return employeeHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        EmployeeHolder vh = (EmployeeHolder) holder;
        Employee model = employeeList.get(position);
        vh.name.setText(model.name);
        vh.des.setText(model.designation);
        vh.salary.setText(model.salary);
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    private class EmployeeHolder extends RecyclerView.ViewHolder {
        TextView name, des, salary;

        public EmployeeHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            des = itemView.findViewById(R.id.des);
            salary = itemView.findViewById(R.id.salary);
        }
    }
}