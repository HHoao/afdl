package lc_80;

/**
 * @author �ƺ�
 *80. ɾ�����������е��ظ��� II
����һ�������������� nums ������Ҫ�� ԭ�� ɾ���ظ����ֵ�Ԫ�أ�ʹ��ÿ��Ԫ�����������Σ������Ƴ���������³��ȡ�

��Ҫʹ�ö��������ռ䣬������� ԭ�� �޸��������� ����ʹ�� O(1) ����ռ����������ɡ�

 

˵����

Ϊʲô������ֵ��������������Ĵ��������أ�

��ע�⣬�����������ԡ����á���ʽ���ݵģ�����ζ���ں������޸�����������ڵ������ǿɼ��ġ�

����������ڲ��������£�

// nums ���ԡ����á���ʽ���ݵġ�Ҳ����˵������ʵ�����κο���
int len = removeDuplicates(nums);

// �ں������޸�����������ڵ������ǿɼ��ġ�
// ������ĺ������صĳ���, �����ӡ�������иó��ȷ�Χ�ڵ�����Ԫ�ء�
for (int i = 0; i < len; i++) {
    print(nums[i]);
}
 */
public class LC_80 {
}
//ɾ��������ظ���
class Solution {
    
    public int[] remElement(int[] arr, int index) {
        for (int i = index + 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }
        
        return arr;
    }    
    
    public int removeDuplicates(int[] nums) {
        int i = 1, count = 1, length = nums.length;
        while (i < length) {
            if (nums[i] == nums[i - 1]) {
                
                count++;
                if (count > 2) {
                    
                    this.remElement(nums, i);
                    i--;

                    length--;
                }
            } else {
                count = 1;
            }
                
            i++;
        }
            
        return length;
    }
}
//���Ƕ�����ظ���
class Solution2 {
    
    public int removeDuplicates(int[] nums) {
        int j = 1, count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            if (count <= 2) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}

