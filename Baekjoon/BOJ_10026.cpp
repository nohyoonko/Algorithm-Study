/*
* BOJ #10026 적록색약
* BFS
* 2020.02.12
*/

#include <iostream>
#include <vector>
#include <queue>
#include <cstring> //memset
#define MAX 100
using namespace std;

int n;
// 상, 하, 좌, 우
int dx[] = { 0, 0, -1, 1 };
int dy[] = { -1, 1, 0, 0 };
char original[MAX][MAX];
char weak[MAX][MAX];
bool visited[MAX][MAX];

void bfs(int x, int y, char (*paint)[MAX]) {
	// bfs를 하기 위해 이용할 queue(좌표때문에 pair<int,int> 사용)
	queue<pair<int, int> > q;
	// 시작 정점을 큐에 넣어주고 visited도 true로 변경
	q.push(make_pair(x, y));
	visited[x][y] = true;

	while (!q.empty()) {
		// 큐의 현재 원소를 꺼내서 방문하기
		x = q.front().first;
		y = q.front().second;
		//char color = paint[x][y];
		q.pop();

		// 해당 위치의 주변을 확인
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			// 배열을 벗어나지 않고
			if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
				// 색이 같고 방문하지 않았다면
				if (paint[nx][ny] == paint[x][y] && visited[nx][ny] == false) {
					// 방문으로 변경하고 큐에 현재 nx, ny를 추가
					visited[nx][ny] = true;
					q.push(make_pair(nx, ny));
				}
			}
		}
	}
}
int main(void) {
	cin >> n;

	int answer1 = 0, answer2 = 0;
	char tmp;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> tmp;
			if (tmp == 'G') {
				original[i][j] = tmp;
				weak[i][j] = 'R';
			}
			else {
				original[i][j] = tmp;
				weak[i][j] = tmp;
			}
		}
	}

	/* 적록색약이 아닌 사람의 경우 */
	memset(visited, false, sizeof(visited));
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (visited[i][j] == false) {
				// bfs를 실행하는 만큼이 구역의 개수
				// bfs에 들어가서 같은 색상을 만나지 못할 때까지 while문을 돌기 때문에
				bfs(i, j, original);
				answer1++;
			}
		}
	}

	/* 적록색약인 사람의 경우 */
	memset(visited, false, sizeof(visited));
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (visited[i][j] == false) {
				bfs(i, j, weak);
				answer2++;
			}
		}
	}
	cout << answer1 << ' ' << answer2;

	return 0;
}
