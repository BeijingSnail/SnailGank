package example.snail.snailgank.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import example.snail.snailgank.R;
import example.snail.snailgank.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ResFragment extends BaseFragment {


    public ResFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateFragmentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_res, container, false);
        return view;
    }

}
