#include <iostream>
using namespace std;

struct node {
    int val;
    node *next;
    node *prev;
    node(int d) {
        val = d;
        next = nullptr;
        prev = nullptr;
    }
};

void insert(node * &h, int d) {
    if(h == nullptr) {
        h = new node(d);
        return;
    }
    node *t = h;
    while(t->next != nullptr) {
        t = t->next;
    }
    node *newnode = new node(d);
    t->next = newnode;
    newnode->prev = t;
}

void deletenode(node * &h, int d) {
    if(h == nullptr) {
        return;
    }
    node *t = h;
    if(h->val == d) {
        h = h->next;
        if(h != nullptr) {
            h->prev = nullptr;
        }
        return;
    }
    while(t != nullptr) {
        if(t->val == d) {
            if(t->next != nullptr) {
                t->next->prev = t->prev;
            }
            if(t->prev != nullptr) {
                t->prev->next = t->next;
            }
            return;
        }
        t = t->next;
    }
}

void printlist(node *h) {
    node *t = h;
    while(t != nullptr) {
        cout << t->val << " ";
        t = t->next;
    }
    cout << endl;
}

node* head = nullptr;

int main() {
    node *head = new node(10);
    insert(head, 20);
    insert(head, 30);
    printlist(head);
    deletenode(head, 10);
    printlist(head);
    return 0;
}