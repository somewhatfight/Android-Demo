package com.example.wanghao35.testfirst;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
/**
 * Demo class
 *
 * @author wanghao35
 * @date 2019/2/26
 */
public class TestOk extends LinearLayout{
    private  Context mContext;
    public TestOk(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        LayoutInflater.from(context).inflate(R.layout.ok_cancel_layout,null);
        Button mOk = findViewById(R.id.ok);
        Button mCancel = findViewById(R.id.cancel);
        mOk.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"ok ok",Toast.LENGTH_SHORT).show();
            }
        });
        mCancel.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"cancel cancel",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
