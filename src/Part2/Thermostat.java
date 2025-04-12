package Part2;

// Receiver class for Thermostat
public class Thermostat {
    private int previousTemp;
    private int currentTemp;

    public void setTemperature(int temperature) {
        previousTemp = currentTemp;
        currentTemp = temperature;
        System.out.println("[Thermostat] Setting temperature to " + currentTemp + "°C");
    }

    public void undo() {
        System.out.println("[Thermostat] Reverting to previous temperature: " + previousTemp + "°C");
        currentTemp = previousTemp;
    }
}

