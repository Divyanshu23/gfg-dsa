#include <bits/stdc++.h>
using namespace std;

int minimum(int n) {
  if(n==1) return 0;

  if(n%2 == 0) return 1 + minimum(n/2);
  else {
    return 1 + min(minimum(n-1), minimum(n+1));
  }
}

int main() {
	int t;
  cin>>t;
  int N;

  while (t--)
  {
    cin>>N;
    cout<<minimum(N)<<"\n";
  }

	return 0;
}