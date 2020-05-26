#include <stdio.h>
#define MAX 81
int stack[MAX][2]; // 81개의 행과열을 담을 stack 선언
int top = -1;   // stack top
int dirX[4] = {1, -1, 0, 0};
int dirY[4] = {0, 0, 1, -1};

int push(int i, int j, int k){ // 스택에 값을 넣는 함수
    top++;
    stack[top][0] = i;
    stack[top][1] = j;
    return 1;
}

int isEmpty(void){ // 스택이 비어있는지 확인 하는 함수
    return top < 0;
}

int* pop(void){ // 스택에 값을 하나 꺼내는 함수
    return (int*)stack[top--];
}

void printStack(void){ // 스택에 담긴 값들을 출력하는 함수
    int i;
    printf("The path is as follows.\n");
    for (i = 0; i <= top; i++){
        printf("[%d, %d]\n", stack[i][0],stack[i][1]);
    }
}

void mazePath() {
    // 미로
    int maze[9][9] = {
        {0, 1, 0, 0, 0, 1, 0, 0, 0},
        {0, 1, 0, 1, 0, 1, 0, 1, 0},
        {0, 1, 0, 1, 0, 1, 0, 1, 0},
        {0, 1, 0, 1, 0, 1, 0, 1, 0},
        {0, 1, 0, 1, 0, 1, 0, 1, 0},
        {0, 1, 0, 1, 0, 1, 0, 1, 0},
        {0, 1, 0, 1, 0, 1, 0, 1, 0},
        {0, 1, 0, 1, 0, 1, 0, 1, 0},
        {0, 0, 0, 1, 0, 0, 0, 1, 0},
    };    
    // 방문 위치를 표시
    int mark[9][9] = {
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0}
    };    
    push(0, 0, 0);
    mark[0][0] = 1; // 현재 위치 방문 표시
    while (top >= 0){
        int *data = pop();
        int i = data[0];
        int j = data[1];
        int k = data[2];
        while (k < 4){
            int nextI = i+dirY[k]; //다음 시도할 행(i)를 설정
            int nextJ = j+dirX[k]; //다음 시도할 열(j)를 설정
            if (nextI == 8 && nextJ == 8){ //미로 발견
                printStack(); //스택에 저장된 경로 출력
                return;
            }
            // 이동 가능 여부 검사, 하나라도 해당된다면 이동 불가능
            // 1. 0~9 범위 체크
            // 2. mark배열 : 이미 방문한 곳 체크
            // 3. maze배열 : 이동가능한 경로(0), 불가능(1) 체크
            if (nextI < 0 || nextI >= 9 || nextJ < 0 || nextJ >= 9                
                || mark[nextI][nextJ]
                || maze[nextI][nextJ]){
                k++; // 다음 이동할 방향을 설정
            }else{
                mark[nextI][nextJ] = 1;
                push(nextI, nextJ, k); //이동한 위치를 스택에 저장
                i = nextI;
                j = nextJ;
                k = 0;
            }
        }
    }
    printf("There is no path\n"); // 미로 경로가 없는 경우
}

int main(){
    mazePath();
	return 0;
}

