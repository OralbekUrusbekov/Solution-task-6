import Part1.FAQBotHandler;
import Part1.JuniorSupportHandler;
import Part1.SeniorSupportHandler;
import Part1.SupportHandler;

public class Main {
    public static void main(String[] args) {
        SupportHandler faq = new FAQBotHandler();
        SupportHandler junior = new JuniorSupportHandler();
        SupportHandler senior = new SeniorSupportHandler();

        faq.setNext(junior).setNext(senior);

        String[] issues = { "password_reset", "refund_request", "account_ban", "unknown_bug" };

        for (String issue : issues) {
            faq.handle(issue);
        }
    }
}
