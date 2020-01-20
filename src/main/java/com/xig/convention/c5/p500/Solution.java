package com.xig.convention.c5.p500;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示。
 *
 *  
 *
 *
 *
 *  
 *
 * 示例：
 *
 * 输入: ["Hello", "Alaska", "Dad", "Peace"]
 * 输出: ["Alaska", "Dad"]
 *  
 *
 * 注意：
 *
 * 你可以重复使用键盘上同一字符。
 * 你可以假设输入的字符串将只包含字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/keyboard-row
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class Solution {

    public static void main(String[] args) {

        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
        String[] res = new Solution().findWords(words);

        System.out.println();
    }

    public String[] findWords(String[] words) {

        if (words == null || words.length == 0) {
            return new String[0];
        }

        int[] map = new int[127];

        map['q'] = 1; map['Q'] = 1; map['w'] = 1; map['W'] = 1; map['e'] = 1; map['E'] = 1;
        map['r'] = 1; map['R'] = 1; map['t'] = 1; map['T'] = 1; map['y'] = 1; map['Y'] = 1;
        map['u'] = 1; map['U'] = 1; map['i'] = 1; map['I'] = 1; map['o'] = 1; map['O'] = 1;
        map['p'] = 1; map['P'] = 1;

        map['a'] = 2; map['A'] = 2; map['s'] = 2; map['S'] = 2; map['d'] = 2; map['D'] = 2;
        map['f'] = 2; map['F'] = 2; map['g'] = 2; map['G'] = 2; map['h'] = 2; map['H'] = 2;
        map['j'] = 2; map['J'] = 2; map['k'] = 2; map['K'] = 2; map['l'] = 2; map['L'] = 2;

        map['z'] = 3; map['Z'] = 3; map['x'] = 3; map['X'] = 3; map['c'] = 3; map['C'] = 3;
        map['v'] = 3; map['V'] = 3; map['b'] = 3; map['B'] = 3; map['n'] = 3; map['N'] = 3;
        map['m'] = 3; map['M'] = 3;

        List<String> res_t = new ArrayList<>();

        for (String word : words) {
            boolean flag = true;
            int type = map[word.charAt(0)];
            for (int i = 1; i < word.length(); ++i)
                if (type != map[word.charAt(i)]) {
                    flag = false;
                    break;
                }
            if (flag) res_t.add(word);
        }

        String[] res = new String[res_t.size()];
        res_t.toArray(res);
        
        return res;
    }

}
