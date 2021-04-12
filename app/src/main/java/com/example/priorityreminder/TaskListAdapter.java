package com.example.priorityreminder;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;

public class TaskListAdapter extends RecyclerView.Adapter<TaskListAdapter.MyViewHolder> {
    private HashMap<Integer, Boolean> isChecked = new HashMap<>();
    private Context mContext;
    private LayoutInflater inflater;
    private List<String> taskList;

    public TaskListAdapter(Context context, List<String> TaskList){
        this.mContext = context;
        this.taskList = TaskList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public TaskListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = inflater.inflate(R.layout.list_task, parent, false);

        MyViewHolder holder = new MyViewHolder(rootView);
        return holder;
    }

    @Override
    public void onBindViewHolder(TaskListAdapter.MyViewHolder holder, int position) {
        holder.cbTask.setText(taskList.get(position));
        if (isChecked.containsKey(position)){
            holder.cbTask.setChecked(isChecked.get(position));
        } else {
            holder.cbTask.setChecked(false);
        }
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        CheckBox cbTask;

        public MyViewHolder(View itemView) {
            super(itemView);

            cbTask = (CheckBox) itemView.findViewById(R.id.cbTask);

            cbTask.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked){
                        // KONDISI PADA SAAT CEKLIS
                        Toast.makeText(mContext, "Task Selesai", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

}
