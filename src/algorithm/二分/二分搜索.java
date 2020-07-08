package algorithm.二分;

import java.util.Comparator;
import java.util.function.Function;

/**
 * @author xushenbao
 * @desc 添加描述
 * @create 2020/7/8
 */
public interface 二分搜索 {
    /**
     * 对有序序列的[left,right)范围进行二分查找下限
     *
     * @param left          左闭
     * @param right         右开
     * @param indexToObject 下标映射到类
     * @param comparator    比较器
     * @param <T>
     * @return
     */
    static <T> int lower_search(int left, int right, T aim, Function<Integer, T> indexToObject, Comparator<T> comparator) {
        while (left < right) {
            int mid = (left + right) >> 1;
            if (comparator.compare(indexToObject.apply(mid), aim) < 0) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    /**
     * 对有序序列的[left,right)范围进行二分查找上限
     *
     * @param left          左闭
     * @param right         右开
     * @param indexToObject 下标映射到类
     * @param comparator    比较器
     * @param <T>
     * @return 返回第一个大于aim的下标，如果不存在应该配合lower_search一起使用判断
     */
    static <T> int upper_search(int left, int right, T aim, Function<Integer, T> indexToObject, Comparator<T> comparator) {
        while (left < right) {
            int mid = (left + right) >> 1;
            if (comparator.compare(indexToObject.apply(mid), aim) <= 0) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
