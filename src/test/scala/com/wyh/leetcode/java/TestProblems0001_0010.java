package com.wyh.leetcode.java;

import org.junit.Test;

import java.util.Arrays;

public class TestProblems0001_0010 {

    private static Problems0001_0010 problems = new Problems0001_0010();

    @Test
    public void testProblem0001(){
        System.out.println(Arrays.toString(problems.twoSum2(new int[]{2, 7, 11, 15}, 9)));
    }

    @Test
    public void testProblem0003(){System.out.println(problems.lengthOfLongestSubstring3("abcabcbb"));}

    @Test
    public void testProblem0004(){System.out.println(problems.findMedianSortedArrays(new int[]{1,3}, new int[]{2}));}
}
