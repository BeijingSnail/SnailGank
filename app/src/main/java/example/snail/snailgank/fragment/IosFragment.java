package example.snail.snailgank.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import butterknife.Bind;
import example.snail.snailgank.R;
import example.snail.snailgank.activity.WebViewActivity;
import example.snail.snailgank.adapter.IosAdapter;
import example.snail.snailgank.base.BaseFragment;
import example.snail.snailgank.bean.IosBean;
import example.snail.snailgank.common.Constant;
import example.snail.snailgank.observable.ObservableHelper;
import example.snail.snailgank.view.SpaceItemDecoration;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class IosFragment extends BaseFragment implements Observer<List<IosBean>>, XRecyclerView.LoadingListener {
    private final String TYPE = "iOS";
    private final int COUNT = 10;
    @Bind(R.id.ios_xrv)
    XRecyclerView iosXrv;
    private int page = 0;
    private IosAdapter adapter;

    public IosFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateFragmentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ios, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initXRecyclerView();
    }

    private void initXRecyclerView() {
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        iosXrv.setLayoutManager(layoutManager);
        iosXrv.setAdapter(adapter = new IosAdapter(mContext));
        iosXrv.addItemDecoration(new SpaceItemDecoration(10));
        iosXrv.setLoadingListener(this);
        iosXrv.refresh();
        adapter.setRecycleViewItemClickListener((v, position) -> {
            IosBean bean = (IosBean) adapter.getItem(position);
            startActivity(new Intent(mContext, WebViewActivity.class).putExtra(Constant.OPENURL, bean.getUrl()));
        });
    }

    public void loadData(int page) {
        ObservableHelper.getIosObservable(TYPE, COUNT, page)
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
            iosXrv.refreshComplete();
        } else {
            iosXrv.loadMoreComplete();
        }
    }

    @Override
    public void onError(Throwable e) {
        if (page == 1) {
            iosXrv.refreshComplete();
        } else {
            iosXrv.loadMoreComplete();
        }
    }

    @Override
    public void onNext(List<IosBean> iosBeen) {
        if (page == 1) {
            adapter.removeAll();
            adapter.setDataSet(iosBeen);
        } else {
            adapter.addData(iosBeen);
        }

    }

}
