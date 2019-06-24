package com.example.administrator.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class numberAdapter extends ArrayAdapter<Integer> {
    private Context context;
    private ArrayList<Integer> array;

    public numberAdapter(@NonNull Context context, int resource, @NonNull List<Integer> objects) {
        super(context, resource, objects);

        this.context = context;
        this.array   = new ArrayList<>(objects);
    }

    @Override
    public void notifyDataSetChanged() {
        array = Datagame.getDatagame().getArrayList();
        super.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView==null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.item,null);
        }
        if(array.size()>0){
            item item = (com.example.administrator.myapplication.item) convertView.findViewById(R.id.item);
            item.setNumber(array.get(position));
        }else {

        }
        return convertView;
    }
}
