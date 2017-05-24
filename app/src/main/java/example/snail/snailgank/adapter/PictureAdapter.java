package example.snail.snailgank.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Snail on 2017/5/24.
 */

public class PictureAdapter extends PagerAdapter {

    private List<View> pageViews;

    public PictureAdapter(List<View> list) {
        this.pageViews = list;
    }

    @Override
    public int getCount() {
        return pageViews.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(pageViews.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(pageViews.get(position));
        return pageViews.get(position);
    }
}
