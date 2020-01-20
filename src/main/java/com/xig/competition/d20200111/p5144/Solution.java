package com.xig.competition.d20200111.p5144;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Date: 2020-01-11 22:50
 * Author: xig
 * Description:
 * <p>
 * 5144. 矩阵区域和
 * <p>
 * 给你一个 m * n 的矩阵 mat 和一个整数 K ，请你返回一个矩阵 answer ，其中每个 answer[i][j] 是所有满足下述条件的元素 mat[r][c] 的和：
 * <p>
 * i - K <= r <= i + K, j - K <= c <= j + K
 * (r, c) 在矩阵内。
 * <p>
 * <p>
 * 示例 1：
 * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]], K = 1
 * 输出：[[12,21,16],[27,45,33],[24,39,28]]
 * <p>
 * 示例 2：
 * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]], K = 2
 * 输出：[[45,45,45],[45,45,45],[45,45,45]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n, K <= 100
 * 1 <= mat[i][j] <= 100
 */
public class Solution {

    public static void main(String[] args) {
        
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        int k = 1;

        int[][] out = new Solution().matrixBlockSum(mat, k);
        System.out.println();
        
    }
    
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] out = new int[m][n];
        int value = 0;

        // 扩展矩阵
        int[][] extendMatrix = new int[m + 2 *K][n + 2 * K];
        for (int[] elem : extendMatrix) {
            Arrays.fill(elem, 0);
        }
        for (int i = 0; i < m; i++) {
            System.arraycopy(mat[i], 0, extendMatrix[i + K], K, n);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                out[i][j] = getValue(extendMatrix, i + K, j + K, K);
            }
        }
        return out;
    }
    
    private static int getValue(int[][] matrix, int i, int j, int K) {
        int value = 0;
        for (int r = i - K; r <= i + K; r++) {
            for (int c = j - K; c <= j + K; c++) {
                value += matrix[r][c];
            }
        }
        return value;
    }

}
