package by.shcherbakov.resumemicroservice.service;

import org.springframework.http.ResponseEntity;

public interface MapperUtilService {
    <T,R> R requestToMap(String url,T request,Class<R> responseType);
    <R> R checkStatusCode(ResponseEntity<R> entity);
}
