package Array;// Sort Array By Parity
// Given an array A of non-negative integers, return an array consisting of all the even elements
// of A, followed by all the odd elements of A.

public class SortArrayByParity {

    public static void main(String[] args) {
        sortArrayByParity(new int[]{3,1,2,4});
    }

    public static int[] sortArrayByParity(int[] A) {
        if(A.length == 0 || A.length == 1)
            return A;
        int i=0;
        int j=1;
        while (j<A.length){
            if(isOdd(A[i]) && isOdd(A[j]))
                j++;
            else if((isEven(A[i]) && isEven(A[j])) || (isEven(A[i]) && isOdd(A[j]))){
                i++;
                j++;
            }
            else if(isOdd(A[i]) && isEven(A[j])){
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        return A;
    }

    private static boolean isOdd(int i) {
        return i%2!=0;
    }

    private static boolean isEven(int i) {
        return i%2==0;
    }
}
