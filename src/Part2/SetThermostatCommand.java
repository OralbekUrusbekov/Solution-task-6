package Part2;

// Concrete Command to set thermostat temperature
public class SetThermostatCommand implements Command {
    private Thermostat thermostat;
    private int temp;

    public SetThermostatCommand(Thermostat thermostat, int temp) {
        this.thermostat = thermostat;
        this.temp = temp;
    }

    public void execute() {
        thermostat.setTemperature(temp);
    }

    public void undo() {
        thermostat.undo();
    }
}


