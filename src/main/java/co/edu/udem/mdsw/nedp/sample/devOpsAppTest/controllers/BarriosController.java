package co.edu.udem.mdsw.nedp.sample.devOpsAppTest.controllers;

import co.edu.udem.mdsw.nedp.sample.devOpsAppTest.entities.BarrioDto;
import co.edu.udem.mdsw.nedp.sample.devOpsAppTest.service.ManejoBarrioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<BarrioDto[]> getBarrios(){
        List<BarrioDto> barrios = manejoBarrioService.getBarrios();
        BarrioDto[] array = new BarrioDto[barrios.size()];
        barrios.toArray(array);
        return ResponseEntity.ok().body(array);
    }

    @PostMapping(
            value = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<BarrioDto> createBarrio(@RequestBody BarrioDto barrioDto ) {
        return ResponseEntity.ok().body(manejoBarrioService.saveBarrio(barrioDto));
    }

    @PutMapping(
            value = "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<BarrioDto> updateBarrio(@RequestBody BarrioDto barrioDto, @PathVariable Integer id) {
        return ResponseEntity.ok().body(manejoBarrioService.updateBarrio(id, barrioDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BarrioDto> deleteBarrio(@PathVariable Integer id) {
        return ResponseEntity.ok().body(manejoBarrioService.deleteBarrio(id));
    }
}
