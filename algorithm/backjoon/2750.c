#include <stdio.h>

void    qsort(int *arr, int start, int end)
{
    int pivot;
    int i;
    int j;
    int temp;

    if (start < end)
    {
        pivot = start;
        i = start + 1;
        j = end;
        while (i < j)
        {
            while (arr[pivot] >= arr[i] && i < j)
                i++;
            while (arr[pivot] < arr[j])
                j--;
            if (i < j)
            {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        temp = arr[pivot];
        arr[pivot] = arr[j];
        arr[j] = temp;
        for(int i=0; i<5; i++)
        {
            printf("%d ",arr[i]);
        }
        printf("pivot : %d, j : %d", pivot, j);
        printf("\n");
        qsort(arr, start, j - 1);
        qsort(arr, j + 1, end);
    }
}

int main()
{
    int n;
    
    scanf("%d", &n);
    int arr[n];
    
    for(int i = 0; i < n; i++)
    {
        scanf("%d", &arr[i]);
    }
    qsort(arr, 0, n - 1);
    // for(int i=0; i<n; i++)
    // {
    //     printf("%d\n",arr[i]);
    // }
}