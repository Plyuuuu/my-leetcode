package github.veikkoroc.Competition.LeetCode.JD215;

import java.util.ArrayList;
import java.util.List;

/**
 * 有 n 个 (id, value) 对，其中 id 是 1 到 n 之间的一个整数，value 是一个字符串。不存在 id 相同的两个 (id, value) 对。
 *
 * 设计一个流，以 任意 顺序获取 n 个 (id, value) 对，并在多次调用时 按 id 递增的顺序 返回一些值。
 *
 * 实现 OrderedStream 类：
 *
 * OrderedStream(int n) 构造一个能接收 n 个值的流，并将当前指针 ptr 设为 1 。
 * String[] insert(int id, String value) 向流中存储新的 (id, value) 对。存储后：
 * 如果流存储有 id = ptr 的 (id, value) 对，则找出从 id = ptr 开始的 最长 id 连续递增序列 ，并 按顺序 返回与这些 id 关联的值的列表。然后，将 ptr 更新为最后那个  id + 1 。
 * 否则，返回一个空列表。
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/15 10:40
 */
public class OrderedStream {

    /**
       用字符串数组模拟流
     */
    String[] stream ;

    /**
     * 辅助指针
     */
    private int ptr = 1;
    public OrderedStream(int n) {
        this.stream = new String[n+1];
    }

    public List<String> insert(int id, String value) {
        // 插入（id，value）
        stream[id] = value;

        // 创建返回结果
        List<String> res = new ArrayList<>();

        // 如果指针指向的位置插入了值，就把所有连续的值输出
        while (ptr<stream.length&&stream[ptr] != null){
            res.add(stream[ptr]);
            ptr++;
        }

        return res;
    }
}
