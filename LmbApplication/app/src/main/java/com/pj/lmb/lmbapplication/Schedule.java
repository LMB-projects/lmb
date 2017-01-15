package com.pj.lmb.lmbapplication;


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
    private String date;

    //時間
    private String time;

    //内容
    private String contents;

    //カテゴリーID
    private int categoryNumber;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public int getCategoryNumber() {
        return categoryNumber;
    }

    public void setCategoryNumber(int categoryNumber) {
        this.categoryNumber = categoryNumber;
    }
    }
