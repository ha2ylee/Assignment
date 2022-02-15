#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#define SIZE 10
int add_array();
void set_array(int a[], int size);
void print_array(int a[], int size);
void add(int sum[], int a1[], int a2[], int size);
int show_menu();
void cal_pow();
int main()
{	
	int result = 0;
	do {
		result = show_menu();
		if (result == 1)
			cal_pow();
		else if (result == 2)
			add_array();
		else if (result == 3)
			break;

	} while (!(result == 1 || result == 2 || result == 3));
	
	return 0;
}
int show_menu()
{	

	int input;
	printf(" 1. a�� b�� ���ϱ�\n");
	printf(" 2. �迭�� ��\n");
	printf(" 3. ������\n");
	printf("�޴��� �����Ͻÿ� :\n");
	scanf("%d", &input);
	return input;
}

void cal_pow()
{
	int a, b;
	printf("���� ���� �� ���� �Է��Ͻÿ�");
	scanf("%d %d", &a, &b);
	printf("%d�� %d ���� %d �Դϴ�. \n", a, b, rpow(a, b));
}

int rpow(a, b)
{	
	
	return a * rpow(a, a - 1);
	
}
int add_array()
{
	int a1[SIZE];
	int a2[SIZE];
	int sum[SIZE];

	set_array(a1, SIZE);
	set_array(a2, SIZE);
	printf("ù��° �迭 : ");
	print_array(a1, SIZE);
	printf("�ι�° �迭:  ");
	print_array(a2, SIZE);
	add(sum, a1, a2, SIZE);
	printf("�� �迭�� �� :  ");
	print_array(sum, SIZE);
	


}
void set_array(int a[], int size)
{	
	int i;
	for (i = 0; i < SIZE; i++)
	{
		a[i] = rand() % 101;
	}
	a[i] = 0;
}
void print_array(int a[], int size)
{
	int i;
	
	for (i = 0; i < SIZE; i++)
	{
		printf("%+5d", a[i]);
	}
	printf("\n");
}
void add(int sum[], int a1[], int a2[], int size) {
	int* a;
	int* b;
	int* total;
	int i;
	a = a1;
	b = a2;
	total = sum;
	for (i = 0; i < SIZE; i++)
	{
		*total++ = *a++ + *b++;

	}
}
