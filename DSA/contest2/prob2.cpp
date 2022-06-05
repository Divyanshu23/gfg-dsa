#include <bits/stdc++.h>
using namespace std;

long long withoutAdjacent(vector<int>& v) {
    int n = v.size();
    // if(n==1) return v[0];
    
    long long incl=v[0];
    long long excl = 0;
    long long temp;
    
    for(int i=1;i<n;i++) {
        temp = incl;
        incl = excl+(long long)v[i];
        excl = max(temp, excl);
    }
    
    return max(incl, excl);
}

int main() {
	int t,n;
	cin>>t;
	vector<int> v;
	while(t--) {
	    cin>>n;
	    v.resize(n);
	    
	    for(int i=0;i<n;i++) {
	        cin>>v[i];
	    }
	    
	    cout<<withoutAdjacent(v)<<"\n";
	}
  
	return 0;
}