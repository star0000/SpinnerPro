package com.moyu.spinnerpro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private ArrayList<String> list;
    private ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (Spinner) findViewById(R.id.spinner);
        initData();

        //参数一:上下文对象;
        // 参数二:指定下拉菜单当中每个条目的样式
        //参数三: 指定了Textview的id
        //参数四:列表数据
//        arrayAdapter = new ArrayAdapter(this, R.layout.item_spinnner, R.id.tv_name, list);
//        spinner.setAdapter(arrayAdapter);
//        spinner.setPrompt("城市");


        //通过createFromResource方法创建一个ArrayAdapter对象
        //参数一:上下文对象;
        // 参数二:引用了在String.xml文件中定义的String数组
        //参数三: 用来指定spinner的样式,是一个布局文件id,该布局文件有系统提供,也可替换为自己定义的
        ArrayAdapter<CharSequence> fromResource = ArrayAdapter.createFromResource(this, R.array.spinner_array, android.R.layout.simple_spinner_item);
        //设置spinner当中每个每个条目的样式,同样是引用系统提供的,也可以自己定义
        fromResource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(fromResource);
        spinner.setPrompt("城市");


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //点击某个条目时获取到点击的条目的数据
                String s = parent.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this,s,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void initData() {
        list = new ArrayList<>();
        list.add("北京");
        list.add("上海");
        list.add("广州");
        list.add("深圳");
        list.add("杭州");
        list.add("郑州");
        list.add("成都");
        list.add("重庆");
        list.add("安徽");
        list.add("河北");
        list.add("天津");
        list.add("太原");
        list.add("海淀");
    }
}
