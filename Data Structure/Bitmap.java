/**
 * 位图
 *
 * @Author: DollarB
 * @Email: byxochitl@gmail.com
 * @Date: 2021/01/19 00:11
 */
public class Bitmap {

    private byte[] bytes;
    private int length;

    public Bitmap(int length) {
        this.length = length;
        bytes = new byte[length % 8 == 0 ? length / 8 : length / 8 + 1];
    }

    public boolean get(int index) {
        int i = index & 7;
        if ((bytes[index >> 3] & (01111111 >>> (7 - i))) >> i == 0) {
            return false;
        } else {
            return true;
        }
    }

    public void set(int index, boolean value) {
        if (value) {
            bytes[index >> 3] |= 1 << (index & 7);
        } else {
            bytes[index >> 3] &= ~(1 << (index & 7));
        }
    }

    public void add(int index) {
        set(index, true);
    }

    public void delete(int index) {
        set(index, false);
    }
}
