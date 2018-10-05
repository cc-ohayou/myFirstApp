package com.space.cc.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MyActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.space.cc.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     *
     * 为使系统能够将该方法（你刚在MyActivity.java中添加的sendMessage方法）
     * 与在android:onClick属性中提供的方法名字匹配，它们的名字必须一致，
     * 特别需要注意的是，这个方法必须满足以下条件：
     是public函数
     无返回值
     参数唯一(为View类型,代表被点击的视图）
     接下来，你可以在这个方法中编写读取文本内容，并将该内容传到另一个Activity的代码。

     Intent是在不同组件中(比如两个Activity)提供运行时绑定的对象。
     Intent代表一个应用"想去做什么事"，你可以用它做各种各样的任务，
     不过大部分的时候他们被用来启动另一个Activity。
     更详细的内容可以参考Intents and Intent Filters。
     *@author CF
     *created at 2018/10/4/004  17:43
     */
    public void sendMessage(View view){
        //在这个Intent构造函数中有两个参数：
        //第一个参数是Context(之所以用this是因为当前Activity是Context的子类)
        //接受系统发送Intent的应用组件的Class（在这个案例中，指将要被启动的activity）。
        Intent intent=new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        //Intent可以携带称作 extras 的键-值对数据类型。 putExtra()方法把键名作为第一个参数，
        // 把值作为第二个参数。
        intent.putExtra(EXTRA_MESSAGE, message);
//        调用startActivity()完成新activity的启动
        startActivity(intent);
//        运行这个方法，系统收到我们的请求后会实例化在Intent中指定的Activity
    }
}
