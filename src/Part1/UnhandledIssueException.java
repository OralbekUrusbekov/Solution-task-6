package Part1;

// Custom exception for unresolved issues
public class UnhandledIssueException extends Exception {
    public UnhandledIssueException(String issue) {
        super("No handler could process the issue: " + issue);
    }
}

