package top.cynara.ctyping.entitiy;

import java.io.Serializable;

/**
 * @ClassName ActiveUser
 * @Description 目前正在活动的用户
 * @author Cynara-remix http://cynara.top E-mail remix7@live.cn
 * @date 2016年10月21日 下午9:19:57
 * @version V1.0
 */
public class ActiveUser implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String username;
	private String realname;
	private String stuNum;

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

}
