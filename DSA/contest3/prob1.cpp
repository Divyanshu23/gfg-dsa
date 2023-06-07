#include <bits/stdc++.h>
using namespace std;

int kthDiff(vector<int>& v, int k)
{
	int n = v.size();
	sort(v.begin(), v.end());
	
	for(int i=0;i<n-1;i++) {
	    v[i] = abs(v[i] - v[i+1]);
	}
	
	sort(v.begin(), v.end()-1);
	return v[k-1];
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
	    cout<<kthDiff(v,k)<<"\n";
	}
  
	return 0;
}