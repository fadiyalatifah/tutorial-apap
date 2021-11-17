package apap.tutorial.cineplux.restcontroller;
import apap.tutorial.cineplux.model.PenjagaModel;
import apap.tutorial.cineplux.rest.PenjagaDetail;
import apap.tutorial.cineplux.service.PenjagaRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1")
public class PenjagaRestController {

    @Autowired
    private PenjagaRestService penjagaRestService;

    @PostMapping(value = "/penjaga")
    private PenjagaModel createPenjaga(@Valid @RequestBody PenjagaModel penjaga, BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field"
            );
        }else{
            return penjagaRestService.createPenjaga(penjaga);
        }
    }

    @GetMapping(value = "/penjaga/{noPenjaga}")
    private PenjagaModel retrievePenjaga(
            @PathVariable("noPenjaga") Long noPenjaga
    ){
        try{
            return penjagaRestService.getPenjagaByNoPenjaga(noPenjaga);
        }catch (NoSuchElementException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "No Penjaga " + String.valueOf(noPenjaga) + "Not Found."
            );
        }
    }
    @DeleteMapping(value = "/penjaga/{noPenjaga}")
    private ResponseEntity deletePenjaga(
            @PathVariable("noPenjaga") Long noPenjaga
    ){
        try {
            penjagaRestService.deletePenjaga(noPenjaga);
            return ResponseEntity.ok("Penjaga has been deleted");
        } catch (NoSuchElementException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Penjaga Not Found."
            );
        } catch (UnsupportedOperationException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Bioskop is still open or has penjaga!"
            );
        }
    }
    @PutMapping(value = "/penjaga/{noPenjaga}")
    private ResponseEntity updatePenjaga(
            @PathVariable("noPenjaga") Long noPenjaga,
            @RequestBody PenjagaModel penjaga
    ){
        try{
            penjagaRestService.updatePenjaga(noPenjaga, penjaga);
            return ResponseEntity.ok("Update Penjaga Success");
        } catch (NoSuchElementException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Penjaga with No Penjaga " + String.valueOf(noPenjaga) + " Not Found."
            );
        }
    }
    @GetMapping(value = "/list-penjaga")
    private List<PenjagaModel> retrieveListPenjaga(){
        return penjagaRestService.retrieveListPenjaga();
    }

    @GetMapping(value = "/penjaga/{noPenjaga}/status")
    private Mono<String> getStatus(@PathVariable("noPenjaga") Long noPenjaga){
        return penjagaRestService.getStatus(noPenjaga);
    }
    @GetMapping(value = "/full2")
    private Mono<PenjagaDetail> postStatus(){
        return penjagaRestService.postStatus();
    }

    @GetMapping(value = "penjaga/umur/{noPenjaga}")
    private PenjagaModel getUmur(@PathVariable("noPenjaga") Long noPenjaga) {
        penjagaRestService.umurPenjaga(noPenjaga);
        return penjagaRestService.getPenjagaByNoPenjaga(noPenjaga);
    }


}