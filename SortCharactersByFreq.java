// Given a string, sort it in decreasing order based on the frequency of characters


import java.util.*;

public class SortCharactersByFreq {

    public static void main(String[] args) {
        SortCharactersByFreq s = new SortCharactersByFreq();
        System.out.println(s.frequencySort("Aabb"));
    }

    public String frequencySort(String s) {
        String result = "";
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if (!map.containsKey(s.charAt(i)))
                map.put(s.charAt(i),1);
            else map.put(s.charAt(i),map.get(s.charAt(i))+1);
        }
        LinkedHashMap<Character, Integer> reverseSortedMap = new LinkedHashMap<>();
        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));

        System.out.println(reverseSortedMap);
        for(Map.Entry<Character,Integer> entry: reverseSortedMap.entrySet()){
            int i=0;
            while (i<entry.getValue()){
                Character c = entry.getKey();
                result = result + c;
                i++;
            }
        }
        return result;
    }

}
