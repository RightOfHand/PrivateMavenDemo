package app.songy.com.lib_tool;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;

/**
 *Description:
 *creator: song
 *Date: 2018/9/10 上午10:07
 */
public class ApiCompat {

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static Drawable getDrawable(@NonNull Context context, @DrawableRes int resId){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            return context.getResources().getDrawable(resId,null);
        }else{
            return context.getResources().getDrawable(resId);
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    public static int getColor(@NonNull Context context, @ColorRes int resId){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return context.getResources().getColor(resId, null);
        }else{
            return context.getResources().getColor(resId);
        }
    }

    public static ColorStateList getColorStateList(@NonNull Context context, @ColorRes int resId){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return context.getResources().getColorStateList(resId, null);
        }else{
            return context.getResources().getColorStateList(resId);
        }
    }



}
