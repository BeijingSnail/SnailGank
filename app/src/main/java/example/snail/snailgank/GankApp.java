package example.snail.snailgank;

import android.app.Application;

/**
 * 自定义 Application 类
 * Created by snial on 2017/5/23.
 */

public class GankApp extends Application {

    private static GankApp mInstance;

    public static GankApp getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

}
