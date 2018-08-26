package com.apps.id.rijks.viewhelper;

import com.apps.id.rijks.model.ArtObjectsItem;

import java.util.ArrayList;

/**
 * Created by fahrezafauzi on 8/27/18.
 */

public interface ViewHelperHome {

    void showLoading();

    void hideLoading();

    void showRefreshLoading();

    void hideRefreshLoading();

    void showError(String message);

    void showList(ArrayList<ArtObjectsItem> list);

    void removeAllList();

}
