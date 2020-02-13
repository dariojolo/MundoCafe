package ar.com.dariojolo.mundocafe.models;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.Date;

import static androidx.room.ForeignKey.CASCADE;


@Entity(tableName = "cafeteriasMessages",
        foreignKeys = @ForeignKey(entity = CafeteriaEntity.class,
        parentColumns = "id",
        childColumns = "idCafeteria",
        onDelete = CASCADE))
public class CafeteriaMessageEntity {
    @PrimaryKey(autoGenerate = true)
    private Long id;
    private Long idCafeteria;
    private String message;
    private String user;
    private Date date;

    public CafeteriaMessageEntity(Long id, Long idCafeteria, String message, String user, Date date) {
        this.id = id;
        this.idCafeteria = idCafeteria;
        this.message = message;
        this.user = user;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCafeteria() {
        return idCafeteria;
    }

    public void setIdCafeteria(Long idCafeteria) {
        this.idCafeteria = idCafeteria;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
