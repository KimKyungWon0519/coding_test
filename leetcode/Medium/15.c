/**
 * Return an array of arrays of size *returnSize.
 * The sizes of the arrays are returned as *returnColumnSizes array.
 * Note: Both returned array and *columnSizes array must be malloced, assume caller calls free().
 */
#include <stdio.h>
#include <stdlib.h>

int compare(const void* a, const void* b) {
    return *(int*)a - *(int*)b;
}

int** threeSum(int* nums, int numsSize, int* returnSize, int** returnColumnSizes) {
    int answerLength = 1;
    int** answer = (int**)calloc(answerLength, sizeof(int*));

    int count = 0;

    qsort(nums, numsSize, sizeof(int), compare);

    for(int i = 0; i < numsSize; i++) {
        if(i > 0 && nums[i] == nums[i - 1]) continue;

        int left = i + 1, right = numsSize - 1;

        while (left < right)
        {
            int sum = nums[i] + nums[left] + nums[right];

            if(sum == 0) {
                if(count == answerLength) {
                    answerLength *= 2;

                    answer = (int**)realloc(answer, answerLength * sizeof(int*));
                } 

                answer[count] = (int*)calloc(3, sizeof(int));

                answer[count][0] = nums[i];
                answer[count][1] = nums[left];
                answer[count][2] = nums[right];

                count++;

                while(left < right && nums[left] == nums[left + 1]) left++;
                while(left < right && nums[right] == nums[right - 1]) right--;

                left++;
                right--;
            } else if(sum < 0) {
                left++;
            } else if(sum > 0) {
                right--;
            }
        }
    }

    *returnSize = count;
    *returnColumnSizes = (int*)calloc(*returnSize, sizeof(int));
    
    for (int i = 0; i < count; i++) {
        (*returnColumnSizes)[i] = 3;
    }

    return answer;
}

int main(int argc, char const *argv[])
{
    int nums[] = { 2,-3,0,-2,-5,-5,-4,1,2,-2,2,0,2,-4,5,5,-10 };
    int numSize = sizeof(nums) / sizeof(int);
    int returnSize = 0;
    int* returnColumnSizes = 0;

    threeSum(nums, numSize, &returnSize, &returnColumnSizes);

    return 0;
}
