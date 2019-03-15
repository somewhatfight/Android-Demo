package com.example.wanghao35.testfirst;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Demo class
 *
 * @author wanghao35
 * @date 20191/2/26
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mTextView;
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            int m = msg.arg1;
            int n = msg.arg2;
            int sum = m+n;
            mTextView.setText(String.valueOf(sum));
            super.handleMessage(msg);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.testlayout);
        Toolbar mToolBar = findViewById(R.id.tb_toolbar);
        setSupportActionBar(mToolBar);
        mToolBar.setNavigationIcon(android.R.drawable.sym_def_app_icon);
        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"guade.ide",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        Button mOk = findViewById(R.id.ok);
        Button mCancel = findViewById(R.id.cancel);
        mOk.setOnClickListener(this);
        mCancel.setOnClickListener(this);
        Button mStartThread = findViewById(R.id.thread);
        mStartThread.setOnClickListener(this);
        mTextView = findViewById(R.id.textView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.addmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.delete:
                Toast.makeText(this,"delete",Toast.LENGTH_SHORT).show();
                break;
            case R.id.add:
                Toast.makeText(this,"add",Toast.LENGTH_SHORT).show();
                break;
            case R.id.more:
                Toast.makeText(this,"more",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ok:
                Toast.makeText(this,"ok ok",Toast.LENGTH_SHORT).show();
                break;
            case R.id.cancel:
                Toast.makeText(this,"cancel cancel ",Toast.LENGTH_SHORT).show();
            case R.id.thread:
                new Thread(new MyRunnable()).start();
            default:
                    break;
        }
    }
    public class MyRunnable implements Runnable{
        @Override
        public void run() {
            int sum = 0;
            int max = 1000000;
            for(int i = 0;i < max ;i++){
                sum += i;
            }
            Message message = Message.obtain(mHandler,12,sum,45);
            message.sendToTarget();
        }
    }
}
