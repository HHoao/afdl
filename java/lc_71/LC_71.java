package lc_71;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author �ƺ�
 *71. ��·��
����һ���ַ��� path ����ʾָ��ĳһ�ļ���Ŀ¼�� Unix ��� ����·�� ���� '/' ��ͷ�������㽫��ת��Ϊ���Ӽ��Ĺ淶·����

�� Unix �����ļ�ϵͳ�У�һ���㣨.����ʾ��ǰĿ¼�������⣬������ ��..�� ��ʾ��Ŀ¼�л�����һ����ָ��Ŀ¼�������߶������Ǹ������·������ɲ��֡�������������б�ܣ�����'//'��������Ϊ����б�� '/' �� ���ڴ����⣬�κ�������ʽ�ĵ㣨���磬'...'��������Ϊ�ļ�/Ŀ¼���ơ�

��ע�⣬���ص� �淶·�� ������ѭ������ʽ��

ʼ����б�� '/' ��ͷ��
����Ŀ¼��֮�����ֻ��һ��б�� '/' ��
���һ��Ŀ¼����������ڣ����� �� '/' ��β��
���⣬·���������Ӹ�Ŀ¼��Ŀ���ļ���Ŀ¼��·���ϵ�Ŀ¼���������� '.' �� '..'����
���ؼ򻯺�õ��� �淶·�� ��
 */
public class LC_71 {

}
class Solution {
    public String simplifyPath(String path) {
            String[] pathArray = path.split("/");
        //�ָ��ļ������ �ո�˵���Ƕ������/��.. .��Ŀ¼
        StringBuilder res =new StringBuilder();
        Deque<String> stack = new ArrayDeque<>();
        for(int i=0;i<pathArray.length;i++){
            //2�������ջΪ�ջ���ջ��Ϊ��
            if(pathArray[i].length()==0||pathArray[i].equals("."))    continue;
            if(!stack.isEmpty()){
                if(pathArray[i].equals("..")){
                    stack.pop();
                }else{
                    stack.push(pathArray[i]);
                }
            }else{
                if(!pathArray[i].equals(".."))  stack.push(pathArray[i]);
            }
        }
        if(stack.isEmpty())    return res.append('/').toString();
        while(!stack.isEmpty()){
            res.insert(0,stack.pop());
            res.insert(0,'/');
        }
        return res.toString();
    }
}
