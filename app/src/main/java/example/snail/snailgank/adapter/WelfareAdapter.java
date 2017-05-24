package example.snail.snailgank.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.Bind;
import butterknife.ButterKnife;
import example.snail.snailgank.R;
import example.snail.snailgank.base.BaseAdapter;
import example.snail.snailgank.bean.WelfareBean;

/**
 * 福利fragment适配器
 * Created by snail on 2017/5/24.
 */

public class WelfareAdapter extends BaseAdapter implements View.OnClickListener {


    public WelfareAdapter(Context context) {
        super(context);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_welfare_layout, null);
        view.setOnClickListener(this);
        return new WelfareHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        holder.itemView.setTag(position);

        WelfareBean welfareBean = (WelfareBean) dataSet.get(position);
        String iamgeUrl = welfareBean.getUrl();
        String time = welfareBean.getCreatedAt();
        String auth = welfareBean.getWho();

        if (!TextUtils.isEmpty(iamgeUrl)) {
            Glide.with(mContext).load(iamgeUrl).placeholder(R.mipmap.preloading).error(R.mipmap.loading_error).into(((WelfareHolder) holder).welfareItemIv);
        }
        if (!TextUtils.isEmpty(time)) {
            ((WelfareHolder) holder).welfareTimeTv.setText(time);
        }
        if (!TextUtils.isEmpty(auth)) {
            ((WelfareHolder) holder).welfareAuthTv.setText(auth);
        }
    }

    @Override
    public void onClick(View v) {
        if (mRecycleViewItemClickListener != null) {
            mRecycleViewItemClickListener.onItemClick(v, (Integer) v.getTag());
        }
    }

    class WelfareHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.welfare_item_iv)
        ImageView welfareItemIv;
        @Bind(R.id.welfare_auth_tv)
        TextView welfareAuthTv;
        @Bind(R.id.welfare_time_tv)
        TextView welfareTimeTv;

        public WelfareHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
