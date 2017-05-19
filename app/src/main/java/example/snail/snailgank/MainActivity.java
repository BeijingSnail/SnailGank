package example.snail.snailgank;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import example.snail.snailgank.base.BaseActivity;
import example.snail.snailgank.common.Constant;
import example.snail.snailgank.fragment.AndroidFragment;
import example.snail.snailgank.fragment.IosFragment;
import example.snail.snailgank.fragment.ResFragment;
import example.snail.snailgank.fragment.WelfareFragment;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

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
    @Bind(R.id.main_radio_group)
    RadioGroup mainRadioGroup;

    private AndroidFragment androidFragment;
    private IosFragment iosFragment;
    private WelfareFragment welfareFragment;
    private ResFragment resFragment;
    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        fm = getSupportFragmentManager();
        initActionBar();

        //设置侧拉页icon颜色
        mainNavigationView.setItemIconTintList(null);
        mainRadioGroup.setOnCheckedChangeListener(this);
        //默认显示第一个Fragment
        setTabSelection(Constant.ANDROIDFRAGMENT);
    }

    /**
     * 初始化ActionBar
     */
    private void initActionBar() {
        setSupportActionBar(mainToolbar);
        //设置旋转特效按钮
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, mianDrawerLayout, mainToolbar, R.string.drawer_open, R.string.drawer_close);
        mDrawerToggle.syncState();
        mianDrawerLayout.addDrawerListener(mDrawerToggle);

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.android_rb:
                setTabSelection(Constant.ANDROIDFRAGMENT);
                break;
            case R.id.ios_rb:
                setTabSelection(Constant.IOSFRAGMENT);
                break;
            case R.id.welfare_rb:
                setTabSelection(Constant.WELFAREFRAGMENT);
                break;
            case R.id.res_rb:
                setTabSelection(Constant.RESFRAGMENT);
                break;
        }

    }

    /**
     * 根据逻辑显示不同的Fragment
     *
     * @param index
     */
    public void setTabSelection(int index) {
        FragmentTransaction transaction = fm.beginTransaction();
        hindeAllFragment(transaction);
        switch (index) {
            case Constant.ANDROIDFRAGMENT:
                if (androidFragment == null) {
                    androidFragment = new AndroidFragment();
                    transaction.add(R.id.main_content, androidFragment, Constant.AndroidFragmentTag);
                } else {
                    transaction.show(androidFragment);
                }
                break;
            case Constant.IOSFRAGMENT:
                if (iosFragment == null) {
                    iosFragment = new IosFragment();
                    transaction.add(R.id.main_content, iosFragment, Constant.IosFragmentTag);
                } else {
                    transaction.show(iosFragment);
                }
                break;
            case Constant.WELFAREFRAGMENT:
                if (welfareFragment == null) {
                    welfareFragment = new WelfareFragment();
                    transaction.add(R.id.main_content, welfareFragment, Constant.WelfareFragmentTag);
                } else {
                    transaction.show(welfareFragment);
                }
                break;
            case Constant.RESFRAGMENT:
                if (resFragment == null) {
                    resFragment = new ResFragment();
                    transaction.add(R.id.main_content, resFragment, Constant.ResFragmentTag);
                } else {
                    transaction.show(resFragment);
                }
                break;
        }
        transaction.commit();
        closeDrawerLayout();
    }

    /**
     * 隐藏所有的fragment
     *
     * @param transaction
     */
    private void hindeAllFragment(FragmentTransaction transaction) {
        //防止Fragmentt引用被回收置空时引起的重叠
        if (androidFragment == null)
            androidFragment = (AndroidFragment) fm.findFragmentByTag(Constant.AndroidFragmentTag);
        if (iosFragment == null)
            iosFragment = (IosFragment) fm.findFragmentByTag(Constant.IosFragmentTag);
        if (welfareFragment == null)
            welfareFragment = (WelfareFragment) fm.findFragmentByTag(Constant.WelfareFragmentTag);
        if (resFragment == null)
            resFragment = (ResFragment) fm.findFragmentByTag(Constant.ResFragmentTag);

        if (androidFragment != null)
            transaction.hide(androidFragment);

        if (iosFragment != null)
            transaction.hide(iosFragment);

        if (welfareFragment != null)
            transaction.hide(welfareFragment);

        if (resFragment != null)
            transaction.hide(resFragment);

    }

    /**
     * 关闭左侧 侧滑菜单
     */
    private void closeDrawerLayout() {
        if (mianDrawerLayout.isDrawerOpen(Gravity.LEFT)) {
            mianDrawerLayout.closeDrawers();
        }
    }


}
