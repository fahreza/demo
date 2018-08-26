package com.apps.id.rijks.networking.request;

/**
 * Created by fahrezafauzi on 8/27/18.
 */

public interface RequestCallBack<T> {

    void onRequestSuccess(T response);

    void onRequestError(String message);

}
