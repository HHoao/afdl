package lc_853;

import java.util.Arrays;

/*
 *@author: �ƺ�
 *@date : 2022��1��24��
 *@todo:853. ����
N  ��������һ������ʻ��λ�� target Ӣ��֮��Ĺ�ͬĿ�ĵء�

ÿ���� i �Ժ㶨���ٶ� speed[i] ��Ӣ��/Сʱ�����ӳ�ʼλ�� position[i] ��Ӣ� �س���ʻ��Ŀ�ĵء�

һ������Զ���ᳬ��ǰ�����һ��������������׷��ȥ������ǰ������ͬ���ٶȽ�������ʻ��

��ʱ�����ǻ������������֮��ľ��룬Ҳ����˵�����Ǳ��ٶ�������ͬ��λ�á�

���� ��һЩ����ʻ����ͬλ�á�������ͬ�ٶȵĳ���ɵķǿռ��ϡ�ע�⣬һ����Ҳ������һ�����ӡ�

����һ������Ŀ�ĵزŸ�����һ�����ӣ�������Ȼ�ᱻ������ͬһ�����ӡ�

 

���ж��ٳ��ӵ���Ŀ�ĵ�?

 

ʾ����

���룺target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
�����3
���ͣ�
�� 10 �� 8 ��ʼ�ĳ������һ�����ӣ������� 12 ��������
�� 0 ����ʼ�ĳ��޷�׷�����������������Լ�����һ�����ӡ�
�� 5 �� 3 ��ʼ�ĳ������һ�����ӣ������� 6 ��������
��ע�⣬�ڵ���Ŀ�ĵ�֮ǰû����������������Щ���ӣ����Դ��� 3��
*/
public class LC_853 {

}
//����
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n == 1 || n == 0) return n;
        Car[] cars = new Car[n];
        for (int i = 0; i < n; i++){
            cars[i] = new Car(position[i], ((double)target - position[i]) / speed[i]);
        }
        Arrays.sort(cars, (a, b)->b.pos-a.pos);
        int count = 1;
        for (int i = 1; i < n; i++){
            if (cars[i].time > cars[i - 1].time){
                count++;
            }else{
                cars[i] = cars[i - 1];
            }
        }
       
        return count;
    }
}
class Car{
    protected int pos;
    protected double time;
    public Car(int pos, double time){
        this.pos = pos;
        this.time = time;
    }
}