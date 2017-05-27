package example.snail.snailgank.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import example.snail.snailgank.R;

/**
 * 展示图片的ViewPager 适配器类
 * Created by Snail on 2017/5/24.
 */

public class PictureAdapter extends PagerAdapter {

    private List<String> urlList;

    private LayoutInflater inflater;

    private Context mContext;

    public PictureAdapter(Context context, List<String> list) {
        this.urlList = list;
        this.mContext = context;
        this.inflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return urlList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        String url = urlList.get(position);
        View view = inflater.inflate(R.layout.item_picture_layout, container, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.item_pic_iv);
        Glide.with(mContext).load(url).placeholder(R.mipmap.preloading).error(R.mipmap.loading_error).into(imageView);
        container.addView(view);
        return view;
    }

}
