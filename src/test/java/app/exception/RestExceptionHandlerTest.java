package app.exception;

import app.exception.response.ExceptionResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RestExceptionHandlerTest
{

    @Test
    void handleEntityNotFoundException()
    {
        RestExceptionHandler restExceptionHandler=new RestExceptionHandler();
        ExceptionResponse exceptionResponse=restExceptionHandler.handleEntityNotFoundException();
        assertEquals("No Record Found",exceptionResponse.message());
    }
}