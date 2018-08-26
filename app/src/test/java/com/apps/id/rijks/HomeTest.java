package com.apps.id.rijks;

import com.apps.id.rijks.impl.ImplHome;
import com.apps.id.rijks.presenter.PresenterHome;
import com.apps.id.rijks.viewhelper.ViewHelperHome;

import org.junit.Test;
import org.mockito.Mockito;

/**
 * Created by fahrezafauzi on 8/27/18.
 */

public class HomeTest {
    private ViewHelperHome viewHelperHome = Mockito.mock(ViewHelperHome.class);
    private PresenterHome presenterHome = new ImplHome(viewHelperHome);

    @Test
    public void testGetList() {
        presenterHome.getList();
        Mockito.verify(viewHelperHome).showLoading();
    }

    @Test
    public void testRefreshList() {
        presenterHome.refreshList();
        Mockito.verify(viewHelperHome).showRefreshLoading();
    }
}
