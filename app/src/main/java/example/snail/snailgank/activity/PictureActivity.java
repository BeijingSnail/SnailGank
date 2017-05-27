package example.snail.snailgank.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.Bind;
import example.snail.snailgank.R;
import example.snail.snailgank.adapter.PictureAdapter;
import example.snail.snailgank.base.BaseActivity;
import example.snail.snailgank.common.Constant;

public class PictureActivity extends BaseActivity {

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
        initToolbar();
        initData();
    }

    private void initToolbar() {
        setSupportActionBar(pictureToolbar);
        pictureToolbar.setNavigationOnClickListener(v -> finish());
        ActionBar bar = getSupportActionBar();
        bar.setDisplayHomeAsUpEnabled(true);
        bar.setTitle(R.string.WelfarePicture);
    }

    private void initData() {
        Intent intent = getIntent();
        int position = intent.getIntExtra(Constant.POSITION, 0);
        ArrayList<String> urlList = intent.getStringArrayListExtra(Constant.UELLIST);
        if (urlList == null || urlList.isEmpty()) {
            return;
        }

        String format = getResources().getString(R.string.PictureCount);
        pictureRightUpTv.setText(String.format(format, position + 1 + "", urlList.size() + ""));

        PictureAdapter adapter = new PictureAdapter(this, urlList);
        pictureVp.setAdapter(adapter);
        pictureVp.setCurrentItem(position);
        pictureVp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                pictureRightUpTv.setText(String.format(format, position + 1 + "", urlList.size() + ""));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

}
