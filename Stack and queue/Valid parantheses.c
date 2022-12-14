bool isValid(char * s){
    char stack[10000];
    int top = -1;
    
    char c = *s;
    int i = 0;
    while (c) {
       if (c=='(' || c=='[' || c=='{')
           stack[++top] = c;
       else {
           if (top == -1) // stack is empty
               return false;
           switch (c) // mismatch opened and closing parenthesis
           {
               case ')': if (stack[top] != '(') return false; break;
               case ']': if (stack[top] != '[') return false; break;
               case '}': if (stack[top] != '{') return false; break;
           }
              
           top--;
       }
       
       i++;
       c = *(s+i);
    }
    return top==-1;
}
