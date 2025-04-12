package Part1;

// Abstract handler in Chain of Responsibility pattern
public abstract class SupportHandler {
    protected SupportHandler nextHandler;

    // Sets the next handler in the chain
    public SupportHandler setNext(SupportHandler handler) {
        this.nextHandler = handler;
        return handler;
    }

    // Handles the issue or passes it forward
    public abstract void handle(String issue) throws UnhandledIssueException;
}
