package co.edu.udea.compumovil.gr04_20211.lab2.DB;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import co.edu.udea.compumovil.gr04_20211.lab2.Daos.SitioDao;
import co.edu.udea.compumovil.gr04_20211.lab2.Daos.UserDao;
import co.edu.udea.compumovil.gr04_20211.lab2.Models.SitiosEntity;
import co.edu.udea.compumovil.gr04_20211.lab2.Models.UserEntity;


@androidx.room.Database(entities = {UserEntity.class, SitiosEntity.class},version = 2, exportSchema = false)
public abstract class DataBaseV2 extends RoomDatabase {

    private static DataBaseV2 instance;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public abstract SitioDao sitioDao();
    public abstract UserDao userDao();


    public static synchronized DataBaseV2 getInstanceDb2(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),DataBaseV2.class,"Database2")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }


}
