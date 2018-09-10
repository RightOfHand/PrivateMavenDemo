package app.songy.com.lib_tool;

import android.util.Log;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 *Description:
 *creator: song
 *Date: 2018/9/10 上午10:10
 */
public class Lock {
    public Lock() {

    }

    private AtomicBoolean flag = new AtomicBoolean(true);

    public boolean tryLock() {
        boolean b = flag.compareAndSet(true, false);
        Log.d("==", "------tryLock---" + b);
        return b;
    }

    public void unlock() {
        Log.d("==", "------unlock---");
        flag.set(true);
    }
}