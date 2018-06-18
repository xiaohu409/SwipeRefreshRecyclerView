package com.example.hutao.swiperefreshrecyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
    }

    private void initUI() {
        TextView sampleView = findViewById(R.id.sample_tv_id);
        sampleView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sample_tv_id:
                startActivity(new Intent(this, SampleActivity.class));
                break;
            case R.id.advanced_tv_id:
                break;
        }
    }
}
