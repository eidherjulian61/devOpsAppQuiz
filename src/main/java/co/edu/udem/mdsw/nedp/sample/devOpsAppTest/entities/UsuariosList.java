package co.edu.udem.mdsw.nedp.sample.devOpsAppTest.entities;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UsuariosList {
    private List<UsuarioDto> usuarioList;

    public UsuariosList() {
        usuarioList = new ArrayList<>();
    }
}
