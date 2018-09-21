package gdms.model;

public class Proccess {
	private int pid;
	private String sId;
	private float proccess;
	private float st;
	private float need;
	private float sysdesign;
	private float test;
	private float report;
	private float paper;

	public String getsId() {
		return sId;
	}

	public void setsId(String sId) {
		this.sId = sId;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public float getProccess() {
		return proccess;
	}

	public void setProccess(float proccess) {
		this.proccess = proccess;
	}

	public float getSt() {
		return st;
	}

	public void setSt(float st) {
		this.st = st;
	}

	public float getNeed() {
		return need;
	}

	public void setNeed(float need) {
		this.need = need;
	}

	public float getSysdesign() {
		return sysdesign;
	}

	public void setSysdesign(float sysdesign) {
		this.sysdesign = sysdesign;
	}

	public float getTest() {
		return test;
	}

	public void setTest(float test) {
		this.test = test;
	}

	public float getReport() {
		return report;
	}

	public void setReport(float report) {
		this.report = report;
	}

	public float getPaper() {
		return paper;
	}

	public void setPaper(float paper) {
		this.paper = paper;
	}

}
