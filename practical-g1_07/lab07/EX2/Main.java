package lab07.EX2;

public class Main {
    public static void main(String[] args) {
        
        String fname = "lab07/EX2/input.txt";

        Interface r1 = new TextReader(fname);
        Interface r2 = new NormalizationFilter(new TextReader(fname));
        Interface r3 = new VowelFilter(new TermFilter(new TextReader(fname)));
        Interface r4 = new VowelFilter(new NormalizationFilter(new TextReader(fname)));
        Interface r5 = new CapitalizationFilter(new TermFilter(new TextReader(fname)));

        Interface lista[] = {r1,r2,r3,r4,r5};

        for (Interface  t : lista) {
            String p = t.next();
            System.out.println(p);

            p = t.next();
            System.out.println(p);

            System.out.println();

        }

    }
}