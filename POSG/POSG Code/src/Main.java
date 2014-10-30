import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		CopyValues originalData = new CopyValues();
		originalData.parse();
		originalData.copy();

		PolicyTree initial = new PolicyTree();

		System.out.println("Enter the value of horizon");
		int horizon = new Scanner(System.in).nextInt();

		initial.setBelief(originalData.getInitialBelief());
		initial.setValue(0);
		initial.setLevel(0);

		TreeNode root = new TreeNode(initial);
		TreeNode currentNode;

		currentNode = root;

		for (int i = 0; i < horizon; ++i) {

			Iterator<TreeNode> it = currentNode.leavesIterator();
			while (it.hasNext()) {
				Computation computationObj = new Computation();

				TreeNode iterationNode = it.next();

				if (iterationNode.getLevel() == i) {

					computationObj
							.computeObsBelief(((PolicyTree) iterationNode
									.getObject()).getBelief(),
									((PolicyTree) iterationNode.getObject())
											.getValue());

					for (int a = 0; a < computationObj.obsAction.length; ++a) {
						for (int o = 0; o < computationObj.obsAction[a].length; ++o) {

							PolicyTree policyTreeObj = new PolicyTree();

							policyTreeObj
									.setBelief(computationObj.obsAction[a][o]
											.getBelief());
							policyTreeObj
									.setActionList(computationObj.obsAction[a][o]
											.getActionList());
							policyTreeObj
									.setObsList(computationObj.obsAction[a][o]
											.getObsList());
							policyTreeObj
									.setValue(computationObj.obsAction[a][o]
											.getMaxValue());
							policyTreeObj.setLevel(((PolicyTree) iterationNode
									.getObject()).getLevel() + 1);

							iterationNode.add(new TreeNode(policyTreeObj));

							Iterator<TreeNode> itPruning = currentNode
									.leavesIterator();

							int flag = 0;
							while (itPruning.hasNext()) {
								TreeNode iterationPruningNode = itPruning
										.next();

								if (iterationPruningNode.getLevel() == (i + 1)) {

									int k = prune(
											((PolicyTree) iterationNode
													.getLastChild().getObject())
													.getBelief(),
											((PolicyTree) iterationPruningNode
													.getObject()).getBelief(),
											((PolicyTree) iterationNode
													.getLastChild().getObject())
													.getValue(),
											((PolicyTree) iterationPruningNode
													.getObject()).getValue());

									if (k == -1) {
										flag = 1;
									}
								}

							}
							if (flag == 1) {
								iterationNode.remove(iterationNode
										.getLastChild());
							}

						}
					}

				}

			}
		}

		Iterator<TreeNode> itDisplay = root.leavesIterator();
		while (itDisplay.hasNext()) {
			TreeNode displayNode = itDisplay.next();

			if (displayNode.getLevel() == horizon) {
				System.out.println("Policy :-");
				List<TreeNode> displayList = displayNode.getPathToRoot();
				Iterator<TreeNode> listIterator = displayList.iterator();
				while (listIterator.hasNext()) {
					TreeNode displayElement = listIterator.next();
					System.out
							.println(((PolicyTree) displayElement.getObject()));
				}

			}
		}

	}

	public static int prune(double[] array1, double[] array2, double value1,
			double value2) {
		ArrayOperations arrayOps = new ArrayOperations();

		array1 = arrayOps.mutliplyElements(array1, value1);
		array2 = arrayOps.mutliplyElements(array2, value2);

		int i = arrayOps.greaterOrEqual(array1, array2);
		int j = arrayOps.less(array1, array2);
		if (i == 0 && j == 1)
			return -1;
		else if (i == 1 && j == 0)
			return 1;
		else
			return 0;
	}

}
