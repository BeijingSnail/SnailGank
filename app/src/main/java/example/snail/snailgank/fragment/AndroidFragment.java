package example.snail.snailgank.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import example.snail.snailgank.R;
import example.snail.snailgank.adapter.AndroidAdapter;
import example.snail.snailgank.base.BaseFragment;
import example.snail.snailgank.bean.AndroidBean;
import example.snail.snailgank.observable.ObservableHelper;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class AndroidFragment extends BaseFragment implements Observer<List<AndroidBean>>, XRecyclerView.LoadingListener {

    private final String TYPE = "Android";
    private final int COUNT = 10;
    @Bind(R.id.android_xrv)
    XRecyclerView androidXrv;
    private int page = 0;
    private AndroidAdapter adapter;

    public AndroidFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateFragmentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_android, null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initXRecyclerView();
    }

    private void initXRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        androidXrv.setLayoutManager(layoutManager);
        androidXrv.setAdapter(adapter = new AndroidAdapter(mContext));
        androidXrv.setLoadingListener(this);
        androidXrv.refresh();
    }


    public void loadData(int page) {
        ObservableHelper.getAndroidObservable(TYPE, COUNT, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this);
    }

    @Override
    public void onCompleted() {
        if (page == 1) {
            androidXrv.refreshComplete();
        } else {
            androidXrv.loadMoreComplete();
        }
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onNext(List<AndroidBean> androidBeen) {
        Log.d("zzq", "androidBeen=" + androidBeen.get(1).toString());
        adapter.addData(androidBeen);
//        adapter.notifyDataSetChanged();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onRefresh() {
        Log.d("zzq", "onRefresh");
        page = 1;
        loadData(page);
    }

    @Override
    public void onLoadMore() {
        loadData(++page);
    }

}
