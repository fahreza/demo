package com.apps.id.rijks.ui.util;

import static com.orhanobut.hawk.Hawk.get;
import static com.orhanobut.hawk.Hawk.put;

/**
 * Created by fahrezafauzi on 8/26/18.
 */

public class PreferenceUtil {
    private static final String USER_EMAIL = "user_email";

    public static void putUserEmail(String email) {
        put(USER_EMAIL, email);
    }

    public static String getUserEmail() {
        return get(USER_EMAIL);
    }
}
