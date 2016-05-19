package ws.abhis.education.old;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhishek on 3/22/15.
 * Website: adeydas.com
 */
public final class BinaryTreeSerializer
{
    public static List<Integer> Serialize(BTNode root)
    {
        List<Integer> serializedNums = new ArrayList<Integer>();

        SerializeRecursively(root, serializedNums);

        return serializedNums;
    }

    private static void SerializeRecursively(BTNode node, List<Integer> nums)
    {
        if (node == null)
        {
            nums.add(0);
            return;
        }

        nums.add(node.data);
        SerializeRecursively(node.left, nums);
        SerializeRecursively(node.right, nums);
    }

    public static BTNode Deserialize(List<Integer> serializedNums)
    {
        Pair pair = DeserializeRecursively(serializedNums, 0);

        return pair.node;
    }

    private static Pair DeserializeRecursively(List<Integer> serializedNums, int start)
    {
        int num = serializedNums.get(start);

        if (num == 0)
        {
            return new Pair(null, start + 1);
        }

        BTNode node = new BTNode(num);

        Pair p1 = DeserializeRecursively(serializedNums, start + 1);
        node.left = p1.node;

        Pair p2 = DeserializeRecursively(serializedNums, p1.startIndex);
        node.right = p2.node;

        return new Pair(node, p2.startIndex);
    }

    private static final class Pair
    {
        BTNode node;
        int startIndex;

        private Pair(BTNode node, int index)
        {
            this.node = node;
            this.startIndex = index;
        }
    }

    public static void main(String... args) {
        //BTNode node = new BTNode(1, new BTNode(2, new BTNode(3, new BTNode(4, null, null), null), null), null);
//        BTNode node = new BTNode(1, new BTNode(2, new BTNode(4, null, null), new BTNode(5, null, null) ), new BTNode(3, null, null));
        BTNode node = new BTNode(1, new BTNode(2, null, null) , new BTNode(3, null, null));

        List<Integer> ser = Serialize(node);
        for (int i=0; i<ser.size(); i++) {
            System.out.println(ser.get(i));
        }

        System.out.println("========");

        BTNode r = Deserialize(ser);
        preOrder(r);

    }

    public static void preOrder(BTNode node) {
        if (node == null)
            return;

        System.out.println(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }
}

