package com.streethawk.example.util;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import com.streethawk.example.R;
import com.streethawk.example.activity.MainActivity;

/**
 * Created by ercanpinar on 03/02/2017.
 */

public class Util {

    /**
     * Close the keyboard method.
     */
    public static void closeKeyboard(Activity activity) {
        View view = activity.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    /**
     * Methods of controlling the Internet connection status.
     */
    public static boolean internetConnectionCheck(Context context) {

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
        return isConnected;


    }

    /**
     * The method shown in the warning message.
     *
     * @param message The warning message
     * @param style   Warning message type
     */
    /*public void messageShow(String message, Style style) {
        Crouton.cancelAllCroutons();
        if (style.equals(Style.ALERT))
            Crouton.makeText(
                    mActivity, "Alert!" + "\n" + message + "\n", style
            ).show();
        else
            Crouton.makeText(
                    mActivity, "\n" + message + "\n", style
            ).show();

    }*/

    //Progress Dialog
    public static ProgressDialog createProgressDialog(Context mContext , boolean isCancelable, String message) {
        return createProgressDialogBase(mContext,isCancelable,message);
    }

    public static ProgressDialog createProgressDialog(Context mContext , boolean isCancelable) {
        return createProgressDialogBase(mContext,isCancelable,"");
    }

    public static ProgressDialog createProgressDialog(Context mContext ) {
        return createProgressDialogBase(mContext,false,"");
    }
    public static ProgressDialog createProgressDialogBase(Context mContext , boolean isCancelable,String message) {
        ProgressDialog dialog = new ProgressDialog(mContext);
        dialog.setCancelable(isCancelable);
        dialog.setMessage(mContext.getString(R.string.loading));
        if(!message.equals(""))
            dialog.setMessage(message);

        try {
            dialog.show();
        } catch (WindowManager.BadTokenException e) {

        }

        return dialog;
    }

}
