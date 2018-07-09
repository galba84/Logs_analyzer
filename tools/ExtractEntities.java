package tools;

import model.Entity;

public class ExtractEntities {
    private  ExtractEntityC extractEntityC = new ExtractEntityC();
    private  ExtractEntityD extractEntityD = new ExtractEntityD();

    public Entity extract(String inputString) {
        String[] parts = splictStringByDelim(inputString);
        String entityMarker = parts[0];
        Entity result = null;
        if (entityMarker.equalsIgnoreCase("C")) {
            result = extractEntityC.extractC(parts);
        }
        if (entityMarker.equalsIgnoreCase("D")) {
            result = extractEntityD.extractD(parts);
        }
        return result;
    }

    private String[] splictStringByDelim(String inputString) {
        String[] parts = inputString.split(" ");
        return parts;
    }
}
