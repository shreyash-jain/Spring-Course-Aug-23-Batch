package com.shreyash.demo.Core.Exception;

import com.shreyash.demo.Features.UrlShortner.Controller.AppController;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorInfo> handleExceptionForOthers(HttpServletRequest req, Exception ex){
        System.out.println("hello-RuntimeException");
        return ResponseEntity.status(503).body(new ErrorInfo(req.getRequestURL().toString(), ex.getLocalizedMessage(), String.valueOf(HttpStatus.BAD_REQUEST.value())));
    }

    @Override
     public ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return ResponseEntity.ok().body("");
     }



        class ErrorInfo {
        public final String url;
        public final String ex;
        public final String responseCode;

        public ErrorInfo(String url, String ex, String responseCode) {
            this.url = url;
            this.ex = ex;
            this.responseCode = responseCode;
        }
    }
}
