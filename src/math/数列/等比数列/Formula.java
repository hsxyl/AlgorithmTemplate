package math.数列.等比数列;

import static algorithm.二分.快速幂.quickPower;

/**
 * @author xushenbao
 * @desc 添加描述
 * @create 2020/7/8
 */
public interface Formula {
    /**
     * 等比数列求和
     * @param a0 首项
     * @param q 比例系数
     * @param n 项数
     * @return
     */
    static Integer sumOfGeometricProgression(Integer a0,Integer q,Integer n,Integer mod) {

        return a0 * quickPower(1-q,n,mod)/(1-q);
    }

//region 私有属性
//endregion

//region 构造方法
//endregion

//region 私有方法
//endregion

//region 公共方法
//endregion

}
