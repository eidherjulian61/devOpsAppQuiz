package co.edu.udem.mdsw.nedp.sample.devOpsAppTest.entities;

import lombok.Data;

import java.io.Serializable;

@Data
public class BarrioDto implements Serializable {
    private String id;
    private String nombre;
    private String ubicacion;
}
