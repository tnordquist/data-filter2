package edu.cnm.deepdive;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class FilterTest {

  private final String TEST_FORMAT = "[{index}] "
      + "data{0}, lowerBound{1}, upperBound{2}, expected{3}, expectedException{4}";

  private static Stream<Arguments> clip() {
    return Stream.of(
        Arguments.of(new int[]{1, 10, 2, 9, 3, 8, 4, 7, 5, 6}, 3, 7,
            new int[]{3, 7, 3, 7, 3, 7, 4, 7, 5, 6}, null),
        Arguments.of(new int[] {10, 2, 9, 3, 8, 4, 7, 5, 6,1},4, 4,new int[]{4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, null)

        );
  }
//
//
//
//
//  {
//    2, 9, 3, 8, 4, 7, 5, 6, 1, 10
//  }
//
//  Integer.MIN_VALUE Integer.
//
//  MAX_VALUE {
//    2, 9, 3, 8, 4, 7, 5, 6, 1, 10
//  } 	(none)
//
//  {
//    9, 3, 8, 4, 7, 5, 6, 1, 10, 2
//  } 	1-1(none)IllegalArgumentException

  @ParameterizedTest(name = TEST_FORMAT)
  @MethodSource

  void clip(int[] data, int lowerBound, int upperBound, int[] expected, Class<?
      extends Throwable> throwable) {
    if(throwable != null){
      assertThrows(throwable, () -> Filter.clip(data, lowerBound,upperBound));
    } else {
      assertArrayEquals(expected,Filter.clip(data,lowerBound,upperBound));
    }
  }

  @Test
  void strip() {
  }
}