#include <iostream>
using namespace std;

int getAvg(string& str) {
    int res=0;
    int n = str.size();
    for(auto x:str) {
        res += x;
    }
    return res/n;
}

int main() {
    int t;
    cin>>t;
    string str;
    while(t--) {
        cin>>str;
        cout<<getAvg(str)<<"\n";
    }
	return 0;
}