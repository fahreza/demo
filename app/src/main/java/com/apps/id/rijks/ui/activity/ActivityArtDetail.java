package com.apps.id.rijks.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.apps.id.rijks.R;
import com.apps.id.rijks.ui.util.TextUtil;
import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by fahrezafauzi on 8/27/18.
 */

public class ActivityArtDetail extends ActivityBase {
    public static final String EXTRA_URL_IMAGE = "extra_url_image";
    public static final String EXTRA_TITLE = "extra_title";

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.img_thumbnail)
    ImageView mImgThumbnail;
    @BindView(R.id.txt_title)
    TextView mTxtTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_art_detail);
        ButterKnife.bind(this);

        setActionBar(mToolbar, true);

        String urlImage = getIntent().getStringExtra(EXTRA_URL_IMAGE);
        String title = getIntent().getStringExtra(EXTRA_TITLE);

        if (!TextUtil.isEmptyOrNull(urlImage) && !TextUtil.isEmptyOrNull(title)) {
            Glide.with(this).load(urlImage).into(mImgThumbnail);
            mTxtTitle.setText(title);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
