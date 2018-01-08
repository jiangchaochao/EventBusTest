package cn.yview.eventbustest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView textView;
    private Button button;
    private String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*注册成为事件订阅者*/
        EventBus.getDefault().register(this);

        textView = findViewById(R.id.tv_text);
        button = findViewById(R.id.secondActivityBtn);
        button.setOnClickListener(this);
    }
    /*自定义事件方法，收到事件后会自动调用*/
    @Subscribe
    public void onEvent(enventclass event)
    {
        Log.e(TAG, "收到事件消息");
        textView.setText(event.getMessage());
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        /*解除订阅*/
        EventBus.getDefault().unregister(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.secondActivityBtn:
                Intent intent = new Intent(MainActivity.this, SecontActivity.class);
                startActivity(intent);
                break;
        }
    }
}
