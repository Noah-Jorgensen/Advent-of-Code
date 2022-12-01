#include <iostream>
#include <fstream>
using namespace std;

int main(){
    ifstream inFile;
    inFile.open("input");
    int largest = 0;
    int current_tally = 0;
    for(string line; getline(inFile, line);){
        if(!line.empty()){
            current_tally += stoi(line);
        }else{
            if(current_tally>largest){
                largest = current_tally;
            }
            current_tally = 0;
        }
    }
    inFile.close();

    cout << largest << endl;
    return 0;
}