/* 
* BOJ #16198 에너지 모으기 
* Brute Force - Recursive Function
* 2020.02.10
*/

#include <iostream>
#include <vector>
using namespace std;

int maxEnergy, tmpEnergy; // Global variable for Recursion

void solution(vector<int> beads) {
	if (beads.size() == 2) { // Recursion ends when there are no more beads to choose
		if (maxEnergy < tmpEnergy) maxEnergy = tmpEnergy;
		return;
	}

	// Can't choose first and last bead
	for (int i = 1; i < beads.size() - 1; i++) {
		int idx = beads[i];
		tmpEnergy = tmpEnergy + (beads[i - 1] * beads[i + 1]);
		beads.erase(beads.begin() + i);
		solution(beads);
		beads.insert(beads.begin() + i, idx);
		tmpEnergy = tmpEnergy - (beads[i - 1] * beads[i + 1]);
	}
}

int main(void) {
	int n, tmp;
	vector<int> beads;

	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> tmp;
		beads.push_back(tmp);
	}

	solution(beads);
	cout << maxEnergy << '\n';

	return 0;
}