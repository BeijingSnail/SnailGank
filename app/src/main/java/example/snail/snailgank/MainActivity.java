package example.snail.snailgank;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import example.snail.snailgank.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Bind(R.id.main_toolbar_tv)
    TextView mainToolbarTv;
    @Bind(R.id.main_toolbar)
    Toolbar mainToolbar;
    @Bind(R.id.main_content)
    FrameLayout mainContent;
    @Bind(R.id.main_navigation_view)
    NavigationView mainNavigationView;
    @Bind(R.id.mian_drawer_layout)
    DrawerLayout mianDrawerLayout;
    @Bind(R.id.activity_main)
    LinearLayout activityMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(mainToolbar);
        //设置旋转特效按钮
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, mianDrawerLayout, mainToolbar, R.string.drawer_open, R.string.drawer_close);
        mDrawerToggle.syncState();
        mianDrawerLayout.addDrawerListener(mDrawerToggle);
        mainNavigationView.setItemIconTintList(null);

    }


}
