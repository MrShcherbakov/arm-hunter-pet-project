package by.shcherbakov.usermicroservice.service;

import org.springframework.http.ResponseEntity;

public interface MapperServiceUtil {
    <T,R> R requestToMap(String url,T request,Class<R> responseType);
    <R> R checkStatusCode(ResponseEntity<R> entity);
}
