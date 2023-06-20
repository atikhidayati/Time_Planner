package com.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Query;

import com.database.entitas.User;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<User> getAll();

    @Query(value = "INSERT INTO user (title,`desc`,date,time,even) VALUES(:name,'desc')")
    void insertAll(String name, String email);

    @Query("UPDATE user SET title=title, 'desc'=`desc` , date=date, time=time, even=even WHERE uid=:uid")
    void update(int uid, String name, String email);

    @Query("SELECT * FROM user WHERE uid=:uid")
    User get(int uid);

    @Delete
    void delete(User user);


    void update(String toString, String toString1, String toString2, String toString3, String toString4);
}
