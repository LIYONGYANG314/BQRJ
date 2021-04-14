package com.example.liyongyang.bqrj1.Fragment;

import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.liyongyang.bqrj1.R;
import com.example.liyongyang.bqrj1.RecyclerViewAdapter.Rj_Adapter;

public class Rj_Fragment extends Fragment {
    /**
     * 控件声明部分
     */
    private RecyclerView RjList_recyclerview;
    private Rj_Adapter adapter;
    private TextView fmt_toptitle;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View Rj_view = inflater.inflate(R.layout.rj_fmt, container, false);//将布局rj_fmt,放入容器中，之后Bq_view可以使用
        show_RjFmt(Rj_view);
        return Rj_view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }



    /**
     * 启用适配器
     * @param Rj_view
     */
    public void show_RjFmt(View Rj_view){

        /**
         * 获取字体
         */
        Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Libian.ttc");


        fmt_toptitle = Rj_view.findViewById(R.id.rj_fmt_toptitle);
        fmt_toptitle.setTypeface(typeface);




        /**
         * 获取屏幕宽度
         */
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        /**
         * 设置adapter
         */
        RjList_recyclerview = Rj_view.findViewById(R.id.rjlist);//找控件
        adapter = new Rj_Adapter(getActivity(), typeface, displayMetrics.widthPixels);//实例化adapter
        RjList_recyclerview.addItemDecoration(new Rj_Fragment.MyDecoration());
        RjList_recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));//布局管理 线性 网格 瀑布流在此处改
        RjList_recyclerview.setAdapter(adapter);

    }

    /**
     * recyclerview列表里的间隙
     */
    class MyDecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0,0,0,10);
        }
    }
}
