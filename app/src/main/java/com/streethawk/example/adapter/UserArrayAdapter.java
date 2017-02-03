package com.streethawk.example.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.streethawk.example.R;
import com.streethawk.example.module.User;

import java.util.List;

/**
 * Created by ercanpinar on 03/02/2017.
 */

public class UserArrayAdapter extends ArrayAdapter<User> {

    private final Activity context;
    private List<User> userList = null;

    static class ViewHolder {
        public TextView nameTextView;
        public TextView emailTextView;

    }

    public UserArrayAdapter(Activity context, List<User> userList) {
        super(context, R.layout.item_user, userList);
        this.context = context;
        this.userList = userList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        // reuse views
        if (rowView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            rowView = inflater.inflate(R.layout.item_user, null);
            // configure view holder
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.nameTextView = (TextView) rowView.findViewById(R.id.textViewName);
            viewHolder.emailTextView = (TextView) rowView.findViewById(R.id.textViewEmail);
            rowView.setTag(viewHolder);
        }

        // fill data
        final  ViewHolder holder= (ViewHolder) rowView.getTag();
        User user = userList.get(position);
//        holder.nameTextView.setText(user.toString());
//        holder.emailTextView.setText(user.toString());


        return rowView;
    }
}
