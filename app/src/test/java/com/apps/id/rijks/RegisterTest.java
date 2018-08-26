package com.apps.id.rijks;

import com.apps.id.rijks.impl.ImplRegister;
import com.apps.id.rijks.presenter.PresenterRegister;
import com.apps.id.rijks.viewhelper.ViewHelperRegister;
import com.google.firebase.auth.FirebaseAuth;

import org.junit.Test;
import org.mockito.Mockito;

/**
 * Created by fahrezafauzi on 8/27/18.
 */

public class RegisterTest {
    private ViewHelperRegister viewHelperRegister = Mockito.mock(ViewHelperRegister.class);
    private PresenterRegister presenterRegister = new ImplRegister(viewHelperRegister, Mockito.mock(FirebaseAuth.class));

    @Test
    public void registerAllEmptyAndNotChecked() {
        String password = "";
        String email = "";
        boolean isTncChecked = false;
        presenterRegister.register(email, password, isTncChecked);
        Mockito.verify(viewHelperRegister).showEmailEmptyMessage();
        Mockito.verify(viewHelperRegister).showPasswordEmptyMessage();
        Mockito.verify(viewHelperRegister).showTncUncheckedMessage();
    }

    @Test
    public void registerPasswordEmptyAndNotChecked() {
        String password = "";
        String email = "rere@gmail.com";
        boolean isTncChecked = false;
        presenterRegister.register(email, password, isTncChecked);
        Mockito.verify(viewHelperRegister).showPasswordEmptyMessage();
        Mockito.verify(viewHelperRegister).showTncUncheckedMessage();
    }

    @Test
    public void registerEmailEmptyAndNotChecked() {
        String password = "123456";
        String email = "";
        boolean isTncChecked = false;
        presenterRegister.register(email, password, isTncChecked);
        Mockito.verify(viewHelperRegister).showEmailEmptyMessage();
        Mockito.verify(viewHelperRegister).showTncUncheckedMessage();
    }
}
