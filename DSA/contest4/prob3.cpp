#include <bits/stdc++.h>
using namespace std;

void printMatch(string& text, string& pat) {
    
    int p=0,t=0;
    int n = text.size();
    int m = pat.size();
    for(int i=0;i<m;i++) {
        p += pat[i] - 96;
    }
    
    for(int i=0;i<m;i++) {
        t += (text[i]-96);
    }
    
    int j;
    bool flag = true;
    for(int i=0;i<=(n-m);i++) {
        if(p==t) {
            flag = false;
            for(j=0;j<m;j++) {
                cout<<text[i+j];
            }
            cout<<" "<<i<<"\n";
        }
        if(i < (n-m)) t = t - (text[i]-96) + (text[i+m]-96);
    } 
    if(flag) cout<<-1<<"\n";
    return;
}

int main() {
    int t;
    cin>>t;
    string text, pat;
    while(t--) {
        cin>>text;
        cin>>pat;
        printMatch(text, pat);
    }
	return 0;
}