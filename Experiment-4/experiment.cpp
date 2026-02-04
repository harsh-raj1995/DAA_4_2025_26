#include <bits/stdc++.h>
using namespace std;

#define MAX 100

int heap[MAX];
int heapSize = 0;
int K = 3;

void heapifyDown(int i) {
    int smallest = i;
    int left = 2*i + 1;
    int right = 2*i + 2;

    if (left < heapSize && heap[left] < heap[smallest])
        smallest = left;
    if (right < heapSize && heap[right] < heap[smallest])
        smallest = right;

    if (i != smallest) {
        swap(heap[i], heap[smallest]);
        heapifyDown(smallest);
    }
}

void heapifyUp(int i) {
    while (i > 0 && heap[(i - 1) / 2] > heap[i]) {
        swap(heap[(i - 1) / 2], heap[i]);
        i = (i - 1) / 2;
    }
}

void insert(int val) {
    heap[heapSize++] = val;
    heapifyUp(heapSize - 1);
}

void deleteRoot() {
    heap[0] = heap[heapSize - 1];
    heapSize--;
    heapifyDown(0);
}

int main() {
    int scores[] = {10, 20, 5, 15, 25, 8};
    int N = 6;

    for (int i = 0; i < N; i++) {
        int score = scores[i];

        if (heapSize < K) {
            insert(score);
            cout << -1 << endl;
        }
        else {
            if (score > heap[0]) {
                deleteRoot();
                insert(score);
            }
            cout << heap[0] << endl;
        }
    }

    return 0;
}
