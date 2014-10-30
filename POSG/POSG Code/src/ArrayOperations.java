import java.util.Arrays;

/**
 * Double single dimensional array operations like comparing, adding, etc.
 * 
 * @author Praneeth Talluri
 * 
 */

public class ArrayOperations {

	/**
	 * Compares two double arrays. Returns 1 of all the elements of array1 >
	 * array2.
	 * 
	 * @param double[] array1
	 * @param double[] array2
	 * 
	 * @return int
	 */
	public int greaterOrEqual(double[] array1, double[] array2) {

		int j = 1;

		if (array1.length == array2.length) {

			for (int i = 0; i < array1.length; ++i) {

				int k = Double.compare(array1[i], array2[i]);

				if (k >= 0)
					k = 1;
				else if (k <= 0)
					k = 0;

				j = j * k;
			}

		}

		return j;

	}

	/**
	 * Compares two double arrays. Returns 1 of all the elements of array1 <
	 * array2.
	 * 
	 * @param double[] array1
	 * @param double[] array2
	 * 
	 * @return int
	 */

	public int less(double[] array1, double[] array2) {

		int j = 1;

		if (array1.length == array2.length) {

			for (int i = 0; i < array1.length; ++i) {

				int k = Double.compare(array1[i], array2[i]);

				if (k <= 0)
					k = 1;
				else if (k >= 0)
					k = 0;

				j = j * k;
			}

		}

		return j;

	}

	/**
	 * Compares two double array. Returns true if all the elements of array1 ==
	 * array2 else returns false.
	 * 
	 * @param double[] array1
	 * @param double[] array2
	 * 
	 * @return boolean
	 */
	public boolean equals(double[] array1, double[] array2) {

		boolean retval = Arrays.equals(array1, array2);

		return retval;
	}

	/**
	 * Multiplies each element in double array. Returns double.
	 * 
	 * @param double[] array
	 * 
	 * @return double
	 */
	public double mutliplyElements(double[] array1) {

		double retval = 1;

		for (int i = 0; i < array1.length; ++i) {
			retval = retval * array1[i];
		}

		return retval;
	}

	/**
	 * Returns a double array which contains dot product of two double arrays
	 * 
	 * @param double[] array1
	 * @param double[] array2
	 * 
	 * @return double[] array
	 */
	public double[] mutliplyElements(double[] array1, double[] array2) {

		double[] retarray = new double[array1.length];

		for (int i = 0; i < array1.length; ++i) {
			retarray[i] = array1[i] * array2[i];
		}

		return retarray;
	}

	/**
	 * Returns a double array with the value multiplied to each element
	 * 
	 * @param double[] array
	 * @param double value
	 * 
	 * @return double[] array
	 */
	public double[] mutliplyElements(double[] array1, double value) {

		double[] retarray = new double[array1.length];

		for (int i = 0; i < array1.length; ++i) {
			retarray[i] = array1[i] * value;
		}

		return retarray;
	}

	/**
	 * Adds each element in double array. Returns double.
	 * 
	 * @param double[] array
	 * 
	 * @return double
	 */
	public double addElements(double[] array1) {

		double retval = 0;

		for (int i = 0; i < array1.length; ++i) {
			retval = retval + array1[i];
		}

		return retval;
	}

	/**
	 * Returns a double array which contains dot sum of two double arrays Dot
	 * sum is similar to dot product except elements are added instead of
	 * summing
	 * 
	 * @param double[] array1
	 * @param double[] array2
	 * 
	 * @return double[] array
	 */
	public double[] addElements(double[] array1, double[] array2) {

		double[] retarray = new double[array1.length];

		for (int i = 0; i < array1.length; ++i) {
			retarray[i] = array1[i] + array2[i];
		}

		return retarray;
	}

	/**
	 * Returns a double array with the value added to each element
	 * 
	 * @param double[] array
	 * @param double value
	 * 
	 * @return double[] array
	 */
	public double[] addElements(double[] array1, double value) {

		double[] retarray = new double[array1.length];

		for (int i = 0; i < array1.length; ++i) {
			retarray[i] = array1[i] + value;
		}

		return retarray;
	}

	/**
	 * Returns the max value element in the double array
	 * 
	 * @param double[] array
	 * 
	 * @return double
	 */
	public double maxElement(double[] array1) {

		double max = array1[0];
		for (int i = 0; i < array1.length; ++i) {
			if (array1[i] > max)
				max = array1[i];
		}

		return max;
	}

	/**
	 * Returns a double array with the value divided to each element
	 * 
	 * @param double[] array
	 * @param double value
	 * 
	 * @return double[] array
	 */
	public double[] divideElements(double[] array1, double value) {

		double[] retarray = new double[array1.length];

		for (int i = 0; i < array1.length; ++i) {
			retarray[i] = array1[i] / value;
		}

		return retarray;
	}

}
