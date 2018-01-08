package cn.yview.eventbustest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Administrator on 2018/1/8.
 */

public class SecontActivity extends AppCompatActivity implements View.OnClickListener{
    private Button button;
    private enventclass ev;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.secontlayout);
        button = findViewById(R.id.sendMessageBtn);
        button.setOnClickListener(this);
         ev = new enventclass("更新了");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.sendMessageBtn:
                EventBus.getDefault().post(ev);
                break;
        }
    }
}
