package com.running4light.gdms.pojo;

import java.io.Serializable;

public class Grade implements Serializable {
	private Short id;

    private String uId;

    private Integer translate;

    private Integer evaluation;

    private Integer guider;

    private Integer answer;

    private Integer result;

    private static final long serialVersionUID = 1L;

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId == null ? null : uId.trim();
    }

    public Integer getTranslate() {
        return translate;
    }

    public void setTranslate(Integer translate) {
        this.translate = translate;
    }

    public Integer getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(Integer evaluation) {
        this.evaluation = evaluation;
    }

    public Integer getGuider() {
        return guider;
    }

    public void setGuider(Integer guider) {
        this.guider = guider;
    }

    public Integer getAnswer() {
        return answer;
    }

    public void setAnswer(Integer answer) {
        this.answer = answer;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", uId=").append(uId);
        sb.append(", translate=").append(translate);
        sb.append(", evaluation=").append(evaluation);
        sb.append(", guider=").append(guider);
        sb.append(", answer=").append(answer);
        sb.append(", result=").append(result);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}