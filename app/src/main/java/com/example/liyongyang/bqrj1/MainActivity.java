package com.example.liyongyang.bqrj1;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.liyongyang.bqrj1.Fragment.Bq_Fragment;
import com.example.liyongyang.bqrj1.Fragment.Rj_Fragment;
import com.example.liyongyang.bqrj1.Fragment.W_Fragment;

public class MainActivity extends AppCompatActivity {

    /**
     * 对fragment的声明
     */
    private Bq_Fragment bq_fragment;
    private Rj_Fragment rj_fragment;
    private W_Fragment w_fragment;
    private BottomNavigationView mBottomnavigationview;
    private Fragment from;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBottomnavigationview = findViewById(R.id.menu);

        /**
         *实例化fragment,并且添加到对应位置中
         */
        bq_fragment = new Bq_Fragment();
        rj_fragment = new Rj_Fragment();
        w_fragment = new W_Fragment();

        from = new Fragment();//记录上一个fragment

        /**
         * 添加需要的fragment然后使得在之后可以使用hint与show加快不同fragment之间的切换速度
         */
        getSupportFragmentManager().beginTransaction().add(R.id.fmt_change_place, w_fragment).commitAllowingStateLoss();
        getSupportFragmentManager().beginTransaction().hide(w_fragment).add(R.id.fmt_change_place, rj_fragment).commitAllowingStateLoss();//在之前的mainactivity的布局中找到fmt_change_place来存放bq_fragment这个view
        getSupportFragmentManager().beginTransaction().hide(rj_fragment).add(R.id.fmt_change_place, bq_fragment).commitAllowingStateLoss();
        from = bq_fragment;//由于显示的第一个页面是bq页所以把from设为bq_fragment

        /**
         * 设置监听
         */
        mBottomnavigationview.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.first:
                        if(bq_fragment != from){//确定不是在已选bq_fragment的情况下选择的此fragment
                            if(!bq_fragment.isAdded()){//判断是否已经用过此fragment
                                getSupportFragmentManager().beginTransaction().hide(from).add(R.id.fmt_change_place, bq_fragment).commitAllowingStateLoss();
                            }else{
                                getSupportFragmentManager().beginTransaction().hide(from).show(bq_fragment).commitAllowingStateLoss();
                                from = bq_fragment;
                            }
                        }
                        break;

                    case R.id.second:
                        if(rj_fragment != from){
                            if(!rj_fragment.isAdded()){
                                getSupportFragmentManager().beginTransaction().hide(from).add(R.id.fmt_change_place, rj_fragment).commitAllowingStateLoss();
                            }else{
                                getSupportFragmentManager().beginTransaction().hide(from).show(rj_fragment).commitAllowingStateLoss();
                                from = rj_fragment;
                            }
                        }
                        break;

                    case R.id.third:
                        if(w_fragment != from){
                            if(!w_fragment.isAdded()){
                                getSupportFragmentManager().beginTransaction().hide(from).add(R.id.fmt_change_place, w_fragment).commitAllowingStateLoss();
                            }else{
                                getSupportFragmentManager().beginTransaction().hide(from).show(w_fragment).commitAllowingStateLoss();
                                from = w_fragment;
                            }
                        }
                        break;
                }
                return true;
            }
        });
    }
}
