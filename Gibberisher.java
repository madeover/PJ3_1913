/**
 * CSCI 1913
 * Izra Bereket
 */

public class Gibberisher {

    private Trie <CharBag> model;
    private int letterSample;
    private int segmentLength;
    /** Constructor that initalizes the length of the segment, msample to 0 and the model */
    public Gibberisher(int segment){
        this.segmentLength = segment;
        letterSample = 0;
        this.model = new Trie<>();
    }
    /** This uses the LetterSample class to generate LetterSamples, and then, for each resulting LetterSample 
     * This function will need to deal with the possibility that it is the first sample for a
     * given string segment (and therefore you need to make a new CharBag and add it. */
    public void train(String[] input){
        for (int i=0; i<input.length; i++){
            LetterSample[] sample = LetterSample.toSamples(input[i], segmentLength);
            for (int j = 0; j < sample.length; j++){
                letterSample ++;
                if (model.get(sample[j].getSegment()) == null){
                    model.put(sample[j].getSegment(), new CharBag());
                }
                model.get(sample[j].getSegment()).add(sample[j].getNextLetter());
            } 
        }
    }
    /** Returns the sample count */
    public int getSampleCount(){
        return letterSample;
    }
    /** Generates a random amount of character */
    public String generate(){
        String word = "";
        while (!word.contains(".")){
            String sample = word;
            if (word.length() > segmentLength){
                sample = word.substring(word.length() - segmentLength);
            } CharBag chars = model.get(sample);
            word = word + chars.getRandomChar();
        }
        return word .substring(0, word.length()-1);
    }
}