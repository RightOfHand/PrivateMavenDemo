package app.songy.com.lib_tool;

import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.content.ContextCompat;

/**
 * Created by Administrator on 2016/11/24.
 * Copyright © 2016年 AXD. All rights reserved.
 */
public class PermissionChecker {
    private final Context mcontext;
    public PermissionChecker(Context context) {
        this.mcontext=context.getApplicationContext();
    }
    private  boolean  lackPermission(String permission){
        return ContextCompat.checkSelfPermission(mcontext,permission)==
                PackageManager.PERMISSION_DENIED;
    }
    public boolean lackPermissions(String... permissions){
        for (String permission:permissions){
            if (lackPermission(permission)){
                return  true;

            }
        }
        return  false;

    }
}
