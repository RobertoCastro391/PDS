package lab07.EX2;
import java.text.Normalizer;

public class NormalizationFilter extends TextDecorator{
    
    public NormalizationFilter(Interface t) {
        super(t);
    }

    public boolean hasNext() { 
        return super.hasNext();
    }

    public String next() {
        String str = super.next();
        str = this.unaccent(str);
        return str;
    }

    public String unaccent(String src) {
		return Normalizer
				.normalize(src, Normalizer.Form.NFD)
				.replaceAll("[^\\p{ASCII}]", "");
	}
}
