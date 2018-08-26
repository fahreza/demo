package com.apps.id.rijks;

import com.apps.id.rijks.impl.ImplLogin;
import com.apps.id.rijks.presenter.PresenterLogin;
import com.apps.id.rijks.viewhelper.ViewHelperLogin;
import com.google.firebase.auth.FirebaseAuth;

import org.junit.Test;
import org.mockito.Mockito;

/**
 * Created by fahrezafauzi on 8/27/18.
 */

public class LoginTest {
    private ViewHelperLogin viewHelperLogin = Mockito.mock(ViewHelperLogin.class);
    private PresenterLogin presenterLogin = new ImplLogin(viewHelperLogin, Mockito.mock(FirebaseAuth.class));

    @Test
    public void loginAllEmpty() {
        String password = "";
        String email = "";
        presenterLogin.doLogin(email, password);
        Mockito.verify(viewHelperLogin).showEmailEmptyMessage();
        Mockito.verify(viewHelperLogin).showPasswordEmptyMessage();
    }

    @Test
    public void loginEmptyPassword() {
        String password = "";
        String email = "rer@gmail.com";
        presenterLogin.doLogin(email, password);
        Mockito.verify(viewHelperLogin).showPasswordEmptyMessage();
    }

    @Test
    public void loginEmptyEmail() {
        String password = "123456";
        String email = "";
        presenterLogin.doLogin(email, password);
        Mockito.verify(viewHelperLogin).showEmailEmptyMessage();
    }

}
