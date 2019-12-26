#include <stdio.h>
#include<stdlib.h>
#include<malloc.h> 
#include<time.h>
#define max 6
typedef int element;
int visit[max];
typedef struct Graphtype
{
	int n;
	int adj[max][max];
}Graphtype;
typedef struct
{
	int front, rear;
	element data[max];
}qtype;
void qinit(qtype *p)
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
		printf("큐포화에러\n");
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
		printf("큐공백에러\n");
		exit(1);
	}
	else
	{
		p->front = (p->front + 1) % max;
		return(p->data[p->front]);
	}
}
void init(Graphtype *p)
{
	p->n = 0;
	for (int i = 0; i < max; i++)
	{
		for (int k = 0; k < max; k++)
		{
			p->adj[i][k] = 0;
		}
	}
}
void insert_vertex(Graphtype *p)
{
	if (p->n > max)
	{
		return;
	}
	p->n++;
}
void bre_first_search(Graphtype *p, int v)
{
	int i;
	qtype s;
	qinit(&s);
	visit[v] = 1;
	enq(&s, v);
	printf("%d ", v);
	while (!is_empty(&s))
	{
		v = deq(&s);
		for (i = 0; i < p->n; i++)
		{
			if (!visit[i] && p->adj[v][i])
			{
				printf("%d ", i);
				visit[i] = 1;
				enq(&s, i);
			}
		}
	}
}
void insert_edge(Graphtype *p, int start, int end)
{
	if (start >= 0 && start <= p->n && end >= 0 && end <= p->n)
	{
		p->adj[start][end] = 1;
	}
	return;
}
int main()
{
	Graphtype s;
	init(&s);
	int i;
	for (i = 0; i < max; i++)
	{
		insert_vertex(&s, i);
	}
	insert_edge(&s, 0, 1);
	insert_edge(&s, 0, 3);
	insert_edge(&s, 1, 2);
	insert_edge(&s, 1, 4);
	insert_edge(&s, 1, 5);
	insert_edge(&s, 2, 5);
	insert_edge(&s, 4, 5);
	bre_first_search(&s, 0);
	printf("\n");
}