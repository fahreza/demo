package com.apps.id.rijks.ui.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;

import com.apps.id.rijks.R;

/**
 * Created by fahrezafauzi on 8/26/18.
 */

@SuppressLint("Registered")
public class ActivityBase extends AppCompatActivity {
    private ProgressDialog mProgressDialog;
    private AlertDialog mAlertBuilder;

    public void showYesNoDialog(String message, DialogInterface.OnClickListener yesListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setMessage(message)
                .setPositiveButton(R.string.action_yes, yesListener)
                .setNegativeButton(R.string.action_no, (dialogInterface, i) -> mAlertBuilder.dismiss());
        mAlertBuilder = builder.create();
        mAlertBuilder.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mAlertBuilder.show();
    }

    public void showProgressDialog() {
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setCancelable(false);
        mProgressDialog.setMessage(getString(R.string.msg_loading));
        mProgressDialog.show();
    }

    public void hideProgressDialog() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }
    }

    public void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        View view = activity.getCurrentFocus();
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public void setActionBar(Toolbar toolbar, boolean backButton) {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(backButton);
        getSupportActionBar().setDisplayShowHomeEnabled(backButton);
    }

}
