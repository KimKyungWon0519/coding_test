int minimumRecolors(char* blocks, int k) {
    int length = strlen(blocks);
    int answer = length;
    int windowChange = 0;

    for(int i = 0; i < length; i++) {
        if(blocks[i] == 'W') {
            windowChange++;
        }

        if(i >= k - 1) {
            if(windowChange < answer) {
                answer = windowChange;
            }

            if(blocks[i - (k - 1)] == 'W') {
                windowChange -= 1;
            }
        }
    }

    return answer;
}