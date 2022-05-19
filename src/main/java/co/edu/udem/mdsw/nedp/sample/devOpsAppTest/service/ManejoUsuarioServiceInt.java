package co.edu.udem.mdsw.nedp.sample.devOpsAppTest.service;

import co.edu.udem.mdsw.nedp.sample.devOpsAppTest.entities.UsuarioDto;

import java.io.IOException;
import java.util.List;

public interface ManejoUsuarioServiceInt {

     UsuarioDto getUsuario(Integer id);
     List<UsuarioDto> getUsuarios();
     UsuarioDto saveUsuarios(UsuarioDto usuario)   throws IOException;
     UsuarioDto updateUsuario(Integer id, UsuarioDto usuarioDto) throws IOException;
     UsuarioDto deleteUsuario(Integer id) throws IOException;
}
