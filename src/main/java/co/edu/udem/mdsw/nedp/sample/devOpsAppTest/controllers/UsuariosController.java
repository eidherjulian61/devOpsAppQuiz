package co.edu.udem.mdsw.nedp.sample.devOpsAppTest.controllers;

import co.edu.udem.mdsw.nedp.sample.devOpsAppTest.entities.UsuarioDto;
import co.edu.udem.mdsw.nedp.sample.devOpsAppTest.service.ManejoUsuarioServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
    ManejoUsuarioServiceInt manejoUsuarioService;

    @Autowired
    public UsuariosController(ManejoUsuarioServiceInt manejoUsuarioService){
        this.manejoUsuarioService = manejoUsuarioService;
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<UsuarioDto> getUsuario(@PathVariable Integer id){
        return ResponseEntity.ok().body(manejoUsuarioService.getUsuario(id));
    }

    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity<List<UsuarioDto>> getUsuarios(){
        return ResponseEntity.ok().body(manejoUsuarioService.getUsuarios());
    }

    @PostMapping("/")
    public ResponseEntity<UsuarioDto> saveUsuario(@RequestBody UsuarioDto usuario) throws IOException {
        return ResponseEntity.ok().body(manejoUsuarioService.saveUsuarios(usuario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDto> updateUsuario(@RequestBody UsuarioDto usuario, @PathVariable Integer id) throws IOException {
        return ResponseEntity.ok().body(manejoUsuarioService.updateUsuario(id, usuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UsuarioDto> deleteUsuario(@PathVariable Integer id) throws IOException {
        return ResponseEntity.ok().body(manejoUsuarioService.deleteUsuario(id));
    }


}
