package by.shcherbakov.usermicroservice.service.impl;

import by.shcherbakov.usermicroservice.exception.HttpRestStatusCodeException;
import by.shcherbakov.usermicroservice.service.MapperServiceUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@AllArgsConstructor
public class MapperServiceUtilImpl implements MapperServiceUtil {

    private final RestTemplate restTemplate;

    @Override
    public <T, R> R requestToMap(String url,T request,Class<R> responseType) {
        ResponseEntity<R> entity =
                restTemplate.postForEntity(
                        url,
                        request,
                        responseType
                );
        log.info("Object of type {} was received from {} successfully: {}",
                responseType,url,entity);
        return checkStatusCode(entity);
    }

    //Only for status code 200
    @Override
    public <R> R checkStatusCode(ResponseEntity<R> entity) {
        if (entity.getStatusCode() == HttpStatusCode.valueOf(200)) {
            log.info("RestTemplate received entity {} with status code 200",entity.getBody());
            return entity.getBody();
        } else {
            log.error("RestTemplate received entity {} with another status code {}",entity,entity.getStatusCode());
            throw new HttpRestStatusCodeException("RestTemplate received entity with another status code "
                    + entity.getStatusCode());
        }
    }
}
