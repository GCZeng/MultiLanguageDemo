package zgc.org.multilanguagedemo.activity;

import android.view.View;
import android.widget.Toast;

import zgc.org.multilanguagedemo.R;
import zgc.org.multilanguagedemo.activity.base.BaseActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener {


    @Override
    protected int provideLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        findViewById(R.id.btn_setting).setOnClickListener(this);
        findViewById(R.id.btn_show).setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_setting:
                gotoActivity(SettingActivity.class);
                break;
            case R.id.btn_show:
                Toast.makeText(this, R.string.click_tip, Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
