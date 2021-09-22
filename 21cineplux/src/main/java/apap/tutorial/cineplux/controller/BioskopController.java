package apap.tutorial.cineplux.controller;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.service.BioskopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.*;


@Controller
public class BioskopController {
    @Autowired
    private BioskopService bioskopService;

    @RequestMapping("/bioskop/add")
    public String addBioskop(
            @RequestParam(value = "idBioskop", required = true) String idBioskop,
            @RequestParam(value = "namaBioskop", required = true) String namaBioskop,
            @RequestParam(value = "alamat", required = true) String alamat,
            @RequestParam(value = "noTelepon", required = true) String noTelepon,
            @RequestParam(value = "jumlahStudio", required = true) int jumlahStudio,
            Model model
    ) {
        //Membuat objek BioskopModel
        BioskopModel bioskopModel = new BioskopModel(idBioskop, namaBioskop, alamat, noTelepon, jumlahStudio);

        //Menambah objek BioskopModel kedalam service
        bioskopService.addBioskop(bioskopModel);

        //Add variabel id bioskop ke "idBioskop" untuk dirender ke dalam thymeleaf
        model.addAttribute("idBioskop", idBioskop);

        //Return view template yang digunakan
        return "add-bioskop";
    }

    @RequestMapping("/bioskop/viewall")
    public String listBioskop(Model model){
        //Mendapatkan semua bioskop
        List<BioskopModel> listBioskop = bioskopService.getBioskopList();

        //Add variable semua BioskopModel ke 'listBioskop' untuk dirender dalam thymeleaf
        model.addAttribute("listBioskop", listBioskop);

        //Return view template yang diinginkan
        return "viewall-bioskop";
    }

    @RequestMapping("/bioskop/view")
    public String detailBioskop(
            @RequestParam(value = "idBioskop", required = true) String idBioskop,
            Model model
    ){
        //Mendapatkan bioskop sesuai dengan idBioskop
        BioskopModel bioskopModel = bioskopService.getBioskopByIdBioskop(idBioskop);

        //Add variable BioskopModel ke 'bioskop' untuk dirender dalam thymeleaf
        model.addAttribute("bioskop", bioskopModel);
        return "view-bioskop";
    }

    @RequestMapping("/bioskop/view/id-bioskop/{idBioskop}")
    public String viewBioskopById(
            @PathVariable("idBioskop") String idBioskop,
            Model model
    ){
        //Mendapatkan bioskop sesuai dengan idBioskop
        BioskopModel bioskopModel = bioskopService.getBioskopByIdBioskop(idBioskop);

        //Add variable BioskopModel ke 'bioskop' untuk dirender dalam thymeleaf
        model.addAttribute("bioskop", bioskopModel);
        return "view-bioskop";
    }

    @RequestMapping("/bioskop/view/id-bioskop-filter/{idBioskop}")
    public String challengeController(
            @PathVariable("idBioskop") String idBioskop,
            Model model
    ){
        //Mendapatkan bioskop sesuai dengan idBioskop
        List<BioskopModel> bioskopModel = bioskopService.challenge1(idBioskop);
        //Mendapatkan semua bioskop
        List<BioskopModel> listBioskop = bioskopService.getBioskopList();
        //Add variable semua BioskopModel ke 'listBioskop' untuk dirender dalam thymeleaf
        model.addAttribute("listBioskop", listBioskop);
        //Add variable BioskopModel ke 'bioskop' untuk dirender dalam thymeleaf
        model.addAttribute("listBioskop", bioskopModel);
        return "viewfilter-bioskop";
    }

    @RequestMapping("/bioskop/update/id-bioskop/{idBioskop}/jumlah-studio/{jumlahStudio}")
    public String updateJmlStudio(
            @PathVariable(value="idBioskop", required=true) String idBioskop, @PathVariable(value = "jumlahStudio", required = true) int jumlahStudio,
            Model model
    ){
        //Mendapatkan bioskop sesuai dengan idBioskop
        BioskopModel bioskopModel2 = bioskopService.getBioskopByIdBioskop(idBioskop);

        // Set nilai jumlah studio baru
        bioskopModel2.setJumlahStudio(jumlahStudio);

        //Add variable BioskopModel ke 'bioskop' untuk dirender dalam thymeleaf
        model.addAttribute("bioskop", bioskopModel2);
        return "update-jumlahStudio";

    }


    @RequestMapping ("/bioskop/delete/id-bioskop/{idBioskop}")
    public String deleteBioskopController(
            @PathVariable(value="idBioskop", required=true) String idBioskop,
            Model model
    ){
        //Mendapatkan bioskop sesuai dengan idBioskop
        BioskopModel bioskopModel3 = bioskopService.getBioskopByIdBioskop(idBioskop);

        //Add variable BioskopModel ke 'bioskop' untuk dirender dalam thymeleaf
        model.addAttribute("bioskop", bioskopModel3);

        //menghapus bioskop
        if(bioskopModel3 != null){
            bioskopService.deleteBioskop(bioskopModel3);
        }

        return "delete-bioskop";


    }






}
