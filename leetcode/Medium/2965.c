/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int *findMissingAndRepeatedValues(int **grid, int gridSize, int *gridColSize, int *returnSize)
{
    *returnSize = 2;
    int *answer = (int *)calloc(*returnSize, sizeof(int));

    int *nums = (int *)calloc(gridSize * gridSize, sizeof(int));

    for (int i = 0; i < gridSize * gridSize; i++)
    {
        int index = grid[i / gridSize][i % gridSize] - 1;

        nums[index] += 1;
    }

    for (int i = 0; i < gridSize * gridSize; i++)
    {
        if (nums[i] > 1)
        {
            answer[0] = i + 1;
        }
        else if (nums[i] == 0)
        {
            answer[1] = i + 1;
        }
    }

    free(nums);

    return answer;
}