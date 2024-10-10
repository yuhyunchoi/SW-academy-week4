package com.nhnacademy;

import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TestExam01 {
    static final Random random = new Random();
    static final int[] originalSource = new int[10];
    static final int[] originalDestination = new int[10];

    /**
     * 테스트용 데이터 생성
     */
    @BeforeAll
    static void init() {
        for (int i = 0; i < originalSource.length; i++) {
            originalSource[i] = random.nextInt();
            originalDestination[i] = random.nextInt();
        }
    }

    /**
     * 소스 배열과 대상 배열이 다른 경우
     *
     * @param srcPos  소스 시작 위치
     * @param destPos 대상 시작 위치
     * @param length  복사 길이
     */
    @ParameterizedTest
    @MethodSource("testArrayCopyProvider")
    void testArrayCopyBetweenDifferentObjects(int srcPos, int destPos, int length) {
        int[] source = new int[originalSource.length];
        int[] destination1 = new int[originalDestination.length];
        int[] destination2 = new int[originalDestination.length];

        System.arraycopy(originalSource, 0, source, 0, originalSource.length);
        System.arraycopy(originalDestination, 0, destination1, 0, originalDestination.length);
        System.arraycopy(originalDestination, 0, destination2, 0, originalDestination.length);

        System.arraycopy(originalSource, srcPos, destination1, destPos, length);
        Exam01.arraycopy(source, srcPos, destination2, destPos, length);

        assertTrue(Arrays.equals(destination1, destination2));

    }

    /**
     * 소스 배열과 대상 배열 동일한 경우
     *
     * @param srcPos  소스 시작 위치
     * @param destPos 대상 시작 위치
     * @param length  복사 길이
     */
    @ParameterizedTest
    @MethodSource("testArrayCopyProvider")
    void testArrayCopyWithinObject(int srcPos, int destPos, int length) {
        int[] destination1 = new int[originalDestination.length];
        int[] destination2 = new int[originalDestination.length];

        System.arraycopy(originalSource, 0, destination1, 0, originalDestination.length);
        System.arraycopy(originalSource, 0, destination2, 0, originalDestination.length);

        System.arraycopy(destination1, srcPos, destination1, destPos, length);
        Exam01.arraycopy(destination2, srcPos, destination2, destPos, length);

        assertTrue(Arrays.equals(destination1, destination2));

    }

    /**
     * 소스 시작 위치, 대상 시작 위치, 복사 길이로 구성된 테스트 케이스
     *
     * @return 테스트 케이스
     */
    static Stream<Arguments> testArrayCopyProvider() {
        return Stream.of(
                Arguments.of(4, 4, 5),
                Arguments.of(4, 7, 2),
                Arguments.of(4, 2, 4),
                Arguments.of(0, 3, 6),
                Arguments.of(3, 0, 6));
    }

    @ParameterizedTest
    @MethodSource("testIndexOutOfBoundsExceptionProvider")
    void testIndexOutOfBoundsException(int srcPos, int destPos, int length) {
        int[] source = new int[originalSource.length];
        int[] destination = new int[originalDestination.length];

        System.arraycopy(originalSource, 0, source, 0, originalSource.length);
        System.arraycopy(originalDestination, 0, destination, 0, originalDestination.length);

        assertThrowsExactly(ArrayIndexOutOfBoundsException.class, () -> {
            Exam01.arraycopy(source, srcPos, destination, destPos, length);
        });
    }

    static Stream<Arguments> testIndexOutOfBoundsExceptionProvider() {
        return Stream.of(
                Arguments.of(4, 6, 5));
    }

    @Test
    void testNullPointer() {
        int[] source = new int[originalSource.length];
        int[] destination1 = new int[originalDestination.length];
        int[] destination2 = new int[originalDestination.length];

        System.arraycopy(originalSource, 0, source, 0, originalSource.length);
        System.arraycopy(originalDestination, 0, destination1, 0, originalDestination.length);
        System.arraycopy(originalDestination, 0, destination2, 0, originalDestination.length);

        assertThrowsExactly(NullPointerException.class, () -> {
            Exam01.arraycopy(null, 0, destination1, 0, destination1.length);
        });

        assertThrowsExactly(NullPointerException.class, () -> {
            Exam01.arraycopy(source, 0, null, 0, source.length);
        });

        assertThrowsExactly(NullPointerException.class, () -> {
            Exam01.arraycopy(null, 0, null, 0, originalSource.length);
        });
    }
}
