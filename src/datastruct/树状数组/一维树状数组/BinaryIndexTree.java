package datastruct.树状数组.一维树状数组;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.IntStream;

import static algorithm.二分.二分搜索.lower_search;
import static algorithm.二分.二分搜索.upper_search;

/**
 * @author xushenbao
 * @desc 树状数组
 * @create 2020/7/8
 */
public class BinaryIndexTree {

//region 私有属性
    private int[] indexs;
    private int[] tree;
    private Type type;
//endregion

//region 构造方法

    public BinaryIndexTree(int[] indexs, int[] valueList, Type type) {
        if (indexs == null || indexs.length == 0) {
            throw new IllegalArgumentException(indexs == null ? "indexs为null" : "indexs大小为0");
        }
        init(indexs, valueList,type);
    }

    /**
     * @param indexList
     */
    public BinaryIndexTree(List<Integer> indexList, List<Integer> valueList, Type type) {
        if (indexList == null || indexList.size() == 0) {
            throw new IllegalArgumentException(indexList == null ? "indexList为Null" : "indexList大小为0");
        }
        init(indexList.stream().mapToInt(Integer::intValue).toArray(), valueList.stream().mapToInt(Integer::intValue).toArray(),type);
    }
//endregion

//region 私有方法
    private void init(int[] indexs, int[] valueList,Type type) {
        this.indexs = Arrays.stream(indexs).sorted().toArray();
        checkIndex();
        this.type = type;
        this.tree = IntStream.range(0,this.indexs.length+1).map(e->this.type.initValue).toArray() ;
        for (int i = 0; i < indexs.length; i++) {
            update(indexs[i], valueList[i]);
        }
    }

    private void checkIndex() {
        for (int i = 1; i < indexs.length; i++) {
            if (indexs[i] == indexs[i - 1]) {
                throw new RuntimeException("索引中的数字应该是唯一的,重复数字:" + indexs[i]);
            }
        }
    }

    private int lowBit(int x) {
        return x & (-x);
    }

    private int mapper(int index) {
        int left = lower_search(0,this.indexs.length,index, e->this.indexs[e],Integer::compareTo);
        int right = upper_search(0,this.indexs.length,index, e->this.indexs[e],Integer::compareTo);
        if(right!=left+1){
            throw new RuntimeException(String.format("无对应索引,或索引有重复值,index is %s,left is %s, right is %s",index, left,right));
        }
        return left+1;
    }
    private int query(int index) {
        if(index)
        int res = type.initValue;
        for (int i = index; i < this.tree.length; i += lowBit(i)) {
            tree[i] = type.addOrUpdateOperation.apply(res,this.tree[i]);
        }
        return res;
    }

//endregion

//region 公共方法

    /**
     * 更新
     * @param index
     * @param x
     */
    public void update(int index, int x) {
        for (int i = mapper(index); i < this.tree.length; i += lowBit(i)) {
            tree[i] = type.addOrUpdateOperation.apply(x,this.tree[i]);
        }
    }

    /**
     * 树状数组区间查询
     * @param left 左闭
     * @param right 右闭
     * @return
     */
    public int query(int left, int right) {
        for(int )
        return query(mapper(right)) - query(mapper(left)-1);
    }

//endregion

//region 公共类
    public enum Type {
        SUM(0, Integer::sum,Integer::sum),
        MAX(Integer.MIN_VALUE,Integer::max,Integer::max),
        MIN(Integer.MAX_VALUE,Integer::min,Integer::min);
        int initValue;
        BiFunction<Integer,Integer,Integer> addOrUpdateOperation;
        BiFunction<Integer,Integer,Integer> queryOperation;

        Type(int initValue, BiFunction<Integer, Integer, Integer> addOrUpdateOperation, BiFunction<Integer, Integer, Integer> queryOperation) {
            this.initValue = initValue;
            this.addOrUpdateOperation = addOrUpdateOperation;
            this.queryOperation = queryOperation;
        }
    }
// endregion
    public static void main(String[] args) {
        int[] index = IntStream.of(1,3,5,7).toArray();
        int[] value = IntStream.of(1,1,1,1).toArray();
        BinaryIndexTree tree = new BinaryIndexTree(index,value,Type.SUM);
        System.out.println(tree.query(1, 7));

    }
}
