package Part1;

import java.util.Arrays;
import java.util.List;

// Concrete handler for simple FAQ issues
public class FAQBotHandler extends SupportHandler {
    private List<String> supportedIssues = Arrays.asList(
            "password_reset", "cannot_login", "update_email",
            "how_to_use", "change_language", "unsubscribe_newsletter", "app_update_help"
    );

    @Override
    public void handle(String issue) throws UnhandledIssueException {
        Logger.log("FAQBot trying to handle: " + issue);

        if (supportedIssues.contains(issue)) {
            System.out.println("[FAQBot] Handled " + issue);
        } else if (nextHandler != null) {
            Logger.log("FAQBot passed issue to next handler");
            nextHandler.handle(issue);
        } else {
            throw new UnhandledIssueException(issue);
        }
    }
}

