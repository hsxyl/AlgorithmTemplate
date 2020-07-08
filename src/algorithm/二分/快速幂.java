package algorithm.二分;

/**
 * @author xushenbao
 * @desc 添加描述
 * @create 2020/7/8
 */
public interface 快速幂 {
    public static int quickPower(int base, int power, int mod) {
        long res = 1;
        long b = base;
        while (power > 0) {
            if (power % 2 != 0) {
                res *= b;
                res %= mod;
            }
            b *= b;
            b %= mod;
            power >>= 1;
        }
        return (int) (res % mod);
    }

}
