#include <cstdio>
#include <queue>
#include <initializer_list>
using namespace std;

const int MAX = 1e6;
int n, k;
int dist[MAX+1];

void bfs() {
    queue<int> q;
    q.push(n);
    int ans = 0, cnt = 0;
    while (!cnt) {
        int s = q.size();
        while (s--) {
            int x = q.front(); q.pop();
            if (x == k) cnt += 1;
            for (int nx : {x-1, x+1, 2*x}) {
                if (nx < 0 || nx > MAX) continue;
                if (dist[nx] && dist[nx] != dist[x]+1) continue;
                q.push(nx);
                dist[nx] = dist[x]+1;
            }
        }
        ans += 1;
    }
    printf("%d\n%d\n", ans-1, cnt);
}

int main() {
    scanf("%d %d", &n, &k);
    bfs();
    return 0;
}
