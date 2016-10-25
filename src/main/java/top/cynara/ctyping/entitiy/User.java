package top.cynara.ctyping.entitiy;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

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
	@NotEmpty
	private String username;
	/*
	 * 密码
	 */
	@NotEmpty
	@Length(min = 6, max = 18)
	private String password;
	/*
	 * 真实姓名
	 */
	@NotEmpty
	private String realname;
	/*
	 * 学号
	 */
	@NotEmpty
	private String stuNum;
	/*
	 * 手机号
	 */
	@NotEmpty
	@Length(max = 12, min = 10)
	private String phoneNum;
	/*
	 * 邮箱
	 */
	@NotEmpty
	private String email;
	/*
	 * 创建时间
	 */
	private String createTime;
	/*
	 * 状态
	 */
	@NotEmpty
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

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
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
