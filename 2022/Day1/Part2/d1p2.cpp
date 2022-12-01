#include <iostream>
#include <fstream>
#include <vector>
#include <bits/stdc++.h>
using namespace std;

int main(){
    ifstream inFile;
    inFile.open("input");
    int largest = 0;
    int current_tally = 0;
    vector<int> allTotals;
    for(string line; getline(inFile, line);){
        if(!line.empty()){
            current_tally += stoi(line);
        }else{
            if(current_tally>largest){
                largest = current_tally;
            }
            allTotals.push_back(current_tally);
            current_tally = 0;
        }
    }
    inFile.close();

    sort(allTotals.begin(), allTotals.end(), greater<int>());
    int topThree = allTotals[0] + allTotals[1] + allTotals[2];
    cout << topThree << endl;
    return 0;
}