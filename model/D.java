package model;

import java.time.LocalDate;

public class D extends Entity {

    int serviceId;
    int serviceVariationId;
    boolean allServices;
    int questionTypeId;
    int questionCategoryId;
    int questionSubCategoryId;
    boolean allQuestions;
    boolean primaryQuestion;
    LocalDate dateFrom;
    LocalDate dateTo;

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

    public boolean isAllServices() {
        return allServices;
    }

    public void setAllServices(boolean allServices) {
        this.allServices = allServices;
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

    public boolean isAllQuestions() {
        return allQuestions;
    }

    public void setAllQuestions(boolean allQuestions) {
        this.allQuestions = allQuestions;
    }

    public boolean isPrimaryQuestion() {
        return primaryQuestion;
    }

    public void setPrimaryQuestion(boolean primaryQuestion) {
        this.primaryQuestion = primaryQuestion;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    @Override
    public String toString() {
        return "D{" +
                "serviceId=" + serviceId +
                ", serviceVariationId=" + serviceVariationId +
                ", allServices=" + allServices +
                ", questionTypeId=" + questionTypeId +
                ", questionCategoryId=" + questionCategoryId +
                ", questionSubCategoryId=" + questionSubCategoryId +
                ", allQuestions=" + allQuestions +
                ", primaryQuestion=" + primaryQuestion +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                '}';
    }
}
