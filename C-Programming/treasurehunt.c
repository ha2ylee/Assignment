/* 201814223, 이하영, c프로그래밍(0452),보물 찾기 게임, 2020.06.14*/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <Windows.h>
#include <conio.h>
#define FLAG_MARK  "▶"
#define PLAYER_MARK  "◆"
#define OBSTACLE_MARK "★"
#define TREASURE "♬"
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



int score = 100; // 게임 score의 초기값은 100으로 지정
void gotoxy(int x, int y) //커서 이동 함수- windows.h에 정의 됨
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
	result = display_rule(); //게임 룰에 대해서 설명


			system("cls");
			while (1) {
				

				if (result == 1) // 1을 입력함 ->초급 레벨의 게임 실행
				{
					gameover = basic_level();
					if (gameover)
					{

						system("cls");
						gotoxy(20, 10);
						printf("축하합니다. 보물을 찾았습니다!");
						gotoxy(20, 12);
						printf("Level 2로 넘어갑니다.score=%d time=%d초", score,gameover);
						gotoxy(20, 13);
						printf("Level 2는 깃발의 개수가 많아지고, 장애물이 생깁니다. 제한시간은 2분입니다.\n");
						Sleep(4000);
						system("cls");
						result = 2; // 다음레벨로 자동이동하기 위해 result변수에 2지정
					}
				}

				
				else if (result == 2)// 중급 레벨의 게임 실행
				{

					gameover2 = middle_level();
					if (gameover2)
					{

						system("cls");
						gotoxy(20, 10);
						printf("축하합니다. 보물을 찾았습니다!");
						gotoxy(20, 12);
						printf("Level 3로 넘어갑니다.score=%d time=%d초", score,gameover2);
						gotoxy(20, 13);
						printf("Level 3는 더 많은 깃발이 생기고,더 많은 장애물이 생깁니다. 제한시간은 1분입니다.\n");
						Sleep(4000);
						system("cls");
						result = 3;
					}
				}
				
				else if (result == 3) // 고급 레벨의 게임 실행
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
						printf("*          !! 축하합니다!!              *\n");
						gotoxy(20, 13);
						printf("*  최종점수는 %d점,%d초 걸렸습니다     *\n",score, gameover3);
						gotoxy(20, 14); 
						printf("*****************************************\n");
						Sleep(4000);
						system("cls");
						gotoxy(20, 12);
						printf("게임을 다시 시작하시겠습니까 ? 다시 시작하시려면 1을 눌러주세요");
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
				else if (result == 0) // 사용자가 0을 누르면 종료함
				{
					system("cls");
					printf("게임을 종료합니다.");
					break;

				}
				else
				{
					system("cls");
					gotoxy(20, 10);
					printf("초급은 1번, 중급은 2번, 고급은 3번입니다.종료하시려면 0을 눌러주세요");
					
					Sleep(2000);
					scanf("%d", &result);
					if (result == 0)
						break;
					else if (result == 1 || result == 2 || result == 3)
					{	
						gotoxy(20, 10);
						printf("메인창으로 돌아갑니다.");
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

int display_rule() //게임 룰에 대해서 설명함
{

	int input;
	printf("--------------------------------------게임 룰 -----------------------------------------\n");
	printf(" 깃발 아래에는 보물이 숨겨져 있습니다.\n");
	printf(" 당신은 깃발까지 방향키로 이동할수 있습니다.\n");
	printf(" 보물을 숨긴 깃발외의 다른 깃발아래에는 폭탄이나 벌점 혹은 힌트가 있을수 있습니다.\n");
	printf(" 당신은 주어진 시간 안에 보물을 찾아야 합니다.\n");
	printf(" 배경 테두리를 지나면 게임이 종료됩니다.\n");
	printf(" --------------------------------------------------------------------------------------\n");

	printf(" 게임은 총 3가지의 레벨이 있습니다.제한시간 안에 보물을 찾으면 다음레벨로 넘어갑니다.\n");
	printf(" 초급: 제한시간 3분이내에 깃발 아래에 숨겨진 보물 하나를 찾으면 당신의 승리입니다.\n");
	printf(" 중급: 제한시간 2분이내에 깃발 아래에 숨겨진 보물 하나를 찾으면 당신의 승리입니다.\n");
	printf(" 고급: 제한시간 1분이내에 깃발 아래에 숨겨진 보물 하나를 찾으면 당신의 승리입니다.\n");
	printf(" 게임 레벨을 선택해 주세요(초급 :1 중급 2: 고급 3),종료하시려면 0을 눌러주세요\n\n");
	printf("----------------------->");
	
	scanf("%d", &input);


	return input;
}

int basic_level() // 초급 레벨의 main함수
{
	time_t start, finish;
	int tx[7], ty[7]; //깃발이 출력될 위치를 지정함 . 보물의 위치는 tx[0], ty[0]이라고 가정함
	int result;
	int matrix[40][20] = { 0, }; // 2차원 배열 정의
	background(matrix); // 게임 테두리 생성
	make_flags(tx, ty);// 깃발 생성
	start = clock();
	result= game_control(tx,ty, &score,matrix); //게임을 컨트롤 하는 함수
	finish = clock();
	
	return (int)((finish - start)/CLOCKS_PER_SEC);
}
void background(int matrix[][20]) // 기본맵 : 게임의 배경화면 생성- 게임의 테두리가 닿으면 게임이 종료됨(matrix2차원 배열에 저장)
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


void make_flags(int tx[], int ty[]) //깃발을 생성하는 함수 깃발이 출발위치에 겹쳐져서 출력되면 다시 생성하여 반복 수행함
{
	int i;
	srand((unsigned)time(NULL));

	for (i = 0; i < 7; i++) 
	{	
		do {
			tx[i] = rand() % 38 + 1;  // 1~38 (테두리 제외)

			ty[i] = rand() % 18 + 1; //1~18 (테두리 제외)

			
		} while (tx[i] == 1 && ty[i] == 18);

		gotoxy(tx[i], ty[i]);
		printf(FLAG_MARK);
	}

}
int game_control(int tx[], int ty[], int* s,int matrix[][20]) // 게임을 컨트롤 하는 함수
{	

	int s_time;
	srand(time(0));
	s_time = time(0);
	int x = 1, y = 18;
	int ch;

		

		while (1) // 키 이동
		{

			gotoxy(50, 12);
			printf("제한시간은 3분입니다.");
			gotoxy(x, y);
			printf(PLAYER_MARK);
			if (time(0) == s_time + TIME_LIMIT_BASIC) // 제한시간을 제어하는 반복문 
						//(초급 -3분의 제한시간이 주어지고 3분이 지나면 fail()함수를 호출
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
			if (matrix[x][y]==1) { // 게임의 테두리를 닿으면 fail()호출 (background()에서 matrix값 지정했음)
				Sleep(1000);
				fail();
			}
			
			else{
				if (x == tx[0] && y == ty[0]) // 보물의 위치와 사용자의 입력키가 일치했을 경우
											//(보물의 위치는 tx[0],ty[0]이라고 가정)
				{
					*s += 500;
					printf("  ");
					printf(TREASURE);
					gotoxy(0, 25);
					printf("보물을 찾았습니다. 다음 단계로 넘어갑니다.");
					Sleep(2000);
					return 1;

				}
				else if (x == tx[1] && y == ty[1])
				{
					gotoxy(0,25);
					*s += 50;
					printf("축하합니다! 점수를 획득했습니다. score =%d",*s);
					Sleep(1000);
					gotoxy(0, 25);
					printf("                                                     ");

					
				}
				else if (x == tx[2] && y == ty[2])
				{
					gotoxy(0, 25);
					*s -= 20;
					printf("벌칙입니다. 점수를 잃었습니다. score =%d", *s);
					Sleep(1000);
					gotoxy(0, 25);
					printf("                                                    \n");
					
				}
				else if (x == tx[3] && y == ty[3])
				{
					gotoxy(0, 25);
					*s = 0;
					printf("당신은 지뢰를 밟았습니다. 점수가 0이 되었습니다. score = % d", *s);
					Sleep(1000);
					gotoxy(0, 25);
					printf("                                                                     \n");
					
				}
				else if (x == tx[4] && y == ty[4])
				{
					gotoxy(0, 25);
					*s += 80;
					printf("축하합니다! 점수를 획득했습니다.score = % d", *s);
					Sleep(1000);

					gotoxy(0, 25); 
					printf("                                                    \n");

					
				}
				else if (x == tx[5] && y == ty[5])
				{
					gotoxy(0, 25);
					printf("폭탄이 터졌습니다.깃발이 재배치 됩니다.score = % d", *s);
					Sleep(1000);
					system("cls");
					background(matrix);
					make_flags(tx, ty);
					gotoxy(x, y);
				}
				else // if-else if문에 해당하지 않는 다른 깃발들은 아무것도 없음
					;
			}



		
	}
}
void fail() // 게임의 테두리가 닿거나, 
//제한시간안에 게임을 clear하지 못했을경우 호출되는 함수
{	
	
	int input;
	system("cls");
	gotoxy(20, 10);
	printf("게임이 종료되었습니다. 다시 시작하시려면 1을 눌러주세요 \n\n");
	printf("----------------------->");
	scanf("%d", &input);

	if (input == 1)// 다시 게임룰을 출력함
	{
		system("cls");
		main();
	} 
	else {// 게임 종료
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
int middle_level() //게임의 중급 레벨
{
	time_t start, finish;
	int tx[13], ty[13]; //깃발이 생성될 위치를 저장하는  1차원 배열 .보물의 위치는 tx[0],ty[0]이라고 지정함
	int result;
	int matrix[50][25] = { 0, };
	background2(matrix); // 게임 테두리 생성
	make_flags2(tx, ty,matrix);// 깃발 생성
	start = clock();
	result = game_control2(tx, ty, &score, matrix); //게임을 컨트롤 하는 함수
	finish = clock();
	return (int)((finish - start) / CLOCKS_PER_SEC);
}
void background2(int matrix[][25]) // 기본맵 : 게임의 테두리 생성 (level1 보다 게임의 배경화면의 크기만 늘렸음
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
void make_flags2(int tx[], int ty[],int a[][25]) //깃발을 생성하는 함수로 level1보다 깃발의 개수가 3개 더 많아지고 추가로 장애물 3개를 생성함
{
	int i;


	srand((unsigned)time(NULL));
	for (i = 0; i < 10; i++) // 깃발 생성(10개)
	{
		do {
			tx[i] = rand() % 48 + 1;  // 1~48 (테두리 제외)

			ty[i] = rand() % 23 + 1; //1~23 (테두리 제외)


		} while ((tx[i] == 1 && ty[i] == 23));

		gotoxy(tx[i], ty[i]);
		printf(FLAG_MARK);
	}
	for (i = 10; i < 13; i++) //장애물 생성(3개)
	{
		do {
			tx[i] = rand() % 48 + 1;  // 1~48 (테두리 제외)

			ty[i] = rand() % 23 + 1; //1~23 (테두리 제외)

		} while ((tx[i] == 1 && ty[i] == 23));
		gotoxy(tx[i], ty[i]);
		printf(OBSTACLE_MARK);
		a[tx[i]][ty[i]] = 2; //장애물이 위치한 곳은 matrix[][]2차원 배열에서 값을 2로 지정함
	}
	

}
int game_control2(int tx[], int ty[], int* s, int matrix[][25]) //level2의 게임을 컨트롤 하는 함수
{

	int s_time;
	srand(time(0));
	s_time = time(0);
	int x = 1, y = 23;
	int ch;


	
	while (1) // 키 이동
	{
		gotoxy(55, 10);
		printf("제한시간은 2분입니다.");
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
		if (matrix[x][y] == 1) { // 게임의 테두리
			fail();
		}
		else if (matrix[x][y] == 2) // 장애물의 위치. 장애물을 밟으면 fail이 실행됨
		{	
			gotoxy(0, 27);
			
			printf("당신은 지뢰를 밟았습니다.게임에 실패하였습니다.");
			Sleep(2000);
			fail();
		}

		else {
			if (x == tx[0] && y == ty[0]) // 보물의 위치와 사용자의 입력키가 일치했을 경우(보물의 위치는 tx[0],ty[0])
			{
				*s += 500;
				printf("   ");
				printf(TREASURE);
				gotoxy(0, 27);
				printf("축하합니다! 보물을 찾았습니다..");
				Sleep(2000);
				return 1;

			}
			else if (x == tx[1] && y == ty[1])
			{
				gotoxy(0, 27);
				printf("축하합니다! 점수를 획득했습니다.score = % d", *s);
				Sleep(1000);
				gotoxy(0, 27);
				printf("                                                           ");

				*s += 70;
			}
			else if (x == tx[2] && y == ty[2])
			{
				gotoxy(0, 27);
				*s -= 100;
				printf("벌칙입니다. 점수를 잃었습니다.score = % d", *s);
				Sleep(1000);
				gotoxy(0, 27);
				printf("                                                    ");
				
			}
			else if (x == tx[3] && y == ty[3])
			{
				gotoxy(0, 27);
				*s = 0;
				printf("당신은 장애물을 밟았습니다. 점수가 0이 되었습니다.score = % d", *s);
				Sleep(1000);
				gotoxy(0, 27);
				printf("                                                                       ");
				
			}
			else if (x == tx[4] && y == ty[4])
			{
				gotoxy(0, 27);
				*s += 80;
				printf("축하합니다! 점수를 획득했습니다.score = % d", *s);
				Sleep(1000);
				gotoxy(0, 27);
				printf("                                                       ");

				
			}
			else if (x == tx[5] && y == ty[5])
			{	
				
				gotoxy(0, 27);
				printf("폭탄이 터졌습니다.깃발이 재배치 됩니다.");
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
				printf("벌칙입니다. 점수를 잃었습니다.score = % d", *s);
				Sleep(1000);
				gotoxy(0, 27);
				printf("                                                     ");
				
			}
			else
				;
		}




	}
}
int high_level() //게임의 고급레벨
{
	time_t start, finish;
	int tx[17], ty[17]; //깃발이 생성될 위치를 저장하는  1차원 배열 .
						//보물의 위치는 tx[0],ty[0], tx[1],ty[1]이라고 지정함

	int result;
	int matrix[50][25] = { 0, };
	background3(matrix); // 게임 테두리 생성
	make_flags3(tx, ty, matrix);// 깃발 생성
	start = clock();
	result = game_control3(tx, ty, &score, matrix); //게임을 컨트롤 하는 함수
	finish = clock();
	return (int)((finish - start) / CLOCKS_PER_SEC);
}
void background3(int matrix[][25]) // 기본맵 : 게임의 테두리 생성
{

	int i, j, k, r; //게임 배경화면 생성


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
void make_flags3(int tx[], int ty[], int a[][25]) //깃발을 생성하는 함수
{
	int i;


	srand((unsigned)time(NULL));
	for (i = 0; i < 12; i++) // 깃발 생성함 (12개)
	{
		do {
			tx[i] = rand() % 48 + 1;  // 1~48 (테두리 제외)

			ty[i] = rand() % 23 + 1; //1~23 (테두리 제외)


		} while ((tx[i] == 1 && ty[i] == 23)); // 깃발의 위치가 게임 플레이어의 초기 위치라면 재생성

		gotoxy(tx[i], ty[i]);
		printf(FLAG_MARK);
	}
	for (i = 12; i < 17; i++) //장애물을 생성함 (5개)
	{
		do {
			tx[i] = rand() % 48 + 1;  // 1~48 (테두리 제외)

			ty[i] = rand() % 23 + 1; //1~23 (테두리 제외)

		} while ((tx[i] == 1 && ty[i] == 23));
		gotoxy(tx[i], ty[i]);
		printf(OBSTACLE_MARK);
		a[tx[i]][ty[i]] = 2;
	}
}
int game_control3(int tx[], int ty[], int* s, int matrix[][25]) //게임을 컨트롤 하는 함수 
{

	int s_time;
	srand(time(0));
	s_time = time(0);
	int x = 1, y = 23;
	int ch;
	int count = 0;

	

	while (1) // 키 이동
	{
		gotoxy(55, 10);
		printf("제한시간은 1분입니다.");
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
		if (matrix[x][y] == 1) { //게임의 테두리를 밟으면 fail()생성
			fail();
		}
		else if (matrix[x][y] == 2) //장애물을 밟으면 fail()생성
		{
			gotoxy(0, 27);
			printf("당신은 지뢰를 밟았습니다.게임에 실패하였습니다.");
			fail();
		}

		else {
			if ((x == tx[0] && y == ty[0])) // 보물의 위치와 사용자의 입력키가 일치했을 경우
											//(보물의 위치는 tx[0],ty[0]).
											//count값을 이용하여 두가지의 보물을 찾으면 
											//종료하도록 실행함
			{
				gotoxy(0, 27);
				*s += 1000;
				printf("축하합니다! 보물을 찾았습니다! score = % d", *s);
				Sleep(1000);
				gotoxy(0, 27);
				printf("                                                            ");
				
				gotoxy(x, y);
				printf("  ");
				printf(TREASURE);
				
				count++;

			}
			else if (x == tx[1] && y == ty[1]) //두 번째 보물의 위치는 tx[1],ty[1] 
			{
				gotoxy(0, 27);
				*s += 1000;
				printf("축하합니다!보물을 찾았습니다! score = % d", *s);
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
				printf("벌칙입니다. 점수를 잃었습니다.score = % d", *s);
				Sleep(1000);
				gotoxy(0, 27);
				printf("                                                   ");
				
			}
			else if (x == tx[3] && y == ty[3])
			{
				gotoxy(0, 27);
				*s = 0;
				printf("당신은 장애물을 밟았습니다. 점수가 0이 되었습니다.score = % d", *s);
				Sleep(1000);
				gotoxy(0, 27);
				printf("                                                                       ");
				
			}
			else if (x == tx[4] && y == ty[4])
			{
				gotoxy(0, 27);
				*s += 80;
				printf("축하합니다! 점수를 획득했습니다.score = % d", *s);
				Sleep(1000);
				gotoxy(0, 27);
				printf("                                                        ");

				
			}
			else if (x == tx[5] && y == ty[5])
			{

				gotoxy(0, 27);
				printf("폭탄이 터졌습니다.깃발이 재배치 됩니다.");
				count = 0; //이전에 얻었던 보물도 모두 초기화됨
				Sleep(1000);
				system("cls");
				background2(matrix);// 게임 테두리 생성
				make_flags2(tx, ty, matrix); // 깃발 생성
				gotoxy(x, y);
			}
			else if (x == tx[6] && y == ty[6])
			{
				gotoxy(0, 27);
				*s -= 50;
				printf("벌칙입니다. 점수를 잃었습니다. score = % d", *s);
				Sleep(1000);
				gotoxy(0, 27);
				printf("                                                   ");
				
			}
			else if (x == tx[7] && y == ty[7])
			{
				gotoxy(0, 27);
				*s -= 80;
				printf("벌칙입니다. 점수를 잃었습니다.score = % d", *s);
				Sleep(1000);
				gotoxy(0, 27);
				printf("                                                   ");
				
			}
			else if (x == tx[8] && y == ty[8])
			{
				gotoxy(0, 27);
				*s += 100;
				printf("축하합니다! 점수를 획득했습니다.score = % d", *s);
				Sleep(1000);
				gotoxy(0, 27);
				printf("                                                      ");
				
			}
			else
				;
		}
		if (count == 2) //count값이 2이면 보물을 두개 다 찾았으므로 게임clear로 종료함
		{
			gotoxy(0, 27);
			printf("보물 2개를 모두다 찾았습니다. 게임 clear입니다!");
			Sleep(3000);
			return 1;
		}


	}
}
