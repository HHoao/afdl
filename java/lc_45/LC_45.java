package lc_45;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author �ƺ�
 *45. ��Ծ��Ϸ II
����һ���Ǹ��������飬�����λ������ĵ�һ��λ�á�

�����е�ÿ��Ԫ�ش������ڸ�λ�ÿ�����Ծ����󳤶ȡ�

���Ŀ����ʹ�����ٵ���Ծ����������������һ��λ�á�

ʾ��:

����: [2,3,1,1,4]
���: 2
����: �������һ��λ�õ���С��Ծ���� 2��
     ���±�Ϊ 0 �����±�Ϊ 1 ��λ�ã��� 1 ����Ȼ���� 3 ��������������һ��λ�á�
˵��:

���������ǿ��Ե�����������һ��λ�á�
 */
public class LC_45 {

}
//������ҳ���λ��
class Solution {
    public int jump(int[] nums) {
        int position = nums.length - 1;
        int steps = 0;
        while (position > 0) {
            for (int i = 0; i < position; i++) {
                if (i + nums[i] >= position) {
                    position = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }
}
//������ҿɵ�������λ��
class Solution1 {
    public int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0; 
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]); 
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
//̰���㷨
class Solution2 {

    //̰���㷨��
    //����ǰ����λ��i�ϣ�������һ����Ծ�Ŀ�ѡ��ΧΪ����[i+1, i+nums[i]]��
    //��������[i+1, i+nums[i]]�е�ÿ���㣬������ÿ������¸��Ƿ�Χ��
    //������λ��i�ϵ���һ����Ծ��������[i+1, i+nums[i]]��ѡ���¸��Ƿ�Χ����λ�á�

    public int jump(int[] nums) {
        return bfs(nums);
        
    }

    private int bfs(int[] nums) {
        int n = nums.length;
        Deque<Integer> queue = new LinkedList<>();
        queue.add(0);
        int step = 0;

        while(!queue.isEmpty()) {
            int queueSize = queue.size();
            while(queueSize-- > 0) {
                int curr = queue.poll();

                //��ǰ�㼴��Ŀ��λ�ã�ֱ�ӷ���step
                if(curr == n-1) {
                    return step;
                }

                //��ǰ��ĸ��Ƿ�Χ����Ŀ��λ�ã�ֱ�ӷ���step+1
                if(curr + nums[curr] >= n-1) {
                    return 1 + step;
                }

                //̰�ģ�ÿ����Ծѡ���ܹ�ʹ�µĸ��Ƿ�Χ����λ��
                int maxCover = 0;
                int nextPosition = -1;
                for(int i = 1; i <= nums[curr]; i++) {
                    int tmp = curr + i;
                    if(tmp < n && maxCover < tmp + nums[tmp]) {
                        maxCover = tmp + nums[tmp];
                        nextPosition = tmp;
                    }
                }
                //���µ�������Ծ�������в�ʹ������1
                if(nextPosition != -1) {
                    queue.offer(nextPosition);
                    step++;
                }
                   
            }
            
        }
        return step;
    }
    
    
   
}