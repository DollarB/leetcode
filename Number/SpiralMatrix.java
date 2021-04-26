//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
//
//
//
// 示例 1：
//
//
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
//
//
// 示例 2：
//
//
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
//
//
//
//
// 提示：
//
//
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 10
// -100 <= matrix[i][j] <= 100
//
// Related Topics 数组

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 *
 * @Author: DollarB
 * @Email: byxochitl@gmail.com
 * @Date: 2021/04/27 00:22
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> num = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return num;
        }

        int left = 0, right = matrix[0].length - 1;
        int top = 0, down = matrix.length - 1;
        while (true) {
            // 第一个数组
            for (int i = left; i <= right; i++) {
                num.add(matrix[top][i]);
            }
            top++;
            if (top > down) {
                break;
            }
            // 第二个数组和第三个数组最大的数字
            for (int i = top; i <= down; i++) {
                num.add(matrix[i][right]);
            }
            right--;
            if (left > right) {
                break;
            }
            for (int i = right; i >= left; i--) {
                num.add(matrix[down][i]);
            }
            down--;
            if (top > down) {
                break;
            }
            for (int i = down; i >= top; i--) {
                num.add(matrix[i][left]);
            }
            left++;
            if (left > right) {
                break;
            }
        }
        return num;
    }
}
