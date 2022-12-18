import java.util.Random;

/**
 * CSCI 1913 Project 3
 * Izra Bereket
 */


public class CharBag {
    int[] data;
    int size;

    /**This creates an empty charbag array */
    public CharBag(){
        data = new int[27];
        size = 0;
    }
    /**This adds a character to the charbag array */
    public void add(char input){
        if (Character.isLetter(input)){
            input = Character.toLowerCase(input);
            data[input - 'a'] += 1;
            size += 1;
        } else {
            data[26] += 1;
            size += 1;
        }
    }
    /** This removes a character from the charbag array */
    public void remove(char c){
        if (!Character.isLetter(c)) {
            if (data[26] > 0){
                data[26] -= 1;
                size -= 1;
            }  
        } else if (data[c - 'a'] > 0) {
            data[c - 'a'] -= 1;
            size -= 1;
        }
    }
    /**It returns the count of the character given to us in the charbag array */
    public int getCount(char input){
        if (!Character.isLetter(input)){
            return data[26];
        } else {
            return data[input - 'a'];
        } 
    }
    /**Returns the size of the charbag array */
    public int getSize(){
        return size;
    }
    /**Returns the string noting the count of each letter */
    public String toString(){
        return "CharBag{a:" + data[0] + ", b:" + data[1] + ", c:" + data[2] + ", d:" + data[3] + ", e:" + data[4] + ", f:" + data[5] + ", g:" + data[6] + ", h:" +
        data[7] + ", i:" + data[8] + ", j:" + data[9] + ", k:" + data[10] + ", l:" + data[11] + ", m:" + data[12] + ", n:" + data[13] + ", o:" + data[14] + ", p:" +
        data[15] + ", q:" + data[16] + ", r:" + data[17] + ", s:" + data[18] + ", t:" + data[19] + ", u:" + data[20] + ", v:" + data[21] + ", w:" + data[22] +
        ", x:" + data[23] + ", y:" + data[24] + ", z:" + data[25] + ", .:" + data[26] + "}";
    }
    /** This function returns a randomly chosen character from the characters in the char bag relative
     * the proportion of the number of times its given 
     */
    public char getRandomChar(){
        if (getSize() <= 0){
            return '.';
        } 
        Random ran = new Random();
        int count = ran.nextInt(getSize());        
        for (int i=0; i < 26; i++){
            count -= data[i];
            if (count < 0){
                return (char) ('a' + i);
            }
        }
        return '.';
    }
}