package tools;

import model.D;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ExtractEntityD {
    D d;

    public D extractD(String[] parts) {
        d = new D();
        if (parts[1].equalsIgnoreCase("*")) {
            d.setAllServices(true);
        } else {
            String[] serviceId = extractIds(parts[1]);
            setServiceId(serviceId);
        }
        if (parts[2].equalsIgnoreCase("*")) {
            d.setAllQuestions(true);
        } else {
            String[] questionId = extractIds(parts[2]);
            setQuestionId(questionId);
        }
        setQuestionPrimatyStatus(parts[3]);
        if (isDoubleDate(parts[4]))
            setDoubleDate(parts[4]);
        else setDateFrom(parts[4]);

        return d;
    }

    private String[] extractIds(String inputSubStr) {
        String[] parts = inputSubStr.split("\\.");
        return parts;
    }

    private String[] extractStringsFromDobleDate(String inputSubStr) {
        String[] parts = inputSubStr.split("-");
        return parts;
    }

    private void setServiceId(String[] serviceIds) {
        if (serviceIds.length > 1)
            d.setServiceVariationId(Integer.parseInt(serviceIds[1]));
        d.setServiceId(Integer.parseInt(serviceIds[0]));
    }

    private void setQuestionId(String[] questionId) {
        if (questionId.length > 2)
            d.setQuestionSubCategoryId(Integer.parseInt(questionId[2]));
        if (questionId.length > 1)
            d.setQuestionCategoryId(Integer.parseInt(questionId[1]));
        d.setQuestionTypeId(Integer.parseInt(questionId[0]));
    }

    private void setQuestionPrimatyStatus(String status) {
        d.setPrimaryQuestion(status.equalsIgnoreCase("P"));
    }

    private void setDateFrom(String dateString) {
        d.setDateFrom(stringToLocalDate(dateString));
    }

    private void setDateTo(String dateString) {
        d.setDateTo(stringToLocalDate(dateString));
    }

    private LocalDate stringToLocalDate(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yyyy", Locale.ENGLISH);
        LocalDate date = LocalDate.parse(dateString, formatter);
        return date;
    }

    private void setDoubleDate(String dateString) {
        String[] parts = extractStringsFromDobleDate(dateString);
        setDateFrom(parts[0]);
        setDateTo(parts[1]);
    }

    private boolean isDoubleDate(String dateString) {
        int index = dateString.indexOf('-');
        if (index > 0) return true;
        return false;
    }
}
