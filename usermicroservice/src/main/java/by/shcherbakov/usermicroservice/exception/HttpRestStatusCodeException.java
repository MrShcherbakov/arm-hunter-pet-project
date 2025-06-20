package by.shcherbakov.usermicroservice.exception;

public class HttpRestStatusCodeException extends RuntimeException {
    public HttpRestStatusCodeException(String message) {
        super(message);
    }
}
