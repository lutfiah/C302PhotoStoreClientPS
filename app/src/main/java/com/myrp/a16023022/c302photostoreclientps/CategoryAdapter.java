package com.myrp.a16023022.c302photostoreclientps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CategoryAdapter extends ArrayAdapter<Category> {

    public static final String LOG_TAG = CategoryAdapter.class.getName();

    private ArrayList<Category> alCat;
    private Context context;
    private TextView tvName;
    private TextView tvDesc;

    public CategoryAdapter(Context context, int resource, ArrayList<Category> objects) {
        super(context, resource, objects);
        alCat = objects;
        this.context = context;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row, null);

        tvName = (TextView) rowView.findViewById(R.id.tv1);
        tvDesc = (TextView) rowView.findViewById(R.id.tv2);

        Category category = alCat.get(position);

        tvName.setText(category.getName());
        tvDesc.setText(category.getDesc());

        return rowView;
    }
}
