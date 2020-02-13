package ar.com.dariojolo.mundocafe.db;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

import ar.com.dariojolo.mundocafe.models.CafeteriaEntity;

public class CafeteriaRepository {
    private CafeteriaRoomDao dao;

    public CafeteriaRepository(Application application){
        CafeteriaRoomDatabase db = CafeteriaRoomDatabase.getDataBase(application);
        dao = db.getCafeteriaDao();
    }
    private static class insertAsyncTask extends AsyncTask<CafeteriaEntity, Void, Void> {
        private CafeteriaRoomDao cafeteriaDaoAsync;
        insertAsyncTask(CafeteriaRoomDao dao) {
            cafeteriaDaoAsync = dao;
        }
        @Override
        protected Void doInBackground(CafeteriaEntity... cafeteriaEntities) {
            cafeteriaDaoAsync.insert(cafeteriaEntities[0]);
            return null;
        }
    }
    public void insert(CafeteriaEntity cafeteria) {
        new insertAsyncTask(dao).execute(cafeteria);
    }
    private static class updateAsyncTask extends AsyncTask<CafeteriaEntity, Void, Void> {
        private CafeteriaRoomDao cafeteriaDaoAsync;
        updateAsyncTask(CafeteriaRoomDao dao) {
            cafeteriaDaoAsync = dao;
        }
        @Override
        protected Void doInBackground(CafeteriaEntity... cafeteriaEntities) {
            cafeteriaDaoAsync.update(cafeteriaEntities[0]);
            return null;
        }
    }
    public void update(CafeteriaEntity cafeteria) {
        new updateAsyncTask(dao).execute(cafeteria);
    }
    public void delete(CafeteriaEntity cafeteria) {
        dao.delete(cafeteria);
    }
    public void deleteAll() {
        dao.deleteAll();
    }
    public void deleteById(int idCafeteria) {
        dao.deleteById(idCafeteria);
    }

    public LiveData<List<CafeteriaEntity>> getAll() {
        return dao.getAll();
    }
    public LiveData<List<CafeteriaEntity>> getFavoritas() {
        return dao.getFavoritas();
    }
    public CafeteriaEntity getById(int idCafeteria) {
        return dao.getById(idCafeteria);
    }

}
