#include <stdlib.h>
#include <stdio.h>

typedef struct btree
{
    struct btree *left;
    struct btree *right;
    void    *item;
} btree;

btree *btree_create_node(void *item)
{
    btree* node = (btree*)malloc(sizeof(btree));
    node->item = item;
    node->left = 0;
    node->right = 0;
    return node;
}

void btree_apply_prefix(btree *root, void (*applyf)(void *))
{
    applyf(root->item);
    if(root->left)
        btree_apply_prefix(root->left,applyf);
    if(root->right)
        btree_apply_prefix(root->right,applyf);
}

void btree_apply_infix(btree *root, void(*applyf)(void *))
{
    if(root->left)
        btree_apply_prefix(root->left,applyf);
    applyf(root->item);
    if(root->right)
        btree_apply_prefix(root->right,applyf);
}

void btree_apply_suffix(btree *root, void(*applyf)(void *))
{
    if(root->left)
        btree_apply_prefix(root->left,applyf);    
    if(root->right)
        btree_apply_prefix(root->right,applyf);
    applyf(root->item);
}

void applyf(void *element)
{
    printf("%s\n", element);
}

int cmpf(void *item1, void *item2)
{
    // int *intItem1 = (int*)item1;
    // int *intItem1 = (int*)item2;

    // return (*intItem1 - *intItem1);
    return 1;
}

void btree_insert_data(btree **root, void *item, int (*cmpf)(void *, void *))
{
    //왼쪽 크면 양수

    btree *newNode;
    btree *parent;
    btree *temp;
    newNode = btree_create_node(item);
    temp = *root;

    if(!temp){
        *root = newNode;
        return;
    } 
    
    while(temp->left || temp->right)
    {
        parent = temp;
        if(cmpf(temp->item, item) <= 0){
            temp = temp->right;
        }else{
            temp = temp->left;
        }
    }

    if(cmpf(parent->item, item) <= 0){
        parent->right = newNode;
    }else{
        parent->left = newNode;
    }
}

void test(int **arg){
    printf("%p",*arg);
}

int main(int argc, char const *argv[])
{
    int a = 1;
    int b = 2;
    int c = 3;
    int d = 4;

    int *ap = &a;
    test(&ap);
    return 0;
}
