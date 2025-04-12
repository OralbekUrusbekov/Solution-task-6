package Part2;

public class SetThermostatCommand implements Command {
    private Thermostat thermostat;
    private int temperature;

    public SetThermostatCommand(Thermostat thermostat, int temperature) {
        this.thermostat = thermostat;
        this.temperature = temperature;
    }

    public void execute() {
        thermostat.setTemperature(temperature);
    }

    public void undo() {
        thermostat.reset();
    }
}

