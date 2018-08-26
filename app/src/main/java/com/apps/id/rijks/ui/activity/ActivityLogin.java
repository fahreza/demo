package com.apps.id.rijks.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.apps.id.rijks.R;
import com.apps.id.rijks.impl.ImplLogin;
import com.apps.id.rijks.presenter.PresenterLogin;
import com.apps.id.rijks.ui.util.PreferenceUtil;
import com.apps.id.rijks.ui.util.SpannableStringBuilder;
import com.apps.id.rijks.viewhelper.ViewHelperLogin;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by fahrezafauzi on 8/26/18.
 */

public class ActivityLogin extends ActivityBase implements ViewHelperLogin, View.OnClickListener {
    @BindView(R.id.root_layout)
    CoordinatorLayout mCoordinatorLayout;
    @BindView(R.id.txt_email)
    EditText mTxtEmail;
    @BindView(R.id.txt_password)
    EditText mTxtPassword;
    @BindView(R.id.btn_login)
    Button mBtnLogin;
    @BindView(R.id.txt_register)
    TextView mTxtRegister;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    private PresenterLogin mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        mPresenter = new ImplLogin(this, FirebaseAuth.getInstance());

        setupUi();
    }

    private void setupUi() {
        setActionBar(mToolbar, false);
        mBtnLogin.setOnClickListener(this);
        SpannableString spannableString = SpannableStringBuilder.init(getString(R.string.msg_register_full))
                .setColor(getString(R.string.msg_have_account), ContextCompat.getColor(this, android.R.color.black))
                .makeLink(getString(R.string.msg_register), this, ContextCompat.getColor(this, R.color.register_color))
                .create();
        mTxtRegister.setText(spannableString, Button.BufferType.SPANNABLE);
        mTxtRegister.setLinksClickable(true);
        mTxtRegister.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override
    public void onClick(View view) {
        if (view == mBtnLogin) {
            mPresenter.doLogin(mTxtEmail.getText().toString(), mTxtPassword.getText().toString());
        } else {
            startActivity(new Intent(this, ActivityRegister.class));
        }
    }

    @Override
    public void showEmailEmptyMessage() {
        mTxtEmail.setError(getString(R.string.error_email_empty));
    }

    @Override
    public void showPasswordEmptyMessage() {
        mTxtPassword.setError(getString(R.string.error_password_empty));
    }

    @Override
    public void hideEmailEmptyMessage() {
        mTxtEmail.setError(null);
    }

    @Override
    public void hidePasswordEmptyMessage() {
        mTxtPassword.setError(null);
    }

    @Override
    public void showAuthFailedMessage(String message) {
        Snackbar.make(mCoordinatorLayout, message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showSuccessLoggedIn() {
        PreferenceUtil.putUserEmail(mTxtEmail.getText().toString());
        startActivity(new Intent(this, ActivityMain.class));
        finish();
    }

    @Override
    public void showLoading() {
        showProgressDialog();
    }

    @Override
    public void hideLoading() {
        hideProgressDialog();
    }

    @Override
    public void hideKeyboard() {
        hideKeyboard(this);
    }
}
