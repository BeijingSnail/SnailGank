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
import example.snail.snailgank.bean.IosBean;

/**
 * Ios  适配器类
 * Created by snail on 2017/5/23.
 */

public class IosAdapter extends BaseAdapter implements View.OnClickListener {


    public IosAdapter(Context context) {
        super(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_ios_layout, null);
        view.setOnClickListener(this);
        return new IosHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        holder.itemView.setTag(position);

        IosBean iosBean = (IosBean) dataSet.get(position);
        String desc = iosBean.getDesc();
        String creatAt = iosBean.getCreatedAt();
        String auth = iosBean.getWho();
        String imageUrl = null;
        List<String> images = iosBean.getImages();

        if (images != null && !images.isEmpty()) {
            imageUrl = images.get(0);
        }
        if (!TextUtils.isEmpty(desc)) {
            ((IosHolder) holder).iosDescTv.setText(desc);
        }
        if (!TextUtils.isEmpty(creatAt)) {
            ((IosHolder) holder).iosItemTimeTv.setText(creatAt);
        }
        if (!TextUtils.isEmpty(auth)) {
            ((IosHolder) holder).iosItemAuthTv.setText(auth);
        }
        if (!TextUtils.isEmpty(imageUrl)) {
            ((IosHolder) holder).iosItemIv.setVisibility(View.VISIBLE);
            Glide.with(mContext).load(imageUrl).placeholder(R.mipmap.preloading).error(R.mipmap.loading_error).into(((IosHolder) holder).iosItemIv);
        } else {
            ((IosHolder) holder).iosItemIv.setVisibility(View.GONE);
        }
    }

    @Override
    public void onClick(View v) {
        if (mRecycleViewItemClickListener != null) {
            mRecycleViewItemClickListener.onItemClick(v, (Integer) v.getTag());
        }
    }

    class IosHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.ios_desc_tv)
        TextView iosDescTv;
        @Bind(R.id.ios_item_iv)
        ImageView iosItemIv;
        @Bind(R.id.ios_item_auth_tv)
        TextView iosItemAuthTv;
        @Bind(R.id.ios_item_time_tv)
        TextView iosItemTimeTv;

        public IosHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
