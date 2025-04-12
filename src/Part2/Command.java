package Part2;

// Command interface (Command Pattern)
public interface Command {
    void execute(); // Execute the command
    void undo();    // Undo the command
}
