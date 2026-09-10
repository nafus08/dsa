import java.io.*;
public class Trees220Reassessed{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine());
        String[] inorderStr = br.readLine().split(" ");
        String[] postorderStr = br.readLine().split(" ");
        int[] inorder = new int[N];
        int[] postorder = new int[N];
        for(int i = 0; i < N; i++){
            inorder[i] = Integer.parseInt(inorderStr[i]);
            postorder[i] = Integer.parseInt(postorderStr[i]);
        }
        preOrder(inorder, 0, N - 1, postorder, 0, N - 1, pw);
        pw.println();
        pw.flush();
    }
    public static void preOrder(int [] inorder, int inStart, int inEnd, int [] postorder, int postStart, int postEnd, PrintWriter pw){
        if (inStart > inEnd || postStart > postEnd){
            return;
        }
        int root = postorder[postEnd];
        pw.print(root + " ");
        int rootIndex = inStart;
        while (inorder[rootIndex] != root){
            rootIndex++;
        }
        int leftSize = rootIndex - inStart;
        preOrder(inorder, inStart, rootIndex - 1, postorder, postStart, postStart + leftSize - 1, pw);
        preOrder(inorder, rootIndex + 1, inEnd, postorder, postStart + leftSize, postEnd - 1, pw);
    }
}