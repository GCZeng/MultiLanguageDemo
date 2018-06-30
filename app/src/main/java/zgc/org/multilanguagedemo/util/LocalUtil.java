package zgc.org.multilanguagedemo.util;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;
import android.util.Log;

import java.util.Locale;

import zgc.org.multilanguagedemo.util.pre.PreUtil;

/**
 * Author: Nick
 * Time: 2018/6/30 下午8:54
 * Description:
 **/
public class LocalUtil {
    public final static int LOCAL_SYSTEM = 1001;
    public final static int LOCAL_CHINESE = 1002;
    public final static int LOCAL_ENGLISH = 1003;

    public static Context setLocal(Context context) {
        return updateResources(context, getSetLanguageLocale(context));
    }

    private static Context updateResources(Context context, Locale locale) {
        Locale.setDefault(locale);

        Resources res = context.getResources();
        Configuration config = new Configuration(res.getConfiguration());
        config.setLocale(locale);
        context = context.createConfigurationContext(config);
        return context;
    }

    /**
     * 获取选择的语言设置
     *
     * @param context
     * @return
     */
    public static Locale getSetLanguageLocale(Context context) {

        switch (PreUtil.getLanguage(context)) {
            case LOCAL_SYSTEM:
                return getSystemLocale(context);
            case LOCAL_CHINESE:
                return Locale.CHINA;
            case LOCAL_ENGLISH:
                return Locale.TAIWAN;
            default:
                return Locale.ENGLISH;
        }
    }

    /**
     * 获取系统的locale
     *
     * @return Locale对象
     */
    public static Locale getSystemLocale(Context context) {
        Locale locale;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            locale = LocaleList.getDefault().get(0);
        } else {
            locale = Locale.getDefault();
        }
        Log.d("org.zgc",locale.toString());
        return locale;
    }

    public static void saveLanguage(int local) {
        PreUtil.setLanguage(local);
    }

}
