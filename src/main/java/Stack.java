public class Stack<T> {
    private T[] types;

    public Stack(){
        this.types = (T[]) new Object[0];
        int[] x = new int[0];
    }
    public void push(T value){
        T[] second = (T[]) new Object[types.length+1];
        for (int i = 0; i < types.length; i++) {
            second[i] = types[i];
        }
        second[second.length-1] = value;
        types = second;
    }
    public T head(){
         return types[types.length-1];
    }
    public T pop(){
        T lastValue = types[types.length-1];
        T[] third =(T[]) new Object[types.length-1];
        for (int i = 0; i < third.length; i++) {
            third[i] = types[i];
        }
        types = third;
        return lastValue;
    }
}
