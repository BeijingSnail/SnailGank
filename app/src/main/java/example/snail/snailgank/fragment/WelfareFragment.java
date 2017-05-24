package example.snail.snailgank.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import example.snail.snailgank.R;
import example.snail.snailgank.activity.PictureActivity;
import example.snail.snailgank.adapter.WelfareAdapter;
import example.snail.snailgank.base.BaseFragment;
import example.snail.snailgank.bean.WelfareBean;
import example.snail.snailgank.common.Constant;
import example.snail.snailgank.observable.ObservableHelper;
import example.snail.snailgank.view.SpaceItemDecoration;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class WelfareFragment extends BaseFragment implements XRecyclerView.LoadingListener, Observer<List<WelfareBean>> {

    private final String TYPE = "福利";
    private final int COUNT = 10;
    @Bind(R.id.welfare_xrv)
    XRecyclerView welfareXrv;
    private int page = 0;
    private WelfareAdapter adapter;


    public WelfareFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateFragmentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_welfare, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initXRecyclerView();
    }

    private void initXRecyclerView() {

        GridLayoutManager layoutManager = new GridLayoutManager(mContext, 2);
        //设置刷新风格
        welfareXrv.setRefreshProgressStyle(Constant.REFRESHSTYLE);
        welfareXrv.setLoadingMoreProgressStyle(Constant.REFRESHSTYLE);
        welfareXrv.setLayoutManager(layoutManager);
        welfareXrv.addItemDecoration(new SpaceItemDecoration(10));
        welfareXrv.setAdapter(adapter = new WelfareAdapter(mContext));
        welfareXrv.setLoadingListener(this);
        welfareXrv.refresh();
        adapter.setRecycleViewItemClickListener((view, position) -> {
            startActivity(new Intent(mContext, PictureActivity.class)
                    .putExtra(Constant.POSITION, position)
                    .putStringArrayListExtra(Constant.UELLIST,transform(adapter.getDataSet()))
            );
        });

        page = 1;
        loadData(page);
    }

    public void loadData(int page) {
        ObservableHelper.getWelfareObservable(TYPE, COUNT, page)
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
            welfareXrv.refreshComplete();
        } else {
            welfareXrv.loadMoreComplete();
        }
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onNext(List<WelfareBean> welfareBeen) {
        if (page == 1) {
            adapter.removeAll();
            adapter.setDataSet(welfareBeen);
            adapter.notifyDataSetChanged();
        } else {
            adapter.addData(welfareBeen);
        }
    }

    /**
     * 提取WelfareBean中的图片url
     */
    public ArrayList<String> transform(List<WelfareBean> list) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (WelfareBean welfareBean : list) {
            arrayList.add(welfareBean.getUrl());
        }
        return arrayList;
    }
}
