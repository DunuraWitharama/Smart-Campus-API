package com.smartcampus.resources;
import com.smartcampus.models.Sensor;
import com.smartcampus.repository.DataStore;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/sensors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SensorResource {
    @POST
    public Response add(Sensor s) {
        if(!DataStore.rooms.containsKey(s.getRoomId())) return Response.status(400).build();
        DataStore.sensors.put(s.getId(), s);
        return Response.status(201).entity(s).build();
    }
}