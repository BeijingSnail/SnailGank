package example.snail.snailgank.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.OnClick;
import example.snail.snailgank.R;
import example.snail.snailgank.base.BaseActivity;
import example.snail.snailgank.common.Constant;

public class AboutActivity extends BaseActivity {

    @Bind(R.id.about_toolbar)
    Toolbar aboutToolbar;
    @Bind(R.id.git_tv)
    TextView gitTv;
    @Bind(R.id.gank_tv)
    TextView gankTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        aboutToolbar.setNavigationOnClickListener(v -> finish());
    }

    @OnClick({R.id.git_tv, R.id.gank_tv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.git_tv:
                startActivity(new Intent(this, WebViewActivity.class).putExtra(Constant.OPENURL, Constant.SnialGit));
                break;
            case R.id.gank_tv:
                startActivity(new Intent(this, WebViewActivity.class).putExtra(Constant.OPENURL, Constant.GankIo));
                break;
        }
    }
}
