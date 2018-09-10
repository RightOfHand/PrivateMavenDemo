package app.songy.com.lib_tool;

import android.content.Context;
import android.support.annotation.ColorRes;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/03/01.
 */
public class SpanableStringUtils {

    public static SpannableStringBuilder getSpanableStringBuider(Context context,
                                                                 String text,
                                                                 int start,
                                                                 int end,
                                                                 int anotherStart,
                                                                 int anotherEnd,
                                                                 @ColorRes int resId) {
        SpannableStringBuilder mSpannableStringBuilder = new SpannableStringBuilder(text);
        mSpannableStringBuilder.setSpan
                (new ForegroundColorSpan(resId),
                        start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        mSpannableStringBuilder.setSpan
                (new ForegroundColorSpan(resId),
                        anotherStart, anotherEnd, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return mSpannableStringBuilder;
    }

    public static SpannableString getSpanableString(Context context,
                                                    String text,
                                                    int start,
                                                    int end,
                                                    @ColorRes int resId) {
        SpannableString style = new SpannableString(text);
        style.setSpan(new ForegroundColorSpan(resId),
                start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return style;
    }
    public static SpannableStringBuilder getTwoColorSpannable(Context context,
                                                              String text,
                                                              int start,
                                                              int end,
                                                              int anotherStart,
                                                              int anotherEnd,
                                                              @ColorRes int startresId,
                                                              @ColorRes int endresId){
        SpannableStringBuilder mSpannableStringBuilder = new SpannableStringBuilder(text);
        mSpannableStringBuilder.setSpan
                (new ForegroundColorSpan(startresId),
                        start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        mSpannableStringBuilder.setSpan
                (new ForegroundColorSpan(endresId),
                        anotherStart, anotherEnd, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return mSpannableStringBuilder;

    }
    public static void stripUnderlines(TextView textView) {
        if(null!=textView&&textView.getText() instanceof Spannable){
            Spannable s = (Spannable)textView.getText();
            URLSpan[] spans = s.getSpans(0, s.length(), URLSpan.class);
            for (URLSpan span: spans) {
                int start = s.getSpanStart(span);
                int end = s.getSpanEnd(span);
                s.removeSpan(span);
                span = new URLSpanNoUnderline(span.getURL());
                s.setSpan(span, start, end, 0);
            }
            textView.setText(s);
        }
    }
}
