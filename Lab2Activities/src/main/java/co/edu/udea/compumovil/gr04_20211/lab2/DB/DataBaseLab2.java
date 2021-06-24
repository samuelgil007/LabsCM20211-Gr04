package co.edu.udea.compumovil.gr04_20211.lab2.DB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import co.edu.udea.compumovil.gr04_20211.lab2.Daos.UserDao;
import co.edu.udea.compumovil.gr04_20211.lab2.Models.SitiosEntity;
import co.edu.udea.compumovil.gr04_20211.lab2.Models.UserEntity;

@androidx.room.Database(entities = {UserEntity.class, SitiosEntity.class},version = 1)
public abstract class DataBaseLab2 extends RoomDatabase {
    private static final String dbName = "user";
    private static DataBaseLab2 dataBaseLab2;

    public static synchronized DataBaseLab2 getDatabase(Context context){
        if(dataBaseLab2 == null){
            dataBaseLab2 = Room.databaseBuilder(context,DataBaseLab2.class,dbName)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return dataBaseLab2;
    }
    public abstract UserDao userDao();
}