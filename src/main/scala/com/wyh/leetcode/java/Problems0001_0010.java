package com.wyh.leetcode.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

class Problems0001_0010 {

    /**
     * 1. 两数之和
     */
    public int[] twoSum(int[] nums, int target) {
        for(int i = nums.length - 1; i >= 0; i--){
            for(int j = 0; j < i; j++){
                if (nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    /**
     * 1. 两数之和
     */
    int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> hashTable = new HashMap<>();
        for(int i = nums.length - 1; i >= 0; i--){
            if (hashTable.containsKey(target - nums[i])) {
                return new int[]{i, hashTable.get(target - nums[i])};
            }
            hashTable.put(nums[i], i);
        }
        return new int[0];
    }

    /**
     * 2. 两数相加
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = null;
        ListNode tail = null;

        int carry = 0;

        while(l1 != null || l2 != null){
            int v1 = l1 != null ? l1.val : 0;
            int v2 = l2 != null ? l2.val : 0;
            int sum = v1 + v2 + carry;
            if (head == null){
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }
        }
        if (carry > 0){
            tail.next = new ListNode(carry);
        }
        return head;
    }

    /**
     * 3. 无重复字符的最长子串
     */
    public int lengthOfLongestSubstring(String s) {
        int length = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for(int i = s.length()-1; i >= 0; i--){
            if (hashMap.containsKey(s.charAt(i))) {
                length = Math.max(length, hashMap.size());
                i = hashMap.get(s.charAt(i));
                hashMap.clear();
            } else {
                hashMap.put(s.charAt(i), i);
                length = Math.max(length, hashMap.size());
            }
        }
        return length;
    }

    /**
     * 3. 无重复字符的最长子串 abcabcbb
     */
    public int lengthOfLongestSubstring2(String s) {
        HashSet<Character> hashSet = new HashSet<>();
        int n = s.length(), result = 0;
        for (int start = 0, end = 0; start < n; ++start){
            while (end < n && !hashSet.contains(s.charAt(end))){
                hashSet.add(s.charAt(end));
                ++end;
            }
            result = Math.max(result, end - start);
            hashSet.remove(s.charAt(start));
        }
        return result;
    }

    /**
     * 3. 无重复字符的最长子串 abcabcbb
     */
    public int lengthOfLongestSubstring3(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int n = s.length(), result = 0;

        for(int start = 0, end = 0; end < n; ++end){
            char alpha = s.charAt(end);
            if (hashMap.containsKey(alpha)){
                start = Math.max(start, hashMap.get(alpha) + 1);
            }
            result = Math.max(result, end - start + 1);
            hashMap.put(alpha, end);
        }

        return result;
    }

    /**
     * 4. 寻找两个正序数组的中位数
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] nums = new int[m + n];

        if (m == 0) {
            if (n % 2 == 0) {
                return (nums2[n/2 - 1] + nums2[n/2]) / 2.0;
            } else {
                return nums2[n/2];
            }
        }

        if (n == 0) {
            if (m % 2 == 0){
                return (nums1[m/2 - 1] + nums1[m/2]) / 2.0;
            } else {
                return nums1[m/2];
            }
        }

        for (int i = 0, j = 0; i + j < m + n;) {
            if (i == m) {
                while (j != n){
                    nums[i+j] = nums2[j++];
                }
                break;
            }
            if (j == n) {
                while (i != m){
                    nums[i+j] = nums1[i++];
                }
                break;
            }
            if (nums1[i] < nums2[j]) {
                nums[i+j] = nums1[i++];
            } else {
                nums[i+j] = nums2[j++];
            }
        }

        if (nums.length % 2 == 0) {
            return (nums[nums.length/2 - 1] + nums[nums.length/2]) / 2.0;
        } else {
            return nums[nums.length/2];
        }
    }

    /**
     * 4. 寻找两个正序数组的中位数
     */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {

        int left = 0, right = 0;

        int m = nums1.length;
        int n = nums2.length;

        int size = m + n;

        int i = 0, j = 0;

        do {
            left = right;
            if (i < m && (j >= n || nums1[i] < nums2[j])) {
                right = nums1[i++];
            } else {
                right = nums2[j++];
            }
        } while (i + j != size / 2);

        if ((size & 1) == 0){
            return (left + right) / 2.0;
        } else {
            return right;
        }

    }

}

 class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }