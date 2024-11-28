package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User currentUser = null;

        while (true) {
            if (currentUser == null) {
                System.out.print("Bitte gib deinen Benutzernamen ein, um dich anzumelden: ");
                String username = scanner.nextLine();
                currentUser = new User(username);
                System.out.println("Willkommen, " + username + "!");
            }

            System.out.println("\nMenü:");
            System.out.println("1. Ordner erstellen");
            System.out.println("2. Ordner anzeigen");
            System.out.println("3. Ordner betreten");
            System.out.println("4. Benutzer wechseln");
            System.out.println("5. Programm beenden");
            System.out.print("Wähle eine Option: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Gib den Namen des Ordners ein: ");
                    String ordnerName = scanner.nextLine();
                    currentUser.addOrdner(new Ordner(ordnerName));
                    System.out.println("Ordner '" + ordnerName + "' wurde erstellt.");
                    break;
                case 2:
                    if (currentUser.getAllOrdner().isEmpty()) {
                        System.out.println("Es gibt keine Ordner.");
                    } else {
                        System.out.println("Ordner:");
                        for (Ordner ordner : currentUser.getAllOrdner()) {
                            System.out.println("- " + ordner.getName());
                        }
                    }
                    break;
                case 3:
                    if (currentUser.getAllOrdner().isEmpty()) {
                        System.out.println("Es gibt keine Ordner. Bitte erstelle zuerst einen Ordner.");
                    } else {
                        System.out.println("Wähle einen Ordner aus:");
                        for (int i = 0; i < currentUser.getAllOrdner().size(); i++) {
                            System.out.println((i + 1) + ". " + currentUser.getAllOrdner().get(i).getName());
                        }
                        System.out.print("Nummer des Ordners: ");
                        int ordnerNummer = scanner.nextInt();
                        scanner.nextLine();

                        if (ordnerNummer < 1 || ordnerNummer > currentUser.getAllOrdner().size()) {
                            System.out.println("Ungültige Auswahl.");
                        } else {
                            Ordner ausgewählterOrdner = currentUser.getAllOrdner().get(ordnerNummer - 1);
                            handleOrdner(scanner, ausgewählterOrdner);
                        }
                    }
                    break;
                case 4:
                    currentUser = null;
                    System.out.println("Benutzer wurde abgemeldet.");
                    break;
                case 5:
                    System.out.println("Programm beendet. Tschüss!");
                    return;
                default:
                    System.out.println("Ungültige Option. Bitte wähle erneut.");
            }
        }
    }

    private static void handleOrdner(Scanner scanner, Ordner ordner) {
        while (true) {
            System.out.println("\nOrdner: " + ordner.getName());
            System.out.println("1. Notiz erstellen");
            System.out.println("2. Notizen anzeigen");
            System.out.println("3. Zurück zum Hauptmenü");
            System.out.print("Wähle eine Option: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Gib den Titel der Notiz ein: ");
                    String notizTitel = scanner.nextLine();
                    System.out.print("Gib den Text der Notiz ein: ");
                    String notizText = scanner.nextLine();
                    ordner.addNotiz(new Notiz(notizTitel, notizText));
                    System.out.println("Notiz wurde hinzugefügt.");
                    break;
                case 2:
                    if (ordner.getNotizen().isEmpty()) {
                        System.out.println("Es gibt keine Notizen in diesem Ordner.");
                    } else {
                        System.out.println("Notizen in '" + ordner.getName() + "':");
                        for (Notiz notiz : ordner.getNotizen()) {
                            System.out.println("- " + notiz.getTitel() + ": " + notiz.getText());
                        }
                    }
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Ungültige Option. Bitte wähle erneut.");
            }
        }
    }
}
