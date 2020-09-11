// Compare Version Numbers
// Compare two version numbers version1 and version2.
//If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.
package Array;

import java.util.ArrayList;
import java.util.List;

public class CompareVersionNumbers {

    public static void main(String[] args) {
        System.out.println(compareVersion("1.0","1.0.0"));
    }

    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
            List<Integer> ver1 = new ArrayList<>();
            List<Integer> ver2 = new ArrayList<>();
            for(int i=0;i<v1.length;i++)
                ver1.add(i,Integer.parseInt(v1[i]));
            for(int i=0;i<v2.length;i++)
                ver2.add(i,Integer.parseInt(v2[i]));

            if(ver1.size()>=ver2.size()){
                return getVersion(ver1,ver2,true);
            }else {
                return getVersion(ver2,ver1,false);
            }


    }

    private static int getVersion(List<Integer> ver1, List<Integer> ver2, boolean v1LengthGreater) {
        int i=0;
        for(i=0;i<ver2.size();i++){
            if(ver1.get(i)>ver2.get(i))
                return v1LengthGreater?1:-1;
            else if(ver1.get(i)<ver2.get(i))
                return v1LengthGreater?-1:1;
        }
        while (i<ver1.size()){
            if(ver1.get(i)>0)
                return v1LengthGreater?1:-1;
            else if(ver1.get(i)<0)
                return v1LengthGreater?-1:1;
            i++;
        }
        return 0;
    }
}
