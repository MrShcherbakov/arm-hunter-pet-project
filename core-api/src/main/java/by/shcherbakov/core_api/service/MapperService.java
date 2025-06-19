package by.shcherbakov.core_api.service;

import org.springframework.stereotype.Service;

@Service
public interface MapperService {
    Object toObject(Object o);
    Object toDto(Object o);
}
