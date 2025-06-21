package by.shcherbakov.resumemicroservice.exception;

public class HttpRestStatusCodeException extends RuntimeException {
    public HttpRestStatusCodeException(String message) {
        super(message);
    }
}
