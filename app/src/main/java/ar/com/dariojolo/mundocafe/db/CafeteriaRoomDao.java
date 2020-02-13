package ar.com.dariojolo.mundocafe.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import ar.com.dariojolo.mundocafe.models.CafeteriaEntity;

@Dao
public interface CafeteriaRoomDao {
    @Insert
    void insert(CafeteriaEntity cafeteria);
    @Update
    void update(CafeteriaEntity cafeteria);
    @Delete
    void delete(CafeteriaEntity cafeteria);
    @Query("DELETE FROM cafeterias")
    void deleteAll();
    @Query("DELETE FROM cafeterias WHERE id = :idCafeteria")
    void deleteById(int idCafeteria);
    @Query("SELECT * FROM cafeterias ORDER BY name ASC")
    LiveData<List<CafeteriaEntity>>getAll();
    @Query("SELECT * FROM cafeterias WHERE favorita = 'true' ORDER BY name ASC")
    LiveData<List<CafeteriaEntity>> getFavoritas();
    @Query("SELECT * FROM cafeterias WHERE id = :idCafeteria")
    CafeteriaEntity getById(int idCafeteria);

}
