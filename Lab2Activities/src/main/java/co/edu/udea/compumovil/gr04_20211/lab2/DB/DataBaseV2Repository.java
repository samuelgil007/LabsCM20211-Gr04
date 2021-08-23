package co.edu.udea.compumovil.gr04_20211.lab2.DB;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;

import java.util.List;

import co.edu.udea.compumovil.gr04_20211.lab2.Daos.SitioDao;
import co.edu.udea.compumovil.gr04_20211.lab2.Models.SitiosEntity;

public class DataBaseV2Repository {
    public DataBaseV2 dataBaseV2;
    public SitioDao sitioDao;

    Context context;
    private static final String TAG = "DataBaseV2Repository";

    public DataBaseV2Repository(Context context) {
        this.context = context;
        dataBaseV2 = DataBaseV2.getInstanceDb2(context);
        sitioDao = dataBaseV2.sitioDao();
    }

    public void saveSitio(SitiosEntity sitiosEntity){
        dataBaseV2.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                try{
                    sitioDao.saveSitio(sitiosEntity);
                    Log.d(TAG,"run: sitio guardado: "+ sitiosEntity.getNombre());
                }catch (Exception e){
                    Log.d(TAG,"run: error guardando sitio: "+ e.getMessage() );

                }
            }
        });
    }

    public LiveData<List<SitiosEntity>> getAllSitios(){
        return sitioDao.getAllSitios();
    }
}
