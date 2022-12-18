 /** CSCI 1913
 * Izra Bereket
 */

public class TrieNode <T> {

    private T data;
    private TrieNode<T>[] children;

    /**Initalizes the children to an array with 26 spaces and sets data to null */
    public TrieNode(){
        data = null;
        children = new TrieNode[26];
        for (int i=0; i < children.length; i++){
            children[i] = null;
        }
    }
    /** Gets the data */
    public T getData(){
        return data;
    }
    /** Sets the data */
    public void setData(T data){
        this.data = data;
    }
    /** Returns the TrieNode associated with the given letter */
    public TrieNode<T> getChild(char input){
        if ('a' > input || 'z' < input){
            return null;
        }
        return (children[input -'a'] == null) ? children[input -'a'] = new TrieNode<>():children[input -'a'];
    }
}