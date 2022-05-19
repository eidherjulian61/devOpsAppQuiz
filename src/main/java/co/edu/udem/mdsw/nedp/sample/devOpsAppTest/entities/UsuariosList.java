package co.edu.udem.mdsw.nedp.sample.devOpsAppTest.entities;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class UsuariosList implements Serializable {
    private List<UsuarioDto> usuarioList;

    public UsuariosList() {
        usuarioList = new ArrayList<>();
    }
}
