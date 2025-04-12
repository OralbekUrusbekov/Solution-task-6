import Part1.*;
import Part2.*;

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


        System.out.println("---------------------------------------");
        System.out.println("---------------------------------------");
        System.out.println("---------------------------------------");
        System.out.println("---------------------------------------");


        Light light = new Light();
        Thermostat thermostat = new Thermostat();


        Command lightOn = new TurnOnLightCommand(light);
        Command thermoSet = new SetThermostatCommand(thermostat, 22);

        SmartHomeRemoteControl remote = new SmartHomeRemoteControl();
        remote.setCommand("A", lightOn);
        remote.setCommand("B", thermoSet);


        remote.pressButton("A");
        remote.pressButton("B");


        remote.undoButton();
    }
}
