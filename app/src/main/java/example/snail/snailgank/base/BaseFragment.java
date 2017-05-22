package example.snail.snailgank.base;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseFragment extends Fragment {

    protected Context mContext;

    private View mContentView;

    public BaseFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mContentView = onCreateFragmentView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, mContentView);
        return mContentView;
    }

    /**
     * 创建view方法，子类必须重写
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    public abstract View onCreateFragmentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    @Override
    public void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    protected void showSnackBar(int strId) {
        Snackbar.make(mContentView, strId, Snackbar.LENGTH_SHORT).show();
    }

    protected void showSnackBar(String str) {
        Snackbar.make(mContentView, str, Snackbar.LENGTH_SHORT).show();
    }

}
