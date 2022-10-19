bool equalFrequency(char * word){
    int freq[26] = {0}, freqFreq[101] = {0}, l = INT_MAX, h = 0;
    size_t len = 0;
    for (; word[len]; len++) freq[word[len] - 'a']++;
    for (size_t i = 0; i < 26; i++) freqFreq[freq[i]]++;
    if (freqFreq[1] == len) return true;
    for (int i = 1; i < 101; i++)
        if (freqFreq[i]) {
            if (i < l) l = i;
            h = i;
        }
    return (h == l && freqFreq[h] == 1) || (h - l == 1 && (freqFreq[h] == 1 || freqFreq[l] == 1));
}
