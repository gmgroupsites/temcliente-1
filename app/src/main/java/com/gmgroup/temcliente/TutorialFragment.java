package com.gmgroup.temcliente;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by reisi_000 on 25/05/2017.
 */

public class TutorialFragment extends Fragment {

    public TutorialFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(getArguments().getInt("slide"));
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        return imageView;
    }
}