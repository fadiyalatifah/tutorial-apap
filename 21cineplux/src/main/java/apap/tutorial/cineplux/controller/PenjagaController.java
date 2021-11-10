package apap.tutorial.cineplux.controller;


import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.PenjagaModel;
import apap.tutorial.cineplux.service.BioskopService;
import apap.tutorial.cineplux.service.PenjagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalTime;
import java.util.List;

@Controller
public class PenjagaController {
    @Qualifier("penjagaServiceImpl")
    @Autowired
    PenjagaService penjagaService;

    @Qualifier("bioskopServiceImpl")
    @Autowired
    BioskopService bioskopService;

    @GetMapping("/penjaga/add/{noBioskop}")
    public String addPenjagaForm(@PathVariable Long noBioskop, Model model){
        PenjagaModel penjaga = new PenjagaModel();
        BioskopModel bioskop = bioskopService.getBioskopByNoBioskop(noBioskop);
        penjaga.setBioskop(bioskop);
        model.addAttribute("penjaga", penjaga);
        return "form-add-penjaga";
    }

    @PostMapping("/penjaga/add")
    public String addPenjagaSubmit(
            @ModelAttribute PenjagaModel penjaga,
            Model model
    ){
        penjagaService.addPenjaga(penjaga);
        model.addAttribute("noBioskop", penjaga.getBioskop().getNoBioskop());
        model.addAttribute("namaPenjaga", penjaga.getNamaPenjaga());
        return "add-penjaga";
    }
    // Nomor 2
    @GetMapping("/penjaga/update/{noPenjaga}")
    public String updatePenjagaForm(
            @PathVariable Long noPenjaga,
            Model model
    ) {
        PenjagaModel penjaga = penjagaService.getPenjagaByNoPenjaga(noPenjaga);
        if(penjaga == null) {
            return "error-id-penjaga";
        }
        model.addAttribute("penjaga", penjaga);
        model.addAttribute("noBioskop", penjaga.getBioskop().getNoBioskop());
        return "form-update-penjaga";
    }

    @PostMapping("/penjaga/update")
    public String updatePenjagaSubmit(
            @ModelAttribute PenjagaModel penjaga,
            Model model
    ) {

        LocalTime time = LocalTime.now();
        if( (time.isAfter(penjaga.getBioskop().getWaktuTutup())) || (time.isBefore(penjaga.getBioskop().getWaktuBuka()))  ){
            penjagaService.updatePenjaga(penjaga);
            model.addAttribute("noPenjaga", penjaga.getNoPenjaga());
            model.addAttribute("noBioskop", penjaga.getBioskop().getNoBioskop());
            return "update-penjaga";
        }
        model.addAttribute("noPenjaga", penjaga.getNoPenjaga());
        model.addAttribute("noBioskop", penjaga.getBioskop().getNoBioskop());
        return "error-update-penjaga";
    }

//    @GetMapping("/penjaga/delete/{noPenjaga}")
//    public String deletePenjaga(
//            @PathVariable Long noPenjaga,
//            Model model
//    ) {
//        PenjagaModel penjaga = penjagaService.getPenjagaByNoPenjaga(noPenjaga);
//        if(penjaga == null) {
//            return "error-id-penjaga";
//        }
//        LocalTime time = LocalTime.now();
//        if( (time.isAfter(penjaga.getBioskop().getWaktuTutup())) || (time.isBefore(penjaga.getBioskop().getWaktuBuka()))  ){
//            penjagaService.deletePenjaga(penjaga);
//            model.addAttribute("penjaga", penjaga);
//            model.addAttribute("noBioskop", penjaga.getBioskop().getNoBioskop());
//            return "delete-penjaga";
//        }
//        model.addAttribute("penjaga", penjaga);
//        model.addAttribute("noBioskop", penjaga.getBioskop().getNoBioskop());
//        return "error-delete-penjaga";
//
//    }

    @PostMapping("/penjaga/delete")
    public String deletePenjagaSubmit(
            @ModelAttribute BioskopModel bioskop,
            Model model
    ){
        model.addAttribute("noBioskop", bioskop.getNoBioskop());
        int res =1;
        for(PenjagaModel penjaga: bioskop.getListPenjaga()){
            res = penjagaService.deletePenjaga(penjaga);
        }
        if(res==1){
            return "delete-penjaga";
        }
        return "error";
    }



}
