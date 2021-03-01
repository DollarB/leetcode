/**
 * 基数排序
 *
 * @Author: DollarB
 * @Email: byxochitl@gmail.com
 * @Date: 2021/01/20 22:11
 */
public class RadixSort {

    public static int[] radixSort(int[] array, int maxDigit) {
        double max = Math.pow(10, maxDigit + 1);
        int n = 1;
        int k = 0;
        int length = array.length;
        int[][] bucket = new int[10][length];
        int[] order = new int[length];
        while (n < max) {
            for (int num : array) {
                int digit = (num / n) % 10;
                bucket[digit][order[digit]] = num;
                order[digit]++;
            }

            for (int i = 0; i < length; i++) {
                if (order[i] != 0) {
                    for (int j = 0; j < order[i]; j++) {
                        array[k] = bucket[i][j];
                        k++;
                    }
                }
                order[i] = 0;
            }
            n *= 10;
            k = 0;
        }
        return array;
    }
}
