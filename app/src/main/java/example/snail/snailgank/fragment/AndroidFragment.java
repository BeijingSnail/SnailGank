package example.snail.snailgank.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import example.snail.snailgank.R;
import example.snail.snailgank.base.BaseFragment;
import example.snail.snailgank.bean.AndroidBean;
import example.snail.snailgank.observable.ObservableHelper;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class AndroidFragment extends BaseFragment implements Observer<List<AndroidBean>> {

    private final String TYPE = "Android";
    private final int COUNT = 10;
    private int page = 1;


    public AndroidFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateFragmentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_android, container, false);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        ObservableHelper.getAndroidObservable(TYPE, COUNT, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this);
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onNext(List<AndroidBean> androidBeen) {
        Log.d("zzq", "androidBeen=" + androidBeen.get(1).toString());

    }

}
