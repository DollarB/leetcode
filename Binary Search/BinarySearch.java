/**
 * 二分查找算法
 *
 * @Author: DollarB
 * @Email: byxochitl@gmail.com
 * @Date: 2021/01/19 21:49
 */
public class BinarySearch {

    public static int binarySearch(int[] array, int a) {
        int low = 0;
        int high = array.length - 1;
        int mid;

        if (a < array[low] || a > array[high] || low > high) {
            return -1;
        }

        while (low <= high) {
            mid = (high - low) / 2 + low;
            if (array[mid] == a) {
                return mid;
            } else if (a > array[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
