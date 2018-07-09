package code;

import model.C;
import model.D;
import model.Entity;
import tools.CMatchPatternD;
import tools.ExtractEntities;
import tools.InputListValidator;
import tools.InputStringValidator;

import java.util.List;

public class Services {

    ExtractEntities extractEntities = new ExtractEntities();
    CMatchPatternD cMatchPatternD = new CMatchPatternD();
    InputStringValidator inputStringValidator = new InputStringValidator();
    InputListValidator inputListValidator = new InputListValidator();

    public boolean validInputString(String string) {
        return inputStringValidator.valid(string);
    }

    public boolean validInputList(List<String> input) {
        return inputListValidator.valid(input);
    }

    public Entity getEntitity(String input) {
        Entity entity = extractEntities.extract(input);
        return entity;
    }

    public void printEntity(Entity entity) {
        print(entity);
    }

    public boolean match(Entity c, Entity d) {
        C cc = (C) c;
        D dd = (D) d;
        return cMatchPatternD.isComply(cc, dd);
    }

    public void resolveQueryD(Entity[] examinedEntities, Entity dPattern) {
        int totalWaitingTime;
        int reportsCounter;
        reportsCounter = 0;
        totalWaitingTime = 0;
        for (Entity entity : examinedEntities
                ) {
            if (isC(entity)) {
                if (match(entity, dPattern)) {
                    C c = (C) entity;
                    reportsCounter++;
                    totalWaitingTime += c.getDurationInMinutes();
                }
            }
        }
        printResultDQuery(totalWaitingTime, reportsCounter);
    }

    public void printResultDQuery(int totalWaitingTime, int reportsCounter) {
        if (reportsCounter > 0)
            System.out.println(totalWaitingTime / reportsCounter);
        else System.out.println("-");
    }

    public boolean isC(Entity entity) {
        return entity.getClass().getSimpleName().toString().equalsIgnoreCase("C");
    }

    public boolean isD(Entity entity) {
        return entity.getClass().getSimpleName().toString().equalsIgnoreCase("D");
    }

    private void print(Entity entity) {
        System.out.println(entity.toString());
    }
}
