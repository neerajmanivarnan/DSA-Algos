#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

#define MAX_LINE_LENGTH 100

void trim_leading_whitespace(char * str) {
    char * temp = str;
    while (isspace((unsigned char) * temp)) temp++;
    if (temp != str) memmove(str, temp, strlen(temp) + 1);
}

void generate_assembly(FILE * input, FILE * output) {
    char line[MAX_LINE_LENGTH];
    char op[10], arg1[10], arg2[10], result[10];
    while (fgets(line, sizeof(line), input)) {
        op[0] = arg1[0] = arg2[0] = result[0] = '\0';

        trim_leading_whitespace(line);

        if (sscanf(line, "%s = %s", result, arg1) == 2 && strchr(line, '+') == NULL && strchr(line, '-') ==
            NULL && strchr(line, '*') == NULL && strchr(line, '/') == NULL) {
            fprintf(output, "\tMOV %s, %s\n", result, arg1);

        } else if (sscanf(line, "%s = %s + %s", result, arg1, arg2) == 3) {
            fprintf(output, "\tMOV AX, %s\n", arg1);
            fprintf(output, "\tADD AX, %s\n", arg2);
            fprintf(output, "\tMOV %s, AX\n", result);

        } else if (sscanf(line, "%s = %s - %s", result, arg1, arg2) == 3) {
            fprintf(output, "\tMOV AX, %s\n", arg1);
            fprintf(output, "\tSUB AX, %s\n", arg2);
            fprintf(output, "\tMOV %s, AX\n", result);

        } else if (sscanf(line, "%s = %s * %s", result, arg1, arg2) == 3) {
            fprintf(output, "\tMOV AX, %s\n", arg1);
            fprintf(output, "\tMOV BX, %s\n", arg2);
            fprintf(output, "\tMUL BX\n");
            fprintf(output, "\tMOV %s, AX\n", result);

        } else if (sscanf(line, "%s = %s / %s", result, arg1, arg2) == 3) {
            fprintf(output, "\tMOV AX, %s\n", arg1);
            fprintf(output, "\tMOV BX, %s\n", arg2);
            fprintf(output, "\tDIV BX\n");
            fprintf(output, "\tMOV %s, AX\n", result);
        } else if (sscanf(line, "goto %s", arg1) == 1) {
            fprintf(output, "\tJMP %s\n", arg1);

        } else if (sscanf(line, "if %s < %s goto %s", arg1, arg2, result) == 3) {
            fprintf(output, "\tMOV AX, %s\n", arg1);
            fprintf(output, "\tCMP AX, %s\n", arg2);
            fprintf(output, "\tJL %s\n", result);
        } else if (sscanf(line, "if %s <= %s goto %s", arg1, arg2, result) == 3) {
            fprintf(output, "\tMOV AX, %s\n", arg1);
            fprintf(output, "\tCMP AX, %s\n", arg2);
            fprintf(output, "\tJLE %s\n", result);

        } else if (sscanf(line, "%s:", result) == 1) {
            fprintf(output, "%s:\n", result);
        }
    }
}
int main() {
    FILE * input = fopen("input.txt", "r");
    FILE * output = fopen("output.txt", "w");
    if (!input || !output) {
        perror("Error : ");
        return 1;
    }
    generate_assembly(input, output);
    printf("Assembly code generated in 'output.txt'.\n");
    fclose(input);
    fclose(output);
    return 0;
}
