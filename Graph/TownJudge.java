package Graph;

public class TownJudge {

    public static void main(String[] args) {
        TownJudge t = new TownJudge();
        int[][] trust = {{1,2},{2,3}};
        System.out.println(t.findJudge(3,trust));
    }

    public int findJudge(int N, int[][] trust) {
        int[] isTrusted = new int[N+1];
        for(int[] person : trust){
            isTrusted[person[0]]--;
            isTrusted[person[1]]++;
        }
        for(int i = 1;i < isTrusted.length;i++){
            if(isTrusted[i] == N-1) return i;
        }
        return -1;
    }
}

