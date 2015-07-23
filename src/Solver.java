public class Solver {
    private final MinPQ<SearchNode> originalPq;
    private final MinPQ<SearchNode> twinPq;
    private final Stack<Board>      shortestBoardSequence;
    private int                     totalMoves        = 0;
    private int                     shortestNumOfMove = 0;
    private boolean                 isSolve           = false;
    
    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {
        
        shortestBoardSequence = new Stack<Board>();
        originalPq = new MinPQ<SearchNode>();
        twinPq = new MinPQ<SearchNode>();
        originalPq.insert(new SearchNode(totalMoves, initial, null));
        twinPq.insert(new SearchNode(totalMoves, initial.twin(), null));

        Queue<Board> neighborBoards = new Queue<Board>();
        Board previousBoard = null;
        SearchNode originalNode;
        SearchNode twinNode;
        
        while (!originalPq.isEmpty() && !twinPq.isEmpty()) {
            
            originalNode = originalPq.delMin();

            if (originalNode.board.isGoal()) {
                
                isSolve = true;
                shortestQueue(originalNode);
                shortestBoardSequence.push(initial);
                break;
            }

            neighborBoards = (Queue<Board>) originalNode.board.neighbors();
            if (originalNode.previousNode != null) {
                previousBoard = originalNode.previousNode.board;
            }
            for (Board neighborBoard : neighborBoards) {
                if (!neighborBoard.equals(previousBoard)) {
                    totalMoves = originalNode.numOfMoves + 1;
                    originalPq.insert(new SearchNode(totalMoves, neighborBoard,
                            originalNode));
                }
            }

            twinNode = twinPq.delMin();

            if (twinNode.board.isGoal()) {
                shortestNumOfMove = -1;
                isSolve = false;
                break;
            }
            neighborBoards = (Queue<Board>) twinNode.board.neighbors();
            if (twinNode.previousNode != null) {
                previousBoard = twinNode.previousNode.board;
            }
            for (Board neighborBoard : neighborBoards) {
                if (!neighborBoard.equals(previousBoard)) {
                    twinPq.insert(new SearchNode(totalMoves, neighborBoard,
                            twinNode));
                }
            }
            originalNode = null;
            twinNode = null;
            neighborBoards = null;
        }
    }

    private void shortestQueue(SearchNode node) {

        while (node.previousNode != null) {
            
            shortestBoardSequence.push(node.board);
            
            node = node.previousNode;
            shortestNumOfMove++;
        }
    }

    // is the initial board solvable?
    public boolean isSolvable() {
        return isSolve;
    }

    // min number of moves to solve initial board; -1 if no solution
    public int moves() {
        return this.shortestNumOfMove;
    }

    // sequence of boards in a shortest solution; null if no solution
    public Iterable<Board> solution() {
        if (shortestNumOfMove != -1)
            return shortestBoardSequence;
        else
            return null;
    }

    private class SearchNode implements Comparable<SearchNode> {
        private int        numOfMoves;
        private Board      board;
        private SearchNode previousNode;

        public SearchNode(int numOfMoves, Board board, SearchNode previousNode) {
            this.numOfMoves = numOfMoves;
            this.board = board;
            this.previousNode = previousNode;
        }

        @Override
        public int compareTo(SearchNode that) {
            if (this.board.manhattan() + this.numOfMoves > that.board
                    .manhattan() + that.numOfMoves)
                return 1;
            else if (this.board.manhattan() + this.numOfMoves < that.board
                    .manhattan() + that.numOfMoves)
                return -1;
            else
                return 0;
        }

    }

    // solve a slider puzzle (given below)
    public static void main(String[] args) {
        // create initial board from file
        // In in = new In(args[0]);
         In in = new In("8puzzle/puzzle08.txt");
//        In in = new In("8puzzle/puzzle40.txt");
        int N = in.readInt();
        int[][] blocks = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                blocks[i][j] = in.readInt();
        Board initial = new Board(blocks);

        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    }

}
