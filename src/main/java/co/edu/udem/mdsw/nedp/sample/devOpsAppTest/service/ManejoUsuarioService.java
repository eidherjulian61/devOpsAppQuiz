package co.edu.udem.mdsw.nedp.sample.devOpsAppTest.service;

import co.edu.udem.mdsw.nedp.sample.devOpsAppTest.entities.UsuarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ManejoUsuarioService implements ManejoUsuarioServiceInt{

    RestTemplate restTemplate;


    @Autowired
    public ManejoUsuarioService(RestTemplate restTemplate){
         this.restTemplate = restTemplate;
    }

    @Override
    public UsuarioDto getUsuario(Integer id){
        String url = "https://6285638196bccbf32d622180.mockapi.io/api/v1/users/"+ id;
        return restTemplate.getForObject(
                url, UsuarioDto.class);
    }

    @Override
    public List<UsuarioDto> getUsuarios(){
        String url = "https://6285638196bccbf32d622180.mockapi.io/api/v1/users/";
        UsuarioDto[] arr =  restTemplate.getForObject(
                url, UsuarioDto[].class);
        return Arrays.asList(arr != null ? arr : new UsuarioDto[0]);
    }

    @Override
    public UsuarioDto saveUsuarios(UsuarioDto usuario) {
        String url = "https://6285638196bccbf32d622180.mockapi.io/api/v1/users/";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<UsuarioDto> entity = new HttpEntity<>(usuario,headers);

        return restTemplate.postForObject(url, entity, UsuarioDto.class);
    }

    @Override
    public UsuarioDto updateUsuario(Integer id, UsuarioDto usuarioDto ) {
        String url = "https://6285638196bccbf32d622180.mockapi.io/api/v1/users/" + id;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<UsuarioDto> entity = new HttpEntity<>(usuarioDto,headers);
        restTemplate.put(url, entity);
        return usuarioDto;
    }

    @Override
    public UsuarioDto deleteUsuario(Integer id) {
        UsuarioDto usuarioDto = this.getUsuario(id);
        String url = "https://6285638196bccbf32d622180.mockapi.io/api/v1/users/"+ id;
        restTemplate.delete(url);
        return usuarioDto;
    }
}
