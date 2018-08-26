package com.apps.id.rijks.viewhelper;

/**
 * Created by fahrezafauzi on 8/26/18.
 */

public interface ViewHelperLogin {

    void showEmailEmptyMessage();

    void showPasswordEmptyMessage();

    void hideEmailEmptyMessage();

    void hidePasswordEmptyMessage();

    void showAuthFailedMessage();

    void showSuccessLoggedIn();

    void showLoading();

    void hideLoading();

    void hideKeyboard();

}
