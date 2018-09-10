package app.songy.com.lib_tool;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Created by diaowj on 2015/7/15.
 */
public class Validator {

    public static boolean password(String password) {
        return password.matches("[0-9a-zA-Z]{8,16}") && !password.matches("[0-9]+") && !password.matches("[a-zA-Z]+");
    }

    public static boolean phoneNub(String phoneNub) {

        return phoneNub.matches("[0-9]{11}");
    }

    public static List<String> findMac(String src) {
        List<String> list = new ArrayList<String>();
        if (src == null || "".equals(src)) {
            return list;
        }
        Pattern pattern = Pattern
                .compile("[0-9a-z]{2}:[0-9a-z]{2}:[0-9a-z]{2}:[0-9a-z]{2}:[0-9a-z]{2}:[0-9a-z]{2}");
        Matcher matcher = pattern.matcher(src);
        while (matcher.find()) {
            list.add(matcher.group(0));
        }
        return list;
    }

    public static List<String> findColor(String src) {
        List<String> list = new ArrayList<String>();
        if (src == null || "".equals(src)) {
            return list;
        }
        Pattern pattern = Pattern
                .compile("#[0-9a-f]{3}|[0-9a-f]{6}|[0-9a-f]{8}");
        Matcher matcher = pattern.matcher(src);
        while (matcher.find()) {
            list.add(matcher.group(0));
        }
        return list;
    }
}
