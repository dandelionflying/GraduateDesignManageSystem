package com.running4light.gdms.pojo;

import java.io.Serializable;

public class GradeResult implements Serializable{

	private static final long serialVersionUID = 1L;

	private Short id;

    private String uId;

    private String username;
    
    private String className;
    
    private Integer translate;

    private Integer evaluation;

    private Integer guider;

    private Integer answer;

    private Integer result;
    
    
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
		this.uId = uId;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getClassName() {
		return className;
	}


	public void setClassName(String className) {
		this.className = className;
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
        sb.append(", username=").append(username);
        sb.append(", className=").append(className);
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
