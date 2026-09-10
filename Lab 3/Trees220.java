import java.io.*;
public class Trees220{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine());
        String[] inorderStr = br.readLine().split(" ");
        String[] preorderStr = br.readLine().split(" ");
        int[] inorder = new int[N];
        int[] preorder = new int[N];
        for (int i = 0; i < N; i++) {
            inorder[i] = Integer.parseInt(inorderStr[i]);
            preorder[i] = Integer.parseInt(preorderStr[i]);
        }
        postOrder(preorder, 0, N - 1, inorder, 0, N - 1, pw);
        pw.println();
        pw.flush();
    }
    public static void postOrder(int [] preorder, int preStart, int preEnd, int [] inorder, int inStart, int inEnd, PrintWriter pw){
        if (preStart > preEnd || inStart > inEnd){
            return;
        }
        int root = preorder[preStart];
        int rootIndex = inStart;
        while (inorder[rootIndex] != root){
            rootIndex++;
        }
        int leftSize = rootIndex - inStart;
        postOrder(preorder, preStart + 1, preStart + leftSize, inorder, inStart, rootIndex - 1, pw);
        postOrder(preorder, preStart + leftSize + 1, preEnd, inorder, rootIndex + 1, inEnd, pw);
        pw.print(root + " ");
    }
}