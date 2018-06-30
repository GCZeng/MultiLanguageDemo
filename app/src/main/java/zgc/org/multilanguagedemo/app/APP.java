package zgc.org.multilanguagedemo.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.media.audiofx.LoudnessEnhancer;
import android.util.Log;

import zgc.org.multilanguagedemo.util.LocalUtil;

/**
 * Author: Nick
 * Time: 2018/6/30 下午8:53
 * Description:
 **/
public class APP extends Application {
    public static Context sContext = null;

    @Override
    public void onCreate() {
        super.onCreate();
        APP.sContext = this;
    }

    @Override
    protected void attachBaseContext(Context base) {
        Log.d("org.zgc", "attachBaseContext");
        if (base != null) {
            super.attachBaseContext(LocalUtil.setLocal(base));
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        LocalUtil.setLocal(this.getApplicationContext());
    }
}
