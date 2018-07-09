package code;

import model.Entity;

import java.util.Arrays;
import java.util.List;

public class Controller {

    Services services = new Services();
    Entity[] entities;


    public boolean analyzeInputFromConsole(List<String> input) {
        if (!services.validInputList(input))
            return false;
        entities = new Entity[Integer.parseInt(input.get(0).toString())];
        for (int i = 1; i < input.size() - 1; i++) {
            if (!services.validInputString(input.get(i)))
                continue;
            Entity entity = services.getEntitity(input.get(i));
            entities[i - 1] = entity;
            if (services.isD(entity)) {
                Entity[] arrayPart = Arrays.copyOfRange(entities, 0, i);
                services.resolveQueryD(arrayPart, entity);
            }
        }
        return true;
    }

    private int getCounter(String string) {
        int result = 0;
        if (services.validInputString(string))
            try {
                result = Integer.parseInt(string);
            } catch (NumberFormatException ex) {
                System.out.println(ex);
            }
        return result;
    }
}




