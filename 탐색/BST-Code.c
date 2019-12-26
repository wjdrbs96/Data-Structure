#include <stdio.h>
#include<stdlib.h>
#include<malloc.h> 
#include<string.h>
#include<time.h>
#define max 100
typedef int element;
typedef struct TreeNode
{
	int key;
	struct TreeNode *left, *right;
}TreeNode;
TreeNode* insert_node(TreeNode *node, element item)
{
	TreeNode *p = (TreeNode *)malloc(sizeof(TreeNode));
	p->key = item;
	if (node == NULL)
	{
		p->left = NULL;
		p->right = NULL;
		return p;
	}
	if (node->key < item)
	{
		node->right = insert_node(node->right, item);
	}
	else if (node->key > item)
	{
		node->left = insert_node(node->left, item);
	}
	return node;
}
TreeNode* min_value_node(TreeNode *node)
{
	TreeNode *current = node;
	while (node->left != NULL)
	{
		current = current->left;
	}
	return current;
}
TreeNode* delete_node(TreeNode *node, element item)
{
	if (node == NULL)
		return NULL;
	if (node->left == NULL)
	{
		TreeNode *temp = node->right;
		free(node);
		return temp;
	}
	else if (node->right == NULL)
	{
		TreeNode *temp = node->left;
		free(node);
		return temp;
	}
	else
	{
		if (node->key<item)
		{
			node->right = delete_node(node->right, item);
		}
		else if (node->key > item)
		{
			node->left = delete_node(node->left, item);
		}
		else
		{
			TreeNode *temp = min_value_node(node->right);
			node->key = temp->key;
			node->right = delete_node(node->right, temp->key);
		}
	}
	return node;
}
void inorder(TreeNode *p)
{
	if (p != NULL)
	{
		inorder(p->left);
		printf("[%d] ", p->key);
		inorder(p->right);
	}
}
int main()
{
	TreeNode *root = NULL;
	root = insert_node(root, 35);
	root = insert_node(root, 18);
	root = insert_node(root, 68);
	root = insert_node(root, 7);
	root = insert_node(root, 26);
	root = insert_node(root, 3);
	root = insert_node(root, 12);
	root = insert_node(root, 22);
	root = insert_node(root, 30);
	root = insert_node(root, 40);
	root = delete_node(root, 68);
	inorder(root);
	printf("\n");
}