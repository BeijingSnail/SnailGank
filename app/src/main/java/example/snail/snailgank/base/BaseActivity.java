package example.snail.snailgank.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.LayoutRes;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import example.snail.snailgank.common.ActivityPageManager;

/**
 * Created by snail on 2017/5/18.
 */

public class BaseActivity extends AppCompatActivity {
    private View view;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        ActivityPageManager.getInstance().addActivity(this);
    }


    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        view = LayoutInflater.from(this).inflate(layoutResID, null);
        setContentView(view);
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
    }

    protected void showSnackBar(int strId) {
        Snackbar.make(view, strId, Snackbar.LENGTH_SHORT).show();
    }

}
