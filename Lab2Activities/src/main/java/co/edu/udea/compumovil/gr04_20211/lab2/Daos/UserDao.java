package co.edu.udea.compumovil.gr04_20211.lab2.Daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import co.edu.udea.compumovil.gr04_20211.lab2.Models.UserEntity;

@Dao
public interface UserDao {
    @Insert
    void registerUser(UserEntity userEntity);

    @Query("SELECT * from user where username=(:userName) and password=(:passWord)")
    UserEntity login(String userName,String passWord);
}