#include <bits/stdc++.h>
using namespace std;

long long sumK(vector<int>& v, int k) {
    
    sort(v.begin(), v.end());
    int n = v.size();
    long long sum = 0;
    
    for(int i=0;i<k;i++) {
        sum += (long long)v[i];
    }
    
    return sum;
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
	    cout<<sumK(v,k)<<"\n";
	}
  
	return 0;
}