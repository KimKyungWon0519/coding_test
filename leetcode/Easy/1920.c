/**
 * Note: The returned array must be malloced, assume caller calls free().
 */

#include <stdio.h>
#include <stdlib.h>

int* buildArray(int* nums, int numsSize, int* returnSize) 
{
    int* ans = (int*)calloc(numsSize, sizeof(int));

    for(int i = 0; i < numsSize; i++) 
    {
        ans[i] = nums[nums[i]];
    }

    *returnSize = numsSize;

    return ans;
}

int main(int argc, char const *argv[])
{
    int nums[] = {5,0,1,2,3,4};
    int numsSize = sizeof(nums) / sizeof(int);
    int returnSize = 0;

    buildArray(nums, numsSize, &returnSize);

    return 0;
}
