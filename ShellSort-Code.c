#include<stdio.h>
#include<stdlib.h>
#include<time.h>
#define max 11
void insertion_sort(int list[], int first, int last, int gap)
{
	int i, j, key;
	for (i = first + gap; i <= last; i = i + gap)
	{
		key = list[i];
		for (j = i - gap; j >= first && key < list[j]; j = j - gap)
			list[j + gap] = list[j];
		list[j + gap] = key;
	}
}
void shell_sort(int list[], int n)
{
	int i, gap;
	for (gap = n / 2; gap > 0; gap = gap / 2)
	{
		if (gap % 2 == 0)gap++;
		for (i = 0; i<gap; i++)
			insertion_sort(list, i, n - 1, gap);
	}
	printf("\n\n정렬후\n");
	for (i = 0; i < max; i++)
	{
		printf("%d ", list[i]);
	}
	printf("\n");
}
int main()
{
	int list[max] = { 10,8,6,20,4,3,22,1,0,15,16 };
	int i;
	printf("정렬전\n");
	for (i = 0; i < max; i++)
	{
		printf("%d ", list[i]);
	}
	shell_sort(list, max);
}