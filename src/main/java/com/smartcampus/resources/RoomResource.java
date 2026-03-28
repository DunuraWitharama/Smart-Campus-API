package com.smartcampus.resources;
import java.util.ArrayList;
import java.util.List;

import com.smartcampus.models.Room;
import com.smartcampus.repository.DataStore;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/rooms")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RoomResource {
    
    @GET
    public List<Room> getAll() { return new ArrayList<>(DataStore.rooms.values()); }
    @POST
    public Response create(Room room) {
        if (DataStore.rooms.containsKey(room.getId())) return Response.status(409).build();
        DataStore.rooms.put(room.getId(), room);
        return Response.status(201).entity(room).build();
    }
}
