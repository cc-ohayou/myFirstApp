package com.space.cc.myfirstapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {
    final String TAG="DisplayMessageActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //若要使用返回的按钮 需要调用setDisplayHomeAsUpEnabled()方法
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        不管用户导航到哪，每个Activity都是通过Intent被调用的。
// 我们可以通过调用getIntent()来获取启动activity的Intent及其包含的数据
        Intent intent = getIntent();
//        调用 getStringExtra()提取从 MyActivity 传递过来的消息.
        String message = intent.getStringExtra(MyActivity.EXTRA_MESSAGE);
//        在onCreate()方法中创建一个对象TextView
        TextView textView = findViewById(R.id.textDisplay);
//        用setText()来设置文本字体大小和内容.
        textView.setText(message);
//        将TextView加入之前被标记为R.id.content的RelativeLayout中
            FloatingActionButton fab = findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "Replace with your own action display flb", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
      /*  if (id == R.id.action_settings) {
            return true;
        }*/
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() { }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.activity_display_message,
                    container, false);
            return rootView;
        }
    }
    @Override
    protected void onStart() {
        Log.e(TAG, "onStart");
        super.onStart();
    }



    @Override
    protected void onStop() {
        Log.e(TAG, "onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.e(TAG, "onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Log.e(TAG, "onPause");

        super.onPause();
    }

    @Override
    protected void onResume() {
        Log.e(TAG, "onResume");

        super.onResume();
    }

    @Override
    protected void onRestart() {
        Log.e(TAG, "onRestart");
        super.onRestart();
    }
}
