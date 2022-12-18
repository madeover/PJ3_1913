
/**
 * CSCI 1913
 * Izra Bereket
 */
public class Trie <T> {

    private TrieNode<T> root;

    /** Single private Trienode root */
    public Trie(){
        root = new TrieNode<>();
    }
    /** Returns teh string and the appropiate trieNode */
    private TrieNode<T> getNode(String input){
        TrieNode<T> newRoot = root;
        for (int i = 0; i < input.length(); i++){
            newRoot = newRoot.getChild(input.charAt(i));
        }
        return newRoot;
    }
    /** Gets the data currently stored on the Trienode*/
    public T get(String input){
        TrieNode<T> sum = getNode(input);
        return sum.getData();
    }
    /** Sets teh data currently stored on the Trienode */
    public void put(String input, T data){
        TrieNode<T> sum = getNode(input);
        sum.setData(data);
    }
}