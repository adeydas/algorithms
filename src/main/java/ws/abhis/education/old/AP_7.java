package ws.abhis.education.old;

/**
 * Given a sorted (increasing order) array with unique integer elements,
 * write an algorithm to create a binary search tree with minimal height.
 */
public class AP_7 {

    public Node formTree(int[] arr, int st, int en) {

        if (en < st) {
            return null;
        }



        int mid = (st+en)/2;

        Node node = new Node(arr[mid], formTree(arr, st , mid-1), formTree(arr, mid+1, en));
        return node;
    }

    public static void main(String... args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(new AP_7().formTree(arr, 0, arr.length-1).value);
    }


}
