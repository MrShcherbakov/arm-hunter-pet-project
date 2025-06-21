package by.shcherbakov.apimicroservice.exception;

public class HttpRestStatusCodeException extends RuntimeException {
    public HttpRestStatusCodeException(String message) {
        super(message);
    }
}
