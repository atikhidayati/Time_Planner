package com.example.time_planner;

import android.app.TaskInfo;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface OnDataBaseAction {

    @Query("SELECT * FROM Task")
    List<Task> getAllTasklist();

    @Query("DELETE FROM Task ")
    void truncateTheList();

    @Insert
    void insertDataIntoTaskList(Task task);

    @Query("DELETE FROM Task WHERE taskId = :taskId")
    void deleteTaskFromId(int taskId);

    @Query("SELECT * FROM Task WHERE taskId = :taskId")
    Task selectDataFromAnId(int taskId);

    @Query("UPDATE Task SET Kegiatan=:Kegiatan, Deskripsi=:Deskripsi, Date=:Date, Time = :taskTime, taskId = :taskEvent WHERE taskId = :taskId")
    void updateAnExistingRow(int taskId, String Kegiatan, String Deskripsi,String Date, String taskTime,
                             String taskEvent);
}
