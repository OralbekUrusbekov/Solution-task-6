package Part1;

import java.util.Arrays;
import java.util.List;

// Concrete handler for medium-level issues
public class JuniorSupportHandler extends SupportHandler {
    private List<String> supportedIssues = Arrays.asList("refund_request", "billing_issue");

    @Override
    public void handle(String issue) throws UnhandledIssueException {
        Logger.log("JuniorSupport trying to handle: " + issue);

        if (supportedIssues.contains(issue)) {
            System.out.println("[JuniorSupport] Handled " + issue);
        } else if (nextHandler != null) {
            Logger.log("JuniorSupport passed issue to next handler");
            nextHandler.handle(issue);
        } else {
            throw new UnhandledIssueException(issue);
        }
    }
}
