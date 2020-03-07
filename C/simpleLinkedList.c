#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct ListNode{ //단순 연결 리스트의 노드 구조 정의
    char data[10];
    struct ListNode* link;
} listNode;

typedef struct{
    listNode* head;
} linkedList_h;

linkedList_h* createLinkedList_h(void);



linkedList_h* createLinkedList_h(void){
    linkedList_h* L;
    L = (linkedList_h*)malloc(sizeof(linkedList_h));
    L->head = NULL;
    return L;
}

void addLastNode(linkedList_h* L, char* x){    
    listNode* newNode;
    listNode* p;
    newNode = (listNode*)malloc(sizeof(listNode));
    strcpy(newNode->data, x);
    newNode->link=NULL;
    if(L->head == NULL){
        L->head = newNode;
        return;
    }
    p = L->head;
    while(p->link != NULL) p = p->link;
    p->link = newNode;
}

void reverse(linkedList_h *L){
    listNode* p;
    listNode* q;
    listNode* r;

    p = L->head;
    q=NULL; 
    r=NULL;

    while(p!=NULL){
        r = q;
        q = p; //현재
        p = p->link; //다음
        q->link = r;
    }
    L->head = q;
}