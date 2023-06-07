#include <bits/stdc++.h>
using namespace std;

void pairBrackets(string& str) {
    int n = str.size();
    
    queue<pair<char, int> > q;
    pair<char, int> p;
    int count = 0;
    vector<pair<int, int> > v;
    
    for(int i=0;i<n;i++) {
        if(str[i] == '(') {
            q.push(make_pair(str[i],i));
        } else {
            if(!q.empty()) {
                p = q.front();
                q.pop();
                ++count;
                v.push_back(make_pair(p.second, i));
            }
        }
    }
    
    cout<<count<<"\n";
    for(auto x:v) {
        cout<<x.first<<" "<<x.second<<"\n";
    }
    return;
}

int main() {
    int t;
    cin>>t;
    string str;
    
    while(t--) {
        cin>>str;
        
        pairBrackets(str);
    }
	return 0;
}