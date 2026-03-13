package com.smartcampus.models;

public class Sensor {
    private String id;
    private String type;
    private String status;
    private String roomId;
    private double lastValue;

    public Sensor() {}
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getType() { return type; }
    public void setType(String t) { this.type = t; }
    public String getStatus() { return status; }
    public void setStatus(String s) { this.status = s; }
    public String getRoomId() { return roomId; }
    public void setRoomId(String r) { this.roomId = r; }
    public double getLastValue() { return lastValue; }
    public void setLastValue(double v) { this.lastValue = v; }
}