package code;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    public List<String> getInput() {
        printMainMenuOptions();
        List<String> input = readInput();
        return input;
    }

    private void printMainMenuOptions() {
        System.out.println("Please : input string");
    }

    private List<String> readInput() {
        Scanner scanner = new Scanner(System.in);
        List<String> result = new LinkedList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            result.add(line);
            if (line.isEmpty())
                break;

        }
        return result;
    }

    public void promptEnterKey() {
        System.out.println("Press \"ENTER\" to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    public void showError() {
        System.out.println("Input is not Valid... Try again...");
    }

}
