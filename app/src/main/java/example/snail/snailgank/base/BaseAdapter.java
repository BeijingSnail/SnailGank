package example.snail.snailgank.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * 适配器基类
 * <p>
 * Created by Snail on 2017/5/20.
 */

public abstract class BaseAdapter<T> extends RecyclerView.Adapter {

    protected List<T> dataSet;

    protected Context mContext;

    protected LayoutInflater layoutInflater;

    protected RecycleViewItemClickListener mRecycleViewItemClickListener;

    @FunctionalInterface
    public interface RecycleViewItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setRecycleViewItemClickListener(RecycleViewItemClickListener recycleViewItemClickListener) {
        this.mRecycleViewItemClickListener = recycleViewItemClickListener;
    }

    public BaseAdapter(Context context) {
        this(context, new ArrayList());
    }

    public BaseAdapter(Context context, List<T> data) {
        this.mContext = context;
        this.dataSet = data;
        this.layoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getItemCount() {
        return this.dataSet.size();
    }

    public Context getContext() {
        return mContext;
    }

    public void addData(List<T> data) {
        this.dataSet.addAll(data);
    }

    public void removeAll() {
        this.dataSet.clear();
    }

    public void setDataSet(List<T> data) {
        this.dataSet = data;
    }

    public T getItem(int position) {
        return dataSet.get(position);
    }

}
