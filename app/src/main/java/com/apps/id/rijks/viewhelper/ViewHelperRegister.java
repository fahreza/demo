package com.apps.id.rijks.viewhelper;

/**
 * Created by fahrezafauzi on 8/26/18.
 */

public interface ViewHelperRegister {

    void showEmailEmptyMessage();

    void showPasswordEmptyMessage();

    void hideEmailEmptyMessage();

    void hidePasswordEmptyMessage();

    void showRegisterFailedMessage();

    void showSuccessRegister();

    void showTncUncheckedMessage();

    void hideTncUncheckedMessage();

    void showLoading();

    void hideLoading();

    void hideKeyboard();

}
