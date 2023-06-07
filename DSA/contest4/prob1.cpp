#include<bits/stdc++.h>
using namespace std;

struct Node {
  int data;
  struct Node* next;
  struct Node* prev;
  Node(int x) {
    data = x;
    next = NULL;
    prev = NULL;
  }
};

class solution
{
  private:

  public:

  void makeDoubly(struct Node *head)
{
    Node* curr;
    while(head != NULL && head->next != NULL) {
        head->next->prev = head;
        head = head->next;
    }
    
    return;
}
};

int main() {
  Node* head = NULL;
  solution solver;
  return 0;
}