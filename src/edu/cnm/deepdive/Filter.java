package edu.cnm.deepdive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Includes the {@link #clip(int[], int, int)} and {@link #strip(int[], int, int)} methods.
 * Implementation of these methods is included in the practical exam problems of the Deep Dive
 * Coding Java + Android Bootcamp.
 */
public class Filter {

  private Filter() {
    // NOTE: There is NO need to do anything with this constructor! The methods
    //       you will implement in this class are static; thus, there is no need
    //       to create instances of this class.
  }

  /* BASIC PROBLEM */

  /**
   * Creates and returns an {@code int[]} containing values from {@code data}, with any values less
   * than {@code lowerBound} or greater than {@code upperBound} replaced by {@code lowerBound} or
   * {@code upperBound}, respectively.
   * <p>For example, {@code Filter.clip(new int[] {1, 8, 7, 10}, 3, 9)} will return an array
   * containing the values {@code {3, 8, 7, 9}}.</p>
   *
   * @param data       input to be filtered.
   * @param lowerBound inclusive lower limit; values in {@code data} less than {@code lowerBound}
   *                   are "clipped" to {@code lowerBound} in the result.
   * @param upperBound inclusive upper limit; values in {@code data} greater than {@code upperBound}
   *                   are "clipped" to {@code upperBound} in the result.
   * @return clipped data.
   */
  public static int[] clip(int[] data, int lowerBound, int upperBound) {

    int[] clipArr = data;

    if (lowerBound > upperBound) {
      throw new IllegalArgumentException();
    }

    for (int i = 0; i < data.length; ++i) {

      if (Math.max(data[i], lowerBound) == lowerBound) {
        clipArr[i] = lowerBound;
      }
      if (Math.min(data[i], upperBound) == upperBound) {
        clipArr[i] = upperBound;
      }
    }

    return clipArr;
  }

  /* EXTRA CREDIT PROBLEM */

  /**
   * Creates and returns an {@code int[]} containing values from {@code data}, with any values less
   * less than {@code lowerBound} or greater than {@code upperBound} stripped out, with the size of
   * the resulting array reduced accordingly.
   * <p>For example, {@code Filter.strip(new int[] {1, 8, 7, 10}, 3, 9)} will return an array
   * containing the values {@code {8, 7}}.</p>
   *
   * @param data       input to be filtered.
   * @param lowerBound inclusive lower limit; values in {@code data} less than {@code lowerBound}
   *                   are excluded from the result.
   * @param upperBound inclusive upper limit; values in {@code data} greater than {@code upperBound}
   *                   are excluded from the result.
   * @return stripped data.
   */
  public static int[] strip(int[] data, int lowerBound, int upperBound) {

    int[] stripArr = new int[data.length];
    int count = 0;

    if (lowerBound > upperBound) {
      throw new IllegalArgumentException();
    }

    for (int i = 0; i < data.length; ++i) {

      if (data[i] >= lowerBound && data[i] <= upperBound) {
        stripArr[count++] = data[i];
      }
    }
    return Arrays.copyOf(stripArr, count);
  }
}