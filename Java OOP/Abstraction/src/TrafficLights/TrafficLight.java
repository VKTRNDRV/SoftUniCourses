package TrafficLights;

public enum TrafficLight {
    RED("GREEN"),
    YELLOW("RED"),
    GREEN("YELLOW");

    private String nextLight;
    TrafficLight(String nextLight) {
        this.nextLight = nextLight;
    }

    public String getNextLight() {
        return nextLight;
    }
}
