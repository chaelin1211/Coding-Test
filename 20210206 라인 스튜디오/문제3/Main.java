
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class Solution {
	public int solution(int n, String[] recipes, String[] orders) {
		int answer = 0;
		int[] oven = new int[n+1];
		HashMap<String, Integer> recip = new HashMap<String, Integer>();

		for (String input : recipes) {
			recip.put(input.split(" ")[0], Integer.parseInt(input.split(" ")[1]));
		}

		int waitTime = 0;
		for (String input : orders) {
			String menu = input.split(" ")[0];
			int inputTime = Integer.parseInt(input.split(" ")[1]);
			int i = 0;
			waitTime = oven[1];
			if (waitTime < inputTime) {
				waitTime = inputTime;
			}
			waitTime += recip.get(menu);
			oven[1] = waitTime;
			heapSort(oven, n);
		}
		answer = waitTime;
		return answer;
	}
	// 대기 시간이 최소인 오븐 하나만 알면 되니 힙정렬 이용
	public void heapSort(int[] oven, int n) {
		for (int i = 2; i <= n; i++) {
			int child = i;
			while(child > 1) {
				int parent = child/2;
				if(oven[child]<oven[parent]) {
					int tmp = oven[child];
					oven[child] = oven[parent];
					oven[parent] = tmp;
				}
				child = parent;
			}
		}
	}
}

public class Main {
	public static void main(String[] args) {
		Solution s = new Solution();

		String[] list = { "SPAGHETTI 3", "FRIEDRICE 2", "PIZZA 8" };
		String[] list2 = { "PIZZA 1", "FRIEDRICE 2", "SPAGHETTI 4", "SPAGHETTI 6", "PIZZA 7", "SPAGHETTI 8" };
		s.solution(3, list, list2);

	}
}