package com.example.time_planner;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Task {

    @PrimaryKey
    public int taskId;

    @ColumnInfo(name = "kegiatan")
    public String Kegiatan;

    public String Deskripsi;

    public String Date;

    public String Time;

    public String TambahKegiatan;
}
