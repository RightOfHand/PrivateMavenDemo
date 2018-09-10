package app.songy.com.lib_tool;

import android.util.Log;

import java.text.DecimalFormat;

/**
 * Created by JasonDing on 15/12/1.
 */
public class ParseUtil {

    private static final String TAG = ParseUtil.class.getSimpleName();

    public static String getFormatFloat(float value, String formater) {
        try {
            DecimalFormat decimalFormat = new DecimalFormat(formater);
            return decimalFormat.format(value);
        } catch (Exception e) {
            Log.e(TAG, "method getFormatFloat has a invalid format");
        }
        return null;
    }

    public static String getPrintMoney(float money) {
        return getFormatFloat(money, "#,##0.0");
    }

    public static String getPrintMoney(String moneyStr) {
        float money = 0;
        try {
            money = Float.parseFloat(moneyStr);
        } catch (Exception e) {
        }
        return getPrintMoney(money);
    }

    public static boolean parseBoolean(String flag) {
        return null != flag && "1".equals(flag);
    }

    public static int parseInt(String intStr) {
        int intValue;
        try {
            if (intStr != null) {
                intValue = Integer.parseInt(intStr);
            } else {
                intValue = 0;
            }

        } catch (NumberFormatException e) {
            intValue = 0;
            Log.w(TAG, "parseInt has a illegal format input");
        }
        return intValue;
    }

    public static float parseFloat(String intStr) {
        float floatValue;
        try {
            if (intStr!=null) {
                floatValue = Float.parseFloat(intStr);
            } else {
                floatValue = 0;
            }
        } catch (NumberFormatException e) {
            floatValue = 0;
            Log.w(TAG, "parseFloat has a illegal format input");
        }
        return floatValue;
    }

    public static String getDistanceFormat(String str) {
        try {
            return getFormatFloat(Float.parseFloat(str), "0.0");
        } catch (Exception e) {
            return str;
        }
    }

    /**
     * 255,255,255 -> 0xffffffff
     */
    public static int parseColor(String color) {
        int result;
        try {
            final String[] split = color.split(",");
            StringBuilder sb = new StringBuilder("ff");
            for (String s : split) {
                final String str = Integer.toHexString(Integer.parseInt(s));
                if (1 == str.length()) {
                    sb.append("0");
                }
                sb.append(str);
            }
            result = (int) Long.parseLong(sb.toString(), 16);
            Log.d(TAG, "assembled string : " + sb.toString());
        } catch (Exception e) {
            Log.w(TAG, String.format("This color [%s] parsed failed.", color));
            result = 0xff000000;
        }
        return result;
    }
}
