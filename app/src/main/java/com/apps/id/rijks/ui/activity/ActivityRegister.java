package com.apps.id.rijks.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.apps.id.rijks.R;
import com.apps.id.rijks.impl.ImplRegister;
import com.apps.id.rijks.presenter.PresenterRegister;
import com.apps.id.rijks.viewhelper.ViewHelperRegister;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by fahrezafauzi on 8/26/18.
 */

public class ActivityRegister extends ActivityBase implements View.OnClickListener, ViewHelperRegister {
    @BindView(R.id.txt_email)
    EditText mTxtEmail;
    @BindView(R.id.txt_password)
    EditText mTxtPassword;
    @BindView(R.id.checkbox_tnc)
    CheckBox mCheckboxTnc;
    @BindView(R.id.btn_register)
    Button mBtnRegister;
    @BindView(R.id.root_layout)
    CoordinatorLayout mCoordinatorLayout;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    private PresenterRegister mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        mPresenter = new ImplRegister(this, FirebaseAuth.getInstance());

        setupUi();
    }

    private void setupUi() {
        mBtnRegister.setOnClickListener(this);
        setActionBar(mToolbar, true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    @Override
    public void onClick(View view) {
        mPresenter.register(mTxtEmail.getText().toString(), mTxtPassword.getText().toString(), mCheckboxTnc.isChecked());
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
    public void showRegisterFailedMessage(String message) {
        Snackbar.make(mCoordinatorLayout, message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showSuccessRegister() {
        Toast.makeText(this, R.string.msg_success_register, Toast.LENGTH_LONG).show();
        startActivity(new Intent(this, ActivityLogin.class));
        finish();
    }

    @Override
    public void showTncUncheckedMessage() {
        mCheckboxTnc.setError(getString(R.string.error_tnc));
    }

    @Override
    public void hideTncUncheckedMessage() {
        mCheckboxTnc.setError(null);
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
