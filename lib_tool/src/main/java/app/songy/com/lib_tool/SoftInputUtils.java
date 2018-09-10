package app.songy.com.lib_tool;

import android.app.Activity;
import android.content.Context;
import android.view.inputmethod.InputMethodManager;

/**
 *Description:
 *creator: song
 *Date: 2018/9/10 下午3:52
 */

public class SoftInputUtils {
    /**
    *  显示软键盘，Dialog使用
     *  @author SY
     * create at 2017/07/26 04:35 PM
    */
    public static void showSoftInput(Activity activity) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    }
    /**
     *  隐藏软键盘
     *  @author SY
     * create at 2017/07/26 04:35 PM
     */
    public static void hideSoftInput(Activity activity) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(
                activity.getWindow().getDecorView().getWindowToken(), 0);
    }

}
