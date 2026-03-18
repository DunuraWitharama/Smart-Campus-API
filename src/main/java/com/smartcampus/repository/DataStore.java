package com.smartcampus.repository;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.smartcampus.models.Room;
import com.smartcampus.models.Sensor;

public class DataStore {
    // ConcurrentHashMap provides thread-safety for multi-threaded JAX-RS environment
    public static Map<String, Room> rooms = new ConcurrentHashMap<>();
    public static Map<String, Sensor> sensors = new ConcurrentHashMap<>();
}