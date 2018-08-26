package com.apps.id.rijks.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.apps.id.rijks.R;
import com.apps.id.rijks.model.ArtObjectsItem;
import com.apps.id.rijks.ui.activity.ActivityArtDetail;
import com.apps.id.rijks.ui.util.TextUtil;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by fahrezafauzi on 8/27/18.
 */

public class AdapterArt extends RecyclerView.Adapter<AdapterArt.ArtViewHolder> {
    private ArrayList<ArtObjectsItem> mItems;
    private Context mContext;

    public AdapterArt(Context mContext) {
        this.mContext = mContext;
        mItems = new ArrayList<>();
    }

    @NonNull
    @Override
    public ArtViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ArtViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_art, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ArtViewHolder holder, int position) {
        holder.mTxtTitle.setText(mItems.get(position).getTitle());
        String urlImage = mItems.get(position).getWebImage().getUrl();
        if (!TextUtil.isEmptyOrNull(urlImage)) {
            Glide.with(mContext).load(urlImage).into(holder.mImgThumbnail);
        }
        holder.mLayout.setOnClickListener(view -> {
            Intent intent = new Intent(mContext, ActivityArtDetail.class);
            intent.putExtra(ActivityArtDetail.EXTRA_TITLE, mItems.get(position).getTitle());
            intent.putExtra(ActivityArtDetail.EXTRA_URL_IMAGE, urlImage);
            mContext.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public void addItems(ArrayList<ArtObjectsItem> list) {
        mItems.addAll(list);
        notifyDataSetChanged();
    }

    public void removeAllItem() {
        mItems.clear();
        notifyDataSetChanged();
    }

    class ArtViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.layout)
        RelativeLayout mLayout;
        @BindView(R.id.img_thumbnail)
        ImageView mImgThumbnail;
        @BindView(R.id.txt_title)
        TextView mTxtTitle;

        public ArtViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
