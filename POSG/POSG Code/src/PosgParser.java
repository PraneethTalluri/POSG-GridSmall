import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PosgParser {

	protected int nodes = 0, states = 0, actions = 0, observations = 0, count = 0;
	private int i = 0, j = 0, k = 0, l = 0, m = 0; // dummy variables
	protected double discount = 0;
	private double value = 0; // dummy variable

	protected double[] initialBelief; // = new double[states];
	protected double[][][][] trans; // = new double[states][actions][actions][states];
	protected double[][][][][] obs; // = new
							// double[observations][observations][states][actions][actions];
	protected double[][][] reward; // = new double[states][actions][actions];

	public void parse() {
		try (BufferedReader br = new BufferedReader(new FileReader(
				"GridSmall.posg"))) {
			for (String line; (line = br.readLine()) != null;) {

				String str = null;

				if (count < 6) {

					str = line.substring(line.indexOf("=") + 1,
							line.length() - 1);
					nodes = Integer.parseInt(str);
					count++;

					line = br.readLine();
					str = line.substring(line.indexOf("=") + 1,
							line.length() - 1);
					states = Integer.parseInt(str);
					count++;

					line = br.readLine();
					str = line.substring(line.indexOf("=") + 1,
							line.length() - 1);
					actions = Integer.parseInt(str);
					count++;

					line = br.readLine();
					str = line.substring(line.indexOf("=") + 1,
							line.length() - 1);
					observations = Integer.parseInt(str);
					count++;

					line = br.readLine();
					str = line.substring(line.indexOf("=") + 1,
							line.length() - 1);
					discount = Double.parseDouble(str);
					count++;

					initialBelief = new double[states];
					trans = new double[states][actions][actions][states];
					obs = new double[observations][observations][states][actions][actions];
					reward = new double[states][actions][actions];

					line = br.readLine(); // index starts with 0, so if in file
											// it refers to 7 then in array it
											// refers to 6
					initialBelief[Integer.parseInt(line.substring(
							line.indexOf("=") + 2, line.lastIndexOf(" "))) - 1] = Double
							.parseDouble(line.substring(
									line.lastIndexOf(" ") + 1, line.length()));
					count++;

				} else if (count == 6) {

					while (line.compareTo(";") != 0) {
						initialBelief[Integer.parseInt(line.substring(0,
								line.lastIndexOf(" "))) - 1] = Double
								.parseDouble(line.substring(
										line.lastIndexOf(" ") + 1,
										line.length()));
						line = br.readLine();
					}
					count++;
					line = br.readLine(); // index starts with 0, so if in file
											// it refers to 7 then in array it
											// refers to 6
					value = Double.parseDouble(line.substring(
							line.lastIndexOf(" ") + 1, line.length()));
					str = line.substring(0, line.lastIndexOf(" "));
					l = Integer.parseInt(str.substring(
							str.lastIndexOf(" ") + 1, str.length() - 1)) - 1;
					str = str.substring(0, str.lastIndexOf(" "));
					k = Integer.parseInt(str.substring(
							str.lastIndexOf(" ") + 1, str.length() - 1)) - 1;
					str = str.substring(0, str.lastIndexOf(" "));
					j = Integer.parseInt(str.substring(
							str.lastIndexOf(" ") + 1, str.length() - 1)) - 1;
					str = str.substring(0, str.lastIndexOf(" "));
					i = Integer.parseInt(str.substring(
							str.lastIndexOf("[") + 1, str.length() - 1)) - 1;

					trans[i][j][k][l] = value;
				}

				else if (count == 7) {

					while (line.compareTo(";") != 0) {

						value = Double.parseDouble(line.substring(
								line.lastIndexOf(" ") + 1, line.length()));
						str = line.substring(0, line.lastIndexOf(" "));
						l = Integer.parseInt(str.substring(
								str.lastIndexOf(" ") + 1, str.length() - 1)) - 1;
						str = str.substring(0, str.lastIndexOf(" "));
						k = Integer.parseInt(str.substring(
								str.lastIndexOf(" ") + 1, str.length() - 1)) - 1;
						str = str.substring(0, str.lastIndexOf(" "));
						j = Integer.parseInt(str.substring(
								str.lastIndexOf(" ") + 1, str.length() - 1)) - 1;
						str = str.substring(0, str.lastIndexOf(" "));
						i = Integer.parseInt(str.substring(
								str.lastIndexOf("[") + 1, str.length() - 1)) - 1;

						trans[i][j][k][l] = value;

						line = br.readLine();
					}
					count++;
					line = br.readLine(); // index starts with 0, so if in file
					// it refers to 7 then in array it
					// refers to 6
					value = Double.parseDouble(line.substring(
							line.lastIndexOf(" ") + 1, line.length()));
					str = line.substring(0, line.lastIndexOf(" "));
					m = Integer.parseInt(str.substring(
							str.lastIndexOf(" ") + 1, str.length() - 1)) - 1;
					str = str.substring(0, str.lastIndexOf(" "));
					l = Integer.parseInt(str.substring(
							str.lastIndexOf(" ") + 1, str.length() - 1)) - 1;
					str = str.substring(0, str.lastIndexOf(" "));
					k = Integer.parseInt(str.substring(
							str.lastIndexOf(" ") + 1, str.length() - 1)) - 1;
					str = str.substring(0, str.lastIndexOf(" "));
					j = Integer.parseInt(str.substring(
							str.lastIndexOf(" ") + 1, str.length() - 1)) - 1;
					str = str.substring(0, str.lastIndexOf(" "));
					i = Integer.parseInt(str.substring(
							str.lastIndexOf("[") + 1, str.length() - 1)) - 1;

					obs[i][j][k][l][m] = value;
				}

				else if (count == 8) {

					while (line.compareTo(";") != 0) {

						value = Double.parseDouble(line.substring(
								line.lastIndexOf(" ") + 1, line.length()));
						str = line.substring(0, line.lastIndexOf(" "));
						m = Integer.parseInt(str.substring(
								str.lastIndexOf(" ") + 1, str.length() - 1)) - 1;
						str = str.substring(0, str.lastIndexOf(" "));
						l = Integer.parseInt(str.substring(
								str.lastIndexOf(" ") + 1, str.length() - 1)) - 1;
						str = str.substring(0, str.lastIndexOf(" "));
						k = Integer.parseInt(str.substring(
								str.lastIndexOf(" ") + 1, str.length() - 1)) - 1;
						str = str.substring(0, str.lastIndexOf(" "));
						j = Integer.parseInt(str.substring(
								str.lastIndexOf(" ") + 1, str.length() - 1)) - 1;
						str = str.substring(0, str.lastIndexOf(" "));
						i = Integer.parseInt(str.substring(
								str.lastIndexOf("[") + 1, str.length() - 1)) - 1;

						obs[i][j][k][l][m] = value;

						line = br.readLine();
					}
					count++;
					line = br.readLine(); // index starts with 0, so if in file
					// it refers to 7 then in array it
					// refers to 6
					value = Double.parseDouble(line.substring(
							line.lastIndexOf(" ") + 1, line.length()));
					str = line.substring(0, line.lastIndexOf(" "));
					k = Integer.parseInt(str.substring(
							str.lastIndexOf(" ") + 1, str.length() - 1)) - 1;
					str = str.substring(0, str.lastIndexOf(" "));
					j = Integer.parseInt(str.substring(
							str.lastIndexOf(" ") + 1, str.length() - 1)) - 1;
					str = str.substring(0, str.lastIndexOf(" "));
					i = Integer.parseInt(str.substring(
							str.lastIndexOf("[") + 1, str.length() - 1)) - 1;

					reward[i][j][k] = value;
				}

				else if (count == 9) {

					while (line.compareTo(";") != 0) {

						value = Double.parseDouble(line.substring(
								line.lastIndexOf(" ") + 1, line.length()));
						str = line.substring(0, line.lastIndexOf(" "));
						k = Integer.parseInt(str.substring(
								str.lastIndexOf(" ") + 1, str.length() - 1)) - 1;
						str = str.substring(0, str.lastIndexOf(" "));
						j = Integer.parseInt(str.substring(
								str.lastIndexOf(" ") + 1, str.length() - 1)) - 1;
						str = str.substring(0, str.lastIndexOf(" "));
						i = Integer.parseInt(str.substring(
								str.lastIndexOf("[") + 1, str.length() - 1)) - 1;

						reward[i][j][k] = value;

						line = br.readLine();
					}
					count++;
				}

			}
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			System.err.println(e.getMessage()); // handle exception
		}
	}
	
	// getters and setters

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

	public double[] getInitialBelief() {
		return initialBelief;
	}

	public void setInitialBelief(double[] initialBelief) {
		this.initialBelief = initialBelief;
	}

	public double[][][][] getTrans() {
		return trans;
	}

	public void setTrans(double[][][][] trans) {
		this.trans = trans;
	}

	public double[][][][][] getObs() {
		return obs;
	}

	public void setObs(double[][][][][] obs) {
		this.obs = obs;
	}

	public double[][][] getReward() {
		return reward;
	}

	public void setReward(double[][][] reward) {
		this.reward = reward;
	}
}
