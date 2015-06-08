package cn.itcast.goods.admin.admin.domain;

/**
 * 管理员模块实体类
 * @author jason
 *
 */
public class Admin {
	private String adminId;
	private String adminname;
	private String adminpass;

	public Admin() {
		super();
	}
	public Admin(String adminId, String adminname, String adminpass) {
		super();
		this.adminId = adminId;
		this.adminname = adminname;
		this.adminpass = adminpass;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public String getAdminpass() {
		return adminpass;
	}
	public void setAdminpass(String adminpass) {
		this.adminpass = adminpass;
	}
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminname=" + adminname
				+ ", adminpass=" + adminpass + "]";
	}
}
