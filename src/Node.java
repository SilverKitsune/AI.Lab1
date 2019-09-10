
/**Класс, описывающий вершину*/
class Node
{
    /**Состояние*/
    private int [][] state = new int [3][3];

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

    /**Конструктор
     * @param _parent - родитель узла
     * @param _action - операция, изменяющая состояние*/
    Node(Node _parent, Action _action)
    {
        parent = _parent;
        action = _action;
        depth = _parent.depth+1;
        cost = _parent.cost+1;
        int[] empt = _parent.findEmptyPlace();
        if(action == Action.UP)
        {

        }
        if(action == Action.DOWN)
        {
        }
        if(action == Action.LEFT)
        {
        }
        if(action == Action.RIGHT)
        {
        }


    }
}
