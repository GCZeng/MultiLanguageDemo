package zgc.org.multilanguagedemo.util.pre;

import android.content.Context;

import zgc.org.multilanguagedemo.app.APP;

/**
 * Author: Nick
 * Time: 2018/6/30 下午8:56
 * Description:
 **/
public class PreUtil {
    public static void setLanguage(int language) {
        PreferencesUtils.putInt(APP.sContext, PreKey.SETTING_LOCAL, language);
    }

    public static int getLanguage(Context context) {
        return PreferencesUtils.getInt(context, PreKey.SETTING_LOCAL,0);
    }
}
