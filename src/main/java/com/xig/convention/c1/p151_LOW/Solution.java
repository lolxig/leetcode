package com.xig.convention.c1.p151_LOW;

/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 *
 *
 * 示例 2：
 *
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 *
 *
 * 示例 3：
 *
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *  
 *
 * 说明：
 *
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *  
 *
 * 进阶：
 *
 * 请选用 C 语言的用户尝试使用 O(1) 额外空间复杂度的原地解法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class Solution {

    public static void main(String[] args) {

        String s = "the sky is blue";
        String res = new Solution().reverseWords(s);

        System.out.println(res);

    }

    public String reverseWords(String s) {

        if (s == null || s.length() == 0) {
            return "";
        }

        String res = "";
        String word;

        for (int index = 0; index < s.length(); ) {
            word = "";

            while (index < s.length() && (s.charAt(index) == ' ')) {    // 滤除空格
                index++;
            }
            while (index < s.length() && (s.charAt(index) != ' ')) {
                word += s.charAt(index++);
            }

            res = word + ' ' + res;
        }

        if (res.equals(" ")) {
            return "";
        }

        return res.charAt(0) != ' ' ? res.substring(0, res.length() - 1) : res.substring(1, res.length() -1);
    }

}
