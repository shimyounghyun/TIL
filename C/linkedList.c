#include <stdio.h>
#include <stdlib.h> 

#define MAX_NODE 100
 
typedef struct listNode
{
    int data;
    struct listNode* prev;
    struct listNode* next;
} ListNode;
 
typedef struct
{
    int use;
    ListNode node;
} ListNodeHeap;

typedef struct{
    ListNode node;
} TT;

ListNodeHeap heap[MAX_NODE];
     
void initHeap(void)
{
    int i;
    for (i = 0; i < MAX_NODE; i++)
    {
        heap[i].use = 0;
    }
}
 
void initListNode(ListNode* node)
{
    node->data = 0;
    node->prev = node;
    node->next = node;
}
 
ListNode* getListNode(void)
{
    int i;
    for (i = 0; i < MAX_NODE; i++)
    {
        if (!heap[i].use)
        {
            heap[i].use = 1;
            initListNode(&heap[i].node);
            return &heap[i].node;
        }
    }
    return NULL;
}
 
void destroyListNode(ListNode* node)
{
    ListNodeHeap* heap_node = (ListNodeHeap*)((int*)node - 1);
    heap_node->use = 0;
}
 
ListNode* appendListNode(ListNode* list, int data)
{
    ListNode* node = getListNode();
    node->data = data;
    if (list == NULL)
    {
        return node;
    }
    else
    {
        ListNode* last = list->prev;
        last->next = node;
        list->prev = node;
        node->prev = last;
        node->next = list;
        return list;
    }
}
 
ListNode* removeListNode(ListNode* list, ListNode* node)
{
    if (list == list->next)
    {
        destroyListNode(node);
        return NULL;
    }
    else
    {
        ListNode* prev = node->prev;
        ListNode* next = node->next;
        prev->next = next;
        next->prev = prev;
        destroyListNode(node);
        return (list == node) ? next : list;
    }
}

int main(int argc, char* argv[])
{
 
    int T, N;
    int a = 5;
    
    // setbuf(stdout, NULL);
    ListNode* list = NULL;
    initHeap();
    list = appendListNode(list, 1);
    list = appendListNode(list, 2);
    list = appendListNode(list, 3);
    list = removeListNode(list,list);
    list = appendListNode(list,4);

    // printf("%d",list->data);
    // printf("%d",list->next->data);
    // printf("%d",list->next->next->data);
    printf("%d",heap[0].use);
    printf("%d",heap[0].node.data);

    // printf("%p\n", list);
    // printf("%p\n", (int*)list);
    // printf("%p\n", (int*)list-1);
    // printf("%p\n", (ListNodeHeap*)((int*)list - 1));
    // printf("%p\n", &(((ListNodeHeap*)((int*)list - 1))->use));
    // printf("%p\n", &(heap[0].use));
    // printf("%d\n", heap[0].use);
    // destroyListNode(list);
    
    // ListNodeHeap* l = (ListNodeHeap*)((int*)list - 1);
    // l->use = 0;
    // ((ListNodeHeap*)((int*)list - 2))->use = 0;
    // printf("%d\n", heap[0].use);

    // printf("%ld", sizeof(ListNodeHeap));

    // removeListNode(list,list);
    // ListNode* h = list;
    // printf("%d",h->data);
    // printf("%d\n",list->data);
    // printf("%p",&list);
    // printf("%d",list->next->data);
    // printf("%d",list->next->next->data);
    // do{
    //     printf("%d",list->data);
    //     list = list->next;
    // }while(list != h);

    // printf("%d", list->data);
    // printf("%d", list->next->data);
    // printf("%d", list->next->next->data);
    // scanf("%d", &T);
 
    // for (int test_case = 1; test_case <= T; ++test_case)
    // {
    //     ListNode* list = NULL;
    //     ListNode* node;
    //     int i;
 
    //     initHeap();
 
    //     scanf("%d", &N);
    //     for (i = 0; i < N; i++)
    //     {
    //         int data;
    //         scanf("%d", &data);
    //         list = appendListNode(list, data);
    //     }
 
    //     node = list;
    //     while (list != list->next)
    //     {
    //         ListNode* nextNode = node->next;
    //         list = removeListNode(list, node);
    //         node = nextNode->next->next;
    //     }
 
    //     printf("#%d %d\n", test_case, list->data);
    // }
    return 0;
}
