package top.cynara.ctyping.entitiy;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName Question
 * @Description 试题表
 * @author Cynara-remix http://cynara.top E-mail remix7@live.cn
 * @date 2016年10月20日 下午11:53:05
 * @version V1.0
 */
public class Question implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	/*
	 * 标题
	 */
	private String title;
	/*
	 * 内容
	 */
	private String content;
	/*
	 * 难易程度
	 */
	private String degree;
	/*
	 * 内容长度
	 */
	private String contentLength;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getContentLength() {
		return contentLength;
	}

	public void setContentLength(String contentLength) {
		this.contentLength = contentLength;
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
