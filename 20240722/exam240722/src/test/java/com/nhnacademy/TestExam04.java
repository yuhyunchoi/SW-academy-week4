package com.nhnacademy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TestExam04 {
    @ParameterizedTest
    @MethodSource("testParserProvider")
    void testParser(String expression, String target) {
        assertEquals(target, Exam04.generateAST(expression).toString());
    }

    @ParameterizedTest
    @MethodSource("testInvalidExpressionProvider")
    void testInvalidExpression(String expression) {
        assertThrowsExactly(InvalidExpressionException.class, () -> {
            Exam04.generateAST(expression);
        });
    }

    static Stream<Arguments> testParserProvider() {
        return Stream.of(
                Arguments.of("0", "(0)"),
                Arguments.of("1 + 2", "((1),+,(2))"),
                Arguments.of("1 + 2 * 3", "((1),+,((2),*,(3)))"),
                Arguments.of("1 + 2 * 3 / 4", "((1),+,(((2),*,(3)),/,(4)))"),
                Arguments.of("1 + 2 * 3 / 4 - 5",
                        "(((1),+,(((2),*,(3)),/,(4))),-,(5))"));
    }

    static Stream<Arguments> testInvalidExpressionProvider() {
        return Stream.of(
                Arguments.of("1 2"),
                Arguments.of("+ 1 3"),
                Arguments.of("1 + / 3"));
    }

    @ParameterizedTest
    @MethodSource("testEvaluationProvider")
    void testEvaluation(String expression, int target) {
        assertEquals(target, Exam04.evaluation(expression));
    }

    static Stream<Arguments> testEvaluationProvider() {
        return Stream.of(
                Arguments.of("0", 0),
                Arguments.of("1 + 2", 3),
                Arguments.of("1 + 2 * 3", 7),
                Arguments.of("1 + 2 * 3 / 4", 2),
                Arguments.of("1 + 2 * 3 / 4 - 5", -3));
    }
}
