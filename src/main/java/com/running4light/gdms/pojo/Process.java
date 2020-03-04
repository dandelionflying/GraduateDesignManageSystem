package com.running4light.gdms.pojo;

import java.io.Serializable;

public class Process implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column process.ID
     *
     * @mbggenerated
     */
    private Short id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column process.S_ID
     *
     * @mbggenerated
     */
    private String sId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column process.TASK_BOOK
     *
     * @mbggenerated
     */
    private Short taskBook;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column process.OPENNING_REPORT
     *
     * @mbggenerated
     */
    private Short openningReport;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column process.MID_TERM_CHECK
     *
     * @mbggenerated
     */
    private Short midTermCheck;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column process.PAPER
     *
     * @mbggenerated
     */
    private Short paper;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column process.EVALUATION1
     *
     * @mbggenerated
     */
    private Short evaluation1;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column process.EVALUATION2
     *
     * @mbggenerated
     */
    private Short evaluation2;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column process.CHECK_REPETITION
     *
     * @mbggenerated
     */
    private Short checkRepetition;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column process.ANSWER_APPLICATION
     *
     * @mbggenerated
     */
    private Short answerApplication;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column process.ANSWER_RECORD
     *
     * @mbggenerated
     */
    private Short answerRecord;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table process
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column process.ID
     *
     * @return the value of process.ID
     *
     * @mbggenerated
     */
    public Short getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column process.ID
     *
     * @param id the value for process.ID
     *
     * @mbggenerated
     */
    public void setId(Short id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column process.S_ID
     *
     * @return the value of process.S_ID
     *
     * @mbggenerated
     */
    public String getsId() {
        return sId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column process.S_ID
     *
     * @param sId the value for process.S_ID
     *
     * @mbggenerated
     */
    public void setsId(String sId) {
        this.sId = sId == null ? null : sId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column process.TASK_BOOK
     *
     * @return the value of process.TASK_BOOK
     *
     * @mbggenerated
     */
    public Short getTaskBook() {
        return taskBook;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column process.TASK_BOOK
     *
     * @param taskBook the value for process.TASK_BOOK
     *
     * @mbggenerated
     */
    public void setTaskBook(Short taskBook) {
        this.taskBook = taskBook;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column process.OPENNING_REPORT
     *
     * @return the value of process.OPENNING_REPORT
     *
     * @mbggenerated
     */
    public Short getOpenningReport() {
        return openningReport;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column process.OPENNING_REPORT
     *
     * @param openningReport the value for process.OPENNING_REPORT
     *
     * @mbggenerated
     */
    public void setOpenningReport(Short openningReport) {
        this.openningReport = openningReport;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column process.MID_TERM_CHECK
     *
     * @return the value of process.MID_TERM_CHECK
     *
     * @mbggenerated
     */
    public Short getMidTermCheck() {
        return midTermCheck;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column process.MID_TERM_CHECK
     *
     * @param midTermCheck the value for process.MID_TERM_CHECK
     *
     * @mbggenerated
     */
    public void setMidTermCheck(Short midTermCheck) {
        this.midTermCheck = midTermCheck;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column process.PAPER
     *
     * @return the value of process.PAPER
     *
     * @mbggenerated
     */
    public Short getPaper() {
        return paper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column process.PAPER
     *
     * @param paper the value for process.PAPER
     *
     * @mbggenerated
     */
    public void setPaper(Short paper) {
        this.paper = paper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column process.EVALUATION1
     *
     * @return the value of process.EVALUATION1
     *
     * @mbggenerated
     */
    public Short getEvaluation1() {
        return evaluation1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column process.EVALUATION1
     *
     * @param evaluation1 the value for process.EVALUATION1
     *
     * @mbggenerated
     */
    public void setEvaluation1(Short evaluation1) {
        this.evaluation1 = evaluation1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column process.EVALUATION2
     *
     * @return the value of process.EVALUATION2
     *
     * @mbggenerated
     */
    public Short getEvaluation2() {
        return evaluation2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column process.EVALUATION2
     *
     * @param evaluation2 the value for process.EVALUATION2
     *
     * @mbggenerated
     */
    public void setEvaluation2(Short evaluation2) {
        this.evaluation2 = evaluation2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column process.CHECK_REPETITION
     *
     * @return the value of process.CHECK_REPETITION
     *
     * @mbggenerated
     */
    public Short getCheckRepetition() {
        return checkRepetition;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column process.CHECK_REPETITION
     *
     * @param checkRepetition the value for process.CHECK_REPETITION
     *
     * @mbggenerated
     */
    public void setCheckRepetition(Short checkRepetition) {
        this.checkRepetition = checkRepetition;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column process.ANSWER_APPLICATION
     *
     * @return the value of process.ANSWER_APPLICATION
     *
     * @mbggenerated
     */
    public Short getAnswerApplication() {
        return answerApplication;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column process.ANSWER_APPLICATION
     *
     * @param answerApplication the value for process.ANSWER_APPLICATION
     *
     * @mbggenerated
     */
    public void setAnswerApplication(Short answerApplication) {
        this.answerApplication = answerApplication;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column process.ANSWER_RECORD
     *
     * @return the value of process.ANSWER_RECORD
     *
     * @mbggenerated
     */
    public Short getAnswerRecord() {
        return answerRecord;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column process.ANSWER_RECORD
     *
     * @param answerRecord the value for process.ANSWER_RECORD
     *
     * @mbggenerated
     */
    public void setAnswerRecord(Short answerRecord) {
        this.answerRecord = answerRecord;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table process
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", sId=").append(sId);
        sb.append(", taskBook=").append(taskBook);
        sb.append(", openningReport=").append(openningReport);
        sb.append(", midTermCheck=").append(midTermCheck);
        sb.append(", paper=").append(paper);
        sb.append(", evaluation1=").append(evaluation1);
        sb.append(", evaluation2=").append(evaluation2);
        sb.append(", checkRepetition=").append(checkRepetition);
        sb.append(", answerApplication=").append(answerApplication);
        sb.append(", answerRecord=").append(answerRecord);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}