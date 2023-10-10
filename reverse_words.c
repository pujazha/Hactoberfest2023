// A program from scratch that reverses the words in a sentence.
// Example, if there is a sentence "Hello World" then the output will be "World Hello"
#include <stdio.h>
#include <string.h>

int main() {
    int i, j, k;
    char original[100];
    char word[100][100]; 
    int count = 0;
    j=0;
    printf("Enter a sentence: ");
    gets(original);
    for (i = 0; i < strlen(original); i++) {
        if (original[i] != ' '){
            word[count][j++] = original[i];
        }
        else {
            word[count][j] = '\0'; 
            count++;
            j = 0; 
        }
    }
    for (k = count; k >= 0; k--) {
        printf("%s", word[k]);
        if (k > 0) {
            printf(" "); 
        }
    }
    return 0;
}
