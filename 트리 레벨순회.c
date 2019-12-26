#include <stdio.h>
#include<stdlib.h>
#include<malloc.h> 
#include<string.h>
#include<time.h>
#define max 100
typedef struct TreeNode
{
	int data;
	struct TreeNode *left, *right;
}TreeNode;
typedef TreeNode * element;
typedef struct qtype
{
	element data[max];
	int front, rear;
}qtype;

TreeNode n1 = { 1,NULL,NULL };
TreeNode n2 = { 4,&n1,NULL };
TreeNode n3 = { 16,NULL,NULL };
TreeNode n4 = { 25,NULL,NULL };
TreeNode n5 = { 20,&n3,&n4 };
TreeNode n6 = { 15,&n2,&n5 };
TreeNode *root = &n6;

int is_empty(qtype *p)
{
	return(p->rear == p->front);
}
int is_full(qtype *p)
{
	return((p->rear + 1) % max == p->front);
}
void init(qtype *p)
{
	p->rear = p->front = 0;
}
void enq(qtype *p, element item)
{
	if (is_full(p))
	{
		printf("큐포화에러\n");
		return;
	}
	else if (item == NULL)
	{
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
void level_order(TreeNode *p)
{
	qtype s;
	init(&s);
	enq(&s, p);
	while (!is_empty(&s))
	{
		p = deq(&s, p);
		printf("[%d] ", p->data);
		enq(&s, p->left);
		enq(&s, p->right);
		if (!p)
			break;

	}
}
int main()
{
	printf("레벨순회\n");
	level_order(root);
	printf("\n");
	return 0;
}