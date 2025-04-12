package Part2;

import java.util.HashMap;
import java.util.Map;

public class SmartHomeRemoteControl {
    private Map<String, Command> slots = new HashMap<>();
    private Command lastCommand;

    public void setCommand(String slot, Command command) {
        slots.put(slot, command);
    }

    public void pressButton(String slot) {
        if (slots.containsKey(slot)) {
            Command cmd = slots.get(slot);
            cmd.execute();
            lastCommand = cmd;
        }
    }

    public void undoButton() {
        if (lastCommand != null) {
            lastCommand.undo();
        }
    }
}
