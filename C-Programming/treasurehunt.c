/* 201814223, ���Ͽ�, c���α׷���(0452),���� ã�� ����, 2020.06.14*/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <Windows.h>
#include <conio.h>
#define FLAG_MARK  "��"
#define PLAYER_MARK  "��"
#define OBSTACLE_MARK "��"
#define TREASURE "��"
#define TIME_LIMIT_BASIC 180
#define TIME_LIMIT_MIDDLE 120
#define TIME_LIMIT_HIGH 60

void gotoxy(int x, int y);
int display_rule();
int basic_level();
int middle_level();
int high_level();
void background(int matrix[][20]);
void background2(int matrix[][25]);
void background3(int matrix[][25]);
void make_flags(int tx[], int ty[]);
void make_flags2(int tx[], int ty[], int a[][25]);
void make_flags3(int tx[], int ty[], int a[][25]);
void fail();
int game_control(int tx[], int ty[], int* s, int matrix[][20]);
int game_control2(int tx[], int ty[], int* s, int matrix[][25]);
int game_control3(int tx[], int ty[], int* s, int matrix[][25]);



int score = 100; // ���� score�� �ʱⰪ�� 100���� ����
void gotoxy(int x, int y) //Ŀ�� �̵� �Լ�- windows.h�� ���� ��
{
	COORD Cur = { x,y };
	SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE),Cur);
}

int main()
{	

	int result;
	
	int gameover;
	int gameover2;
	int gameover3;
	int replay;
	gotoxy(20, 10);
	printf("************************************\n");
	gotoxy(20, 11);
	printf("*          GAME START!             *\n");
	gotoxy(20, 12);
	printf("*                                  *\n");
	gotoxy(20, 13);
	printf("*      < Treasure Hunt Game>       *\n");
	gotoxy(20, 14);
	printf("************************************\n");
	Sleep(3000);
	system("cls");
	result = display_rule(); //���� �꿡 ���ؼ� ����


			system("cls");
			while (1) {
				

				if (result == 1) // 1�� �Է��� ->�ʱ� ������ ���� ����
				{
					gameover = basic_level();
					if (gameover)
					{

						system("cls");
						gotoxy(20, 10);
						printf("�����մϴ�. ������ ã�ҽ��ϴ�!");
						gotoxy(20, 12);
						printf("Level 2�� �Ѿ�ϴ�.score=%d time=%d��", score,gameover);
						gotoxy(20, 13);
						printf("Level 2�� ����� ������ ��������, ��ֹ��� ����ϴ�. ���ѽð��� 2���Դϴ�.\n");
						Sleep(4000);
						system("cls");
						result = 2; // ���������� �ڵ��̵��ϱ� ���� result������ 2����
					}
				}

				
				else if (result == 2)// �߱� ������ ���� ����
				{

					gameover2 = middle_level();
					if (gameover2)
					{

						system("cls");
						gotoxy(20, 10);
						printf("�����մϴ�. ������ ã�ҽ��ϴ�!");
						gotoxy(20, 12);
						printf("Level 3�� �Ѿ�ϴ�.score=%d time=%d��", score,gameover2);
						gotoxy(20, 13);
						printf("Level 3�� �� ���� ����� �����,�� ���� ��ֹ��� ����ϴ�. ���ѽð��� 1���Դϴ�.\n");
						Sleep(4000);
						system("cls");
						result = 3;
					}
				}
				
				else if (result == 3) // ��� ������ ���� ����
				{
					
					gameover3 =high_level();
					if (gameover3)
					{	
						system("cls");
						gotoxy(20, 10);
						printf("*****************************************\n");
						gotoxy(20, 11);
						printf("*          !!GAME CLEAR!!               *\n");
						gotoxy(20, 12);
						printf("*                                       *\n");
						gotoxy(20, 13);
						printf("*          !! �����մϴ�!!              *\n");
						gotoxy(20, 13);
						printf("*  ���������� %d��,%d�� �ɷȽ��ϴ�     *\n",score, gameover3);
						gotoxy(20, 14); 
						printf("*****************************************\n");
						Sleep(4000);
						system("cls");
						gotoxy(20, 12);
						printf("������ �ٽ� �����Ͻðڽ��ϱ� ? �ٽ� �����Ͻ÷��� 1�� �����ּ���");
						scanf("%d", &replay);

						if (replay == 1)
						{
							system("cls");
							main();
							}
						else
							break;
					}
				}
				else if (result == 0) // ����ڰ� 0�� ������ ������
				{
					system("cls");
					printf("������ �����մϴ�.");
					break;

				}
				else
				{
					system("cls");
					gotoxy(20, 10);
					printf("�ʱ��� 1��, �߱��� 2��, ����� 3���Դϴ�.�����Ͻ÷��� 0�� �����ּ���");
					
					Sleep(2000);
					scanf("%d", &result);
					if (result == 0)
						break;
					else if (result == 1 || result == 2 || result == 3)
					{	
						gotoxy(20, 10);
						printf("����â���� ���ư��ϴ�.");
						Sleep(2000);
						system("cls");
						main();
					}
					else
						break;
					
				}
			}
		
			
				system("cls");
				gotoxy(20, 10);
				printf("************************************\n");
				gotoxy(20, 11);
				printf("*          GAME OVER               *\n");
				gotoxy(20, 12);
				printf("*                                  *\n");
				gotoxy(20, 13);
				printf("*      < Treasure Hunt Game>       *\n");
				gotoxy(20, 14);
				printf("************************************\n");
				Sleep(1000);
				system("pause");
			
}

int display_rule() //���� �꿡 ���ؼ� ������
{

	int input;
	printf("--------------------------------------���� �� -----------------------------------------\n");
	printf(" ��� �Ʒ����� ������ ������ �ֽ��ϴ�.\n");
	printf(" ����� ��߱��� ����Ű�� �̵��Ҽ� �ֽ��ϴ�.\n");
	printf(" ������ ���� ��߿��� �ٸ� ��߾Ʒ����� ��ź�̳� ���� Ȥ�� ��Ʈ�� ������ �ֽ��ϴ�.\n");
	printf(" ����� �־��� �ð� �ȿ� ������ ã�ƾ� �մϴ�.\n");
	printf(" ��� �׵θ��� ������ ������ ����˴ϴ�.\n");
	printf(" --------------------------------------------------------------------------------------\n");

	printf(" ������ �� 3������ ������ �ֽ��ϴ�.���ѽð� �ȿ� ������ ã���� ���������� �Ѿ�ϴ�.\n");
	printf(" �ʱ�: ���ѽð� 3���̳��� ��� �Ʒ��� ������ ���� �ϳ��� ã���� ����� �¸��Դϴ�.\n");
	printf(" �߱�: ���ѽð� 2���̳��� ��� �Ʒ��� ������ ���� �ϳ��� ã���� ����� �¸��Դϴ�.\n");
	printf(" ���: ���ѽð� 1���̳��� ��� �Ʒ��� ������ ���� �ϳ��� ã���� ����� �¸��Դϴ�.\n");
	printf(" ���� ������ ������ �ּ���(�ʱ� :1 �߱� 2: ��� 3),�����Ͻ÷��� 0�� �����ּ���\n\n");
	printf("----------------------->");
	
	scanf("%d", &input);


	return input;
}

int basic_level() // �ʱ� ������ main�Լ�
{
	time_t start, finish;
	int tx[7], ty[7]; //����� ��µ� ��ġ�� ������ . ������ ��ġ�� tx[0], ty[0]�̶�� ������
	int result;
	int matrix[40][20] = { 0, }; // 2���� �迭 ����
	background(matrix); // ���� �׵θ� ����
	make_flags(tx, ty);// ��� ����
	start = clock();
	result= game_control(tx,ty, &score,matrix); //������ ��Ʈ�� �ϴ� �Լ�
	finish = clock();
	
	return (int)((finish - start)/CLOCKS_PER_SEC);
}
void background(int matrix[][20]) // �⺻�� : ������ ���ȭ�� ����- ������ �׵θ��� ������ ������ �����(matrix2���� �迭�� ����)
{

	int i, j, k, r; 
	

	for (i = 0; i < 40; i++) {
		printf("#");
		matrix[i][0] = 1;
	}
	printf("\n");
	for (k = 0; k < 19; k++)
	{
		printf("#");
		for (j = 0; j < 38; j++)
			printf(" ");
		printf("#");
		printf("\n");
		matrix[0][k] = 1;
		matrix[39][k] = 1;
	}
	for (r = 0; r < 40; r++) {

		printf("#");
		matrix[r][19] = 1;
	}
	printf("\n");
}


void make_flags(int tx[], int ty[]) //����� �����ϴ� �Լ� ����� �����ġ�� �������� ��µǸ� �ٽ� �����Ͽ� �ݺ� ������
{
	int i;
	srand((unsigned)time(NULL));

	for (i = 0; i < 7; i++) 
	{	
		do {
			tx[i] = rand() % 38 + 1;  // 1~38 (�׵θ� ����)

			ty[i] = rand() % 18 + 1; //1~18 (�׵θ� ����)

			
		} while (tx[i] == 1 && ty[i] == 18);

		gotoxy(tx[i], ty[i]);
		printf(FLAG_MARK);
	}

}
int game_control(int tx[], int ty[], int* s,int matrix[][20]) // ������ ��Ʈ�� �ϴ� �Լ�
{	

	int s_time;
	srand(time(0));
	s_time = time(0);
	int x = 1, y = 18;
	int ch;

		

		while (1) // Ű �̵�
		{

			gotoxy(50, 12);
			printf("���ѽð��� 3���Դϴ�.");
			gotoxy(x, y);
			printf(PLAYER_MARK);
			if (time(0) == s_time + TIME_LIMIT_BASIC) // ���ѽð��� �����ϴ� �ݺ��� 
						//(�ʱ� -3���� ���ѽð��� �־����� 3���� ������ fail()�Լ��� ȣ��
			{
				system("cls");
				fail();
				s_time = time(0);
			}
			ch = _getch();
			if (ch == 224)
			{
				ch = _getch();
				switch (ch)
				{
				case 72:

					y--;
					gotoxy(x, y + 1);
					printf("  ");
					gotoxy(x, y);
					printf(PLAYER_MARK);
					
					break;
				case 80:
					y++;
					gotoxy(x, y - 1);
					printf("  ");
					gotoxy(x, y);
					printf(PLAYER_MARK);
					
					break;
				case 75:
					x--;
					gotoxy(x + 1, y);
					printf("  ");
					gotoxy(x, y);
					printf(PLAYER_MARK);
					
					break;
				case 77:
					x++;
					gotoxy(x - 1, y);
					printf("  ");
					gotoxy(x, y);
					printf(PLAYER_MARK);
					
					break;
				}
			}
			if (matrix[x][y]==1) { // ������ �׵θ��� ������ fail()ȣ�� (background()���� matrix�� ��������)
				Sleep(1000);
				fail();
			}
			
			else{
				if (x == tx[0] && y == ty[0]) // ������ ��ġ�� ������� �Է�Ű�� ��ġ���� ���
											//(������ ��ġ�� tx[0],ty[0]�̶�� ����)
				{
					*s += 500;
					printf("  ");
					printf(TREASURE);
					gotoxy(0, 25);
					printf("������ ã�ҽ��ϴ�. ���� �ܰ�� �Ѿ�ϴ�.");
					Sleep(2000);
					return 1;

				}
				else if (x == tx[1] && y == ty[1])
				{
					gotoxy(0,25);
					*s += 50;
					printf("�����մϴ�! ������ ȹ���߽��ϴ�. score =%d",*s);
					Sleep(1000);
					gotoxy(0, 25);
					printf("                                                     ");

					
				}
				else if (x == tx[2] && y == ty[2])
				{
					gotoxy(0, 25);
					*s -= 20;
					printf("��Ģ�Դϴ�. ������ �Ҿ����ϴ�. score =%d", *s);
					Sleep(1000);
					gotoxy(0, 25);
					printf("                                                    \n");
					
				}
				else if (x == tx[3] && y == ty[3])
				{
					gotoxy(0, 25);
					*s = 0;
					printf("����� ���ڸ� ��ҽ��ϴ�. ������ 0�� �Ǿ����ϴ�. score = % d", *s);
					Sleep(1000);
					gotoxy(0, 25);
					printf("                                                                     \n");
					
				}
				else if (x == tx[4] && y == ty[4])
				{
					gotoxy(0, 25);
					*s += 80;
					printf("�����մϴ�! ������ ȹ���߽��ϴ�.score = % d", *s);
					Sleep(1000);

					gotoxy(0, 25); 
					printf("                                                    \n");

					
				}
				else if (x == tx[5] && y == ty[5])
				{
					gotoxy(0, 25);
					printf("��ź�� �������ϴ�.����� ���ġ �˴ϴ�.score = % d", *s);
					Sleep(1000);
					system("cls");
					background(matrix);
					make_flags(tx, ty);
					gotoxy(x, y);
				}
				else // if-else if���� �ش����� �ʴ� �ٸ� ��ߵ��� �ƹ��͵� ����
					;
			}



		
	}
}
void fail() // ������ �׵θ��� ��ų�, 
//���ѽð��ȿ� ������ clear���� ��������� ȣ��Ǵ� �Լ�
{	
	
	int input;
	system("cls");
	gotoxy(20, 10);
	printf("������ ����Ǿ����ϴ�. �ٽ� �����Ͻ÷��� 1�� �����ּ��� \n\n");
	printf("----------------------->");
	scanf("%d", &input);

	if (input == 1)// �ٽ� ���ӷ��� �����
	{
		system("cls");
		main();
	} 
	else {// ���� ����
		system("cls");
		gotoxy(20, 10);
		printf("************************************\n");
		gotoxy(20, 11);
		printf("*          GAME OVER               *\n");
		gotoxy(20, 12);
		printf("*                                  *\n");
		gotoxy(20, 13);
		printf("*      < Treasure Hunt Game>       *\n");
		gotoxy(20, 14);
		printf("************************************\n");
		Sleep(1000);
		system("pause");
	}
}


/*middle level*/
int middle_level() //������ �߱� ����
{
	time_t start, finish;
	int tx[13], ty[13]; //����� ������ ��ġ�� �����ϴ�  1���� �迭 .������ ��ġ�� tx[0],ty[0]�̶�� ������
	int result;
	int matrix[50][25] = { 0, };
	background2(matrix); // ���� �׵θ� ����
	make_flags2(tx, ty,matrix);// ��� ����
	start = clock();
	result = game_control2(tx, ty, &score, matrix); //������ ��Ʈ�� �ϴ� �Լ�
	finish = clock();
	return (int)((finish - start) / CLOCKS_PER_SEC);
}
void background2(int matrix[][25]) // �⺻�� : ������ �׵θ� ���� (level1 ���� ������ ���ȭ���� ũ�⸸ �÷���
{

	int i, j, k, r;


	for (i = 0; i < 50; i++) {
		printf("#");
		matrix[i][0] = 1;
	}
	printf("\n");
	for (k = 0; k < 24; k++)
	{
		printf("#");
		for (j = 0; j <48; j++)
			printf(" ");
		printf("#");
		printf("\n");
		matrix[0][k] = 1;
		matrix[49][k] = 1;
	}
	for (r = 0; r < 50; r++) {

		printf("#");
		matrix[r][24] = 1;
	}
	printf("\n");
}
void make_flags2(int tx[], int ty[],int a[][25]) //����� �����ϴ� �Լ��� level1���� ����� ������ 3�� �� �������� �߰��� ��ֹ� 3���� ������
{
	int i;


	srand((unsigned)time(NULL));
	for (i = 0; i < 10; i++) // ��� ����(10��)
	{
		do {
			tx[i] = rand() % 48 + 1;  // 1~48 (�׵θ� ����)

			ty[i] = rand() % 23 + 1; //1~23 (�׵θ� ����)


		} while ((tx[i] == 1 && ty[i] == 23));

		gotoxy(tx[i], ty[i]);
		printf(FLAG_MARK);
	}
	for (i = 10; i < 13; i++) //��ֹ� ����(3��)
	{
		do {
			tx[i] = rand() % 48 + 1;  // 1~48 (�׵θ� ����)

			ty[i] = rand() % 23 + 1; //1~23 (�׵θ� ����)

		} while ((tx[i] == 1 && ty[i] == 23));
		gotoxy(tx[i], ty[i]);
		printf(OBSTACLE_MARK);
		a[tx[i]][ty[i]] = 2; //��ֹ��� ��ġ�� ���� matrix[][]2���� �迭���� ���� 2�� ������
	}
	

}
int game_control2(int tx[], int ty[], int* s, int matrix[][25]) //level2�� ������ ��Ʈ�� �ϴ� �Լ�
{

	int s_time;
	srand(time(0));
	s_time = time(0);
	int x = 1, y = 23;
	int ch;


	
	while (1) // Ű �̵�
	{
		gotoxy(55, 10);
		printf("���ѽð��� 2���Դϴ�.");
		gotoxy(x, y);
		printf(PLAYER_MARK);
		if (time(0) == s_time + TIME_LIMIT_HIGH)
		{
			system("cls");
			fail();
			s_time = time(0);
		}
		ch = _getch();
		if (ch == 224)
		{
			ch = _getch();
			switch (ch)
			{
			case 72:

				y--;
				gotoxy(x, y + 1);
				printf("  ");
				gotoxy(x, y);
				printf(PLAYER_MARK);

				break;
			case 80:
				y++;
				gotoxy(x, y - 1);
				printf("  ");
				gotoxy(x, y);
				printf(PLAYER_MARK);

				break;
			case 75:
				x--;
				gotoxy(x + 1, y);
				printf("  ");
				gotoxy(x, y);
				printf(PLAYER_MARK);

				break;
			case 77:
				x++;
				gotoxy(x - 1, y);
				printf("  ");
				gotoxy(x, y);
				printf(PLAYER_MARK);

				break;
			}
		}
		if (matrix[x][y] == 1) { // ������ �׵θ�
			fail();
		}
		else if (matrix[x][y] == 2) // ��ֹ��� ��ġ. ��ֹ��� ������ fail�� �����
		{	
			gotoxy(0, 27);
			
			printf("����� ���ڸ� ��ҽ��ϴ�.���ӿ� �����Ͽ����ϴ�.");
			Sleep(2000);
			fail();
		}

		else {
			if (x == tx[0] && y == ty[0]) // ������ ��ġ�� ������� �Է�Ű�� ��ġ���� ���(������ ��ġ�� tx[0],ty[0])
			{
				*s += 500;
				printf("   ");
				printf(TREASURE);
				gotoxy(0, 27);
				printf("�����մϴ�! ������ ã�ҽ��ϴ�..");
				Sleep(2000);
				return 1;

			}
			else if (x == tx[1] && y == ty[1])
			{
				gotoxy(0, 27);
				printf("�����մϴ�! ������ ȹ���߽��ϴ�.score = % d", *s);
				Sleep(1000);
				gotoxy(0, 27);
				printf("                                                           ");

				*s += 70;
			}
			else if (x == tx[2] && y == ty[2])
			{
				gotoxy(0, 27);
				*s -= 100;
				printf("��Ģ�Դϴ�. ������ �Ҿ����ϴ�.score = % d", *s);
				Sleep(1000);
				gotoxy(0, 27);
				printf("                                                    ");
				
			}
			else if (x == tx[3] && y == ty[3])
			{
				gotoxy(0, 27);
				*s = 0;
				printf("����� ��ֹ��� ��ҽ��ϴ�. ������ 0�� �Ǿ����ϴ�.score = % d", *s);
				Sleep(1000);
				gotoxy(0, 27);
				printf("                                                                       ");
				
			}
			else if (x == tx[4] && y == ty[4])
			{
				gotoxy(0, 27);
				*s += 80;
				printf("�����մϴ�! ������ ȹ���߽��ϴ�.score = % d", *s);
				Sleep(1000);
				gotoxy(0, 27);
				printf("                                                       ");

				
			}
			else if (x == tx[5] && y == ty[5])
			{	
				
				gotoxy(0, 27);
				printf("��ź�� �������ϴ�.����� ���ġ �˴ϴ�.");
				Sleep(1000);
				system("cls");
				background2(matrix);
				make_flags2(tx, ty, matrix);
				gotoxy(x, y);
			}
			else if (x == tx[6] && y == ty[6])
			{
				gotoxy(0, 27);
				*s -= 50;
				printf("��Ģ�Դϴ�. ������ �Ҿ����ϴ�.score = % d", *s);
				Sleep(1000);
				gotoxy(0, 27);
				printf("                                                     ");
				
			}
			else
				;
		}




	}
}
int high_level() //������ ��޷���
{
	time_t start, finish;
	int tx[17], ty[17]; //����� ������ ��ġ�� �����ϴ�  1���� �迭 .
						//������ ��ġ�� tx[0],ty[0], tx[1],ty[1]�̶�� ������

	int result;
	int matrix[50][25] = { 0, };
	background3(matrix); // ���� �׵θ� ����
	make_flags3(tx, ty, matrix);// ��� ����
	start = clock();
	result = game_control3(tx, ty, &score, matrix); //������ ��Ʈ�� �ϴ� �Լ�
	finish = clock();
	return (int)((finish - start) / CLOCKS_PER_SEC);
}
void background3(int matrix[][25]) // �⺻�� : ������ �׵θ� ����
{

	int i, j, k, r; //���� ���ȭ�� ����


	for (i = 0; i < 50; i++) {
		printf("#");
		matrix[i][0] = 1;
	}
	printf("\n");
	for (k = 0; k < 24; k++)
	{
		printf("#");
		for (j = 0; j < 48; j++)
			printf(" ");
		printf("#");
		printf("\n");
		matrix[0][k] = 1;
		matrix[49][k] = 1;
	}
	for (r = 0; r < 50; r++) {

		printf("#");
		matrix[r][24] = 1;
	}
	printf("\n");
}
void make_flags3(int tx[], int ty[], int a[][25]) //����� �����ϴ� �Լ�
{
	int i;


	srand((unsigned)time(NULL));
	for (i = 0; i < 12; i++) // ��� ������ (12��)
	{
		do {
			tx[i] = rand() % 48 + 1;  // 1~48 (�׵θ� ����)

			ty[i] = rand() % 23 + 1; //1~23 (�׵θ� ����)


		} while ((tx[i] == 1 && ty[i] == 23)); // ����� ��ġ�� ���� �÷��̾��� �ʱ� ��ġ��� �����

		gotoxy(tx[i], ty[i]);
		printf(FLAG_MARK);
	}
	for (i = 12; i < 17; i++) //��ֹ��� ������ (5��)
	{
		do {
			tx[i] = rand() % 48 + 1;  // 1~48 (�׵θ� ����)

			ty[i] = rand() % 23 + 1; //1~23 (�׵θ� ����)

		} while ((tx[i] == 1 && ty[i] == 23));
		gotoxy(tx[i], ty[i]);
		printf(OBSTACLE_MARK);
		a[tx[i]][ty[i]] = 2;
	}
}
int game_control3(int tx[], int ty[], int* s, int matrix[][25]) //������ ��Ʈ�� �ϴ� �Լ� 
{

	int s_time;
	srand(time(0));
	s_time = time(0);
	int x = 1, y = 23;
	int ch;
	int count = 0;

	

	while (1) // Ű �̵�
	{
		gotoxy(55, 10);
		printf("���ѽð��� 1���Դϴ�.");
		gotoxy(x, y);
		printf(PLAYER_MARK);
		if (time(0) == s_time + TIME_LIMIT_MIDDLE)
		{
			system("cls");
			fail();
			s_time = time(0);
		}
		ch = _getch();
		if (ch == 224)
		{
			ch = _getch();
			switch (ch)
			{
			case 72:

				y--;
				gotoxy(x, y + 1);
				printf("  ");
				gotoxy(x, y);
				printf(PLAYER_MARK);
				break;
			case 80:
				y++;
				gotoxy(x, y - 1);
				printf("  ");
				gotoxy(x, y);
				printf(PLAYER_MARK);

				break;
			case 75:
				x--;
				gotoxy(x + 1, y);
				printf("  ");
				gotoxy(x, y);
				printf(PLAYER_MARK);

				break;
			case 77:
				x++;
				gotoxy(x - 1, y);
				printf("  ");
				gotoxy(x, y);
				printf(PLAYER_MARK);

				break;
			}
		}
		if (matrix[x][y] == 1) { //������ �׵θ��� ������ fail()����
			fail();
		}
		else if (matrix[x][y] == 2) //��ֹ��� ������ fail()����
		{
			gotoxy(0, 27);
			printf("����� ���ڸ� ��ҽ��ϴ�.���ӿ� �����Ͽ����ϴ�.");
			fail();
		}

		else {
			if ((x == tx[0] && y == ty[0])) // ������ ��ġ�� ������� �Է�Ű�� ��ġ���� ���
											//(������ ��ġ�� tx[0],ty[0]).
											//count���� �̿��Ͽ� �ΰ����� ������ ã���� 
											//�����ϵ��� ������
			{
				gotoxy(0, 27);
				*s += 1000;
				printf("�����մϴ�! ������ ã�ҽ��ϴ�! score = % d", *s);
				Sleep(1000);
				gotoxy(0, 27);
				printf("                                                            ");
				
				gotoxy(x, y);
				printf("  ");
				printf(TREASURE);
				
				count++;

			}
			else if (x == tx[1] && y == ty[1]) //�� ��° ������ ��ġ�� tx[1],ty[1] 
			{
				gotoxy(0, 27);
				*s += 1000;
				printf("�����մϴ�!������ ã�ҽ��ϴ�! score = % d", *s);
				Sleep(1000);
				gotoxy(0, 27);
				printf("                                                            ");
				
				gotoxy(x, y);
				printf("  ");
				printf(TREASURE);
				Sleep(2000);
				count++;
			}
			else if (x == tx[2] && y == ty[2])
			{
				gotoxy(0, 27);
				*s -= 100;
				printf("��Ģ�Դϴ�. ������ �Ҿ����ϴ�.score = % d", *s);
				Sleep(1000);
				gotoxy(0, 27);
				printf("                                                   ");
				
			}
			else if (x == tx[3] && y == ty[3])
			{
				gotoxy(0, 27);
				*s = 0;
				printf("����� ��ֹ��� ��ҽ��ϴ�. ������ 0�� �Ǿ����ϴ�.score = % d", *s);
				Sleep(1000);
				gotoxy(0, 27);
				printf("                                                                       ");
				
			}
			else if (x == tx[4] && y == ty[4])
			{
				gotoxy(0, 27);
				*s += 80;
				printf("�����մϴ�! ������ ȹ���߽��ϴ�.score = % d", *s);
				Sleep(1000);
				gotoxy(0, 27);
				printf("                                                        ");

				
			}
			else if (x == tx[5] && y == ty[5])
			{

				gotoxy(0, 27);
				printf("��ź�� �������ϴ�.����� ���ġ �˴ϴ�.");
				count = 0; //������ ����� ������ ��� �ʱ�ȭ��
				Sleep(1000);
				system("cls");
				background2(matrix);// ���� �׵θ� ����
				make_flags2(tx, ty, matrix); // ��� ����
				gotoxy(x, y);
			}
			else if (x == tx[6] && y == ty[6])
			{
				gotoxy(0, 27);
				*s -= 50;
				printf("��Ģ�Դϴ�. ������ �Ҿ����ϴ�. score = % d", *s);
				Sleep(1000);
				gotoxy(0, 27);
				printf("                                                   ");
				
			}
			else if (x == tx[7] && y == ty[7])
			{
				gotoxy(0, 27);
				*s -= 80;
				printf("��Ģ�Դϴ�. ������ �Ҿ����ϴ�.score = % d", *s);
				Sleep(1000);
				gotoxy(0, 27);
				printf("                                                   ");
				
			}
			else if (x == tx[8] && y == ty[8])
			{
				gotoxy(0, 27);
				*s += 100;
				printf("�����մϴ�! ������ ȹ���߽��ϴ�.score = % d", *s);
				Sleep(1000);
				gotoxy(0, 27);
				printf("                                                      ");
				
			}
			else
				;
		}
		if (count == 2) //count���� 2�̸� ������ �ΰ� �� ã�����Ƿ� ����clear�� ������
		{
			gotoxy(0, 27);
			printf("���� 2���� ��δ� ã�ҽ��ϴ�. ���� clear�Դϴ�!");
			Sleep(3000);
			return 1;
		}


	}
}
