package localVariable;

public class LocalVariableType {
    public static void main(String[] args) {
        var x=121313;
        var y=11333;

        FuncInterface funcInterface=( var a, var b) -> (a+b);

        System.out.println(funcInterface.operation(x,y));

    }
}

@FunctionalInterface
interface FuncInterface{
    int operation(int a,int b);
}
