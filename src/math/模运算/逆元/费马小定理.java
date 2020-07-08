package math.模运算.逆元;

import static algorithm.二分.快速幂.quickPower;

/**
 * @author xushenbao
 * @desc 添加描述
 * @create 2020/7/8
 */
public interface 费马小定理 {

    static int inv(int num,int mod) {
        return quickPower(num,mod-2,mod);
    }
}
