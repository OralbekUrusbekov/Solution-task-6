package Part1;

import java.util.Arrays;
import java.util.List;

// Concrete handler for complex issues
public class SeniorSupportHandler extends SupportHandler {
    private List<String> supportedIssues = Arrays.asList("account_ban", "data_loss");

    @Override
    public void handle(String issue) throws UnhandledIssueException {
        Logger.log("SeniorSupport trying to handle: " + issue);

        if (supportedIssues.contains(issue)) {
            System.out.println("[SeniorSupport] Handled " + issue);
        } else {
            Logger.log("SeniorSupport cannot handle issue");
            throw new UnhandledIssueException(issue);
        }
    }
}


