package zgc.org.multilanguagedemo.activity.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import zgc.org.multilanguagedemo.activity.MainActivity;
import zgc.org.multilanguagedemo.activity.SettingActivity;
import zgc.org.multilanguagedemo.util.LocalUtil;

/**
 * Author: Nick
 * Time: 2018/6/30 下午8:47
 * Description:
 **/
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(provideLayout());

        initView();
        initData();
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocalUtil.setLocal(newBase));
    }

    protected abstract int provideLayout();

    protected abstract void initView();

    protected abstract void initData();


    protected void gotoActivity(Class<? extends Activity> activity) {
        gotoActivity(activity, null);
    }

    protected void gotoActivity(Class<? extends Activity> activity, Bundle bundle) {
        gotoActivity(this, activity, bundle);
    }

    protected void gotoActivity(Context context, Class<? extends Activity> activity, Bundle bundle) {
        Intent intent = new Intent(this, activity);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        context.startActivity(intent);
    }

    protected void restartApp(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

}
