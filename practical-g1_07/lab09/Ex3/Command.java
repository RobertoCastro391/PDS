package Ex3;
interface Command<T> {
    public boolean execute(T element);
    public boolean undo();
}
