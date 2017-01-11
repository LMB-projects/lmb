package com.pj.lmb.lmbapplication;

import java.sql.Time;
import java.util.Date;

import io.realm.RealmObject;

/**
 * Created by reika.sato on 2017/01/05.
 */

public class Schedule extends RealmObject{

    //予定ID
    private int id;

    //予定のタイトル
    private String title;

    //日付
    private Date date;

    //時間
    private Time time;

    //内容
    private String contents;

    //カテゴリーID
    private int categoryNumber;

    public void setId(int id) {
        this.id = id;
    }

    public int getId(int id) {
        return id;
    }

    public  void setTitle(String title) {
        this.title = title;
    }

    public String getTitle(String title) {
        return title;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate(Date date) {
        return date;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Time getTime(Time time) {
        return time;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getContents(String contents) {
        return contents;
    }

    public void setCategoryNumber(int categoryNumber) {
        this.categoryNumber = categoryNumber;
    }

    public int getCategoryNumber(int categoryNumber) {
        return categoryNumber;
    }

}
