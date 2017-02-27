package com.aibei.lixue.recylerviewexamle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RecylerViewDemoActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btn_normal;
    private Button btn_mix;
    private Button btn_header;
    private Button btn_mutiselected;
    private Button btn_sliding_left;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyler_view_demo);
        initView();
        initData();
    }

    private void initView(){
        btn_normal = (Button) findViewById(R.id.btn_normal);
        btn_mix = (Button) findViewById(R.id.btn_mix);
        btn_header = (Button) findViewById(R.id.btn_header_boot);
        btn_mutiselected = (Button) findViewById(R.id.mutil_select);
        btn_sliding_left = (Button) findViewById(R.id.btn_sliding_left);
    }

    private void initData(){
        btn_normal.setOnClickListener(this);
        btn_header.setOnClickListener(this);
        btn_mix.setOnClickListener(this);
        btn_mutiselected.setOnClickListener(this);
        btn_sliding_left.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        intent.setClass(getBaseContext(),MainActivity.class);
        switch (view.getId()){
            case R.id.btn_normal:
                intent.putExtra("adapterType",0);
                break;
            case R.id.btn_mix:
                intent.putExtra("adapterType",1);
                break;
            case R.id.mutil_select:
                intent.putExtra("adapterType",2);
                break;
            case R.id.btn_header_boot:
                intent.putExtra("adapterType",3);
                break;
            case R.id.btn_sliding_left:
                intent.putExtra("adapterType",4);
                break;
        }
        startActivity(intent);
    }
}
