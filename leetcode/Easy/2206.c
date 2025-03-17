bool divideArray(int *nums, int numsSize)
{
    int map[501] = {
        0,
    };
    int pairCount = 0;

    for (int i = 0; i < numsSize; i++)
    {
        map[nums[i]]++;
    }

    for (int i = 0; i < 501; i++)
    {
        if (map[i] % 2 != 0)
        {
            return false;
        }
    }

    return true;
}