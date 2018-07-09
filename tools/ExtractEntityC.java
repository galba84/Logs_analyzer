package tools;

import model.C;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ExtractEntityC {
    private C c;

    public C extractC(String[] parts) {
        c = new C();
        String[] serviceId = extractIds(parts[1]);
        String[] questionId = extractIds(parts[2]);
        setServiceId(serviceId);
        setQuestionId(questionId);
        setQuestionPrimatyStatus(parts[3]);
        setDate(parts[4]);
        setDuration(parts[5]);
        return c;
    }

    private String[] extractIds(String inputSubStr) {
        String[] parts = inputSubStr.split("\\.");
        return parts;
    }

    private void setServiceId(String[] serviceIds) {
        if (serviceIds.length > 1)
            c.setServiceVariationId(Integer.parseInt(serviceIds[1]));
        c.setServiceId(Integer.parseInt(serviceIds[0]));
    }

    private void setQuestionId(String[] questionId) {
        if (questionId.length > 2)
            c.setQuestionSubCategoryId(Integer.parseInt(questionId[2]));
        if (questionId.length > 1)
            c.setQuestionCategoryId(Integer.parseInt(questionId[1]));
        c.setQuestionTypeId(Integer.parseInt(questionId[0]));
    }

    private void setQuestionPrimatyStatus(String status) {
        c.setPrimaryQuestion(status.equalsIgnoreCase("P"));
    }

    private void setDate(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale.ENGLISH);
        LocalDate date = LocalDate.parse(dateString, formatter);
        c.setDate(date);
    }

    private void setDuration(String duration) {
        c.setDurationInMinutes(Integer.parseInt(duration));
    }

}
