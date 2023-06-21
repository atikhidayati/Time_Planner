package com.example.time_planner;

import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import kotlinx.coroutines.scheduling.Task;

public interface OnDataBaseAction {

    @Query("SELECT * FROM Task")
    List<Task> getAllTasksList();

    @Query("DELETE FROM Task")
    void truncateTheList();

    @Insert
    void insertDataIntoTaskList(Task task);

    @Query("DELETE FROM Task WHERE taskId = :taskId"
    void deleteTaskFromId(int taskId);

    @Query("SELECT * FROM tambahtask WHERE taskId = :taskId")
    Task selectDataFromAnId(int taskId);

    @Query("UPDATE Task SET Kegiatan = Kegiatan, Deskripsi = :Deskripsi, Date = Date, " +
            "lastAlarm = :taskTime, event = :taskEvent WHERE taskId = :taskId")
    void updateAnExistingRow(int taskId, String Kegiatan, String Deskripsi,String Date, String taskTime,
                             String taskEvent);
}
