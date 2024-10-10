package com.nhnacademy;


public class Exam01 {

    Exam01() {
    }

    public static void arraycopy(int[] src, int srcPos, int[] dest, int destPost, int length) {
        if(src == null || dest == null){
            throw new NullPointerException();
        }
        if( (length < 0) || (srcPos < 0) || (src.length < srcPos + length) 
            ||(destPost < 0) || (dest.length < destPost + length) ){
                throw new ArrayIndexOutOfBoundsException();
        }

        if(srcPos < destPost){
            for(int i = length - 1 ; i >= 0 ; i--){
                dest[destPost + i] = src[srcPos + i];
            }
        }
        else if(srcPos > destPost){
            for(int i = 0; i < length; i++){
                dest[destPost + i] = src[srcPos + i];
            }
        }
    }

}
