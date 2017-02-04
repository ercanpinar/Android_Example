package com.streethawk.example.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.streethawk.example.R;
import com.streethawk.example.module.Post;

import java.util.ArrayList;

/**
 * Created by ercanpinar on 03/02/2017.
 */

/**
 * ****** Adapter class extends with BaseAdapter***********
 */
public class PostArrayAdapter extends BaseAdapter {

    /**
     * ******** Declare Used Variables ********
     */
    private Activity activity;
    private ArrayList postDataArrayList;
    private static LayoutInflater inflater = null;


    /**
     * **********  CustomAdapter Constructor ****************
     */
    public PostArrayAdapter(Activity a, ArrayList<Post> d) {

        /********** Take passed values **********/
        activity = a;
        postDataArrayList = d;

        /***********  Layout inflator to call external xml layout () ***********/
        inflater = (LayoutInflater) activity.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    /**
     * ***** What is the size of Passed Arraylist Size ***********
     */
    public int getCount() {
        return postDataArrayList.size();
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

            /****** Inflate item_post.xml file for each row ( Defined below ) *******/
            vi = inflater.inflate(R.layout.item_post, null);

            /****** View Holder Object to contain item_post.xml file elements ******/

            holder = new ViewHolder();
            holder.nameTextView = (TextView) vi.findViewById(R.id.textViewTitle);
            holder.emailTextView = (TextView) vi.findViewById(R.id.textViewBody);
            /************  Set holder with LayoutInflater ************/
            vi.setTag(holder);
        } else
            holder = (ViewHolder) vi.getTag();

        if (postDataArrayList.size() > 0) {

            /***** Get each Model object from Arraylist ********/
            Post postTempValue = (Post) postDataArrayList.get(position);

            /************  Set Model values in Holder elements ***********/

            holder.nameTextView.setText(postTempValue.getTitle());
            holder.emailTextView.setText(postTempValue.getBody());

        }

        return vi;
    }

    /**
     * get data
     */

    public ArrayList getData() {
        return postDataArrayList;
    }
}




