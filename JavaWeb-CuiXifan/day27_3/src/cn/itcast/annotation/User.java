/**
 * 说明：实体类，配合Demo3
 */
package cn.itcast.annotation;

@Table("t_user")
public class User {
	@ID("id")
	private String userId;
	@Column("passwd")
	private String password;

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
