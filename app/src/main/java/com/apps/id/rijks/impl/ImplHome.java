package com.apps.id.rijks.impl;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;

import com.apps.id.rijks.model.ArtResponse;
import com.apps.id.rijks.networking.request.RequestArtList;
import com.apps.id.rijks.networking.request.RequestCallBack;
import com.apps.id.rijks.presenter.PresenterHome;
import com.apps.id.rijks.viewhelper.ViewHelperHome;

/**
 * Created by fahrezafauzi on 8/27/18.
 */

public class ImplHome implements RequestCallBack<ArtResponse>, PresenterHome, LifecycleObserver {
    private RequestArtList requestArtList;
    private ViewHelperHome viewHelper;

    public ImplHome(ViewHelperHome viewHelper) {
        this.viewHelper = viewHelper;
        requestArtList = new RequestArtList();
        requestArtList.addCallBack(this);

        if (viewHelper instanceof LifecycleOwner) {
            ((LifecycleOwner) viewHelper).getLifecycle().addObserver(this);
        }
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    @Override
    public void addView() {
        requestArtList.addView();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    @Override
    public void removeView() {
        requestArtList.removeView();
    }

    @Override
    public void getList() {
        viewHelper.showLoading();
        requestArtList.requestApi();
    }

    @Override
    public void refreshList() {
        viewHelper.showRefreshLoading();
        requestArtList.requestApi();
    }

    @Override
    public void onRequestSuccess(ArtResponse response) {
        viewHelper.hideLoading();
        viewHelper.hideRefreshLoading();
        viewHelper.removeAllList();
        viewHelper.showList(response.getArtObjects());
    }

    @Override
    public void onRequestError(String message) {
        viewHelper.hideLoading();
        viewHelper.hideRefreshLoading();
        viewHelper.showError(message);
    }
}
