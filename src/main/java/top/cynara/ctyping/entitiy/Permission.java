package top.cynara.ctyping.entitiy;

import java.io.Serializable;

/**
 * @ClassName Permission
 * @Description 权限
 * @author Cynara-remix http://cynara.top E-mail remix7@live.cn
 * @date 2016年10月27日 下午8:48:37
 * @version V1.0
 */
public class Permission implements Serializable {
	private Integer id;
	private String name;
	private String type;
	private String url;
	private String percode;
	private String avaliable;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPercode() {
		return percode;
	}

	public void setPercode(String percode) {
		this.percode = percode;
	}

}
