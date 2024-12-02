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

            System.out.println("\nMenue:");
            System.out.println("1. Ordner erstellen");
            System.out.println("2. Ordner anzeigen");
            System.out.println("3. Ordner betreten");
            System.out.println("4. Benutzer wechseln");
            System.out.println("5. Programm beenden");
            System.out.print("Wähle eine Option: ");

            try {
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
                            for (int i = 0; i < currentUser.getAllOrdner().size(); i++) {
                                System.out.println((i + 1) + ". " + currentUser.getAllOrdner().get(i));
                            }
                            System.out.print("Wähle einen Ordner zum Verwalten (0 zum Abbrechen): ");
                            int ordnerNummer = scanner.nextInt();
                            scanner.nextLine();

                            if (ordnerNummer == 0) break;
                            if (ordnerNummer < 1 || ordnerNummer > currentUser.getAllOrdner().size()) {
                                System.out.println("Ungültige Auswahl.");
                            } else {
                                Ordner ausgewahlterOrdner = currentUser.getAllOrdner().get(ordnerNummer - 1);
                                System.out.println("1. Ordner löschen");
                                System.out.println("2. Ordner umbenennen");
                                System.out.print("Wähle eine Option (0 zum Abbrechen): ");
                                int verwaltenOption = scanner.nextInt();
                                scanner.nextLine();

                                if (verwaltenOption == 1) {
                                    currentUser.getAllOrdner().remove(ordnerNummer - 1);
                                    System.out.println("Ordner gelöscht.");
                                } else if (verwaltenOption == 2) {
                                    System.out.print("Gib den neuen Namen für den Ordner ein: ");
                                    String neuerName = scanner.nextLine();
                                    ausgewahlterOrdner.setName(neuerName);
                                    System.out.println("Ordner wurde umbenannt.");
                                }
                            }
                        }
                        break;

                    case 3:
                        if (currentUser.getAllOrdner().isEmpty()) {
                            System.out.println("Es gibt keine Ordner. Bitte erstelle zuerst einen Ordner.");
                        } else {
                            System.out.println("Wähle einen Ordner aus:");
                            for (int i = 0; i < currentUser.getAllOrdner().size(); i++) {
                                System.out.println((i + 1) + ". " + currentUser.getAllOrdner().get(i));
                            }
                            System.out.print("Nummer des Ordners: ");
                            int ordnerNummer = scanner.nextInt();
                            scanner.nextLine();

                            if (ordnerNummer < 1 || ordnerNummer > currentUser.getAllOrdner().size()) {
                                System.out.println("Ungültige Auswahl.");
                            } else {
                                Ordner ausgewahlterOrdner = currentUser.getAllOrdner().get(ordnerNummer - 1);
                                handleOrdner(scanner, ausgewahlterOrdner);
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
            } catch (Exception e) {
                System.out.println("Fehler: Bitte geben Sie eine gültige Zahl ein.");
                scanner.nextLine();
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

            try {
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
                            for (int i = 0; i < ordner.getNotizen().size(); i++) {
                                System.out.println((i + 1) + ". " + ordner.getNotizen().get(i));
                            }
                            System.out.print("Wähle eine Notiz zum Verwalten (0 zum Abbrechen): ");
                            int notizNummer = scanner.nextInt();
                            scanner.nextLine();

                            if (notizNummer == 0) break;
                            if (notizNummer < 1 || notizNummer > ordner.getNotizen().size()) {
                                System.out.println("Ungültige Auswahl.");
                            } else {
                                Notiz ausgewaehlteNotiz = ordner.getNotizen().get(notizNummer - 1);
                                System.out.println("1. Notiz löschen");
                                System.out.println("2. Notiz bearbeiten");
                                System.out.print("Wähle eine Option (0 zum Abbrechen): ");
                                int notizOption = scanner.nextInt();
                                scanner.nextLine();

                                if (notizOption == 1) {
                                    ordner.getNotizen().remove(notizNummer - 1);
                                    System.out.println("Notiz gelöscht.");
                                } else if (notizOption == 2) {
                                    System.out.print("Gib den neuen Titel der Notiz ein: ");
                                    String neuerTitel = scanner.nextLine();
                                    System.out.print("Gib den neuen Text der Notiz ein: ");
                                    String neuerText = scanner.nextLine();
                                    ausgewaehlteNotiz.setTitel(neuerTitel);
                                    ausgewaehlteNotiz.setText(neuerText);
                                    System.out.println("Notiz wurde bearbeitet.");
                                }
                            }
                        }
                        break;

                    case 3:
                        return;

                    default:
                        System.out.println("Ungültige Option. Bitte wähle erneut.");
                }
            } catch (Exception e) {
                System.out.println("Fehler: Bitte geben Sie eine gültige Zahl ein.");
                scanner.nextLine();
            }
        }
    }
}
