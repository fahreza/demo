package com.apps.id.rijks.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.apps.id.rijks.R;
import com.apps.id.rijks.impl.ImplSplashScreen;
import com.apps.id.rijks.presenter.PresenterSplashScreen;
import com.apps.id.rijks.viewhelper.ViewHelperSplashScreen;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by fahrezafauzi on 8/26/18.
 */

public class ActivitySplashScreen extends AppCompatActivity implements ViewHelperSplashScreen {
    private static final long DELAY = 1000;
    private FirebaseAuth mAuth;
    private PresenterSplashScreen mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        mAuth = FirebaseAuth.getInstance();
        mPresenter = new ImplSplashScreen(this);

        new Handler().postDelayed(() -> mPresenter.checkUserToken(mAuth.getCurrentUser()), DELAY);
    }

    @Override
    public void onUserAlreadyLoggedIn() {
        startActivity(new Intent(this, ActivityMain.class));
        finish();
    }

    @Override
    public void onUserNotLoggedId() {
        startActivity(new Intent(this, ActivityLogin.class));
        finish();
    }
}
