package example.snail.snailgank.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * SharedPreferences管理类
 * Created by Snail on 2017/5/31.
 */

public class PreferencesManager {

    private static String shareName = "SHARE_DATA";

    private static PreferencesManager instance;

    private SharedPreferences preferences;

    private Context mContext;

    public PreferencesManager(Context context) {
        this(context, shareName);
    }

    /**
     * 构造方法
     *
     * @param context    上下文
     * @param sharedName 文件名
     */
    public PreferencesManager(Context context, String sharedName) {
        this.mContext = context;
        preferences = mContext.getSharedPreferences(sharedName, Context.MODE_PRIVATE);
    }

    public static PreferencesManager getInstance(Context context) {
        return getInstance(context, shareName);
    }

    /**
     * 单例模式
     *
     * @param context
     * @param shareName
     * @return
     */
    public static PreferencesManager getInstance(Context context, String shareName) {
        if (instance == null) {
            synchronized (PreferencesManager.class) {
                if (instance == null) {
                    instance = new PreferencesManager(context, shareName);
                }
            }
        }
        return instance;
    }

    public void put(String key, int value) {
        SharedPreferences.Editor editor = preferences.edit();
        if (editor != null) {
            editor.putInt(key, value);
            editor.commit();
        }
    }

    public int get(String key, int defValue) {
        return preferences.getInt(key, defValue);
    }


}
