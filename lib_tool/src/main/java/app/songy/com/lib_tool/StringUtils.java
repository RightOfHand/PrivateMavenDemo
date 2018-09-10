package app.songy.com.lib_tool;

import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *Description:
 *creator: song
 *Date: 2018/9/10 下午3:53
 */
public class StringUtils{
    public static boolean isNotEmpty(String str) {
        return null != str && !"".equals(str) && !str.matches("^[\\s\\n\\r\\t]*$");
    }

    public static boolean isEmpty(String str) {
        return !isNotEmpty(str);
    }

    public static boolean isUrl(String str){
        return null != str && (str.startsWith("http://") || str.startsWith("https://"));
    }
    public static boolean isEmail(String email) {
        String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(email);

        return m.matches();
    }
    public static boolean isQQ(String str) {
        Pattern pattern = Pattern.compile("[1-9][0-9]{4,12}");
        Matcher matcher = pattern.matcher(str);
        if (matcher.matches()) {
            return true;
        }else {
            return false;
        }
    }
    public static boolean isWeiChat(String weiChat){
        String str="^[a-zA-Z\\d_]{5,}$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(weiChat);
        return m.matches();
    }

    public static boolean isPwd(String password) {
        return password.matches("[0-9a-zA-Z]{6,16}") && !password.matches("[0-9]+") && !password.matches("[a-zA-Z]+");
    }
    public static String splitString(String string){
        String[] str=string.split(",");
        return str[0]+"-"+str[1]+str[2]+"\n"+"       "+str[3];
    }
    public static boolean isPhoneNum(String phoneNum) {
        if (phoneNum == null || phoneNum.length() != 11) {
            return false;
        }
        if (!TextUtils.isDigitsOnly(phoneNum)) {
            return false;
        }
        Pattern p = Pattern.compile("^((13[0-9])|(14[0-9])|(15[^4,\\D])|(16[0-9])|(17[0-9])|(18[0-9])|(19[0-9]))\\d{8}$");
        return p.matcher(phoneNum).find();
    }
    public static String ToSBC(String input) {
        char c[] = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == ' ') {
                c[i] = '\u3000';
            } else if (c[i] < '\177') {
                c[i] = (char) (c[i] + 65248);
            }
        }
        return new String(c);
    }

    public static boolean checkColor(String color) {
        if (TextUtils.isEmpty(color))
            return false;
        boolean flag;
        try {
            String check = "^#([0-9a-fA-F]{6}|[0-9a-fA-F]{8})$";
            Pattern regex = Pattern.compile(check, Pattern.CASE_INSENSITIVE);
            Matcher matcher = regex.matcher(color);
            flag = matcher.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }
}
