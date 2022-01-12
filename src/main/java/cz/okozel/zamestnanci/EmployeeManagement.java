package cz.okozel.zamestnanci;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;
import java.util.stream.Collectors;

public class EmployeeManagement {

    public static void main(String[] args) {
        new EmployeeManagement().start();
    }

    private final Scanner sc;
    private final List<Employee> employees;

    private EmployeeManagement() {
        sc = new Scanner(System.in);
        employees = new ArrayList<>();
    }

    private void start() {
        System.out.println("Vítejte v managementu zaměstnanců!");
        runMenuView();
        System.out.println("Děkuji za využívání programu.");
    }

    private void runMenuView() {
        boolean continuee = true;
        while (continuee) {
            switch (showMenu()) {
                case CREATE_USER -> createUser();
                case PRINT_ALL_USERS -> printUsers();
                case STATISTICS -> statistics();
                case EXPORT_EMPLOYEES -> exportEmployees();
                case IMPORT_EMPLOYEES -> importEmployees();
                case QUIT -> continuee = false;
            }
        }
    }

    private void createUser() {
        System.out.println("\n\tNOVÝ UŽIVATEL");
        System.out.print("Jméno: ");
        String name = sc.nextLine().trim();
        System.out.print("Plat: ");
        int salary = getIntInput();
        if (name.isBlank() || salary < 0) System.out.println("Nepodařilo se vytvořit uživatele.");
        else {
            employees.add(new Employee(name, salary));
            System.out.println("Uživatel byl úspěšně přidán.");
        }
    }

    private void printUsers() {
        System.out.println("\n\tVŠICHNI ZAMĚSTNANCI");
        int index = 1;
        for (Employee employee : employees) {
            System.out.printf("%d. %s, plat %d, zaměstnán od %s\n", index, employee.getName(), employee.getSalary(), employee.getEmployedSince().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)));
            index++;
        }
    }

    private void statistics() {
        System.out.println("\n\tSTATISTIKY\n");
        System.out.println(buildStatistics());
    }

    private void exportEmployees() {
        System.out.println("\n\tEXPORT ZAMĚSTNANCŮ");
        if (employees.isEmpty()) {
            System.out.println("Žádní uživatelé.");
            return;
        }
        System.out.println("Název souboru bez přípony: ");
        String fileName = sc.nextLine().trim();
        if (fileName.matches("^[a-zA-Z0-9_]{1,20}$")) writeToFile(fileName + ".csv", employeesToCsv());
        else System.out.println("Nevhodný název souboru.");
    }

    private String employeesToCsv() {
        return employees.stream()
                .map(employee -> String.format("%s,%d,%s", employee.getName(), employee.getSalary(), employee.getEmployedSince()))
                .collect(Collectors.joining(";"));
    }

    private void importEmployees() {
        System.out.println("\n\tIMPORT ZAMĚSTNANCŮ");
        System.out.println("Název souboru bez přípony: ");
        String fileName = sc.nextLine().trim();
        readFromFile(fileName + ".csv");
    }

    private void readFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            employees.clear();
            String[] values = reader.readLine().split(";");
            for (String value : values) {
                String[] subValues = value.split(",");
                employees.add(new Employee(subValues[0], Integer.parseInt(subValues[1]), LocalDateTime.parse(subValues[2])));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nevhodný název souboru.");
        } catch (IOException e) {
            System.out.println("Nepodařilo se číst ze souboru.");
        }
    }

    private void writeToFile(String fileName, String st) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            bufferedWriter.write(st);
            System.out.println("Zapsáno do souboru " + fileName);
        } catch (IOException e) {
            System.out.println("Nepodařilo se zapsat do souboru.");
        }
    }

    private String buildStatistics() {
        return "Průměrná mzda: " + averageSalary() + "\n" +
               "Náklady na mzdy: " + salaryCosts() + "\n";
    }

    private double averageSalary() {
        return employees.stream().mapToInt(Employee::getSalary).average().orElseThrow();
    }

    private int salaryCosts() {
        return employees.stream().mapToInt(Employee::getSalary).sum();
    }

    private MenuItem showMenu() {
        System.out.println("\n\tMENU");
        MenuItem[] values = MenuItem.values();
        for (int i = 0, valuesLength = values.length; i < valuesLength; i++) {
            MenuItem menuItem = values[i];
            System.out.println((i + 1) + ". " + menuItem.title);
        }
        System.out.print("Vyberte akci: ");
        int input = getIntInput();
        if (input < 1 || input > values.length) return MenuItem.QUIT;
        return values[input - 1];
    }

    private int getIntInput() {
        int input = 0;
        boolean continuee = true;
        while (continuee) {
            try {
                input = Integer.parseInt(sc.nextLine());
                continuee = false;
            } catch (NumberFormatException e) {
                System.out.println("Byl zadán neplatný vstup.");
            }
        }
        return input;
    }

    private enum MenuItem {
        CREATE_USER("Přidat nového zaměstnance..."),
        PRINT_ALL_USERS("Vypsat všechny zaměstnance..."),
        STATISTICS("Statistiky..."),
        EXPORT_EMPLOYEES("Exportovat zaměstnance..."),
        IMPORT_EMPLOYEES("Importovat zaměstnance..."),
        QUIT("Ukončit");

        final String title;

        MenuItem(String title) {
            this.title = title;
        }
    }
}
