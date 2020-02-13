package ar.com.dariojolo.mundocafe.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import ar.com.dariojolo.mundocafe.models.CafeteriaMessageEntity;

@Dao
public interface CafeteriaRoomMessagesDao {

    @Insert
    void insert(CafeteriaMessageEntity cafeteriaMessage);
    @Update
    void update(CafeteriaMessageEntity cafeteriaMessage);
    @Delete
    void delete(CafeteriaMessageEntity cafeteriaMessage);
    @Query("DELETE FROM cafeteriasMessages")
    void deleteAll();
    @Query("DELETE FROM cafeteriasMessages WHERE id = :idCafeteriaMessage")
    void deleteById(int idCafeteriaMessage);
    @Query("SELECT * FROM cafeteriasMessages ORDER BY date DESC")
    LiveData<List<CafeteriaMessageEntity>>getAll();
    @Query("SELECT * FROM cafeteriasMessages WHERE id = :idCafeteriaMessage")
    CafeteriaMessageEntity getById(int idCafeteriaMessage);

}
