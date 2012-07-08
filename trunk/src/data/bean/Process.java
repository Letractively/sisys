package data.bean;

import java.util.Date;

/**
 * 
 * @author huangxin 工序信息
 * 
 */
public class Process {

	private int id;
	private String procName;
	private String colorNo;
	private String proNo;
	private int unitOutput; // 班产量，用于转换工时：工时=生产数量/班产量*8
	private int unitCost; // 工时单价，用于转换为工钱
	private int isDelete;
	private Date deleteTime;

	// get和set方法
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProcName() {
		return procName;
	}

	public void setProcName(String procName) {
		this.procName = procName;
	}

	public String getColorNo() {
		return colorNo;
	}

	public void setColorNo(String colorNo) {
		this.colorNo = colorNo;
	}

	public String getProNo() {
		return proNo;
	}

	public void setProNo(String proNo) {
		this.proNo = proNo;
	}

	public int getUnitOutput() {
		return unitOutput;
	}

	public void setUnitOutput(int unitOutput) {
		this.unitOutput = unitOutput;
	}

	public int getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(int unitCost) {
		this.unitCost = unitCost;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	public Date getDeleteTime() {
		return deleteTime;
	}

	public void setDeleteTime(Date deleteTime) {
		this.deleteTime = deleteTime;
	}

	// 得到hashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((colorNo == null) ? 0 : colorNo.hashCode());
		result = prime * result
				+ ((deleteTime == null) ? 0 : deleteTime.hashCode());
		result = prime * result + id;
		result = prime * result + isDelete;
		result = prime * result + ((proNo == null) ? 0 : proNo.hashCode());
		result = prime * result
				+ ((procName == null) ? 0 : procName.hashCode());
		result = prime * result + unitCost;
		result = prime * result + unitOutput;
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
		Process other = (Process) obj;
		if (colorNo == null) {
			if (other.colorNo != null)
				return false;
		} else if (!colorNo.equals(other.colorNo))
			return false;
		if (deleteTime == null) {
			if (other.deleteTime != null)
				return false;
		} else if (!deleteTime.equals(other.deleteTime))
			return false;
		if (id != other.id)
			return false;
		if (isDelete != other.isDelete)
			return false;
		if (proNo == null) {
			if (other.proNo != null)
				return false;
		} else if (!proNo.equals(other.proNo))
			return false;
		if (procName == null) {
			if (other.procName != null)
				return false;
		} else if (!procName.equals(other.procName))
			return false;
		if (unitCost != other.unitCost)
			return false;
		if (unitOutput != other.unitOutput)
			return false;
		return true;
	}

	// 构造函数
	public Process(int id, String procName, String colorNo, String proNo,
			int unitOutput, int unitCost, int isDelete, Date deleteTime) {
		super();
		this.id = id;
		this.procName = procName;
		this.colorNo = colorNo;
		this.proNo = proNo;
		this.unitOutput = unitOutput;
		this.unitCost = unitCost;
		this.isDelete = isDelete;
		this.deleteTime = deleteTime;
	}

	public Process() {
		super();
		// TODO Auto-generated constructor stub
	}

	// 转换为字符串
	@Override
	public String toString() {
		return "Process [id=" + id + ", procName=" + procName + ", colorNo="
				+ colorNo + ", proNo=" + proNo + ", unitOutput=" + unitOutput
				+ ", unitCost=" + unitCost + ", isDelete=" + isDelete
				+ ", deleteTime=" + deleteTime + "]";
	}

}
