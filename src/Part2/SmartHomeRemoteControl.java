package Part2;

// Invoker class that manages commands and undo/redo stacks
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SmartHomeRemoteControl {
    private Map<String, Command> slots = new HashMap<>();
    private Stack<Command> undoStack = new Stack<>();
    private Stack<Command> redoStack = new Stack<>();

    // Assign command to a slot
    public void setCommand(String slotName, Command command) {
        slots.put(slotName, command);
    }

    // Execute command by slot name
    public void pressButton(String slotName) {
        Command command = slots.get(slotName);
        if (command != null) {
            command.execute();
            undoStack.push(command);
            redoStack.clear(); // reset redo history
        } else {
            System.out.println("[Remote] No command in this slot");
        }
    }

    // Undo last command
    public void undoButton() {
        if (!undoStack.isEmpty()) {
            Command command = undoStack.pop();
            command.undo();
            redoStack.push(command);
        } else {
            System.out.println("[Remote] Nothing to undo");
        }
    }

    // Redo last undone command
    public void redoButton() {
        if (!redoStack.isEmpty()) {
            Command command = redoStack.pop();
            command.execute();
            undoStack.push(command);
        } else {
            System.out.println("[Remote] Nothing to redo");
        }
    }

    // Show all available command slots
    public void showSlots() {
        System.out.println("[Remote] Available commands:");
        for (String key : slots.keySet()) {
            System.out.println(" - " + key);
        }
    }
}
