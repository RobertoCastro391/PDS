package lab07.EX2;
public class TermFilter extends TextDecorator {

    private int numWords = -1;
    
    public TermFilter(Interface text) {
        super(text);
    }

    public boolean hasNext() {
        String line = super.next();
        String words[] = line.split("\\s");
        if (this.numWords == words.length - 1) {
            return false;
        }
        return true;
    }
    
    public String next() {
        String line = super.next();
        String words[] = line.split("\\s");
        this.numWords++;
        return words[this.numWords];
    }
}