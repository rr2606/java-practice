package practice;

public class Variables {
    public static void main(String[] args){
        //variable names can't begin with number and can't include special characters other than $ and _
        //final keyword for constants in java
        final int age=37;
        final String name="Sandeep";
        final double weight=70.5;
        // above variables are of primitive type, memory allocated on stack.
        Point point = new Point();
        point.x = 10;
        point.y= 20;
        System.out.println(name + " is " + age + " years old and weighs " + weight + "kgs" + " and his coordinates are: " + point);
        // Wrapper Classes i.e. Object substitutes for Primitive Types (to be used with collections/generics)
        int x1 = 10;
        Integer x2 = x1; //Autoboxing : converts primitive type to corresponding wrapper class
        int x3 = x2; //Auto-unboxing : converts wrapper class object to corresponding primitive type
        System.out.println(x1 + " " + x2+ " " + x3);

        //widening or implicit conversion : byte -> short -> int -> long -> float -> double
        int x=100;
        long y=x;
        float z=y;
        System.out.println(x + " " + y + " " + z);

        //narrowing or explicit conversion : possibility for loss of data
        double d = 65.4;
        int i = (int)d;
        char c = (char)i;
        System.out.println(d + " " + i + " " + c);

        // Valid Escape Sequences : \t : tab, \n : new line, \" : for double quote, \\ : for back slash
    }
}
class Point{
    // not primitive type, variables always stored as references, memory allocated dynamically on heap
    int x;
    int y;
    public String toString(){
        return "("+this.x+", "+this.y+")";
    }
}
