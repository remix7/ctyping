package top.cynara.ctyping.entitiy;

import java.io.Serializable;

/**
 * @ClassName ExamRecode
 * @Description 测试记录表
 * @author Cynara-remix http://cynara.top E-mail remix7@live.cn
 * @date 2016年10月21日 上午12:01:25
 * @version V1.0
 */
public class ExamRecode implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	/*
	 * 对应的考卷
	 */
	private Exam exam;
	/*
	 * 对应的用户
	 */
	private User user;
	/*
	 * 内容
	 */
	private String content;
	/*
	 * 所用时间
	 */
	private String useTime;
	/*
	 * 更新时间
	 */
	private String updateTime;
	/*
	 * 分数
	 */
	private String score;
	/*
	 * 正确率
	 */
	private String accuracy;
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

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUseTime() {
		return useTime;
	}

	public void setUseTime(String useTime) {
		this.useTime = useTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
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

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(String accuracy) {
		this.accuracy = accuracy;
	}

}
