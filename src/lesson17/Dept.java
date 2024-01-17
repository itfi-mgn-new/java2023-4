package lesson17;

import java.io.Serializable;

public class Dept implements Serializable {
	public int	deptNo;

	public Dept(int deptNo) {
		this.deptNo = deptNo;
	}

	@Override
	public String toString() {
		return "Dept [deptNo=" + deptNo + "]";
	}
}
