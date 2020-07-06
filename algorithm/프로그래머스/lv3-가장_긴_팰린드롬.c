#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(const char* s) {
    int answer = 1;

    while (*s){
        if (*s == *(s+1)){
            int i = 1;
            while (*(s-i) && *(s+1+i) && *(s-i) == *(s+1+i))
                i++;
            if (answer < i*2)
                answer = i*2;
        }
        if (*s == *(s+2)){
            int i = 1;
            while (*(s-i) && *(s+2+i) && *(s-i) == *(s+2+i))
                i++;
            if (answer < i*2+1)
                answer = i*2+1;
        }
        s++;
    }
    return answer;
}
