import java.util.Arrays;

public class Action {

	protected int[] actionList;
	protected int[] obsList;

	protected double[] oldBelief;
	protected double[] belief;

	protected double oldValue;
	protected double currentValue;
	protected double maxValue;

	protected double[] beliefAction;

	protected double sumRewardAction;

	protected double[] beliefActionObs;

	protected double sumBeliefActionObs;

	protected double sumAllBeliefActionObs;

	// Setters and Getters for belief and value
	public double[] getBelief() {
		return belief;
	}

	public void setBelief(double[] belief) {
		this.belief = Arrays.copyOf(belief, belief.length);
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

	public double getOldValue() {
		return oldValue;
	}

	public void setOldValue(double oldValue) {
		this.oldValue = oldValue;
	}

	public double getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(double currentValue) {
		this.currentValue = currentValue;
	}

	public double getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(double maxValue) {
		this.maxValue = maxValue;
	}

	public double[] getBeliefAction() {
		return beliefAction;
	}

	public void setBeliefAction(double[] beliefAction) {
		this.beliefAction = Arrays.copyOf(beliefAction, beliefAction.length);
	}

	public double getSumRewardAction() {
		return sumRewardAction;
	}

	public void setSumRewardAction(double sumRewardAction) {
		this.sumRewardAction = sumRewardAction;
	}

	public double[] getOldBelief() {
		return oldBelief;
	}

	public void setOldBelief(double[] oldBelief) {
		this.oldBelief = Arrays.copyOf(oldBelief, oldBelief.length);
	}

	public double[] getBeliefActionObs() {
		return beliefActionObs;
	}

	public void setBeliefActionObs(double[] beliefActionObs) {
		this.beliefActionObs = Arrays.copyOf(beliefActionObs,
				beliefActionObs.length);
	}

	public double getSumBeliefActionObs() {
		return sumBeliefActionObs;
	}

	public void setSumBeliefActionObs(double sumBeliefActionObs) {
		this.sumBeliefActionObs = sumBeliefActionObs;
	}

	public double getSumAllBeliefActionObs() {
		return sumAllBeliefActionObs;
	}

	public void setSumAllBeliefActionObs(double sumAllBeliefActionObs) {
		this.sumAllBeliefActionObs = sumAllBeliefActionObs;
	}

	@Override
	public String toString() {
		return "Action [JointAction=" + Arrays.toString(actionList)
				+ ", JointObservation=" + Arrays.toString(obsList) + "]";
	}

}
