package com.running4light.gdms.common;

public class SessionValue {
	private String id;
	private String role;
	private String username;
	public SessionValue() {
		
	}
	public SessionValue(String id, String role, String username) {
		super();
		this.id = id;
		this.role = role;
		this.username = username;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	 @Override
	    public String toString() {
	        StringBuilder sb = new StringBuilder();
	        sb.append(getClass().getSimpleName());
	        sb.append(" [");
	        sb.append("Hash = ").append(hashCode());
	        sb.append("id = ").append(id);
	        sb.append("role = ").append(role);
	        sb.append("username = ").append(username);
	        sb.append("]");
	        return sb.toString();
	    }
	
}
