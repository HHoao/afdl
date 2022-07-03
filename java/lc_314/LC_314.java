package lc_314;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by macro on 2022/3/25
 *
 * @author hhoa
 **/
public class LC_314 {
}
class NestedIterator implements Iterator<Integer> {
    private final List<Integer> wholeList;
    private final Iterator<Integer> internalIterator;
    private void dfs(List<NestedInteger> nestedList){
        for (NestedInteger integer : nestedList){
            if (integer.isInteger()){
                wholeList.add(integer.getInteger());
            }else{
                dfs(integer.getList());
            }
        }
    }
    public NestedIterator(List<NestedInteger> nestedList) {
        wholeList = new ArrayList<>();
        dfs(nestedList);
        internalIterator = wholeList.iterator();
    }

    @Override
    public Integer next() {
        return internalIterator.next();
    }

    @Override
    public boolean hasNext() {
        return internalIterator.hasNext();
    }
}

/**
 * ����������
 * ���ýⷨһ�����ϵ������������������Ӧ�ö�item��ֵ��ֱ�Ӵ洢����Ӧ�ṩ����;����
 * 1.������������ֹ(���ֵ����)ʱ��ʼ��������ȫ�ֿ����Ǳ�Ҫ.
 * 2.��ʼ���������󣬵����������޷�����List��ĳNestedIntegerֵ(intֵ)�ı�ĳ���.
 */
class NestedIterator2 implements Iterator<Integer> {
    private final List<NestedInteger> nestedList;
    private final int size;
    private int i=0;
    private NestedIterator2 iterator=null;

    public NestedIterator2(List<NestedInteger> nestedList) {
        this.nestedList=nestedList;
        size=nestedList.size();
    }

    @Override
    public Integer next() {
        NestedInteger curr=nestedList.get(i);
        if(curr.isInteger()){
            i++;
            return curr.getInteger();
        }else{
            return iterator.next();
        }
    }

    @Override
    public boolean hasNext() {
        while(i<size){
            NestedInteger curr=nestedList.get(i);
            if(curr.isInteger()){
                return true;
            }else{
                if(iterator==null){
                    iterator=new NestedIterator2(curr.getList());
                }

                if(iterator.hasNext()){
                    return true;
                }else{
                    iterator=null;
                    i++;
                }
            }
        }

        return false;
    }
}