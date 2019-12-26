#include<stdio.h>
#include<stdlib.h>
#include<time.h>
#define SIZE 100
typedef struct TreeNode
{
	int data;
	struct TreeNode *left, *right;
}TreeNode;
TreeNode *stack[SIZE];
int top = -1;

TreeNode n1 = { 1,NULL,NULL };
TreeNode n2 = { 4,&n1,NULL };
TreeNode n3 = { 16,NULL,NULL };
TreeNode n4 = { 25,NULL,NULL };
TreeNode n5 = { 20,&n3,&n4 };
TreeNode n6 = { 15,&n2,&n5 };
TreeNode *root = &n6;
void push(TreeNode *p)
{
	if (top < SIZE - 1)
		stack[++top] = p;
}
TreeNode *pop()
{
	if (top > -1)
		return(stack[top--]);
	return NULL;
}
void inorder_iter(TreeNode *root)
{
	while (1)
	{
		for (; root; root = root->left)
		{
			push(root);
		}
		root = pop();
		if (!root)
			break;
		printf("[%d] ", root->data);
		root = root->right;
	}
}
int main()
{
	printf("중위순회\n");
	inorder_iter(root);
	printf("\n");
	return 0;
}
