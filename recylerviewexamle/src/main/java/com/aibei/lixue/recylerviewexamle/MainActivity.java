package com.aibei.lixue.recylerviewexamle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<String> stringList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView(){
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
    }

    private void initData(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        String[] arrayList = getResources().getStringArray(R.array.datas);
        for(int i =0 ;i < arrayList.length; i ++){
            stringList.add(arrayList[i]);
        }
//        recyclerView.setAdapter(new RecyclerAdapter(stringList));
        recyclerView.setAdapter(new MixRecyclerAdapter(stringList));

    }

    @Override
    protected void onDestroy() {
        if (stringList != null){
            stringList.clear();
            stringList = null;
        }
        super.onDestroy();
    }
}
