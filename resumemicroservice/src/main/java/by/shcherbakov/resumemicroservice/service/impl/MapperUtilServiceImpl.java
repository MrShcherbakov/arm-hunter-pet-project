package by.shcherbakov.resumemicroservice.service.impl;

import by.shcherbakov.resumemicroservice.exception.HttpRestStatusCodeException;
import by.shcherbakov.resumemicroservice.service.MapperUtilService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@AllArgsConstructor
public class MapperUtilServiceImpl implements MapperUtilService {

    private final RestTemplate restTemplate;

    @Override
    public <T, R> R requestToMap(String url, T request, Class<R> responseType) {
        ResponseEntity<R> response = restTemplate.postForEntity(
                url,
                request,
                responseType
        );
        log.info("Object of type {} was received from {} successfully: {}",
                responseType,url,response);
        return checkStatusCode(response);
    }

    @Override
    public <R> R checkStatusCode(ResponseEntity<R> entity) {
        if (entity.getStatusCode() == HttpStatusCode.valueOf(200)) {
            log.info("RestTemplate returned {} with status code 200",entity.getBody());
            return entity.getBody();
        } else {
            log.error("RestTemplate returned {} with status code {}",
                    entity.getBody(),entity.getStatusCode());
            throw new HttpRestStatusCodeException("RestTemplate returned entity with another status code: "
            + entity.getStatusCode());
        }
    }
}
