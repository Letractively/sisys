package data.bean;

/**
 * 
 * @author huangxin 不合格详情，以链表的形式记录不合格种类及对应数量， 入口id提供给每日员工—不合格详情
 **/
public class DisqDetail {

	private Integer id = null;
	private int disKId; // 不合格详细种类的id
	private int nextId; // 该工单记录的下一条不合格详细记录id,0代表结尾
	private int num;

	// get和set方法
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getDisKId() {
		return disKId;
	}

	public void setDisKId(int disKind) {
		this.disKId = disKind;
	}

	public int getNextId() {
		return nextId;
	}

	public void setNextId(int nextId) {
		this.nextId = nextId;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	// 得到hashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + disKId;
		result = prime * result + id;
		result = prime * result + nextId;
		result = prime * result + num;
		return result;
	}

	// 判断两个类是否相同
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DisqDetail other = (DisqDetail) obj;
		if (disKId != other.disKId)
			return false;
		if (id != other.id)
			return false;
		if (nextId != other.nextId)
			return false;
		if (num != other.num)
			return false;
		return true;
	}

	// 构造函数
	public DisqDetail(int id, int disKind, int nextId, int num) {
		super();
		this.id = id;
		this.disKId = disKind;
		this.nextId = nextId;
		this.num = num;
	}

	public DisqDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	// 转换为字符串
	@Override
	public String toString() {
		return "DisqDetail [id=" + id + ", disKind=" + disKId + ", nextId="
				+ nextId + ", num=" + num + "]";
	}

}
