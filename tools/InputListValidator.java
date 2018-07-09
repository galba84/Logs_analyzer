package tools;

import java.util.List;

public class InputListValidator {
    public boolean valid(List<String> input) {
        if (input.size() == 0)
            return false;
        if (!getCounter(input.get(0)))
            return false;
        return true;
    }

    private boolean getCounter(String counterString) {
        try {
            int result = Integer.parseInt(counterString);
            return true;
        } catch (NumberFormatException ex) {
            System.out.println(ex);
        }
        return false;

    }
}
