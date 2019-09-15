
/**Класс, описывающий вершину*/
class Node implements Comparable<Node>
{
    private static final int[][] GOAL = new int[][] {{1,2,3},{8,0,4},{7,6,5}};

    /**Состояние*/
    private int [][] state;

    /**Родитель вершины*/
    private Node parent;

    @Override
    public int compareTo(Node o)
    {
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                if(state[i][j] != o.state[i][j])
                    return -1;
        return 0;
    }

    /**Перечисление возможных операций*/
    public enum Action {UP, DOWN, LEFT, RIGHT}

    /**Операция, которой было получено это состояние*/
    private Action action;

    /**Стоимость пути*/
    private int cost;

    /**Глубина*/
    private int depth;

    int[][] getState()
    {
        return state;
    }

    void returnState()
    {
        System.out.println(state[0][0]+" "+state[0][1]+" "+state[0][2]);
        System.out.println(state[1][0]+" "+state[1][1]+" "+state[1][2]);
        System.out.println(state[2][0]+" "+state[2][1]+" "+state[2][2]);
        System.out.println(" ");

    }

    /** Функция, возвращающая индекс пустой клетки на поле
     * @return индекс пустой клетки*/
    int[] findEmptyPlace()
    {
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                if (state[i][j] == 0)
                    return new int [] {i,j};
        return new int [] {-1,-1};
    }

    /**Конструктор для создания корня дерева*/
    Node()
    {
        state = new int [][] {{4,8,1},{0,3,6},{2,7,5}};
        parent = null;
        action = null;
        cost = 0;
        depth = 0;
    }

    /**Конструктор
     * @param _parent - родитель узла
     * @param _action - операция, изменяющая состояние
     * @param i - строка, в которой находится пустая клетка
     * @param j - столбец, в котором находится пустая клетка*/
    Node(Node _parent, Action _action, int i, int j)
    {
        parent = _parent;
        action = _action;
        depth = _parent.depth+1;
        cost = _parent.cost+1;
        this.state = new int[3][3];
        for(int k = 0; k < 3; k++)
            for(int l = 0; l < 3; l++)
                this.state[k][l] = _parent.state[k][l];
        if(action == Action.UP)
        {
            System.out.println("UP");
            this.state[i][j] = this.state[i+1][j];
            this.state[i+1][j] = 0;
        }
        if(action == Action.DOWN)
        {
            System.out.println("DOWN");
            this.state[i][j] = this.state[i-1][j];
            this.state[i-1][j] = 0;
        }
        if(action == Action.LEFT)
        {
            System.out.println("LEFT");
            this.state[i][j] = this.state[i][j+1];
            this.state[i][j+1] = 0;
        }
        if(action == Action.RIGHT)
        {
            System.out.println("RIGHT");
            this.state[i][j] = this.state[i][j-1];
            this.state[i][j-1] = 0;
        }
    }
    /**Проверка на целевое состояние*/
    boolean isGoal()
    {
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                if(GOAL[i][j]!= state[i][j])
                    return false;
        return true;
    }
}