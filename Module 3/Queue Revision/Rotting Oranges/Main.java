class Main {
    class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    // TC: O(N*N) SC: O(N)
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        // store all the src, i.e rotten oranges places
        Queue<Pair> que = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    // found a rotten orange, hence this is one of the src
                    que.add(new Pair(i, j));
                }
            }
        }

        // BFS
        int level = 0;
        while (que.size() > 0) {
            int size = que.size();
            while (size > 0) {
                Pair rpair = que.remove();
                int cr = rpair.row;
                int cc = rpair.col;

                // do we have a fresh orange above
                if (cr - 1 >= 0 && grid[cr - 1][cc] == 1) {
                    // rotten that orange
                    grid[cr - 1][cc] = 2;
                    // add to que
                    que.add(new Pair(cr - 1, cc));
                }

                // do we have a fresh orange below
                if (cr + 1 < n && grid[cr + 1][cc] == 1) {
                    // rotten that orange
                    grid[cr + 1][cc] = 2;
                    // add to que
                    que.add(new Pair(cr + 1, cc));
                }

                // do we have a fresh orange left
                if (cc - 1 >= 0 && grid[cr][cc - 1] == 1) {
                    // rotten that orange
                    grid[cr][cc - 1] = 2;
                    // add to que
                    que.add(new Pair(cr, cc - 1));
                }

                // do we have a fresh orange right
                if (cc + 1 < m && grid[cr][cc + 1] == 1) {
                    // rotten that orange
                    grid[cr][cc + 1] = 2;
                    // add to que
                    que.add(new Pair(cr, cc + 1));
                }

                size--;
            }
            level++;
        }

        // check does any cell has a fresh, hence return -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    // a fresh orange is found
                    return -1;
                }
            }
        }

        if (level == 0) {
            return 0;
        }

        // as first level is already rotten hence minTimeTaken = level - 1
        return level - 1;
    }
}