#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <regex.h>

// Token types
typedef enum {
    KEYWORD,
    IDENTIFIER,
    NUMBER,
    OPERATOR,
    PUNCTUATION,
    STRING,
    INVALID
} TokenType;

// Define token structure
typedef struct {
    TokenType type;
    char value[100];
} Token;

// Define regex patterns for different token types
const char *keywords[] = {"if", "else", "while", "return", "int", "float", "char", NULL}; // Add more keywords as needed
const char *operator_pattern = "[+\\-*/=<>!&|^%]";
const char *punctuation_pattern = "[;,.(){}\\[\\]]";  // Punctuation marks like ';', ',', '(', ')', etc.
const char *identifier_pattern = "^[a-zA-Z_][a-zA-Z0-9_]*$";
const char *number_pattern = "^[0-9]+$";
const char *string_pattern = "^\"[^\"]*\"$";  // Matches a simple string literal

// Function to check if a string is a keyword
int is_keyword(const char *str) {
    for (int i = 0; keywords[i] != NULL; i++) {
        if (strcmp(str, keywords[i]) == 0) {
            return 1;
        }
    }
    return 0;
}

// Function to initialize regex and match against patterns
int match_regex(const char *str, const char *pattern) {
    regex_t regex;
    int ret = regcomp(&regex, pattern, REG_EXTENDED);
    if (ret) {
        printf("Could not compile regex\n");
        return 0;
    }

    ret = regexec(&regex, str, 0, NULL, 0);
    regfree(&regex);
    return ret == 0;
}

// Function to classify token
TokenType classify_token(const char *str) {
    if (is_keyword(str)) {
        return KEYWORD;
    }
    if (match_regex(str, identifier_pattern)) {
        return IDENTIFIER;
    }
    if (match_regex(str, number_pattern)) {
        return NUMBER;
    }
    if (match_regex(str, operator_pattern)) {
        return OPERATOR;
    }
    if (match_regex(str, punctuation_pattern)) {
        return PUNCTUATION;
    }
    if (match_regex(str, string_pattern)) {
        return STRING;
    }
    return INVALID;
}

// Function to print token type
void print_token(Token token) {
    char *type;
    switch (token.type) {
        case KEYWORD: type = "Keyword"; break;
        case IDENTIFIER: type = "Identifier"; break;
        case NUMBER: type = "Number"; break;
        case OPERATOR: type = "Operator"; break;
        case PUNCTUATION: type = "Punctuation"; break;
        case STRING: type = "String Literal"; break;
        default: type = "Invalid"; break;
    }
    printf("Type: %-15s Value: %s\n", type, token.value);
}

// Function to process and tokenize the C file
void tokenize_file(const char *file_name) {
    FILE *file = fopen(file_name, "r");
    if (!file) {
        perror("Error opening file");
        return;
    }

    char ch;
    char buffer[100];
    int index = 0;

    while ((ch = fgetc(file)) != EOF) {
        // Ignore whitespaces and comments
        if (ch == ' ' || ch == '\t' || ch == '\n') {
            continue;
        }

        // Read a token into the buffer
        buffer[index++] = ch;

        // If the token is a complete one, classify it
        if (index > 0 && (ch == ';' || ch == ',' || ch == '(' || ch == ')'
                || ch == '{' || ch == '}' || ch == '=' || ch == '+' || ch == '-'
                || ch == '*' || ch == '/' || ch == '<' || ch == '>' || ch == '&'
                || ch == '|')) { // Simple punctuation or operator
            buffer[index] = '\0'; // Null terminate
            Token token;
            token.type = classify_token(buffer);
            strcpy(token.value, buffer);
            print_token(token);
            index = 0; // Reset buffer index
        }
    }

    fclose(file);
}

int main() {
    const char *file_name = "sample.c";  // Replace with your C file path
    tokenize_file(file_name);
    return 0;
}

