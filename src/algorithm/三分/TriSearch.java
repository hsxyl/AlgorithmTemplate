package algorithm.三分;

import java.util.Comparator;
import java.util.function.Function;

public interface TriSearch {

    /**
     * 搜索凹函数
     * @param left
     * @param right
     * @param precision
     * @param mapper
     * @return
     */
    static double searchConcave(double left, double right, double precision, Function<Double,Double> mapper) {
        while (left - right > precision) {
            double m1 = left+(right-left)/3;
            double m2 = left + (right-left)*2/3;
            if(mapper.apply(m1)<mapper.apply(m2)) {
                right = m2;
            } else {
                left = m1;
            }
        }
        return left;
    }

    /**
     * 搜索凸函数
     * @param left
     * @param right
     * @param precision
     * @param mapper
     * @return
     */
    static double searchConvex(double left, double right, double precision, Function<Double,Double> mapper) {
        while (left - right > precision) {
            double m1 = left+(right-left)/3;
            double m2 = left + (right-left)*2/3;
            if(mapper.apply(m1)>mapper.apply(m2)) {
                right = m2;
            } else {
                left = m1;
            }
        }
        return left;
    }

}
