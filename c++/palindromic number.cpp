/*
  时间：2020年2月23日13:35:08
  目的：验证一个数是否是回文数
*/


#include <stdio.h>

int main(void)
{
	int m = 0;
	int i;
	int n;
	
	printf("请输入一个数:");
	scanf("%d",&i);
	n = i;
    
	while (i)
	{
        m = m*10 + i%10;
	    i = i/10;
	}
    
	if (m == n)
	{
		printf("该数是回文数\n");
	}
	else
		printf("该数不是回文数\n");
   
	return 0;
}

/*
  在Vc++6.0中的输出结果是：
-----------------------------
请输入一个数：121
该数是回文数
-----------------------------
*/