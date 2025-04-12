import Part1.*;

public class Main {
    public static void main(String[] args) {
        // Create handlers
        SupportHandler faq = new FAQBotHandler();
        SupportHandler junior = new JuniorSupportHandler();
        SupportHandler senior = new SeniorSupportHandler();

        // Dynamically build the chain
        faq.setNext(junior).setNext(senior);

        // Example issues
        String[] issues = {
                "password_reset", "refund_request", "account_ban",
                "unknown_bug", "cannot_login", "data_loss", "billing_issue"
        };

        for (String issue : issues) {
            try {
                System.out.println("\nProcessing issue: " + issue);
                faq.handle(issue);
            } catch (UnhandledIssueException e) {
                System.out.println("[Error] " + e.getMessage());
            }
        }
    }
}
