package com.nhnacademy;

import java.util.Scanner;

public class Exam02 {
    Exam02() {
    }

    static String baseConversion(String input, int fromBase, int toBase) {        
        StringBuilder sb = new StringBuilder();
	    int intInput = Integer.parseInt(input);
        
        if(fromBase == 10){ // 10 -> N 
            while(intInput > 0){
                if(intInput % toBase < 10){
                    sb.append(intInput % toBase);
                } else {
                    sb.append((char)(intInput % toBase - 10 + 'A'));
                }
                intInput /= toBase;
            }
            // StringBuilder의 reverse를 사용해야 정상적으로 출력 가능. 안그러면 거꾸로 출력됨
            System.out.println("숫자 : " + intInput + "를 " + toBase + "진법으로 변환한 수 : " + sb.reverse());
        }
        else if (toBase == 10){// N -> 10
            char[] nums = input.toCharArray(); 
            int ans = 0; 
        
            for(int i=0; i < nums.length; i++){
                if(nums[i] >= 'A'){
                    ans = ans * fromBase + (nums[i] - 'A' + 10);    
                } else {
                    ans = ans * fromBase + (nums[i] - '0');
                }
            }
            System.out.println(ans);
        }
        
        return input + fromBase + toBase;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("수 입력 : ");
        String input = sc.nextLine();

        System.out.print("원래 진법 : ");
        String fromBase = sc.nextLine();
        int intFromBase = Integer.parseInt(fromBase);
        
        System.out.print("바꾸려는 진법 : " );
        String toBase = sc.nextLine();
        int intToBase = Integer.parseInt(toBase);

        baseConversion(input, intFromBase, intToBase); // 1111 2 16 => F 출력
        
        sc.close();
    }
}
