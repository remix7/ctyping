package top.cynara.ctyping.entitiy;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName Exam
 * @Description 测试bean
 * @author Cynara-remix http://cynara.top E-mail remix7@live.cn
 * @date 2016年10月20日 下午11:57:33
 * @version V1.0
 */
public class Exam implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	/*
	 * 名称
	 */
	private String name;
	/*
	 * 开始时间
	 */
	private Date beginTime;
	/*
	 * 结束时间
	 */
	private Date endTime;
	/*
	 * 对应的考题
	 */
	private Question question;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
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
