package lab07.EX2;
public abstract class TextDecorator implements Interface {
    protected Interface text;

    public TextDecorator(Interface text) {
        this.text = text;
    }

    @Override
    public boolean hasNext() {
        return text.hasNext();
    }

    @Override 
    public String next() {
        return text.next();

    }
}