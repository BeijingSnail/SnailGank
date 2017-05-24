package example.snail.snailgank.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import example.snail.snailgank.R;
import example.snail.snailgank.adapter.PictureAdapter;
import example.snail.snailgank.base.BaseActivity;
import example.snail.snailgank.common.Constant;

public class PictureActivity extends BaseActivity {

    private int position;

    @Bind(R.id.picture_right_up_tv)
    TextView pictureRightUpTv;
    @Bind(R.id.picture_toolbar)
    Toolbar pictureToolbar;
    @Bind(R.id.picture_vp)
    ViewPager pictureVp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);
        initData();

    }

    private void initData() {
        Intent intent = getIntent();
        position = intent.getIntExtra(Constant.POSITION, 0);
        ArrayList<String> urlList = intent.getStringArrayListExtra(Constant.UELLIST);
        if (urlList == null || urlList.isEmpty()) {
            return;
        }
        List<View> views = new ArrayList<>();
        for (String url : urlList) {
            ImageView imageView = new ImageView(this);
            Glide.with(this).load(url).placeholder(R.mipmap.preloading).error(R.mipmap.loading_error).into(imageView);
            views.add(imageView);
        }
        PictureAdapter adapter = new PictureAdapter(views);
        pictureVp.setAdapter(adapter);
        pictureVp.setCurrentItem(position);
    }


}
