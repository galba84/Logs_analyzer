package model;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

public class C extends Entity {

    int serviceId;
    int serviceVariationId;
    int questionTypeId;
    int questionCategoryId;
    int questionSubCategoryId;
    boolean primaryQuestion;
    LocalDate date;
    int durationInMinutes;

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public int getServiceVariationId() {
        return serviceVariationId;
    }

    public void setServiceVariationId(int serviceVariationId) {
        this.serviceVariationId = serviceVariationId;
    }

    public int getQuestionTypeId() {
        return questionTypeId;
    }

    public void setQuestionTypeId(int questionTypeId) {
        this.questionTypeId = questionTypeId;
    }

    public int getQuestionCategoryId() {
        return questionCategoryId;
    }

    public void setQuestionCategoryId(int questionCategoryId) {
        this.questionCategoryId = questionCategoryId;
    }

    public int getQuestionSubCategoryId() {
        return questionSubCategoryId;
    }

    public void setQuestionSubCategoryId(int questionSubCategoryId) {
        this.questionSubCategoryId = questionSubCategoryId;
    }

    public boolean isPrimaryQuestion() {
        return primaryQuestion;
    }

    public void setPrimaryQuestion(boolean primaryQuestion) {
        this.primaryQuestion = primaryQuestion;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    @Override
    public String toString() {
        return "C{" +
                "serviceId=" + serviceId +
                ", serviceVariationId=" + serviceVariationId +
                ", questionTypeId=" + questionTypeId +
                ", questionCategoryId=" + questionCategoryId +
                ", questionSubCategoryId=" + questionSubCategoryId +
                ", primaryQuestion=" + primaryQuestion +
                ", date=" + date +
                ", durationInMinutes=" + durationInMinutes +
                '}';
    }
}
