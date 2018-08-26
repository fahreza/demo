package com.apps.id.rijks.networking.request;

import com.apps.id.rijks.model.ArtResponse;

/**
 * Created by fahrezafauzi on 8/27/18.
 */

public class RequestArtList extends RequestBase<ArtResponse> {
    @Override
    public void requestApi() {
        sendRequest(getClient().getArtList());
    }
}
