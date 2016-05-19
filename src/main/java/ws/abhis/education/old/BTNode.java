package ws.abhis.education.old;

/**
 * Created by abhishek on 3/22/15.
 * Website: adeydas.com
 */
public class BTNode
{
    public int data;
    public BTNode left;
    public BTNode right;

    public BTNode(int data)
    {
        this.data = data;
    }

    public BTNode(int data, BTNode left, BTNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
