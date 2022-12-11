package app.exception;

import app.exception.response.ExceptionResponse;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler
{
    @ExceptionHandler({EntityNotFoundException.class})
    @ResponseStatus(value=HttpStatus.NOT_FOUND)
    public ExceptionResponse handleEntityNotFoundException()
    {
        return new ExceptionResponse("No Record Found");
    }
}
