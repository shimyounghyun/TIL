#include <stdio.h>
#include <stdlib.h>

typedef struct TreeNode
{
    int key;
    struct TreeNode *left;
    struct TreeNode *right;
} TreeNode;

// TreeNode *search(TreeNode *node, int key)
// {
//     if(!node)
//         return NULL;

//     if(key == node->key)
//         return node;
//     else if(key > node->key)
//         search(node->right, key);
//     else
//         search(node->left, key);
// }

void insert_node(TreeNode **root, int key)
{
    TreeNode *p; //부모
    TreeNode *t; //현재
    TreeNode *n; //새로운


    t = *root;
    p = NULL;

    while(t)
    {
        if(key == t->key) return;
        p = t;

        if(key < p->key)
            t = p->left;
        else
            t = p->right;
    }

    n = (TreeNode*)malloc(sizeof(TreeNode));
    if(!n) return;
    if(p)
    {
        if(key < p->key)
            p->left = n;
        else
            p->right = n;
    }
    else
    {
        *root = n;
    }
}


void delete_node(TreeNode **root, int key)
{
    TreeNode *parent, *child, *suc, *suc_p, *t;

    parent = NULL;
    t = *root;

    while(t != NULL && t->key != key)
    {
        parent = t;
        t = (key < parent->key) ? parent->left : parent->right;
    }

    suc_p = t;
    suc = t->right;
    while(suc->left != NULL)
    {
        suc_p = suc;
        suc = suc->left;
    }

}


int main(int argc, char const *argv[])
{
    // int local = 10;
    // int *value = &local;
    // int *refer = &local;

    // printf("before : *value=%d, *refer=%d\n", *value, *refer); 
    // call_by_value(value); 
    // call_by_refer(&refer); 
    // printf("after : *value=%d, *refer=%d\n", *value, *refer);

    return 0;
}
