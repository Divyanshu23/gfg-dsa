#include <bits/stdc++.h>
using namespace std;

long long nearestSquare(long long N) {
  long long n = sqrt(N);
  // cout<<n<<"\n";
  long long  t1 = n*n;
  // cout<<t1<<"\n";
  long long t2 = (n+1)*(n+1);
  // cout<<t2<<"\n";

  long long a =  (N - n*n) <= ((n+1)*(n+1) - N) ? t1:t2;

  if(a!=N) return a;
  else return (N - (n-1)*(n-1)) <= ((n+1)*(n+1) - N)  ? (n-1)*(n-1) : t2;
}

int main() {
  int t;
  cin>>t;
  long long N;
  
  while (t--)
  {
    cin>>N;
    cout<<nearestSquare(N)<<"\n";
  }
  
	return 0;
}