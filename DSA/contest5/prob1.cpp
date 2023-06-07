#include<bits/stdc++.h>
using namespace std;

stack<int>_push(int arr[],int n)
{
    stack<int> s;
    s.push(arr[0]);
    int curr_min = arr[0];
    
    for(int i=1;i<n;i++) {
        if(arr[i] >= curr_min) s.push(arr[i]);
        else {
            s.push(2*arr[i] - curr_min);
            curr_min = arr[i];
        }
    }
    s.push(curr_min);
    return s;
}

void _getMinAtPop(stack<int>s)
{
    int min = s.top();
    s.pop();
    int x;
    
    while(!s.empty()) {
        x = s.top();
        s.pop();
        if(x>= min) cout<<min<<" ";
        else {
            cout<<min<<" ";
            min = 2*min - x;
        }
    }
}

int main() {
  int t;
  cin>>t;
  while (t--)
  {
    int n;
    cin>>n;
    int arr[n];
    for(int i=0;i<n;i++) {
      cin>>arr[i];
    }
    stack<int> s = _push(arr,n);
    _getMinAtPop(s);
    cout<<"\n";
  }
  
}