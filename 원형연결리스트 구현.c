#include<stdio.h>
#include<stdlib.h>
typedef int element;
int count = 0;
typedef struct ListNode
{
	element data;
	struct ListNode *link;
}ListNode;
ListNode *tail = NULL;
void print(ListNode *head, ListNode *tail)
{
	while (head != tail)
	{
		printf("%d-> ", head->data);
		head = head->link;
	}
	printf("NULL\n");
}
ListNode *insert_first(ListNode *head, element item)
{
	ListNode *node = (ListNode *)malloc(sizeof(ListNode));
	node->data = item;
	if (head == NULL)
	{
		head = node;
		node->link = head;
	}
	else
	{
		node->link = head->link;
		head->link = node;
	}
	return head;
}
ListNode* insert_last(ListNode *head, element item)
{
	ListNode *node = (ListNode *)malloc(sizeof(ListNode));
	node->data = item;
	if (head == NULL)
	{
		head = node;
		node->link = head;
	}
	else
	{
		node->link = head->link;
		head->link = node;
		head = node;
	}
	return head;
}
ListNode* search(ListNode *head, int pos)
{
	int i;
	for (i = 1; i < pos - 1; i++)
		head = head->link;
	return head;
}
ListNode* insert_node(ListNode *head, int pos, element item)
{
	ListNode *temp = head;
	ListNode *node = (ListNode *)malloc(sizeof(ListNode));
	node->data = item;
	count++;
	if (head == NULL)  // ��尡 �ϳ��� ������ 
	{
		head = node;
		node->link = node;
		tail = node;
	}
	else if (pos == 1)  // 1.ó���� ��带 �����ϰ� ������ 
	{
		tail->link = node;
		head = node;
	}
	else if (pos == count)  // 2.��������忡 �����ϰ� ������
	{
		tail->link = node;  // ���Ⱑ �����ε� ����? ���� 
		tail = node;
		node->link = head;
	}
	else   // 3.�߰��� ��带 �����ϰ� ������ 
	{
		temp = search(temp, pos);
		node->link = head->link;
		head->link = node;
		return temp;
	}
	if (count == 5) //  5���� ��尡 �� �������� print �Լ� ȣ�� 
	{
		print(head, tail);
	}
	return head;

}
int main()
{
	ListNode *head = NULL;
	for (int i = 1; i <= 5; i++)
	{
		head = insert_node(head, i, i);
	}
}
