#include <bits/stdc++.h>
using namespace std;


void fun(vector<int>& v, int N) {


  for(int i=0; i<N; i++) {
    v[i] -= 1;
  }

  sort(v.begin(), v.end());

  for(int i=0; i<N; i++) {
    v[v[i]%N] += N;
  }

  for(int i=0; i<N; i++) {
    v[i] /= N;
  }

  auto it = find(v.begin(), v.end(), 0);
  int a = (int)(it - v.begin()) + 1;

  it = find(v.begin(), v.end(), 2);
  int b = (int)(it - v.begin()) + 1;

  cout<<b<<" "<<a<<"\n";

}

int main() {
	
  int t;
  cin>>t;
  int N;
  vector<int> v;
  int temp;

  while(t--) {
    cin>>N;
    for(int i=0;i<N;i++) {
      cin>>temp;
      v.push_back(temp);
    }

    fun(v, N);
    v.clear();
  }
	return 0;
}