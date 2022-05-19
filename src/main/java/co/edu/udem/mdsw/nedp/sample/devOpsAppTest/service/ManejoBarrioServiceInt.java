package co.edu.udem.mdsw.nedp.sample.devOpsAppTest.service;

import co.edu.udem.mdsw.nedp.sample.devOpsAppTest.entities.BarrioDto;

import java.util.List;

public interface ManejoBarrioServiceInt {
    BarrioDto getBarrio(Integer id);

    List<BarrioDto> getBarrios();

    BarrioDto saveBarrio(BarrioDto barrioDto);

    BarrioDto updateBarrio(Integer id, BarrioDto barrioDto);

    BarrioDto deleteBarrio(Integer id);
}
