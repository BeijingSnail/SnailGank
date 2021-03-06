package example.snail.snailgank.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import example.snail.snailgank.R;
import example.snail.snailgank.base.BaseAdapter;
import example.snail.snailgank.bean.AndroidBean;

/**
 * Android 适配器类
 * Created by admin on 2017/5/20.
 */

public class AndroidAdapter extends BaseAdapter implements View.OnClickListener {

    public AndroidAdapter(Context context) {
        super(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_android_layout, null);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        holder.itemView.setTag(position);

        Object object = dataSet.get(position);
        AndroidBean androidBean = (AndroidBean) object;

        String desc = androidBean.getDesc();
        String createdAt = androidBean.getCreatedAt();
        String auth = androidBean.getWho();
        List<String> images = androidBean.getImages();
        String iamgeUrl = null;
        if (images != null && !images.isEmpty()) {
            iamgeUrl = images.get(0);
        }
        if (!TextUtils.isEmpty(desc)) {
            ((ViewHolder) holder).androidItemDescTv.setText(desc);
        }
        if (!TextUtils.isEmpty(createdAt)) {
            ((ViewHolder) holder).androidItemTimeTv.setText(createdAt);
        }
        if (!TextUtils.isEmpty(auth)) {
            ((ViewHolder) holder).androidItemAuthTv.setText(auth);
        }

        if (!TextUtils.isEmpty(iamgeUrl)) {
            Glide.with(mContext).load(iamgeUrl).placeholder(R.mipmap.preloading).error(R.mipmap.loading_error).into(((ViewHolder) holder).androidItemIv);
        } else {
            ((ViewHolder) holder).androidItemIv.setImageResource(R.mipmap.no_icon);
        }
    }

    @Override
    public void onClick(View v) {
        if (mRecycleViewItemClickListener != null) {
            mRecycleViewItemClickListener.onItemClick(v, (Integer) v.getTag());
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.android_item_desc_tv)
        TextView androidItemDescTv;
        @Bind(R.id.android_item_auth_tv)
        TextView androidItemAuthTv;
        @Bind(R.id.android_item_time_tv)
        TextView androidItemTimeTv;
        @Bind(R.id.android_item_iv)
        ImageView androidItemIv;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
