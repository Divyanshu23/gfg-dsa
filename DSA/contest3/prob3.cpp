#include <bits/stdc++.h>
using namespace std;

string XORPair(vector<int>& v, int c) {
    unordered_set<int> us;
    int n = v.size();
    
    for(int i=0;i<n;i++) {
        if(us.find(v[i]^c) != us.end()) return string("Yes");
        us.insert(v[i]);
    }
    
    return string("No");
}

int main() {
    
	int t,n,k;
	cin>>t;
	vector<int> v;
	
	while(t--) {
	    cin>>n;
	    cin>>k;
	    v.resize(n);
	    
	    for(int i=0;i<n;i++) {
	        cin>>v[i];
	    }
	    cout<<XORPair(v,k)<<"\n";
	}
  
	return 0;
}