package lc_1036;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/*
 *@author: �ƺ�
 *@date : 2022��1��11��
 *@todo:1036. ������Թ�
��һ�� 106 x 106 �������У�ÿ�������Ϸ��������Ϊ (x, y) ��

���ڴ�Դ���� source = [sx, sy] ��ʼ��������ͼ����Ŀ�귽�� target = [tx, ty] ������ blocked �Ƿ����ķ����б�����ÿ�� blocked[i] = [xi, yi] ��ʾ����Ϊ (xi, yi) �ķ����ǽ�ֹͨ�еġ�

ÿ���ƶ����������ߵ����������ĸ����������ڵķ���ֻҪ�÷��� �� �ڸ����ķ����б� blocked �ϡ�ͬʱ���������߳�����

ֻ���ڿ���ͨ��һϵ�е��ƶ���Դ���� source ����Ŀ�귽�� target ʱ�ŷ��� true�����򣬷��� false��

 

ʾ�� 1��

���룺blocked = [[0,1],[1,0]], source = [0,0], target = [0,2]
�����false
���ͣ�
��Դ�����޷�����Ŀ�귽����Ϊ�����޷����������ƶ���
�޷��򱱻������ƶ�����Ϊ�����ֹͨ�С�
�޷����ϻ��������ƶ�����Ϊ�����߳�����
ʾ�� 2��

���룺blocked = [], source = [0,0], target = [999999,999999]
�����true
���ͣ�
��Ϊû�з��񱻷���������һ�����Ե���Ŀ�귽��
*/
public class LC_1036 {

}class Solution {
    static int SURROUND = -1;
    static int FOUND = 1;
    static int VALID = 0;
    static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int BOUNDRY = 1000000;
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        if (blocked.length < 2){
            return true;
        }
        int n = blocked.length * (blocked.length - 1) / 2;
        Set<Block> set = new HashSet<>();
        for (int[] bs : blocked){
            set.add(new Block(bs[0], bs[1]));
        }
        int res = bfs(set, source, target, n);
        if (res == SURROUND){
            return false;
        }else if (res == FOUND){
            return true;
        }else{
            res = bfs(set, target, source, n);
            return res == VALID;
        }
    }
    public int bfs(Set<Block> set, int[] source, int[] target, int n){
        Set<Block> visited = new HashSet<>();
        Queue<Block> queue = new ArrayDeque<>();
        Block sourceBlock = new Block(source[0], source[1]);
        queue.offer(sourceBlock);
        visited.add(sourceBlock);
        int curBlock = 0;
        while (!queue.isEmpty()){
            Block point = queue.poll();
            int x = point.x, y = point.y;
            for (int[] dir : dirs){
                int dx = x +dir[0], dy = y + dir[1];
                Block newBlock = new Block(dx, dy);
                if (dx >= 0 && dy >=0 && dx < BOUNDRY && dy < BOUNDRY && !visited.contains(newBlock) &&
                    !set.contains(newBlock)){
                    curBlock++;
                    if (dx == target[0] && dy == target[1]){
                        return FOUND;
                    }
                    if (curBlock > n){
                        return VALID;
                    }
                    visited.add(newBlock);
                    queue.offer(newBlock);
                }
            }
        }
        return SURROUND;
    }
    class Block{
        int x;
        int y;
        Block(int x, int y){
            this.x = x;
            this.y = y;
        }
        @Override
        public boolean equals(Object obj){
            if (obj instanceof Block){
                Block b = (Block) obj;
                return b.x == this.x && b.y == this.y;
            }
            return false;
        }

        @Override
        public int hashCode(){
            return ((int)(x << 20) | y);
        }
    }
}
