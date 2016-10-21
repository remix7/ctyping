package top.cynara.ctyping.entitiy;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName User
 * @Description 注册用户bean
 * @author Cynara-remix http://cynara.top E-mail remix7@live.cn
 * @date 2016年10月20日 下午11:47:33
 * @version V1.0
 */
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	/*
	 * 用户名
	 */
	private String username;
	/*
	 * 密码
	 */
	private String password;
	/*
	 * 真实姓名
	 */
	private String realname;
	/*
	 * 学号
	 */
	private String stuNum;
	/*
	 * 手机号
	 */
	private String phoneNum;
	/*
	 * 邮箱
	 */
	private String email;
	/*
	 * 创建时间
	 */
	private Date createTime;
	/*
	 * 状态
	 */
	private String state;
	/*
	 * 备注
	 */
	private String remarks;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getStuNum() {
		return stuNum;
	}

	public void setStuNum(String stuNum) {
		this.stuNum = stuNum;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
