package co.edu.udea.compumovil.gr04_20211.lab2.Daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import co.edu.udea.compumovil.gr04_20211.lab2.Models.SitiosEntity;
import co.edu.udea.compumovil.gr04_20211.lab2.Models.UserEntity;
@Dao
public interface SitioDao {
    @Insert
    void saveSitio(SitiosEntity sitiosEntity);

    @Query("SELECT * FROM sitios ORDER BY id DESC")
    LiveData<List<SitiosEntity>> getAllSitios();
}
