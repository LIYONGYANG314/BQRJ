package com.example.liyongyang.bqrj1.Datas;

import java.io.Serializable;

public class Bq_Data implements Serializable {

    public int mId;
    public String mNeirong;
    public String mTime;

    public Bq_Data(int id, String neirong, String time){
        this.mId = id;
        this.mNeirong = neirong;
        this.mTime = time;
    }

    public Bq_Data(String neirong, String time){
        this.mNeirong = neirong;
        this.mTime = time;
    }

    public Bq_Data(){
        this.mNeirong = null;
        this.mTime = null;
    }

    public int getId(){//得到id
        return mId;
    }

    public String getNeirong(){//得到内容
        return mNeirong;
    }

    public String getTime(){//得到时间
        return mTime;
    }

}
