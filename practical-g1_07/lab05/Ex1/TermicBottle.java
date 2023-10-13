package lab05.Ex1;

class TermicBottle extends Container{

    TermicBottle(Portion portion){
        super(portion);
    }

    @Override
    public String toString(){
        return "TermicBottle with portion = " + getPortion().toString();
    }
}