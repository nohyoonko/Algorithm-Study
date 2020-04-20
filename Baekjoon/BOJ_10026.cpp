/*
* BOJ #16198 ���ϻ���
* Brute Force - Recursive Function
* 2020.02.12
*/

#include <iostream>
#include <vector>
#include <queue>
#include <cstring> //memset
#define MAX 100
using namespace std;

int n;
// ��, ��, ��, ��
int dx[] = { 0, 0, -1, 1 };
int dy[] = { -1, 1, 0, 0 };
char original[MAX][MAX];
char weak[MAX][MAX];
bool visited[MAX][MAX];

void bfs(int x, int y, char (*paint)[MAX]) {
	// bfs�� �ϱ� ���� �̿��� queue(��ǥ������ pair<int,int> ���)
	queue<pair<int, int> > q;
	// ���� ������ ť�� �־��ְ� visited�� true�� ����
	q.push(make_pair(x, y));
	visited[x][y] = true;

	while (!q.empty()) {
		// ť�� ���� ���Ҹ� ������ �湮�ϱ�
		x = q.front().first;
		y = q.front().second;
		//char color = paint[x][y];
		q.pop();

		// �ش� ��ġ�� �ֺ��� Ȯ��
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			// �迭�� ����� �ʰ�
			if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
				// ���� ���� �湮���� �ʾҴٸ�
				if (paint[nx][ny] == paint[x][y] && visited[nx][ny] == false) {
					// �湮���� �����ϰ� ť�� ���� nx, ny�� �߰�
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

	/* ���ϻ����� �ƴ� ����� ��� */
	memset(visited, false, sizeof(visited));
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (visited[i][j] == false) {
				// bfs�� �����ϴ� ��ŭ�� ������ ����
				// bfs�� ���� ���� ������ ������ ���� ������ while���� ���� ������
				bfs(i, j, original);
				answer1++;
			}
		}
	}

	/* ���ϻ����� ����� ��� */
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