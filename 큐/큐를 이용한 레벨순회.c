#include<stdio.h>
#include<stdlib.h>
#include<time.h>
#define SIZE 100
typedef struct TreeNode
{
	int data;
	struct TreeNode *left, *right;
}TreeNode;
typedef TreeNode *element;
typedef struct
{
	element data[SIZE];
	int front, rear;
}qtype;

TreeNode n1 = { 1,NULL,NULL };
TreeNode n2 = { 4,&n1,NULL };
TreeNode n3 = { 16,NULL,NULL };
TreeNode n4 = { 25,NULL,NULL };
TreeNode n5 = { 20,&n3,&n4 };
TreeNode n6 = { 15,&n2,&n5 };
TreeNode *root = &n6;
void init(qtype *p)
{
	p->rear = p->front = 0;
}
int is_full(qtype *p)
{
	return((p->rear + 1) % SIZE == p->front);
}
int is_empty(qtype *p)
{
	return(p->front == p->rear);
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
		p->rear = (p->rear + 1) % SIZE;
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
		p->front = (p->front + 1) % SIZE;
		return(p->data[p->front]);
	}
}
void level_order(TreeNode *root)
{
	qtype s;
	init(&s);
	if (root == NULL)
		return;
	enq(&s, root);
	while (!is_empty(&s))
	{
		root = deq(&s);
		printf("[%d] ", root->data);
		if (root->left)
			enq(&s, root->left);
		if (root->right)
			enq(&s, root->right);
	}
}
int main()
{
	printf("레벨순회\n");
	level_order(root);
	printf("\n");
	return 0;
}