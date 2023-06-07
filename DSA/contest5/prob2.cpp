#include <bits/stdc++.h>
using namespace std;


vector<int> closestFriends(vector<int>& v) {
    int n = v.size();
    vector<int> res;
    stack<int> s;
    s.push(-1);
    res.push_back(-1);
    int j;
    
    for(int i=1;i<n;i++) {
        if(v[i] > v[i-1]) {
            s.push(i-1);
            res.push_back(i-1);
        } else {
            j = s.top();
            s.pop();
            while(!s.empty() && v[j] >= v[i]) {
                j = s.top();
                s.pop();
            }
            res.push_back(j);
            s.push(j);
        }
    }
    
    return res;
}


int main() {
    int t;
    cin>>t;
    int n;
    vector<int> v;
    vector<int> res;
    
    while(t--) {
        cin>>n;
        v.resize(n);
        for(int i=0;i<n;i++) {
            cin>>v[i];
        }
        
        res = closestFriends(v);
        for(auto x:res) {
            cout<<x<<" ";
        }
        cout<<"\n";
    }
	return 0;
}