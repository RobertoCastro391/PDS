package lab07.EX2;

public class VowelFilter extends TextDecorator{
     
    public VowelFilter(Interface t) {
        super(t);
    }

    public boolean hasNext() { 
        return super.hasNext();
    }

    public String next() {
        String str = super.next();
        String vogais = "AEIOUaeiou";
        String palavra = "";

        for (int i = 0; i < str.length(); i++) {
            if ( str.charAt(i) == ' ' || vogais.indexOf( str.charAt(i) ) == -1) {
                palavra += str.charAt(i);
            }
        }
        return palavra;
    }
    
}
