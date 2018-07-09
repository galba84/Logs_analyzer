package tools;

import model.C;
import model.D;


public class CMatchPatternD {
    C c;
    D d;

    public boolean isComply(C c, D d) {
        this.c = c;
        this.d = d;
        return (isServiceComply() & isQuestionComply() & isPrimaryComply()&idDateRangeComply());
    }

    private boolean isServiceComply() {
        if (d.isAllServices())
            return true;
        return isServiceComplyByIds();
    }

    private boolean isServiceComplyByIds() {
        int checkDepth = serviceIdCheckDepth();
        if (checkDepth == 1)
            return isServiceIdEqual();
        return (isServiceIdEqual() & isServiceVariationIdEqual());

    }

    private int serviceIdCheckDepth() {
        int result = 0;
        if (d.getServiceId() > 0)
            result++;
        if (d.getServiceVariationId() > 0)
            result++;
        return result;
    }

    private boolean isServiceIdEqual() {
        return (c.getServiceId() == d.getServiceId());
    }

    private boolean isServiceVariationIdEqual() {
        return (c.getServiceVariationId() == d.getServiceVariationId());
    }

    private boolean isQuestionComply() {
        if (d.isAllQuestions())
            return true;
        return isQuestionComplyByIds();
    }

    private boolean isQuestionComplyByIds() {
        int idDepth = questionIdCheckDepth();
        if (idDepth == 1)
            return questionTypeEqual();
        else if (idDepth == 2)
            return (questionTypeEqual() & questionCategoryEqual());
        return (questionTypeEqual() & questionCategoryEqual() & questionSubCategoryEqual());
    }

    private int questionIdCheckDepth() {
        int result = 0;
        if (d.getQuestionTypeId() > 0) result++;
        if (d.getQuestionCategoryId() > 0) result++;
        if (d.getQuestionSubCategoryId() > 0) result++;
        return result;
    }

    private boolean questionTypeEqual() {
        return (d.getQuestionTypeId() == c.getQuestionTypeId());
    }

    private boolean questionCategoryEqual() {
        return (d.getQuestionCategoryId() == c.getQuestionCategoryId());
    }

    private boolean questionSubCategoryEqual() {
        return (d.getQuestionSubCategoryId() == c.getQuestionSubCategoryId());
    }

    private boolean isPrimaryComply() {
        return (c.isPrimaryQuestion() & d.isPrimaryQuestion());
    }

    private boolean idDateRangeComply() {
        boolean after = (c.getDate().isAfter(d.getDateFrom()));
        if (d.getDateTo() == null)
            return after;
        boolean before = (c.getDate().isBefore(d.getDateTo()));
        return (after & before);
    }
}
