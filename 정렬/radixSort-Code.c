#include<stdio.h>
#include<stdlib.h>
#include<time.h>
#define max 8
typedef int element;
typedef struct
{
	int front, rear;
	element data[max];
}qtype;
void init(qtype *p)
{
	p->front = p->rear = 0;
}
int is_empty(qtype *p)
{
	return(p->front == p->rear);
}
int is_full(qtype *p)
{
	return((p->rear + 1) % max == p->front);
}
void enq(qtype *p, element item)
{
	if (is_full(p))
	{
		fprintf(stderr, "큐포화에러\n");
		return;
	}
	else
	{
		p->rear = (p->rear + 1) % max;
		p->data[p->rear] = item;
	}
}
element deq(qtype *p)
{
	if (is_empty(p))
	{
		fprintf(stderr, "큐공백에러\n");
		exit(1);
	}
	else
	{
		p->front = (p->front + 1) % max;
		return(p->data[p->front]);
	}
}
void radix_sort(int list[], int n)
{
	int i, k = 0, j = 0;
	qtype s[10];
	for (i = 0; i < 10; i++)
		init(&s[i]);
	for (i = 0; i < max; i++)
	{
		enq(&s[list[i] % 10], list[i]);
	}
	for (i = 0; i < 10; i++)
	{
		while (!is_empty(&s[k]))
		{
			list[j] = deq(&s[k]);
			j++;
		}
		k++;
	}
	for (i = 0; i < max; i++)
	{
		enq(&s[list[i] / 10], list[i]);
	}
	j = 0, k = 0;
	for (i = 0; i < 10; i++)
	{
		while (!is_empty(&s[k]))
		{
			list[j] = deq(&s[k]);
			j++;
		}
		k++;
	}
}
int main()
{
	int list[max] = { 42,60,75,81,10,23,12,18 };
	radix_sort(list, max);
	for (int i = 0; i < max; i++)
	{
		printf("%d ", list[i]);
	}
	printf("\n");
}