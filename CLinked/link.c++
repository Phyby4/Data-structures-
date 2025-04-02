#include <stdio.h>
#include <stdlib.h>

// Node structure
struct Node {
    int data;
    struct Node* next;
};

// Stack structure
struct Stack {
    struct Node* top;
};

// Function to initialize the stack
void initStack(struct Stack* stack) {
    stack->top = NULL;
}

// Check if stack is empty
int isEmpty(struct Stack* stack) {
    return stack->top == NULL;
}

// Push operation
void push(struct Stack* stack, int item) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    if (!newNode) {
        printf("Memory allocation failed\n");
        return;
    }
    newNode->data = item;
    newNode->next = stack->top;
    stack->top = newNode;
}

// Pop operation
int pop(struct Stack* stack) {
    if (isEmpty(stack)) {
        printf("Stack Underflow\n");
        return -1;
    }
    struct Node* temp = stack->top;
    int popped = temp->data;
    stack->top = stack->top->next;
    free(temp);
    return popped;
}

// Peek operation
int peek(struct Stack* stack) {
    if (isEmpty(stack)) {
        printf("Stack is empty\n");
        return -1;
    }
    return stack->top->data;
}

// Main function to test the stack
int main() {
    struct Stack stack;
    initStack(&stack);
    
    push(&stack, 1);
    push(&stack, 2);
    push(&stack, 3);

    printf("Stack contents:\n");
    while (!isEmpty(&stack)) {
        printf("%d\n", pop(&stack));
    }
    
    return 0;
}
