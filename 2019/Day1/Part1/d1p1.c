#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int get_fuel(double num) {
    int result;
    result = (int)floor(num/3.0) - 2;
    return result; 
}

int main(void){
    FILE* inFile;
    char* line = NULL;
    size_t len = 0;

    int fuel_total = 0;
    inFile = fopen("input", "r");
    while (getline(&line, &len, inFile) != -1) {
        int convert = atoi(line);
        fuel_total += get_fuel(convert);
    }
    fclose(inFile);
    printf("%d\n", fuel_total);
    
    exit(EXIT_SUCCESS);
}