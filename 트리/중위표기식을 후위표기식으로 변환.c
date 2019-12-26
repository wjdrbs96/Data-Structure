#include <stdio.h>
#include<stdlib.h>
#include<malloc.h> 
#include<string.h>
#include<time.h>
#define max 10
typedef char element;
typedef struct
{
	element data[max];
	int top;
}stacktype;
void init(stacktype *p)
{
	p->top = -1;
}
int is_empty(stacktype *p)
{
	return(p->top == -1);
}
int is_full(stacktype *p)
{
	return(p->top == max - 1);
}
void push(stacktype *p, element item)
{
	if (is_full(p))
	{
		printf("스택포화에러\n");
		return;
	}
	else
	{
		p->data[++p->top] = item;
	}
}
element pop(stacktype *p)
{
	if (is_empty(p))
	{
		printf("스택공백에러\n");
		exit(1);
	}
	else
	{
		return(p->data[p->top--]);
	}
}
element peek(stacktype *p)
{
	if (is_empty(p))
	{
		printf("스택공백에러\n");
		exit(1);
	}
	else
	{
		return(p->data[p->top]);
	}
}
int prec(char op)
{
	switch (op)
	{
	case')':case'(':
		return 0;
	case'+':case'-':
		return 1;
	case'*':case'/':
		return 2;
	}
	return -1;
}
void infix_to_postfix(char exp[])
{
	int i, k = strlen(exp);
	char ch, ch1;
	stacktype s;
	init(&s);
	for (i = 0; i < k; i++)
	{
		ch = exp[i];
		switch (ch)
		{
		case'+':case'-':case'*':case'/':
			while (!is_empty(&s) && prec(ch) <= prec(peek(&s)))
				printf("%c", pop(&s));
			push(&s, ch);
			break;
		case'(':
			push(&s, ch);
			break;
		case')':
			ch1 = pop(&s);
			while (ch1 != '(')
			{
				printf("%c", ch1);
				ch1 = pop(&s);
			}
			break;
		default:
			printf("%c", ch);
			break;
		}
	}
	while (!is_empty(&s))
	{
		printf("%c", pop(&s));
	}
}
int main()
{
	char *p = "(2+3)*4+9";
	printf("중위표기식: %s\n", p);
	printf("후위표기식: ");
	infix_to_postfix(p);
	printf("\n");
	return 0;
}