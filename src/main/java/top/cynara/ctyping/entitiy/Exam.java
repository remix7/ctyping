package top.cynara.ctyping.entitiy;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @ClassName Exam
 * @Description 测试bean
 * @author Cynara-remix http://cynara.top E-mail remix7@live.cn
 * @date 2016年10月20日 下午11:57:33
 * @version V1.0
 */
public class Exam implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	/*
	 * 名称
	 */
	@NotEmpty
	private String name;
	/*
	 * 开始时间
	 */
	@NotEmpty
	private String beginTime;
	/*
	 * 结束时间
	 */
	@NotEmpty
	private String endTime;
	/*
	 * 对应的考题
	 */
	private Question question;
	/*
	 * 创建时间
	 */
	private String createTime;
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

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
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
