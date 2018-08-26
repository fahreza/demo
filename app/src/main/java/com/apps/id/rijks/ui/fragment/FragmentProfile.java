package com.apps.id.rijks.ui.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.apps.id.rijks.R;
import com.apps.id.rijks.ui.activity.ActivityBase;
import com.apps.id.rijks.ui.activity.ActivityLogin;
import com.apps.id.rijks.ui.util.PreferenceUtil;
import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.bumptech.glide.request.RequestOptions.circleCropTransform;

/**
 * Created by fahrezafauzi on 8/26/18.
 */

public class FragmentProfile extends Fragment implements View.OnClickListener {

    @BindView(R.id.img_profile_picture)
    ImageView mImgProfilePicture;
    @BindView(R.id.txt_profile_user_name)
    TextView mTxtProfileUserName;
    @BindView(R.id.btn_profile_logout)
    Button mBtnProfileLogout;
    Unbinder unbinder;

    public static FragmentProfile newInstance() {
        return new FragmentProfile();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_detail, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBtnProfileLogout.setOnClickListener(this);
        mTxtProfileUserName.setText(PreferenceUtil.getUserEmail());
        Glide.with(getContext()).load("https://i.stack.imgur.com/l60Hf.png").apply(circleCropTransform()).into(mImgProfilePicture);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onClick(View view) {
        ((ActivityBase) getActivity()).showYesNoDialog(getString(R.string.msg_logout), (dialogInterface, i) -> {
            FirebaseAuth.getInstance().signOut();
            getActivity().startActivity(new Intent(getActivity(), ActivityLogin.class));
            getActivity().finish();
        });

    }
}
