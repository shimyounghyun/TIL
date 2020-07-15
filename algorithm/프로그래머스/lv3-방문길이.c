#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>
int map[11][11][11][11];
int dx[4] = {0,0,1,-1};
int dy[4] = {1,-1,0,0};
enum {U,D,R,L};
int solution(const char* dirs) {
    int answer = 0;
    int x = 5;
    int y = 5;
    while (*dirs){
        int nx = x;
        int ny = y;
        if (*dirs == 'U'){
            nx += dx[U];
            ny += dy[U];
        }else if (*dirs == 'D'){
            nx += dx[D];
            ny += dy[D];
        }else if (*dirs == 'L'){
            nx += dx[L];
            ny += dy[L];
        }else if (*dirs == 'R'){
            nx += dx[R];
            ny += dy[R];
        }
        if (nx < 0|| ny < 0 || nx > 10 || ny > 10){ 
            dirs++;
            continue;
        }
        if (map[x][y][nx][ny] != 1)
            answer++;
        map[x][y][nx][ny] = 1;
        map[nx][ny][x][y] = 1;
        x = nx;
        y = ny;
        dirs++;
    }
    return answer;
}
