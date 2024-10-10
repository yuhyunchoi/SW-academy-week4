package com.nhnacademy;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TestExam03 {
    @Test
    void testException() {
        assertThrowsExactly(IllegalArgumentException.class, () -> {
            Exam03.searchRiemannPrimes(-2, -1);
        });
    }

    @ParameterizedTest
    @MethodSource("testRiemannPrimesProvider")
    void testRiemannPrimes(int n, int m, int[] primes) {
        assertArrayEquals(primes, Exam03.searchRiemannPrimes(n, m));
    }

    static Stream<Arguments> testRiemannPrimesProvider() {
        return Stream.of(
                Arguments.of(2, 3, new int[] { 5, 7 }),
                Arguments.of(12, 13, new int[] { 149, 151, 157, 163, 167 }),
                Arguments.of(13, 12, new int[] { 149, 151, 157, 163, 167 }),
                Arguments.of(100, 101,
                        new int[] { 10007, 10009, 10037, 10039, 10061, 10067, 10069, 10079, 10091, 10093, 10099, 10103,
                                10111, 10133, 10139, 10141, 10151, 10159, 10163, 10169, 10177, 10181, 10193 }));
    }
}
