#include <bits/stdc++.h>
using namespace std;

int toggleBit(int n) {
    int size = (int)log2(n) + 1;
    int mask = 1;
    
    if(size % 2 == 0) {
    for(int i=0;i<(size)/2;i++) {
        mask = 1;
        mask = mask << i;
    }
    n = n^mask;
    n = n^(mask<<1);
    return n;
    } else 
    {
        for(int i=0;i<(size/2+1);i++) {
            mask = 1;
            mask = mask << i;
        }
        n = n^mask;
        return n;
    }
    
}

int main() {
	int t,n;
	cin>>t;
	
	while(t--) {
	    cin>>n;
	    
	    cout<<toggleBit(n)<<"\n";
	}
  
	return 0;
}