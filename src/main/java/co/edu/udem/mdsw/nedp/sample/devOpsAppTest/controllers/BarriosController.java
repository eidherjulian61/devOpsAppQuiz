package co.edu.udem.mdsw.nedp.sample.devOpsAppTest.controllers;

import co.edu.udem.mdsw.nedp.sample.devOpsAppTest.entities.BarrioDto;
import co.edu.udem.mdsw.nedp.sample.devOpsAppTest.service.ManejoBarrioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/barrios")
public class BarriosController {

    ManejoBarrioService manejoBarrioService;

    @Autowired
    public BarriosController(ManejoBarrioService manejoBarrioService){
        this.manejoBarrioService = manejoBarrioService;
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<BarrioDto> getBarrio(@PathVariable Integer id){
        return ResponseEntity.ok().body(manejoBarrioService.getBarrio(id));
    }

    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity<List<BarrioDto>> getBarrios(){
        return ResponseEntity.ok().body(manejoBarrioService.getBarrios());
    }

    @PostMapping(
            value = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<BarrioDto> createBarrio(@RequestBody BarrioDto barrioDto ) throws IOException {
        return ResponseEntity.ok().body(manejoBarrioService.saveBarrio(barrioDto));
    }

    @PostMapping(
            value = "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<BarrioDto> updateBarrio(@RequestBody BarrioDto barrioDto, @PathVariable Integer id) throws IOException {
        return ResponseEntity.ok().body(manejoBarrioService.updateBarrio(id, barrioDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BarrioDto> deleteBarrio(@PathVariable Integer id) throws IOException {
        return ResponseEntity.ok().body(manejoBarrioService.deleteBarrio(id));
    }
}
