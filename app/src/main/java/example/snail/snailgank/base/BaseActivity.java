package example.snail.snailgank.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import butterknife.ButterKnife;
import example.snail.snailgank.R;
import example.snail.snailgank.common.ActivityPageManager;
import example.snail.snailgank.utils.PreferencesManager;

/**
 * Activity 基类
 * Created by snail on 2017/5/18.
 */

public class BaseActivity extends AppCompatActivity {
    private View view;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityPageManager.getInstance().addActivity(this);
        //获取sp保存的themId并设置默认值
        int appThem = PreferencesManager.getInstance(this).get("themId", R.style.LightBlueTheme);
        //设置主题
        setTheme(appThem);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        view = LayoutInflater.from(this).inflate(layoutResID, null);
        setContentView(view);
        ButterKnife.bind(this);
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
    }

    protected void showSnackBar(int strId) {
        Snackbar.make(view, strId, Snackbar.LENGTH_SHORT).show();
    }

    protected void showSnackBar(String str) {
        Snackbar.make(view, str, Snackbar.LENGTH_SHORT).show();
    }

}
