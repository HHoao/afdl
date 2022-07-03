package lc_1970;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 *@author: �ƺ�
 *@date : 2021��12��12��
 *@todo:1970. ���ܴ�����������һ��
����һ���±�� 1 ��ʼ�Ķ����ƾ������� 0 ��ʾ½�أ�1 ��ʾˮ��ͬʱ���� row �� col �ֱ��ʾ�������к��е���Ŀ��

һ��ʼ�ڵ� 0 �죬���� ������ ½�� ����ÿһ�춼����һ����½�ر� ˮ ��û���ˮ�򡣸���һ���±�� 1 ��ʼ�Ķ�ά���� cells ������ cells[i] = [ri, ci] ��ʾ�ڵ� i �죬�� ri �� ci �У��±궼�Ǵ� 1 ��ʼ����½�ػ��� ˮ�� ��Ҳ���� 0 ��� 1 ����

����֪���Ӿ����� ���� һ���ߵ��� ���� һ�У���ֻ����½�ظ��ӵ� ���һ�� ����һ�졣����Դ�������һ�е� ���� ���ӳ���������������һ�е� ���� ���ӡ���ֻ������ �ĸ� ���������ƶ���Ҳ�����������ң���

�뷵��ֻ����½�ظ����ܴ��� ���� һ���ߵ��� ���� һ�е� ���һ�� ��
*/
public class LC_1970 {
	public static void main(String[] args) {
		System.out.println(new Solution().latestDayToCross(6, 2, new int[][]{{6,2},{6,2},{2,1},{4,1},{6,1},{3,1},{2,2},{3,2},{1,1},{5,1},{5,2},{1,2}}));
	}
}
//�����������+���ֲ���
class Solution {
    int[][] dirs = new int[][]{{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
    boolean bfs(int row, int col, int[][] area){
        Deque<Integer[]> queue = new ArrayDeque<>();
        queue.offer(new Integer[]{row, col});
        boolean[][] visited = new boolean[area.length][area[0].length];
        visited[row][col] = true;
        while(!queue.isEmpty()){
            Integer[] pos = queue.poll();
            for (int[] dir : dirs){
                int drow = dir[0] + pos[0];
                int dcol = dir[1] + pos[1];
                if (drow >= 0 && drow < area.length && dcol >= 0 && dcol < area[0].length &&
                    !visited[drow][dcol] && 
                    area[drow][dcol] == 0){
                    if (drow == area.length - 1) return true;
                    visited[drow][dcol] = true;
                    queue.offer(new Integer[]{drow, dcol});
                }
            }
        }
        return false;
    }
    public int latestDayToCross(int row, int col, int[][] cells) {
        int n = cells.length;
        int l = 0, r = n - 1;
        while(l < r){
            int mid = (r - l) / 2 + l;
            int[][] area = new int[row][col];
            boolean valid = false;
            for (int i = 0; i <= mid; i++){
                area[cells[i][0] - 1][cells[i][1] - 1] = 1;
            }
            for (int i = 0; i < col; i++){
                if (area[0][i] == 0){
                    valid = bfs(0, i, area);
                }
                if (valid){
                    break;
                }
            }
            if (!valid){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return r;
    }
}

//���鼯+ʱ�⵹��
class UnionFind{
	private int[] parent;
	private int[] size;
	int n;
	int setCount;
	UnionFind(int n){
		parent = new int[n];
		size = new int[n];
		this.setCount = n;
		this.n = n;
		for (int i = 0; i < n; i++) {
			parent[i] = i;
			size[i] = 1;
		}
	}
	int find(int x) {
		return parent[x] == x ? x : (parent[x] = find(parent[x]));
	}
	void merge(int x, int y) {
		x = find(x);
		y = find(y);
		if (size[x] > size[y]) {
			size[x] += size[y];
			parent[y] = x;
		}else {
			size[y] += size[x];
			parent[x] = y;
		}
		setCount--;
	}
	boolean connected(int x, int y) {
		return find(x) == find(y);
	}
}
class Solution1{
	public int latestDayToCross(int row, int col, int[][] cells) {
		int k = row * col;
		int n = cells.length;
		int ans = 0;
		UnionFind unionFind = new UnionFind(row * col + 2);
		boolean valid[][] = new boolean[row][col];
		for (int i = n - 1; n >= 0; n--) {
			int x = cells[i][0], y = cells[i][1];
			valid[x][y] = true;
			int id = x * col + y;
			if (x > 0 && valid[x - 1][y]) {
				unionFind.merge(id, id - col);
			}
			if (x < row - 1 && valid[x + 1][y]) {
				unionFind.merge(id, id + col);
			}
			if (y > 0 && valid[x][y - 1]) {
				unionFind.merge(id, id - 1);
			}
			if (y < col - 1 && valid[x][y + 1]) {
				unionFind.merge(id, id + 1);
			}
			if (x == row - 1) {
				unionFind.merge(id, k + 1);
			}
			if (x == 0) {
				unionFind.merge(id, k);
			}
			if (unionFind.connected(k, k + 1)) {
				ans = i;
				break;
			}
		}
		return ans;
	}
}