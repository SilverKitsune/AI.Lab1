
/**Класс, описывающий вершину*/
class Node
{
    /**Состояние*/
    private int [][] state;

    /**Родитель вершины*/
    private Node parent;

    /**Перечисление возможных операций*/
    public enum Action {UP, DOWN, LEFT, RIGHT}

    /**Операция, которой было получено это состояние*/
    private Action action;

    /**Стоимость пути*/
    private int cost;

    /**Глубина*/
    private int depth;

    /** Функция, возвращающая индекс пустой клетки на поле
     * @return индекс пустой клетки*/
    private int[] findEmptyPlace()
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
        state = _parent.state;
        if(action == Action.UP)
            this.action_UP(i,j);
        if(action == Action.DOWN)
            this.action_DOWN(i,j);
        if(action == Action.LEFT)
            this.action_LEFT(i,j);
        if(action == Action.RIGHT)
            this.action_RIGHT(i,j);
    }

    /**Выполнение операции "Вверх"
     * @param i - строка, в которой находится пустая клетка
     * @param j - столбец, в котором находится пустая клетка*/
    private void action_UP(int i, int j)
    {
        System.out.println("UP");
        state[i][j] = state[i+1][j];
        state[i+1][j] = 0;
    }

    /**Выполнение операции "Вниз"
     * @param i - строка, в которой находится пустая клетка
     * @param j - столбец, в котором находится пустая клетка*/
    private void action_DOWN(int i, int j)
    {
        System.out.println("DOWN");
        state[i][j] = state[i-1][j];
        state[i-1][j] = 0;
    }

    /**Выполнение операции "Влево"
     * @param i - строка, в которой находится пустая клетка
     * @param j - столбец, в котором находится пустая клетка*/
    private void action_LEFT(int i, int j)
    {
        System.out.println("LEFT");
        state[i][j] = state[i][j+1];
        state[i][j+1] = 0;
    }

    /**Выполнение операции "Вправо"
     * @param i - строка, в которой находится пустая клетка
     * @param j - столбец, в котором находится пустая клетка*/
    private void action_RIGHT(int i, int j)
    {
        System.out.println("RIGHT");
        state[i][j] = state[i][j-1];
        state[i][j-1] = 0;
    }
}