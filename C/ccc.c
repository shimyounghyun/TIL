#include <stdio.h>
#include <stdlib.h>

typedef struct      s_btree
{
    struct s_btree  *left;
    struct s_btree  *right;
    void            *item;
}                   t_btree;

t_btree         *btree_create_node(void *item);

t_btree *btree_create_node(void *item)
{
    t_btree *node;
    if(!(node = (t_btree*)malloc(sizeof(t_btree))))
        return (NULL);
    node->item = item;
    node->right = 0;
    node->left = 0;
    return (node);
}

int compare(void *a, void* b)
{
    return *((int*)a)-*((int*)b);
}

void btree_insert_data(t_btree **root, void *item, int (*cmpf)(void *, void *))
{
    t_btree *node;
    node = btree_create_node(item); //새로운 노드를 만들어서 item을 넣어준다.

    if(!(*root)->item)    //root 노드가 null이면 
    {
        *root = node;   //node를 root로 해준다.
    }
    else    //root가 null이 아니면
    {
        if((cmpf((*root)->item, node->item)) > 0)
        {
            if((*root)->left){
                btree_insert_data(&(*root)->left, item,cmpf);
            }else{
                (*root)->left = node;
            }            
        }
        else
        {
            if((*root)->right){
                btree_insert_data(&(*root)->right, item,cmpf);
            }else{
                (*root)->right = node;
            }            
        }
        
    }

}

void *btree_search_item(t_btree *root, void *data_ref, int(*cmpf)(void *, void *))
{
    if(!data_ref){
        root = data_ref;
        return;
    }

    if(cmpf(root->item, data_ref) > 0 )
    {
        btree_search_item(root->left, data_ref, cmpf);
    }else if(cmpf(root->item, data_ref) < 0)
    {
        btree_search_item(root->right, data_ref, cmpf);
    }

    
}
int main(int argc, char const *argv[])
{
    int a = 10;
    int b = 5;
    int c = 12;
    int d = 6;

    t_btree *root = btree_create_node(&a);
    // btree_insert_data(&root, &a, compare);
    btree_insert_data(&root, &b, compare);
    btree_insert_data(&root, &c, compare);
    btree_insert_data(&root, &d, compare);
    printf("%d \n", *((int*)(root->item)));
    printf("%d \n", *((int*)(root->left->item)));
    printf("%d \n", *((int*)(root->right->item)));
    printf("%d \n", *((int*)(root->left->right->item)));
    // btree_insert_data(&root, &d, compare);
    // printf("%d \n", *((int*)(root->left->right->item)));
    return 0;
}