package com.nhnacademy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TestExam02 {
    @ParameterizedTest
    @MethodSource("testBaseConversionProvider")
    void testBaseConversion(String input, int fromBase, int toBase, String target) {
        assertEquals(target, Exam02.baseConversion(input, fromBase, toBase));
    }

    static Stream<Arguments> testBaseConversionProvider() {
        return Stream.of(
                Arguments.of("1", 2, 8, "1"),
                Arguments.of("111", 2, 8, "7"),
                Arguments.of("111", 2, 10, "7"),
                Arguments.of("1111", 2, 16, "f"),
                Arguments.of("1", 8, 10, "1"),
                Arguments.of("111", 8, 10, "73"),
                Arguments.of("111", 8, 16, "49"),
                Arguments.of("1111", 10, 16, "457"));
    }

    @ParameterizedTest
    @MethodSource("testInvalidBaseConversionProvider")
    void testInvalidBaseConversion(String input, int fromBase, int toBase) {
        assertThrowsExactly(NumberFormatException.class, () -> Exam02.baseConversion(input, fromBase, toBase));
    }

    static Stream<Arguments> testInvalidBaseConversionProvider() {
        return Stream.of(
                Arguments.of("2", 2, 8),
                Arguments.of("10a", 2, 8),
                Arguments.of("001", 2, 10),
                Arguments.of("f001", 2, 16),
                Arguments.of("9", 8, 10),
                Arguments.of("a11", 8, 10),
                Arguments.of("000", 8, 16),
                Arguments.of("0000", 10, 16));
    }

    @ParameterizedTest
    @MethodSource("testNotSupportedBaseProvider")
    void testNotSupportedBase(String input, int fromBase, int toBase) {
        assertThrowsExactly(NotSupportedBaseException.class, () -> Exam02.baseConversion(input, fromBase, toBase));
    }

    static Stream<Arguments> testNotSupportedBaseProvider() {
        return Stream.of(
                Arguments.of("1", 1, 8),
                Arguments.of("1", 4, 8),
                Arguments.of("1", 5, 8),
                Arguments.of("1", 7, 8),
                Arguments.of("1", 9, 8),
                Arguments.of("1", 11, 8),
                Arguments.of("1", 2, 1),
                Arguments.of("1", 2, 3),
                Arguments.of("1", 2, 4),
                Arguments.of("1", 2, 5),
                Arguments.of("1", 2, 6),
                Arguments.of("1", 2, 7),
                Arguments.of("1", 2, 9));
    }
}
