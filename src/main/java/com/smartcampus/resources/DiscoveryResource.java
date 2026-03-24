package com.smartcampus.resources;
import java.util.HashMap;
import java.util.Map;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/")
public class DiscoveryResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDiscovery() {
        Map<String, Object> info = new HashMap<>();
        info.put("api", "Smart Campus IoT");
        info.put("version", "v1");
        Map<String, String> links = new HashMap<>();
        links.put("rooms", "/api/v1/rooms");
        links.put("sensors", "/api/v1/sensors");
        info.put("_links", links);
        return Response.ok(info).build();
    }
}