package com.streethawk.example.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.streethawk.example.R;
import com.streethawk.example.module.User;

import java.util.ArrayList;

/**
 * Created by ercanpinar on 03/02/2017.
 */

/**
 * ****** Adapter class extends with BaseAdapter***********
 */
public class UserArrayAdapter extends BaseAdapter {

    /**
     * ******** Declare Used Variables ********
     */
    private Activity activity;
    private ArrayList userDataArrayList;
    private static LayoutInflater inflater = null;


    /**
     * **********  CustomAdapter Constructor ****************
     */
    public UserArrayAdapter(Activity a, ArrayList<User> d) {

        /********** Take passed values **********/
        activity = a;
        userDataArrayList = d;

        /***********  Layout inflator to call external xml layout () ***********/
        inflater = (LayoutInflater) activity.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    /**
     * ***** What is the size of Passed Arraylist Size ***********
     */
    public int getCount() {
        return userDataArrayList.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    /**
     * ****** Create a holder Class to contain inflated xml file elements ********
     */
    public static class ViewHolder {

        public TextView nameTextView;
        public TextView emailTextView;
    }

    /**
     * *** Depends upon data size called for each row , Create each ListView row ****
     */
    public View getView(int position, View convertView, ViewGroup parent) {

        View vi = convertView;
        ViewHolder holder;

        if (convertView == null) {

            /****** Inflate item_user.xml file for each row ( Defined below ) *******/
            vi = inflater.inflate(R.layout.item_user, null);

            /****** View Holder Object to contain item_user.xml file elements ******/

            holder = new ViewHolder();
            holder.nameTextView = (TextView) vi.findViewById(R.id.textViewName);
            holder.emailTextView = (TextView) vi.findViewById(R.id.textViewEmail);
            /************  Set holder with LayoutInflater ************/
            vi.setTag(holder);
        } else
            holder = (ViewHolder) vi.getTag();

        if (userDataArrayList.size() > 0) {

            /***** Get each Model object from Arraylist ********/
            User userTempValue = (User) userDataArrayList.get(position);

            /************  Set Model values in Holder elements ***********/

            holder.nameTextView.setText("userTempValue.name");
            holder.emailTextView.setText("userTempValue.email");

        }

        return vi;
    }

    /**
     * get data
     */

    public ArrayList getData() {
        return userDataArrayList;
    }
}




