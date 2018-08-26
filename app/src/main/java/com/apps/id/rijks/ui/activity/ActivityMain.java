package com.apps.id.rijks.ui.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.apps.id.rijks.R;
import com.apps.id.rijks.ui.fragment.FragmentHome;
import com.apps.id.rijks.ui.fragment.FragmentProfile;
import com.apps.id.rijks.ui.util.PreferenceUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivityMain extends ActivityBase implements NavigationView.OnNavigationItemSelectedListener {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.nav_view)
    NavigationView mNavView;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    private ActionBarDrawerToggle mActionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setupUi();

        if (savedInstanceState == null) {
            setView(R.id.menu_home);
        }
    }

    private void setupUi() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(mActionBarDrawerToggle);
        mNavView.setNavigationItemSelectedListener(this);

        View headerView = mNavView.getHeaderView(0);
        TextView txtEmail = headerView.findViewById(R.id.txt_user_name);
        txtEmail.setText(getString(R.string.msg_welcome, PreferenceUtil.getUserEmail()));
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        setView(item.getItemId());
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mActionBarDrawerToggle.syncState();
    }

    private void setView(@IdRes int id) {
        Fragment frag = null;
        switch (id) {
            case R.id.menu_home:
                frag = FragmentHome.newInstance();
                break;
            case R.id.menu_profile:
                frag = FragmentProfile.newInstance();
                break;
        }
        if (frag != null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.content_frame, frag);
            transaction.commit();
        }
    }
}
