package com.involves.selecao.service;

import com.involves.selecao.entity.Pesquisa;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class PesquisaService {

    public static final String URL_PESQUISA = "https://selecao-involves.agilepromoter.com/pesquisas";
    private RestTemplate restTemplate;

    public PesquisaService() {
        this.restTemplate = getRestTemplate();
    }

    //https://stackoverflow.com/questions/44176335/restclientexception-could-not-extract-response-no-suitable-httpmessageconverte
    private RestTemplate getRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Arrays.asList(MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON));
        restTemplate.getMessageConverters().add(converter);
        return restTemplate;
    }

    public List<Pesquisa> getPesquisas() {
        return Arrays.asList(restTemplate.getForObject(URL_PESQUISA, Pesquisa[].class));
    }

}
