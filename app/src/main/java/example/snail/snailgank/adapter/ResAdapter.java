package example.snail.snailgank.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import example.snail.snailgank.R;
import example.snail.snailgank.base.BaseAdapter;
import example.snail.snailgank.bean.ResBean;

/**
 * 拓展资源 适配器类
 * Created by snial on 2017/5/25.
 */

public class ResAdapter extends BaseAdapter implements View.OnClickListener {

    public ResAdapter(Context context) {
        super(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_res_layout, null);
        view.setOnClickListener(this);
        return new ResHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        holder.itemView.setTag(position);
        ResBean resBean = (ResBean) dataSet.get(position);
        ((ResHolder) holder).resDescTv.setText(resBean.getDesc());
        ((ResHolder) holder).resAuthTv.setText(resBean.getWho());
        ((ResHolder) holder).resTimeTv.setText(resBean.getCreatedAt());
    }

    @Override
    public void onClick(View v) {
        if (mRecycleViewItemClickListener != null) {
            mRecycleViewItemClickListener.onItemClick(v, (Integer) v.getTag());
        }
    }

    class ResHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.res_desc_tv)
        TextView resDescTv;
        @Bind(R.id.res_auth_tv)
        TextView resAuthTv;
        @Bind(R.id.res_time_tv)
        TextView resTimeTv;

        public ResHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
