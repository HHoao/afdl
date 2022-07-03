package lc_303;

/*
 *@author: �ƺ�
 *@date : 2021��7��30��
 *@todo:303. ����ͼ��� - ���鲻�ɱ�
����һ����������  nums�������������� i �� j��i �� j����Χ��Ԫ�ص��ܺͣ����� i��j ���㡣

ʵ�� NumArray �ࣺ

NumArray(int[] nums) ʹ������ nums ��ʼ������
int sumRange(int i, int j) �������� nums ������ i �� j��i �� j����Χ��Ԫ�ص��ܺͣ����� i��j ���㣨Ҳ���� sum(nums[i], nums[i + 1], ... , nums[j])��
*/
public class LC_303 {
	public static void main(String[] args) {
	}
}
class NumArray {
    int[] sums;
    public NumArray(int[] nums) {
        sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++){
            sums[i] = sums[i - 1] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
    	if (left == 0) {
    		return sums[right];
    	}
    	return sums[right] - sums[left - 1];
    }
}