package com.smartcampus.exceptions;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class GlobalMapper implements ExceptionMapper<Throwable> {
    public Response toResponse(Throwable t) {
        // Prevents stack trace disclosure
        return Response.status(500).entity("{\"msg\":\"Internal Server Error\"}").build();
    }
}