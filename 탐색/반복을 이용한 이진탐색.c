#include<stdio.h>
#include<stdlib.h>
#include<time.h>
#define max 9
int search_binary(int list[], int key, int low, int high)
{
	int mid;
	while (low <= high)
	{
		mid = (low + high) / 2;
		if (key == list[mid])
			return mid;
		else if (key > list[mid])
			low = mid + 1;
		else
			high = mid - 1;
	}
	return -1;
}
int main()
{
	int s[max] = { 1,3,5,6,7,8,11,20,30 };
	printf("%d\n", search_binary(s, 30, 0, 8));

}
