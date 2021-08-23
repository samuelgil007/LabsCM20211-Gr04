package co.edu.udea.compumovil.gr04_20211.lab2.Models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "sitios")
public class SitiosEntity {
    @PrimaryKey(autoGenerate = true)
    public Integer id;

    @ColumnInfo(name = "nombre")
    public String nombre;

    @ColumnInfo(name = "imagen")
    public String imagen;

    @ColumnInfo(name = "descripcion")
    public String descripcion;

    @ColumnInfo(name = "temperatura")
    public String temperatura;

    @ColumnInfo(name = "localizacion")
    public String localizacion;

    public Integer getId() {
        return id;
    }

    public SitiosEntity(String nombre, String imagen, String descripcion, String temperatura, String localizacion) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.temperatura = temperatura;
        this.localizacion = localizacion;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public SitiosEntity() {
    }
}
