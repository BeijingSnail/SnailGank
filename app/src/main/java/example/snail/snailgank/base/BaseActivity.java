package example.snail.snailgank.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import example.snail.snailgank.common.ActivityPageManager;
import rx.Observer;

/**
 * Created by snail on 2017/5/18.
 */

public class BaseActivity extends AppCompatActivity implements Observer {

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        ActivityPageManager.getInstance().addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityPageManager.getInstance().removeActivity(this);
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onNext(Object o) {

    }


}
