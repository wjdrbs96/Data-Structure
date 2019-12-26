#include <stdio.h>
#include<stdlib.h>
#include<malloc.h> 
#include<string.h>
#include<time.h>
#define max 6
typedef struct
{
	short r;
	short c;
}element;
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
char maze[max][max] = {
	{ '1','1','1','1','1','1' },
{ 'e','0','0','0','1','1' },
{ '1','1','0','1','1','1' },
{ '1','1','0','1','1','1' },
{ '1','0','0','0','0','x' },
{ '1','1','1','1','1','1' }
};
element start = { 1,0 };
element end = { 5,6 };
element here = { 1,0 };
void push_loc(stacktype *p, int r, int c)
{
	if (r < 0 || c < 0 || r>6 || c>6)
		return;
	else if (maze[r][c] != '1' && maze[r][c] != '.')
	{
		element temp;
		temp.r = r;
		temp.c = c;
		push(p, temp);
	}

}
void print(char maze[max][max])
{
	printf("\n");
	for (int r = 0; r < max; r++)
	{
		for (int c = 0; c < max; c++)
		{
			printf("%c", maze[r][c]);
		}
		printf("\n");
	}
}
int main()
{
	int r, c;
	stacktype s;
	init(&s);
	here = start;
	while (maze[here.r][here.c] != 'x')
	{
		r = here.r;
		c = here.c;
		maze[r][c] = '.';
		print(maze);
		push_loc(&s, r - 1, c);
		push_loc(&s, r + 1, c);
		push_loc(&s, r, c - 1);
		push_loc(&s, r, c + 1);
		if (is_empty(&s))
		{
			printf("실패\n");
			return 0;
		}
		else
		{
			here = pop(&s);
		}
	}
	printf("성공\n");
	return 0;

}