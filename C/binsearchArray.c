#include <stdio.h>

int test_case[30] = {1,3,5,6,7,8,11,12,14,15,24,26,42,43,48,49,51,55,56,59,66,67,69,70,71,73,75,80,96,99};

// Array 이진 검색
void binsearch(int find){
	int start = 0;
	int end = (sizeof(test_case) / sizeof(int)) - 1; // 배열 원소 개수 - 1 == 마지막 index
	int mid = (start+end)/2;

	while (start <= end){
		mid = (start+end)/2;
		if (test_case[mid] == find){
			printf("find index : %d\n", mid); // 일치하는 인덱스 출력후 종료
			return;
		}else if (test_case[mid] < find){
			start = mid+1;
		}else{
			end = mid-1;
		}
	}
	printf("not found\n");
}

int main(){
	
	int find[5] = {3,96,15,66,99};

	for (int i=0; i<5; i++){
		binsearch(find[i]);
	}
	return (0);
}
