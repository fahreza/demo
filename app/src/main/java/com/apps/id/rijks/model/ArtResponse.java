package com.apps.id.rijks.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class ArtResponse {

    @SerializedName("artObjects")
    private ArrayList<ArtObjectsItem> artObjects;

    public void setArtObjects(ArrayList<ArtObjectsItem> artObjects) {
        this.artObjects = artObjects;
    }

    public ArrayList<ArtObjectsItem> getArtObjects() {
        return artObjects;
    }

    @Override
    public String toString() {
        return
                "ArtResponse{" +
                        "artObjects = '" + artObjects + '\'' +
                        "}";
    }
}