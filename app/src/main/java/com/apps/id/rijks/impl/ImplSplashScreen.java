package com.apps.id.rijks.impl;

import com.apps.id.rijks.presenter.PresenterSplashScreen;
import com.apps.id.rijks.viewhelper.ViewHelperSplashScreen;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by fahrezafauzi on 8/26/18.
 */

public class ImplSplashScreen implements PresenterSplashScreen {
    private ViewHelperSplashScreen viewHelper;

    public ImplSplashScreen(ViewHelperSplashScreen viewHelper) {
        this.viewHelper = viewHelper;
    }

    @Override
    public void checkUserToken(FirebaseUser firebaseUser) {
        if (firebaseUser != null) {
            viewHelper.onUserAlreadyLoggedIn();
        } else {
            viewHelper.onUserNotLoggedId();
        }
    }
}
