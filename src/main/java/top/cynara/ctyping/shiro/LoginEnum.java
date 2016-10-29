package top.cynara.ctyping.shiro;

/**
 * @ClassName LoginEnum
 * @Description 登录标识
 * @author Cynara-remix http://cynara.top E-mail remix7@live.cn
 * @date 2016年10月27日 下午2:25:08
 * @version V1.0
 */
public enum LoginEnum {
	
	CUSTOMER("1"), ADMIN("2");
	
	private String type;

	private LoginEnum(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return this.type.toString();
	}
}
