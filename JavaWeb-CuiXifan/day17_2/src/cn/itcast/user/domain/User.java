/*
 * 说明：JavaBean
 */
package cn.itcast.user.domain;

public class User {
	private String username;
	private String password;
	private String verifyCode;
	public User() {
		super();
	}
	public User(String username, String password, String verifyCode) {
		super();
		this.username = username;
		this.password = password;
		this.verifyCode = verifyCode;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getVerifyCode() {
		return verifyCode;
	}
	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password
				+ ", verifyCode=" + verifyCode + "]";
	}
	
}
