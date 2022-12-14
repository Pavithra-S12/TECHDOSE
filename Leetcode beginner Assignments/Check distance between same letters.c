bool checkDistances(char * s, int* distance, int distanceSize){
    int len = strlen(s);
    for(int i = 0; i < len; i++){
        int idx = s[i]-'a';
        int dist = distance[idx] + 1 + i;
        if(distance[idx]>=0 && dist < len && s[dist] == s[i]){
            distance[idx] = -1;
        }
        else if(distance[idx] != -1 || dist >= len)
            return false;
    }
    return true;
}
