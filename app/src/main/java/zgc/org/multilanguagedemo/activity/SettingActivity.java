package zgc.org.multilanguagedemo.activity;

import android.view.View;

import java.util.Locale;

import zgc.org.multilanguagedemo.R;
import zgc.org.multilanguagedemo.activity.base.BaseActivity;
import zgc.org.multilanguagedemo.util.LocalUtil;

/**
 * Author: Nick
 * Time: 2018/6/30 下午9:09
 * Description:
 **/
public class SettingActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected int provideLayout() {
        return R.layout.activity_setting;
    }

    @Override
    protected void initView() {
        findViewById(R.id.btn_system).setOnClickListener(this);
        findViewById(R.id.btn_chinese).setOnClickListener(this);
        findViewById(R.id.btn_english).setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_system:
                selectLanguage(LocalUtil.LOCAL_SYSTEM);
                break;
            case R.id.btn_chinese:
                selectLanguage(LocalUtil.LOCAL_CHINESE);
                break;
            case R.id.btn_english:
                selectLanguage(LocalUtil.LOCAL_ENGLISH);
                break;
        }
    }

    private void selectLanguage(int select) {
        LocalUtil.saveLanguage(select);
        //重启APP到主页面
        restartApp();
    }

}
