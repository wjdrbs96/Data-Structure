#include <stdio.h>
#include<stdlib.h>
#include<malloc.h> 
#include<time.h>
#define max 5
typedef int element;
typedef struct Graphtype
{
	int n;
	int adj[max][max];
}Graphtype;
int visit[max];
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
void insert_edge(Graphtype *p, int start, int end)
{
	if (start >= 0 && start <= p->n && end >= 0 && end <= p->n)
	{
		p->adj[start][end] = 1;
		p->adj[end][start] = 1;
	}
	return;
}
void depth_search(Graphtype *p, int start)
{
	visit[start] = 1;
	int i;
	printf("%d ", start);
	for (i = 0; i < max; i++)
	{
		if (p->adj[start][i] && !visit[i])
		{
			depth_search(p, i);
		}
	}
}
int main()
{
	int i;
	Graphtype s;
	init(&s);
	for (i = 0; i < max; i++)
	{
		insert_vertex(&s, i);
	}
	insert_edge(&s, 0, 1);
	insert_edge(&s, 0, 2);
	insert_edge(&s, 0, 4);
	insert_edge(&s, 3, 4);
	insert_edge(&s, 2, 3);
	insert_edge(&s, 2, 4);
	insert_edge(&s, 1, 2);
	depth_search(&s, 0);
	printf("\n");

}