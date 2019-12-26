#include<stdio.h>
#include<stdlib.h>
#include<time.h>
#define max 10
#define SWAP(x,y,t) ((t)=(x), (x)=(y),(y)=(t))
int list[max];
int n;

int partition(int list[], int left, int right)
{
	int pivot, temp;
	int low, high;
	low = left;
	high = right + 1;
	pivot = list[left];
	do {
		do
		{
			low++;
		} while (list[low] < pivot);
		do
		{
			high--;
		} while (list[high] > pivot);
		if (low < high) SWAP(list[low], list[high], temp);
	} while (low < high);
	SWAP(list[left], list[high], temp);
	return high;
}
void quick_sort(int list[], int left, int right)
{
	if (left < right)
	{
		int q = partition(list, left, right);
		quick_sort(list, left, q - 1);
		quick_sort(list, q + 1, right);
	}
}
int main()
{
	int i;
	n = max;
	srand(time(NULL));
	printf("정렬전\n");
	for (i = 0; i < max; i++)
	{
		list[i] = rand() % 100;
		printf("%d ", list[i]);
	}
	printf("\n\n");
	quick_sort(list, 0, n - 1);
	printf("정렬후\n");
	for (i = 0; i < max; i++)
	{
		printf("%d ", list[i]);
	}
	printf("\n");
}