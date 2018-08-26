package com.apps.id.rijks.impl;

import android.support.annotation.NonNull;

import com.apps.id.rijks.presenter.PresenterRegister;
import com.apps.id.rijks.ui.util.TextUtil;
import com.apps.id.rijks.viewhelper.ViewHelperRegister;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by fahrezafauzi on 8/26/18.
 */

public class ImplRegister implements PresenterRegister, OnCompleteListener<AuthResult> {
    private ViewHelperRegister viewHelper;
    private FirebaseAuth firebaseAuth;

    public ImplRegister(ViewHelperRegister viewHelper, FirebaseAuth firebaseAuth) {
        this.viewHelper = viewHelper;
        this.firebaseAuth = firebaseAuth;
    }

    @Override
    public void register(String email, String password, boolean isTncChecked) {
        boolean isUserNameEmpty = TextUtil.isEmptyOrNull(email);
        boolean isPasswordEmpty = TextUtil.isEmptyOrNull(password);

        if (isUserNameEmpty) {
            viewHelper.showEmailEmptyMessage();
        }

        if (isPasswordEmpty) {
            viewHelper.showPasswordEmptyMessage();
        }

        if (!isTncChecked) {
            viewHelper.showTncUncheckedMessage();
        }

        if (!isUserNameEmpty && !isPasswordEmpty && isTncChecked) {
            viewHelper.hideEmailEmptyMessage();
            viewHelper.hidePasswordEmptyMessage();
            viewHelper.hideTncUncheckedMessage();
            viewHelper.hideKeyboard();
            viewHelper.showLoading();

            firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this);
        }
    }

    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {
        viewHelper.hideLoading();

        if (task.isSuccessful()) {
            viewHelper.showSuccessRegister();
        } else {
            String errorMessage = TextUtil.isEmptyOrNull(task.getException().getMessage()) ? "An Error Has Occurred" : task.getException().getMessage();
            viewHelper.showRegisterFailedMessage(errorMessage);
        }
    }
}
