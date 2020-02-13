package ar.com.dariojolo.mundocafe.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import ar.com.dariojolo.mundocafe.models.CafeteriaEntity;
import ar.com.dariojolo.mundocafe.models.CafeteriaMessageEntity;

@Database(entities = {CafeteriaEntity.class, CafeteriaMessageEntity.class}, version = 1, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class CafeteriaRoomDatabase extends RoomDatabase {
    public abstract CafeteriaRoomDao getCafeteriaDao();
    private static volatile CafeteriaRoomDatabase INSTANCE;
    public static CafeteriaRoomDatabase getDataBase(final Context context) {
        if (INSTANCE == null) {
            synchronized (CafeteriaRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), CafeteriaRoomDatabase.class, "cafeteria_database").build();
                }
            }
        }
        return INSTANCE;
    }

}
