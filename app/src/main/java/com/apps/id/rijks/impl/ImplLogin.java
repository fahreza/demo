package com.apps.id.rijks.impl;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.apps.id.rijks.presenter.PresenterLogin;
import com.apps.id.rijks.viewhelper.ViewHelperLogin;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by fahrezafauzi on 8/26/18.
 */

public class ImplLogin implements PresenterLogin, OnCompleteListener<AuthResult> {
    private ViewHelperLogin viewHelper;
    private FirebaseAuth firebaseAuth;

    public ImplLogin(ViewHelperLogin viewHelper, FirebaseAuth firebaseAuth) {
        this.viewHelper = viewHelper;
        this.firebaseAuth = firebaseAuth;
    }

    @Override
    public void doLogin(String email, String password) {
        boolean isUserNameEmpty = TextUtils.isEmpty(email);
        boolean isPasswordEmpty = TextUtils.isEmpty(password);

        if (isUserNameEmpty) {
            viewHelper.showEmailEmptyMessage();
        }

        if (isPasswordEmpty) {
            viewHelper.showPasswordEmptyMessage();
        }

        if (!isUserNameEmpty && !isPasswordEmpty) {
            viewHelper.hidePasswordEmptyMessage();
            viewHelper.hideEmailEmptyMessage();
            viewHelper.hideKeyboard();
            viewHelper.showLoading();

            firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this);
        }
    }

    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {
        viewHelper.hideLoading();
        if (task.isSuccessful()) {
            viewHelper.showSuccessLoggedIn();
        } else {
            viewHelper.showAuthFailedMessage();
        }
    }
}
