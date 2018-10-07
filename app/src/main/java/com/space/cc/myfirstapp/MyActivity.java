package com.space.cc.myfirstapp;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.Toast;

public class MyActivity extends AppCompatActivity implements View.OnClickListener {
    public final static String EXTRA_MESSAGE = "com.space.cc.myfirstapp.MESSAGE";
    Toolbar mToolbar;
    Toast mToast;
    PopupWindow mPopupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mToast = Toast.makeText(this, "", Toast.LENGTH_SHORT);
        mToast.setGravity(Gravity.CENTER, 0, 0);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        // App Logo
    mToolbar.setLogo(R.drawable.app_icon2);
    // 主标题,默认为app_label的名字
        mToolbar.setTitle("Title");
        mToolbar.setTitleTextColor(Color.YELLOW);
        // 副标题
        mToolbar.setSubtitle("Sub title");
        mToolbar.setSubtitleTextColor(Color.parseColor("#FFF0D0"));
        //侧边栏的按钮
//        mToolbar.setNavigationIcon(R.drawable.back);
        //取代原本的actionbar
        setSupportActionBar(mToolbar);
        //设置NavigationIcon的点击事件,需要放在setSupportActionBar之后设置才会生效,
        //因为setSupportActionBar里面也会setNavigationOnClickListener
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mToast.setText("click NavigationIcon");
                mToast.show();
            }
        });
        //设置toolBar上的MenuItem点击事件
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_edit:
                        mToast.setText("click edit");
                        break;
                    case R.id.action_share:
                        mToast.setText("click share");
                        break;
                    case R.id.action_overflow:
                        //弹出自定义overflow
                        popUpMyOverflow();
                        return true;
                }
                mToast.show();
                return true;
            }
        });
        //ToolBar里面还可以包含子控件
        mToolbar.findViewById(R.id.btn_diy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mToast.setText("点击自定义按钮");
                mToast.show();
            }
        });
        mToolbar.findViewById(R.id.tv_title).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mToast.setText("点击自定义标题");
                mToast.show();
            }
        });

      /*  FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }
    /**
     * 弹出自定义的popWindow
     */
    public void popUpMyOverflow() {
        //获取状态栏高度
        Rect frame = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
        //状态栏高度+toolbar的高度
        int yOffset = frame.top + mToolbar.getHeight();
        if (null == mPopupWindow) {
            //初始化PopupWindow的布局
            View popView = getLayoutInflater().inflate(R.layout.action_overflow_popwindow, null);
            //popView即popupWindow的布局，ture设置focusAble.
            mPopupWindow = new PopupWindow(popView,
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT, true);
            //必须设置BackgroundDrawable后setOutsideTouchable(true)才会有效
            mPopupWindow.setBackgroundDrawable(new ColorDrawable());
            //点击外部关闭。
            mPopupWindow.setOutsideTouchable(true);
            //设置一个动画。
            mPopupWindow.setAnimationStyle(android.R.style.Animation_Dialog);
            //设置Gravity，让它显示在右上角。
            mPopupWindow.showAtLocation(mToolbar, Gravity.RIGHT | Gravity.TOP, 0, yOffset);
            //设置item的点击监听
            popView.findViewById(R.id.ll_item1).setOnClickListener(this);
            popView.findViewById(R.id.ll_item2).setOnClickListener(this);
            popView.findViewById(R.id.ll_item3).setOnClickListener(this);
        } else {
            mPopupWindow.showAtLocation(mToolbar, Gravity.RIGHT | Gravity.TOP, 0, yOffset);
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_item1:
                mToast.setText("哈哈");
                break;
            case R.id.ll_item2:
                mToast.setText("呵呵");
                break;
            case R.id.ll_item3:
                mToast.setText("嘻嘻");
                break;
        }
        //点击PopWindow的item后,关闭此PopWindow
        if (null != mPopupWindow && mPopupWindow.isShowing()) {
            mPopupWindow.dismiss();
        }
        mToast.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        super.onCreateOptionsMenu(menu);
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
//        if (id == R.id.action_settings) {
//            return true;
//        }

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
