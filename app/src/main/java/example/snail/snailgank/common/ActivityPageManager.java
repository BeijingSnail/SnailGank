package example.snail.snailgank.common;

import android.app.Activity;

import java.util.Stack;

/**
 * Created by Snail on 2017/5/17.
 */

public class ActivityPageManager {

    private Stack<Activity> activityStack;

    private static ActivityPageManager instance;

    public static ActivityPageManager getInstance() {
        if (instance == null) {
            instance = new ActivityPageManager();
        }
        return instance;
    }

    /**
     * 向Stack中添加Activity
     */
    public void addActivity(Activity activity) {
        if (activityStack == null) {
            activityStack = new Stack<>();
        }
        activityStack.add(activity);
    }

    /**
     * 从Stack中移除Activity
     */
    public void removeActivity(Activity activity) {
        if (activityStack != null) {
            activityStack.remove(activity);
        }
    }

    /**
     * 获取当前Activity
     */
    public Activity getCurrentActivity() {
        return activityStack.lastElement();
    }


    private void finishActivity(Activity activity) {
        if (activity != null && activityStack != null) {
            activityStack.remove(activity);
            activity.finish();
            activity = null;
        }
    }

    /**
     * finish指定Activity
     */
    public void finishActivity(Class<?> cls) {
        for (Activity activity : activityStack) {
            if (activity.getClass().equals(cls)) {
                finishActivity(activity);
                break;
            }
        }
    }

    /**
     * 关闭所有Activity
     */
    private void finishAllActivity() {
        for (int i = 0; i < activityStack.size(); i++) {
            activityStack.get(i).finish();
        }
        activityStack.clear();
    }

    /**
     * 完全退出程序
     */
    public void exit() {
        finishAllActivity();
        System.exit(0);
        android.os.Process.killProcess(android.os.Process.myPid());
    }

}
