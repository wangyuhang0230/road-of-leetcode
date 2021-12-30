package com.wyh.leetcode.java;

import java.util.HashMap;
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

}

 class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }