package com.xig.competition.d20200111.p5303;

/**
 * Created with IntelliJ IDEA.
 * Date: 2020-01-05 12:30
 * Author: xig
 * Description:
 *
 * 5303. 解码字母到整数映射
 *
 * 给你一个字符串 s，它由数字（'0' - '9'）和 '#' 组成。我们希望按下述规则将 s 映射为一些小写英文字符：
 *
 * 字符（'a' - 'i'）分别用（'1' - '9'）表示。
 * 字符（'j' - 'z'）分别用（'10#' - '26#'）表示。 
 * 返回映射之后形成的新字符串。
 *
 * 题目数据保证映射始终唯一。
 *
 *  
 *
 * 示例 1：
 * 输入：s = "10#11#12"
 * 输出："jkab"
 * 解释："j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
 *
 * 示例 2：
 * 输入：s = "1326#"
 * 输出："acz"
 *
 * 示例 3：
 * 输入：s = "25#"
 * 输出："y"
 *
 * 示例 4：
 * 输入：s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"
 * 输出："abcdefghijklmnopqrstuvwxyz"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s[i] 只包含数字（'0'-'9'）和 '#' 字符。
 * s 是映射始终存在的有效字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decrypt-string-from-alphabet-to-integer-mapping
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public static void main(String[] args) {
        String s = "10#11#12";
        System.out.println(new Solution().freqAlphabets(s));
    }

    public String freqAlphabets(String s) {
        char[] out = new char[1000];
        int tail = 1000;
        int len = 0;
        char[] map = new char[26];
        for (int i = 0; i < 26; i++) {
            map[i] = (char)('a' + i);
        }
        for (int i = s.length() - 1; i >= 0; --i) {
            char ch = s.charAt(i);
            if (ch == '#') {
                out[--tail] = map[Integer.parseInt(s.substring(i - 2, i)) - 1];
                i -= 2;
            } else {
                out[--tail] = map[ch - 49];
            }
            ++len;
        }
        return new String(out, tail, len);
    }

}
