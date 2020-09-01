/*
*   Baekjoon
*   #4963 섬의 개수 - BFS
*   2020.08.31
*/
#include <iostream>
#include <queue> // bfs algorithm
#include <cstring> // memset

#define MAX 50

using namespace std;

int w, h;
int land = 0;
int map[MAX][MAX];
bool visited[MAX][MAX];

// 상, 하, 좌, 우, 상좌, 상우, 하좌, 하우
// 상: (0, -1) 로 하는 이유는 높이(h)가 x이기 때문!
int dx[8] = { 0, 0, -1, 1, -1, 1, -1, 1};
int dy[8] = { -1, 1, 0, 0, -1, -1, 1, 1};

void bfs(int x, int y) {
    queue<pair<int, int> > q;
    q.push(make_pair(x, y));
    
    // 처음 x, y를 방문했기 때문에
    visited[x][y] = true;
    while (!q.empty()) {
        // 큐의 현재 원소를 꺼내기
        x = q.front().first;
        y = q.front().second;
        q.pop();
 
        // 해당 위치의 주변을 확인
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
 
            // 지도를 벗어나지 않고,
            if (0 <= nx && 0 <= ny && nx < MAX && ny < MAX) {
                // 섬이면서 방문하지 않았다면
                if (map[nx][ny] && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.push(make_pair(nx, ny));
                }
            }
        }
    }
    return;
}
int main(void) {
    while(1) {
        /* input */
        cin >> w >> h;
        if(!w && !h) break; // 종료 조건
        
        for(int i=0; i<h; i++) {
            for(int j=0; j<w; j++) {
                cin >> map[i][j];
            }
        }

        /* output */
        for(int i=0; i<h; i++) {
            for(int j=0; j<w; j++) {
                if(map[i][j] && !visited[i][j]) { // 땅이 존재하고 방문하지 않았으면 탐색
                    land++;
                    bfs(i, j);
                }
            }
        }
        cout << land << '\n';

        /* reset */
        memset(map, 0, sizeof(map));
        memset(visited, false, sizeof(visited));
        land = 0;
    }

    return 0;
}
