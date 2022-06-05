#include <bits/stdc++.h>
using namespace std;

void modifyMatrix(vector<vector<int> >& v, vector<int>& sum) {
    int m = v.size();
    
    for(int i=0;i<m;i++) {
        if(sum[i] > 0) 
            fill((v[i]).begin(), (v[i]).end(), 1);
    }
    
    return;
}

int main() {
	int t,m,n;
	vector<vector<int> > v;
	cin>>t;
	vector<int> row;
	vector<int> sum;
	while(t--) {
	    cin>>m>>n;
	    v.resize(m);
	    row.resize(n);
	    sum.resize(m);
	    fill(sum.begin(), sum.end(), 0);
	    
	    for(int i=0;i<m;i++) {
	        for(int j=0;j<n;j++) {
	            cin>>row[j];
	            sum[i] += row[j];
	        }
	        v[i] = row;
	    }
	    modifyMatrix(v,sum);
	    
	    for(int i=0;i<m;i++) {
	        for(int j=0;j<n;j++) {
	            cout<<v[i][j]<<" ";
	        }
	        cout<<"\n";
	    }
	}

	return 0;
}