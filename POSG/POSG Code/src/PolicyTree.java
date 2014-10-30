import java.util.Arrays;

public class PolicyTree {

	protected double[] belief;

	protected double value;

	protected int level;

	protected int[] actionList;

	protected int[] obsList;

	public double[] getBelief() {
		return belief;
	}

	public void setBelief(double[] belief) {
		this.belief = Arrays.copyOf(belief, belief.length);
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int[] getActionList() {
		return actionList;
	}

	public void setActionList(int[] actionList) {
		this.actionList = Arrays.copyOf(actionList, actionList.length);
	}

	public int[] getObsList() {
		return obsList;
	}

	public void setObsList(int[] obsList) {
		this.obsList = Arrays.copyOf(obsList, obsList.length);
	}

	@Override
	public String toString() {
		return "Policy [JointAction=" + Arrays.toString(actionList)
				+ ", JointObservation=" + Arrays.toString(obsList) + "]";
	}

}
