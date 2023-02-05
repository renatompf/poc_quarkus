package org.renatofreire.ExceptionHandler;

import org.renatofreire.Exceptions.PersonNotFoundException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class CustomExceptionHandlers implements ExceptionMapper<PersonNotFoundException> {

    @Override
    public Response toResponse(PersonNotFoundException exception) {
        return Response.status(404)
                .entity(exception.getMessage())
                .build();
    }
}
