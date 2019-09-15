import java.util.*;

/**Дерево поиска*/
public class TreeSearch
{
    /**Очередь вершин для раскрытия*/
    private Queue<Node> queue = new LinkedList<>();

    /**Корень дерева*/
    private Node root = new Node();

    /**Множество уже пройденных состояний*/
    private TreeSet<Node> setOfStates = new TreeSet<>();

    /**Поиск в ширину
     * @return - вершина с целевым состоянием*/
    Node rowSearch()
    {
        queue.add(root);
        while(true)
        {
            if(queue.isEmpty()) return null;
            Node node = queue.poll();
            if(node.isGoal())
                return node;
            addNodes(makeChildren(node));
        }
    }

    /**Добавление множества вершин в очередь
     * @param nodes - добавляемые вершины*/
    private void addNodes(Node[] nodes)
    {
        for(int i = 0; i < 4; i++)
            if(nodes[i] != null && setOfStates.add(nodes[i]))
            {queue.add(nodes[i]); nodes[i].returnState();}
    }

    /**Расскрытие вершины
     * @param node - раскрываемая вершина
     * @return массив новых вершин*/
    private Node[] makeChildren(Node node)
    {
        Node[] children = new Node [4];
        int [] index = node.findEmptyPlace();
        if(index[0] != 2)
        { children[0] = new Node(node, Node.Action.UP,index[0],index[1]); children[0].returnState();}
        if(index[0] != 0)
        {    children[1] = new Node(node, Node.Action.DOWN,index[0],index[1]); children[1].returnState();}
        if(index[1] != 2)
        {    children[2] = new Node(node, Node.Action.LEFT,index[0],index[1]); children[2].returnState();}
        if(index[1] != 0)
        {    children[3] = new Node(node, Node.Action.RIGHT,index[0],index[1]); children[3].returnState();}

        return children;
    }




    public static void main(String[] args)
    {
        Node answer = new TreeSearch().rowSearch();
    }
}
