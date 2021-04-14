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
import com.example.liyongyang.bqrj1.RecyclerViewAdapter.Bq_Adapter;

public class Bq_Fragment extends Fragment {
    /**
     * 控件声明部分
     */
    private RecyclerView BqList_recyclerview;
    private Bq_Adapter adapter;
    private TextView fmt_toptitle;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View Bq_view = inflater.inflate(R.layout.bq_fmt, container, false);//将布局bq_fmt,放入容器中，之后Bq_view可以使用
        show_BqFmt(Bq_view);
        return Bq_view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }



    /**
     * 启用适配器
     * @param Bq_view
     */
    public void show_BqFmt(View Bq_view){

        /**
         * 获取字体
         */
        Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Libian.ttc");


        fmt_toptitle = Bq_view.findViewById(R.id.bq_fmt_toptitle);
        fmt_toptitle.setTypeface(typeface);




        /**
         * 获取屏幕宽度
         */
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        /**
         * 设置adapter
         */
        BqList_recyclerview = Bq_view.findViewById(R.id.bqlist);//找控件
        adapter = new Bq_Adapter(getActivity(), typeface, displayMetrics.widthPixels);//实例化adapter
        BqList_recyclerview.addItemDecoration(new MyDecoration());
        BqList_recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));//布局管理 线性 网格 瀑布流在此处改
        BqList_recyclerview.setAdapter(adapter);

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
