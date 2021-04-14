package com.example.liyongyang.bqrj1.Fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.liyongyang.bqrj1.R;

public class W_Fragment extends Fragment {
    /**
     *控件声明
     */
    private EditText user;
    private Button denglu,zhuce;
    private TextView fmt_toptitle,password;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View W_view = inflater.inflate(R.layout.w_fmt, container, false);
        show_Wfmt(W_view);
        return W_view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void show_Wfmt(View W_view){
        /**
         * 找控件
         */
        user = W_view.findViewById(R.id.user);
        denglu = W_view.findViewById(R.id.denglu);
        zhuce = W_view.findViewById(R.id.zhuce);
        password = W_view.findViewById(R.id.password);
        fmt_toptitle = W_view.findViewById(R.id.w_fmt_toptitle);

        /**
         * 设置字体
         */
        Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Libian.ttc");
        user.setTypeface(typeface);
        denglu.setTypeface(typeface);
        zhuce.setTypeface(typeface);
        password.setTypeface(typeface);
        fmt_toptitle.setTypeface(typeface);
    }
}
