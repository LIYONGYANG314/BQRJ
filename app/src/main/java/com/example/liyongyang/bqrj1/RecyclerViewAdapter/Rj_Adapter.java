package com.example.liyongyang.bqrj1.RecyclerViewAdapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.liyongyang.bqrj1.R;

public class Rj_Adapter extends RecyclerView.Adapter<Rj_Adapter.LinearViewHolder> {
    private Context mContext;
    private int mWidth;//获取的宽度
    private Typeface mTypeface;

    public Rj_Adapter(Context context, Typeface typeface, int width){//构造函数从外部获取需要的量
        this.mContext = context;
        this.mWidth = width;
        this.mTypeface = typeface;

    }


    @NonNull
    @Override
    public Rj_Adapter.LinearViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new Rj_Adapter.LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.rvitem, viewGroup, false));//f返回一个对象，这个对象就是能实现对item操作的一个对象
    }

    @Override
    public void onBindViewHolder(@NonNull Rj_Adapter.LinearViewHolder viewHolder, int i) {

        /**
         * 大方框的设置
         */
        viewHolder.btn.setTextSize(25);
        viewHolder.btn.setText("item"+i);
        viewHolder.btn.setBackgroundColor(0xCCffffff);
        viewHolder.btn.setTypeface(mTypeface);
        viewHolder.btn.setWidth(mWidth);


        /**
         * 删除按键的设置
         */
        viewHolder.sbtn.setTextSize(25);
        viewHolder.sbtn.setText("删除");
        viewHolder.sbtn.setBackgroundColor(0xCCffffff);
        viewHolder.sbtn.setTypeface(mTypeface);
        viewHolder.sbtn.setTextColor(Color.parseColor("#E03636"));

    }

    @Override
    public int getItemCount() {
        return 7;
    }

    class LinearViewHolder extends RecyclerView.ViewHolder{

        private Button btn;
        private Button sbtn;

        public LinearViewHolder(@NonNull View itemView) {

            super(itemView);

            btn = itemView.findViewById(R.id.xc_btn);//修改查看的button，点击后能够修改本条信息
            sbtn = itemView.findViewById(R.id.Del_btn);
        }
    }
}
