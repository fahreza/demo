package com.apps.id.rijks.networking.request;

import com.apps.id.rijks.networking.RestClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by fahrezafauzi on 8/27/18.
 */

public abstract class RequestBase<T> {
    private RestClient.ApiService client;
    private RequestCallBack<T> callBack;
    private boolean isViewAdded = false;

    public RequestBase() {
        client = RestClient.getClient();
    }

    public void addView() {
        isViewAdded = true;
    }

    public void addCallBack(RequestCallBack<T> requestCallBack) {
        this.callBack = requestCallBack;
    }

    public void removeView() {
        isViewAdded = false;
    }

    public boolean isViewAdded() {
        return isViewAdded;
    }

    public abstract void requestApi();

    protected RestClient.ApiService getClient(){
        return client;
    }

    protected void sendRequest(Call<T> call) {
        call.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                if (response.isSuccessful() && isViewAdded) {
                    callBack.onRequestSuccess(response.body());
                } else if (!response.isSuccessful() && isViewAdded()) {
                    callBack.onRequestError("An Error Has Occurred");
                }
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                if (isViewAdded()) {
                    callBack.onRequestError("Connection fail, Please Try Again");
                }
            }
        });
    }

}
