public class StraightLine {

    public static void main(String[] args) {
        StraightLine s = new StraightLine();
        int[][] coordinates = {{-4,-3},{1,0},{3,-1}};
        System.out.println(s.checkStraightLine(coordinates));
    }

    public boolean checkStraightLine(int[][] coordinates) {
        float slope = (float)(coordinates[1][1] - coordinates[0][1])/(float)(coordinates[1][0] - coordinates[0][0]);
        for(int i=2; i<coordinates.length; i++){
            if((float) (coordinates[i][1] - coordinates[i-1][1])/(float) (coordinates[i][0] - coordinates[i-1][0])!=slope)
                return false;

        }
        return true;
    }
}
