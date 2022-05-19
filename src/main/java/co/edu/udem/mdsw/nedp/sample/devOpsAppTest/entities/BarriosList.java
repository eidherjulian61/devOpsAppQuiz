package co.edu.udem.mdsw.nedp.sample.devOpsAppTest.entities;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BarriosList {
    private List<BarrioDto> barriosList;

    public BarriosList() {
        barriosList = new ArrayList<>();
    }
}
