// 211. Add and Search Word - Data structure design


class Triee{
    Triee[] children;

    boolean isWord;

    public Triee(){
        this.children = new Triee[26];

        this.isWord = false;
    }
}



public class AddAndSearchWord {

    Triee root;

    public AddAndSearchWord() {
        root = new Triee();
    }

    public void addWord(String word) {
        Triee cur = root;

        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new Triee();
            }
            cur = cur.children[c - 'a'];
        }

        cur.isWord = true;
    }

    public boolean search(String word) {
        return search(root, word, 0);
    }

    public boolean search(Triee cur, String word, int i) {
        if (i == word.length() ) {
            return cur.isWord;
        }
        char c = word.charAt(i);

        if (c == '.') {
            for (Triee child: cur.children) {
                if (child != null && search(child, word, i + 1)) {
                    return true;
                }
            }
            return false;
        }else{

            return cur.children[c - 'a'] != null && search(cur.children[c - 'a'], word, i + 1);
        }

    }

    public static void main(String[] args) {
        AddAndSearchWord obj = new AddAndSearchWord();
        obj.addWord("bad");
        obj.addWord("dad");
        obj.addWord("mad");
        System.out.println(obj.search("pad"));
        System.out.println(obj.search("bad"));
        System.out.println(obj.search(".ad"));
        System.out.println(obj.search("b.."));
    }
}
