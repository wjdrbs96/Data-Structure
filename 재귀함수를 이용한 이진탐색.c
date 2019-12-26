#include<stdio.h>
#include<stdlib.h>
#include<time.h>
#define max 9
int search_binary(int list[], int key, int low, int high)
{
	int mid = (low + high) / 2;
	if (low <= high)
	{
		if (list[mid] < key)
		{
			return(search_binary(list, key, mid + 1, high));
		}
		else if (list[mid]>key)
		{
			return(search_binary(list, key, low, mid - 1));
		}
		else
		{
			return mid;
		}
	}
	return -1;
}
int main()
{
	int s[max] = { 1,3,5,6,7,8,11,20,30 };
	printf("%d\n", search_binary(s, 30, 0, 8));

}
