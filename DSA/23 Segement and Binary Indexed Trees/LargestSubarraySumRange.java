public class LargestSubarraySumRange {
    public static void main(String[] args) {
        int[] arr = { 1, 3, -4, 5, -2 };
        int n = arr.length;

        Node[] Tree = constructTree(arr, n);
        int start, end, maxSubarraySum;

        // Answering query 1:
        start = 0;
        end = 4;
        maxSubarraySum = query(Tree, start, end, n);
        System.out.println("Maximum Sub-Array Sum between "
                + start + " and " + end + " = "
                + maxSubarraySum);

        // Answering query 2:
        start = 0;
        end = 2;
        maxSubarraySum = query(Tree, start, end, n);
        System.out.println("Maximum Sub-Array Sum between "
                + start + " and " + end + " = "
                + maxSubarraySum);
    }

    static Node[] constructTree(int[] arr, int n) {
        int x = (int) (Math.ceil(
                Math.log(n)
                        / Math.log(2))); // Height of the tree

        int max_size = 2 * (int) Math.pow(2, x) - 1;
        Node[] tree = new Node[max_size];
        for (int i = 0; i < max_size; i++)
            tree[i] = new Node();

        constructTreeUtil(tree, arr, 0, n - 1, 1);
        return tree;
    }

    static void constructTreeUtil(Node[] tree, int[] arr, int start, int end, int index) {
        /* Leaf Node */
        if (start == end) {
            tree[index].totalSum = arr[start];
            tree[index].maxSuffixSum = arr[start];
            tree[index].maxPrefixSum = arr[start];
            tree[index].maxSubarraySum = arr[start];
            return;
        }

        int mid = (start + end) / 2;
        constructTreeUtil(tree, arr, start, mid, 2 * index);
        constructTreeUtil(tree, arr, mid + 1, end,
                2 * index + 1);

        tree[index] = merge(tree[2 * index], tree[2 * index + 1]);
    }

    // Returns Parent Node after merging its left and right
    // child
    static Node merge(Node leftChild, Node rightChild) {
        Node parentNode = new Node();
        parentNode.maxPrefixSum = Math.max(
                leftChild.maxPrefixSum,
                leftChild.totalSum + rightChild.maxPrefixSum);
        parentNode.maxSuffixSum = Math.max(
                rightChild.maxSuffixSum,
                rightChild.totalSum + leftChild.maxSuffixSum);
        parentNode.totalSum = leftChild.totalSum + rightChild.totalSum;
        parentNode.maxSubarraySum = Math.max(Math.max(leftChild.maxSubarraySum,
                rightChild.maxSubarraySum),
                leftChild.maxSuffixSum
                        + rightChild.maxPrefixSum);
        return parentNode;
    }

    /*
     * Returns the Maximum Subarray Sum between start and end
     */
    static int query(Node[] tree, int start, int end, int n) {
        Node res = queryUtil(tree, 0, n - 1, start, end, 1);
        return res.maxSubarraySum;
    }

    static Node queryUtil(Node[] tree, int ss, int se, int qs, int qe, int index) {
        if (ss > qe || se < qs) {
            Node nullNode = new Node();
            return nullNode;
        }

        if (ss >= qs && se <= qe) {
            return tree[index];
        }

        int mid = (ss + se) / 2;
        Node left = queryUtil(tree, ss, mid, qs, qe, 2 * index);
        Node right = queryUtil(tree, mid + 1, se, qs, qe,
                2 * index + 1);
        Node res = merge(left, right);
        return res;
    }

    /*
     * Node of the segment tree
     */
    private static class Node {
        int maxPrefixSum;
        int maxSuffixSum;
        int totalSum;
        int maxSubarraySum;

        Node() {
            maxPrefixSum = maxSuffixSum = maxSubarraySum = Integer.MIN_VALUE;
            totalSum = Integer.MIN_VALUE;
        }
    }
}
