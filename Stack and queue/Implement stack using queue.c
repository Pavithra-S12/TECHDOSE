typedef struct {
    int head, tail;
    int* queue;
} MyQueue;

typedef struct {
    int Q_size;
    MyQueue* Q;
} MyStack;

#define MAX_STACK_SIZE 50
bool myStackEmpty(MyStack* obj);

MyStack* myStackCreate() {
    MyStack* tempStack = (MyStack*)malloc(sizeof(MyStack));
    tempStack->Q = (MyQueue*)malloc(sizeof(MyQueue));
    tempStack->Q->queue = (int*)malloc(MAX_STACK_SIZE*sizeof(int));
    tempStack->Q->head = -1;
    tempStack->Q->tail = -1;
    tempStack->Q_size = 0;
    return tempStack;
}

int myQueuepop(MyQueue* Q){
    int temp = Q->queue[Q->head];
    Q->head = (Q->head + 1) % MAX_STACK_SIZE;
    return temp;
}

bool myQueuepush(MyQueue* Q, int val){
    if(Q->head == -1){
        Q->head = 0;
    }
    Q->tail = (Q->tail + 1) % MAX_STACK_SIZE; 
    Q->queue[Q->tail] = val;
    return true;
}

void myStackPush(MyStack* obj, int x) {
    myQueuepush(obj->Q, x);
    obj->Q_size++;
}

int myStackPop(MyStack* obj) {
    if(myStackEmpty(obj)){
        return INT_MIN;
    }else{
        int i, temp;
        for(i=0; i<obj->Q_size-1; i++){
            temp = myQueuepop(obj->Q);
            obj->Q->tail = (obj->Q->tail + 1) % MAX_STACK_SIZE; 
            obj->Q->queue[obj->Q->tail] = temp;
        }
        temp = myQueuepop(obj->Q);
        obj->Q_size--;
        return temp;
    }
}

int myStackTop(MyStack* obj) {
    return obj->Q->queue[obj->Q->tail];
}

bool myStackEmpty(MyStack* obj) {
    return obj->Q_size == 0;
}

void myStackFree(MyStack* obj) {
    free(obj->Q->queue);
    free(obj->Q);
    free(obj);
}
