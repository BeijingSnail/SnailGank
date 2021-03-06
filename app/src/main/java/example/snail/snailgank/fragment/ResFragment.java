package example.snail.snailgank.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import butterknife.Bind;
import example.snail.snailgank.R;
import example.snail.snailgank.activity.WebViewActivity;
import example.snail.snailgank.adapter.ResAdapter;
import example.snail.snailgank.base.BaseFragment;
import example.snail.snailgank.bean.ResBean;
import example.snail.snailgank.common.Constant;
import example.snail.snailgank.observable.ObservableHelper;
import example.snail.snailgank.view.SpaceItemDecoration;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Res Fragment
 * A simple {@link Fragment} subclass.
 */
public class ResFragment extends BaseFragment implements XRecyclerView.LoadingListener, Observer<List<ResBean>> {

    @Bind(R.id.res_xrv)
    XRecyclerView resXrv;

    private final String TYPE = "拓展资源";

    private final int COUNT = 10;
    private int page = 0;
    private ResAdapter adapter;

    public ResFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateFragmentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_res, container, false);
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
        resXrv.setLayoutManager(layoutManager);
        //设置刷新风格
        resXrv.setRefreshProgressStyle(Constant.REFRESHSTYLE);
        resXrv.setLoadingMoreProgressStyle(Constant.REFRESHSTYLE);
        resXrv.addItemDecoration(new SpaceItemDecoration(10));

        resXrv.setAdapter(adapter = new ResAdapter(mContext));
        resXrv.setLoadingListener(this);
        resXrv.refresh();
        adapter.setRecycleViewItemClickListener((view, position) -> {
            ResBean bean = (ResBean) adapter.getItem(position);
            startActivity(new Intent(mContext, WebViewActivity.class).putExtra(Constant.OPENURL, bean.getUrl()));
        });
    }

    public void loadData(int page) {
        ObservableHelper.getResObservable(TYPE, COUNT, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this);
    }

    @Override
    public void onRefresh() {
        page = 1;
        loadData(page);
    }

    @Override
    public void onLoadMore() {
        loadData(++page);
    }

    @Override
    public void onCompleted() {
        if (page == 1) {
            resXrv.refreshComplete();
        } else {
            resXrv.loadMoreComplete();
        }
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onNext(List<ResBean> resBeen) {
        if (page == 1) {
            adapter.removeAll();
            adapter.setDataSet(resBeen);
        } else {
            adapter.addData(resBeen);
        }
    }
}
