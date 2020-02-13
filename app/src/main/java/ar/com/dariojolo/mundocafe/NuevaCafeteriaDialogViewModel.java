package ar.com.dariojolo.mundocafe;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import ar.com.dariojolo.mundocafe.db.CafeteriaRepository;
import ar.com.dariojolo.mundocafe.models.CafeteriaEntity;

public class NuevaCafeteriaDialogViewModel extends AndroidViewModel {
    private LiveData<List<CafeteriaEntity>> allNotas;
    private LiveData<List<CafeteriaEntity>>allFavNotas;
    private CafeteriaRepository notaRepository;

    public NuevaCafeteriaDialogViewModel(Application application){
        super(application);

        notaRepository = new CafeteriaRepository(application);
        allNotas = notaRepository.getAll();
        allFavNotas = notaRepository.getFavoritas();
    }

    public LiveData<List<CafeteriaEntity>>getAllNotas(){
        return allNotas;
    }
    public LiveData<List<CafeteriaEntity>>getFavNotas(){
        return allFavNotas;
    }

    public void insertNota(CafeteriaEntity nuevaNotaEntity){
        notaRepository.insert(nuevaNotaEntity);
    }

    public void updateNota(CafeteriaEntity nuevaNotaEntity){
        notaRepository.update(nuevaNotaEntity);
    }
}
