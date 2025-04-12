package Part2;

public class Thermostat {
    public void setTemperature(int temp) {
        System.out.println("[Thermostat] Setting temperature to " + temp + "°C");
    }

    public void reset() {
        System.out.println("[Thermostat] Reverting to previous temperature");
    }
}
