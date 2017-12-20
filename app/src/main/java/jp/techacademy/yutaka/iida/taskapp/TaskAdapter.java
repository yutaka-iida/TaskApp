package jp.techacademy.yutaka.iida.taskapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by iiday on 2017/12/17.
 */

public class TaskAdapter extends BaseAdapter{
    private List<Task> mTaskList;
    private LayoutInflater mLayoutInflater;

    public TaskAdapter(Context context){
        mLayoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setTaskList(List<Task> taskList){
        mTaskList = taskList;
    }

    @Override
    public int getCount() {
        return mTaskList.size();
    }

    @Override
    public Object getItem(int position) {
        return mTaskList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mTaskList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if(convertView == null){
            convertView = mLayoutInflater.inflate(android.R.layout.simple_expandable_list_item_2, null);
        }
        TextView textView1 = (TextView)convertView.findViewById(android.R.id.text1);
        TextView textView2 = (TextView)convertView.findViewById(android.R.id.text2);

        textView1.setText(mTaskList.get(position).getTitle()+"   ["+mTaskList.get(position).getCategory()+"]");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-dd-mm HH:mm", Locale.JAPANESE);
        Date date = mTaskList.get(position).getDate();
        textView2.setText(simpleDateFormat.format(date));

        return convertView;
    }

}
