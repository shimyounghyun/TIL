#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

void solve(int index, int max, int *result, int front)
  {
       if (index == max*2 && front == 0)
           (*result)++;
       else if (front > max || front < 0 || index > max*2)
          return;
     else
      {
          solve(index+1, max, result, front+1);
          solve(index+1, max, result, front-1);
      }
  }
  int solution(int n) {
      int answer = 0;
      solve(1, n, &answer, 1);
      return answer;
  }
