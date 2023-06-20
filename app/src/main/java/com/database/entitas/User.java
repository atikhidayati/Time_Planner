package com.database.entitas;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {

    @PrimaryKey
    public int uid;

    @ColumnInfo(name = "title")
    public String tasktitle;

    public String desc;
    public String date;
    public String time;
    public String even;
    public int title;
}
