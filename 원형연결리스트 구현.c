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
	if (head == NULL)  // 노드가 하나도 없을때 
	{
		head = node;
		node->link = node;
		tail = node;
	}
	else if (pos == 1)  // 1.처음에 노드를 삽입하고 싶을때 
	{
		tail->link = node;
		head = node;
	}
	else if (pos == count)  // 2.마지막노드에 삽입하고 싶을떄
	{
		tail->link = node;  // 여기가 오류인데 왜지? ㅆㅂ 
		tail = node;
		node->link = head;
	}
	else   // 3.중간에 노드를 삽입하고 싶을때 
	{
		temp = search(temp, pos);
		node->link = head->link;
		head->link = node;
		return temp;
	}
	if (count == 5) //  5개의 노드가 다 들어왔으면 print 함수 호출 
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
