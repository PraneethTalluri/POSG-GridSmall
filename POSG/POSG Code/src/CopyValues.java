
public class CopyValues {
	
	protected int nodes = 0, states = 0, actions = 0, observations = 0;
		
	protected double discount = 0;
	
	PosgParser posg = new PosgParser();
	
	//getter and setters
	public int getNodes() {
		return nodes;
	}

	public void setNodes(int nodes) {
		this.nodes = nodes;
	}

	public int getStates() {
		return states;
	}

	public void setStates(int states) {
		this.states = states;
	}

	public int getActions() {
		return actions;
	}

	public void setActions(int actions) {
		this.actions = actions;
	}

	public int getObservations() {
		return observations;
	}

	public void setObservations(int observations) {
		this.observations = observations;
	}
	
	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	//function to parse posg
	public void parse() {
		posg.parse();
		setNodes(posg.nodes);
		setStates(posg.states);
		setActions(posg.actions);
		setObservations(posg.observations);
		setDiscount(posg.discount);
		
	}
	
	//For copying initail belief, trans, obs, rewards
	protected double[] initialBelief = new double[states];
	protected double[][][][] trans = new double[states][actions][actions][states];
	protected double[][][][][] obs = new double[observations][observations][states][actions][actions];
	protected double[][][] reward = new double[states][actions][actions];

	public double[] getInitialBelief() {
		return initialBelief;
	}

	public void setInitialBelief(double[] initialBelief) {
		try {
			this.initialBelief = (double[]) ObjectCloner.deepCopy(initialBelief);
		} catch (Exception e) {
			System.out.println("Error Deep Copying Initial Belief");
			e.printStackTrace();
		}
	}

	public double[][][][] getTrans() {
		return trans;
	}

	public void setTrans(double[][][][] trans) {
		try {
			this.trans = (double[][][][]) ObjectCloner.deepCopy(trans);
		} catch (Exception e) {
			System.out.println("Error Deep Copying Transitions");
			e.printStackTrace();
		}
	}

	public double[][][][][] getObs() {
		return obs;
	}

	public void setObs(double[][][][][] obs) {
		try {
			this.obs = (double[][][][][]) ObjectCloner.deepCopy(obs);
		} catch (Exception e) {
			System.out.println("Error Deep Copying Obseravations");
			e.printStackTrace();
		}
	}

	public double[][][] getReward() {
		return reward;
	}

	public void setReward(double[][][] reward) {
		try {
			this.reward = (double[][][]) ObjectCloner.deepCopy(reward);
		} catch (Exception e) {
			System.out.println("Error Deep Copying Rewards");
			e.printStackTrace();
		}
	}
	
	//function to copy
	public void copy() {
		
		setInitialBelief(posg.initialBelief);
		setTrans(posg.trans);
		setObs(posg.obs);
		setReward(posg.reward);
		
	}

}
