package app.songy.com.lib_view.common;

import app.songy.com.lib_tool.Lock;

/**
 * Description:
 * Created by song on 2018/9/12.
 * email：bjay20080613@qq.com
 */
public class CheckLock {
    private static  Lock lock=new Lock();

    public static boolean isLock(){
        return lock.tryLock();
    }
}
