package co.edu.udea.compumovil.gr04_20211.lab2.Models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "sitios")
public class SitiosEntity {
    @PrimaryKey(autoGenerate = true)
    Integer id;

    @ColumnInfo(name = "nombre")
    String nombre;

    @ColumnInfo(name = "imagen")
    String imagen;

    @ColumnInfo(name = "descripcion")
    String descripcion;

    @ColumnInfo(name = "temperatura")
    String temperatura;

    @ColumnInfo(name = "localizacion")
    String localizacion;

}
