package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.PenjagaModel;

import java.util.List;

public interface PenjagaService {
    void addPenjaga(PenjagaModel penjaga);
    void updatePenjaga(PenjagaModel penjaga);
//    List<BioskopModel> getPenjagaList();
    PenjagaModel getPenjagaByNoPenjaga(Long noPenjaga);
}
