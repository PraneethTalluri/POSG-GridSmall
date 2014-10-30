import java.util.Arrays;

public class Computation {

	CopyValues cVComputation = new CopyValues();

	Action[] action;

	Action[][] obsAction;

	public void initialize(double[] oldBelief, double oldValue) {

		cVComputation.parse();
		cVComputation.copy();
		action = new Action[cVComputation.getActions()
				* cVComputation.getActions()];

		for (int a1 = 0, k = 0; a1 < cVComputation.getActions(); ++a1)
			for (int a2 = 0; a2 < cVComputation.getActions(); ++a2) {
				Action actionObj = new Action();

				// ActionList
				int[] actionList = new int[cVComputation.getNodes()];
				actionList[0] = a1;
				actionList[1] = a2;
				actionObj.setActionList(actionList);

				// Old Belief and Old Value
				actionObj.setOldBelief(oldBelief);
				actionObj.setOldValue(oldValue);

				// Belief Action
				double[] beliefAction = new double[cVComputation.getStates()];
				Arrays.fill(beliefAction, 0);
				for (int s1 = 0; s1 < cVComputation.getStates(); ++s1) {
					for (int s = 0; s < cVComputation.getStates(); ++s) {
						beliefAction[s1] = beliefAction[s1]
								+ (cVComputation.getTrans()[s1][a1][a2][s] * oldBelief[s]);
					}
				}
				actionObj.setBeliefAction(beliefAction);

				// Sum Reward Action
				double sumRewardAction = 0;
				for (int s = 0; s < cVComputation.getStates(); ++s) {
					sumRewardAction = sumRewardAction
							+ (cVComputation.getReward()[s][a1][a2] * oldBelief[s]);
				}
				actionObj.setSumRewardAction(sumRewardAction);

				action[k] = actionObj;
				k++;
			}
	}

	public void computeObsBelief(double[] oldBelief, double oldValue) {

		Computation comp = new Computation();

		comp.initialize(oldBelief, oldValue);

		obsAction = new Action[comp.action.length][comp.cVComputation
				.getObservations() * comp.cVComputation.getObservations()];

		double maxValue = 0;

		for (int a = 0; a < comp.action.length; ++a) {
			double sumAllBeliefActionObs = 0;
			for (int o1 = 0, k = 0; o1 < comp.cVComputation.getObservations(); ++o1) {
				for (int o2 = 0; o2 < comp.cVComputation.getObservations(); ++o2) {
					Action actionObj = new Action();

					// ActionList
					actionObj.setActionList(comp.action[a].getActionList());

					// ObsList
					int[] obsList = new int[comp.cVComputation.getNodes()];
					obsList[0] = o1;
					obsList[1] = o2;
					actionObj.setObsList(obsList);

					// Belief Action Observation without Average
					double[] beliefActionObs = new double[comp.cVComputation
							.getStates()];
					double sumBeliefActionObs = 0;
					Arrays.fill(beliefActionObs, 0);
					for (int s1 = 0; s1 < comp.action[a].getBeliefAction().length; ++s1) {
						beliefActionObs[s1] = beliefActionObs[s1]
								+ (comp.cVComputation.getObs()[o1][o2][s1][comp.action[a]
										.getActionList()[0]][comp.action[a]
										.getActionList()[1]] * comp.action[a]
										.getBeliefAction()[s1]);
						sumBeliefActionObs = sumBeliefActionObs
								+ beliefActionObs[s1];
					}
					actionObj.setBeliefActionObs(beliefActionObs);
					actionObj.setSumBeliefActionObs(sumBeliefActionObs);

					// Sum all belief action observations
					sumAllBeliefActionObs = sumAllBeliefActionObs
							+ sumBeliefActionObs;

					// Belief State after taking action a and observation o
					double[] belief = new double[comp.cVComputation.getStates()];
					Arrays.fill(belief, 0);
					for (int s1 = 0; s1 < beliefActionObs.length; ++s1) {

						double divisor = 1;
						if (sumBeliefActionObs == 0) {
							divisor = 1;
						} else {
							divisor = sumBeliefActionObs;
						}

						belief[s1] = beliefActionObs[s1] / divisor;
					}
					actionObj.setBelief(belief);

					obsAction[a][k] = actionObj;
					k++;
				}
			}
			double currentValue = comp.action[a].getSumRewardAction()
					+ (comp.cVComputation.getDiscount()
							* comp.action[a].getOldValue() * sumAllBeliefActionObs);
			comp.action[a].setCurrentValue(currentValue);
			int compare = Double.compare(currentValue, maxValue);
			if (compare > 0)
				maxValue = currentValue;
			comp.action[a].setMaxValue(maxValue);
		}

		for (int a = 0; a < comp.action.length; ++a) {
			for (int o = 0; o < obsAction[a].length; ++o) {
				obsAction[a][o].setMaxValue(maxValue);
			}
		}
	}

}
