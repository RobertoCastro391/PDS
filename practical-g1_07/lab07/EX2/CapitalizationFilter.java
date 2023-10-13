package lab07.EX2;
public class CapitalizationFilter extends TextDecorator {
    
    public CapitalizationFilter(Interface text) {
        super(text);
    }

    public boolean hasNext() {
        return text.hasNext();
    }

    public String next() {
        String stringFinal = "";
        String str = super.next();
        char ch[] = str.toCharArray();
        ch[0] = Character.toUpperCase(ch[0]);
        ch[ str.length()-1 ] = Character.toUpperCase(ch[ str.length()-1 ]);
        for (char c : ch) {
            stringFinal += c;
        }
        return stringFinal;
    }
}
