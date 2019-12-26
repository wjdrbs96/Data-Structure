#include<stdio.h>
#include<stdlib.h>
#include<time.h>
#define max 12
typedef struct
{
	int key;
}element;
typedef struct
{
	element heap[max];
	int heap_size;
}heaptype;
void init(heaptype *p)
{
	p->heap_size = 0;
}
void insert_heap(heaptype *p, element data)
{
	int i = ++p->heap_size;
	while (i != 1 && p->heap[i / 2].key<data.key)
	{
		p->heap[i] = p->heap[i / 2];
		i /= 2;
	}
	p->heap[i] = data;
}
element delete_heap(heaptype *p)
{
	int parent, child;
	element item, temp;
	item = p->heap[1];
	temp = p->heap[p->heap_size--];
	parent = 1, child = 2;
	while (child <= p->heap_size)
	{
		if (child < p->heap_size && p->heap[child].key < p->heap[child + 1].key)
			child++;
		if (temp.key >= p->heap[child].key)
			break;
		p->heap[parent] = p->heap[child];
		parent = child;
		child *= 2;
	}
	p->heap[parent] = temp;
	return item;  //최대값 반환

}
int main()
{
	heaptype s;
	init(&s);
	element k[max];
	srand(time(NULL));
	for (int i = 1; i < max; i++)
	{
		k[i].key = rand() % 50;
		insert_heap(&s, k[i]);
	}
	for (int i = 1; i < max; i++)
	{
		k[i] = delete_heap(&s);
	}
	for (int i = 1; i < max; i++)
	{
		printf("%d ", k[i].key);
	}
	printf("\n");
}