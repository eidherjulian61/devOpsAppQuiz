package co.edu.udem.mdsw.nedp.sample.devOpsAppTest.service;

import co.edu.udem.mdsw.nedp.sample.devOpsAppTest.entities.BarrioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ManejoBarrioService implements ManejoBarrioServiceInt {

    RestTemplate restTemplate;

    @Autowired
    public ManejoBarrioService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public BarrioDto getBarrio(Integer id){
        String url = "https://62858c6e96bccbf32d64835a.mockapi.io/barrios/"+ id;
        return restTemplate.getForObject(
                url, BarrioDto.class);
    }

    @Override
    public List<BarrioDto> getBarrios(){
        String url = "https://62858c6e96bccbf32d64835a.mockapi.io/barrios/";
        BarrioDto[] arr =  restTemplate.getForObject(
                url, BarrioDto[].class);
        return Arrays.asList(arr != null ? arr : new BarrioDto[0]);
    }

    @Override
    public BarrioDto saveBarrio(BarrioDto barrio) {
        String url = "https://62858c6e96bccbf32d64835a.mockapi.io/barrios/";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<BarrioDto> entity = new HttpEntity<>(barrio,headers);

        return restTemplate.postForObject(url, entity, BarrioDto.class);
    }

    @Override
    public BarrioDto updateBarrio(Integer id, BarrioDto barrioDto ) {
        String url = "https://62858c6e96bccbf32d64835a.mockapi.io/barrios/" + id;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<BarrioDto> entity = new HttpEntity<>(barrioDto,headers);
        restTemplate.put(url, entity);
        return barrioDto;
    }

    @Override
    public BarrioDto deleteBarrio(Integer id) {
        BarrioDto barrioDto = this.getBarrio(id);
        String url = "https://62858c6e96bccbf32d64835a.mockapi.io/barrios/"+ id;
        restTemplate.delete(url);
        return barrioDto;
    }

}
