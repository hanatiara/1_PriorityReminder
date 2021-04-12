package com.example.priorityreminder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<String> taskList;
    private RecyclerView rvListTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        taskList = new ArrayList<>();
        taskList.add("PR Matematika Hal. 76 ");
        taskList.add("Tugas Seni Budaya Teater ");
        taskList.add("Presentasi PPKn ");
        taskList.add("PR Kimia Hal. 43 ");

        rvListTask = (RecyclerView) findViewById(R.id.rvListTask);
        rvListTask.setLayoutManager(new LinearLayoutManager(this));
        rvListTask.setAdapter(new TaskListAdapter(this, taskList));
    }
}