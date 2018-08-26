package com.apps.id.rijks.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.apps.id.rijks.R;
import com.apps.id.rijks.impl.ImplHome;
import com.apps.id.rijks.model.ArtObjectsItem;
import com.apps.id.rijks.presenter.PresenterHome;
import com.apps.id.rijks.ui.adapter.AdapterArt;
import com.apps.id.rijks.viewhelper.ViewHelperHome;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by fahrezafauzi on 8/26/18.
 */

public class FragmentHome extends Fragment implements ViewHelperHome, SwipeRefreshLayout.OnRefreshListener {
    @BindView(R.id.list)
    RecyclerView mList;
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.progress_bar)
    ProgressBar mProgressBar;
    @BindView(R.id.coordinator)
    CoordinatorLayout mCoordinator;

    private Unbinder mUnbinder;
    private AdapterArt mAdapterArt;
    private PresenterHome mPresenter;

    public static FragmentHome newInstance() {
        return new FragmentHome();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        mUnbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mAdapterArt = new AdapterArt(getContext());
        mPresenter = new ImplHome(this);
        mSwipeRefreshLayout.setColorSchemeColors(ContextCompat.getColor(getContext(), R.color.colorPrimary));
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mList.setAdapter(mAdapterArt);
        mList.setLayoutManager(new LinearLayoutManager(getContext()));
        mPresenter.getList();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

    @Override
    public void onRefresh() {
        mPresenter.refreshList();
    }

    @Override
    public void showLoading() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showRefreshLoading() {
        mSwipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void hideRefreshLoading() {
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showError(String message) {
        Snackbar.make(mCoordinator, message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showList(ArrayList<ArtObjectsItem> list) {
        mAdapterArt.addItems(list);
    }

    @Override
    public void removeAllList() {
        mAdapterArt.removeAllItem();
    }
}
