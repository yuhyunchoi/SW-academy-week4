package com.nhnacademy;


import java.util.Scanner;
import java.lang.Math;

public class Exam03 {
    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static int findPrime(int min, int max) { // 9 16 
        for (int i = min + 1; i < max; i++) {
            if (isPrime(i)) {
                return i;
            }
        }
        return -1; // 소수를 찾지 못한 경우 -1 반환
    }
    static int[] searchRiemannPrimes(int n, int m) {
        int min = (int)Math.pow(n,2);
        int max = (int)Math.pow(m,2);
        int[] primes = new int[max];

        if(n < 0 || m < 0){
            throw new IllegalArgumentException();
        }
        for(int i = min + 1; i < max ; i++){
            if(isPrime(i)){
                primes[i] = i;
                System.out.println(min + " < " + primes[i] + " < " + max);
            }
        } 
        return primes;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("두 정수 입력(n m) >> ");
        int n = sc.nextInt();
        int m = sc.nextInt();

        searchRiemannPrimes(n, m);
        
        sc.close();
    }
}
