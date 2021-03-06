//package apap.tutorial.cineplux.service;
//
//import apap.tutorial.cineplux.model.BioskopModel;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class BioskopInMemoryService implements BioskopService {
//
//    private List<BioskopModel> listBioskop;
//
//    //Constructor
//    public BioskopInMemoryService(){
//        listBioskop = new ArrayList<>();
//    }
//
//    @Override
//    public void addBioskop(BioskopModel bioskop) {
//        listBioskop.add(bioskop);
//    }
//
//    @Override
//    public List<BioskopModel> getBioskopList() {
//        return listBioskop;
//    }
//
//    @Override
//    public BioskopModel getBioskopByIdBioskop(String idBioskop) {
//        for (BioskopModel bm: listBioskop){
//            if (bm.getIdBioskop().equals(idBioskop)){
//                return bm;
//            }
//        }
//        return null;
//
//    }
//
//    @Override
//    public void deleteBioskop(BioskopModel idBioskop) {
//        listBioskop.remove(idBioskop);
//    }
//
//
//}
