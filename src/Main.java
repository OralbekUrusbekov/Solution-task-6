import Part1.*;
import Part2.*;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("-------------------Part 1--------------------");
        System.out.println("---------------------------------------------");
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


        System.out.println("-------------------Part 2--------------------");
        System.out.println("---------------------------------------------");



        // Create device instances (Receivers)
        Light light = new Light();
        Thermostat thermostat = new Thermostat();
        DoorLock doorLock = new DoorLock();

        // Create concrete commands
        Command lightOn = new TurnOnLightCommand(light);
        Command setTemp22 = new SetThermostatCommand(thermostat, 22);
        Command lockDoor = new LockDoorCommand(doorLock);

        // Create macro command for "Goodnight mode"
        Command goodnightMode = new MacroCommand(Arrays.asList(
                lightOn, setTemp22, lockDoor
        ));

        // Create remote and assign commands
        SmartHomeRemoteControl remote = new SmartHomeRemoteControl();
        remote.setCommand("light_on", lightOn);
        remote.setCommand("set_temp", setTemp22);
        remote.setCommand("lock_door", lockDoor);
        remote.setCommand("goodnight", goodnightMode);

        // CLI loop for user input
        while (true) {
            System.out.println("\n=== Smart Home Remote ===");
            remote.showSlots();
            System.out.println("Type command name, or 'undo', 'redo', 'exit':");
            System.out.print("> ");

            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("exit")) break;
            else if (input.equals("undo")) remote.undoButton();
            else if (input.equals("redo")) remote.redoButton();
            else remote.pressButton(input);
        }

        scanner.close();
    }
}
