#include <stdio.h>
# define ABS(x) ((x) < 0 ? -(x) : (x))
void    init(int *arr, int size)
{
    int i;

    i = 0;
    while (i < size)
    {
        arr[i] = 0;
        i++;
    }
}

int     check(int *arr, int index, int num)
{
    int i;
    int x1;
    int y1;
    int x2;
    int y2;

    i = 0;
    x2 = index;
    y2 = num;
    while (i < index)
    {
        x1 = i;
        y1 = arr[i];
        if (y2 == y1)
            return 0;
        if (ABS(x2 - x1) == ABS(y2 - y1))
            return 0;
        i++;
    }
    return 1;
}

void    solve(int *arr, int size, int index, int *count)
{
    int i, j;

    if (index == size)
        (*count)++;
    else
    {
        i = 0;
        while (i < size)
        {
            if(check(arr, index, i))
            {
                arr[index] = i;
                solve(arr, size, index + 1, count);
            }
            i++;
        }
    }
}

int main()
{
    int n;
    int result;

    scanf("%d", &n);
    int arr[n];
    result = 0;
    init(arr, n);
    solve(arr, n, 0, &result);
    printf("%d", result);
}