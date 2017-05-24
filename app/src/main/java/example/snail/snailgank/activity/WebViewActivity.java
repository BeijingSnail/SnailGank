package example.snail.snailgank.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.handywebviewlibrary.ProgressWebView;

import butterknife.Bind;
import example.snail.snailgank.R;
import example.snail.snailgank.base.BaseActivity;
import example.snail.snailgank.common.Constant;

public class WebViewActivity extends BaseActivity {

    @Bind(R.id.wv_title)
    TextView wvTitle;
    @Bind(R.id.wv_toolbar)
    Toolbar wvToolbar;
    @Bind(R.id.progress_webview)
    ProgressWebView progressWebview;
    @Bind(R.id.activity_main)
    LinearLayout activityMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        setSupportActionBar(wvToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initData();
        wvToolbar.setNavigationOnClickListener((v) -> {
            if (progressWebview.canGoBack()) {
                progressWebview.goBack();
            } else {
                finish();
            }
        });
    }

    private void initData() {
        Intent intent = getIntent();
        String url = intent.getStringExtra(Constant.OPENURL);
        if (!TextUtils.isEmpty(url)) {
            progressWebview.loadUrl(url);
            String title = progressWebview.getTitle();
        }
    }

}
