package com.space.cc.myfirstapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        Button but01 = findViewById(R.id.first_button);
        but01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Toast.makeText(FirstActivity.this,
                        "click on but01", Toast.LENGTH_SHORT).show();*/
                //跳转到另外一个活动页面
//                Intent intent=new Intent(FirstActivity.this,SecondActivity.class);
                //跳转到系统浏览器 打开网页
                Intent  intent=new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("http://www.baidu.com"));
                //调用系统拨号界面
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);
            }
        });
    }

    /**
     * @author CF
     * created at 2018/10/14/014  22:23
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //创建资源菜单返回false 创建的菜单将无法使用
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    /**
     * 菜单响应事件
     *
     * @author CF
     * created at 2018/10/14/014  22:23
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "clicked menu add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "clicked menu remove", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

}
