package Reader;

import java.util.Scanner;

public class Reader {
    Scanner scanner;
    public  Reader(){
         this.scanner=new Scanner(System.in);
    }
    public double getDouble(){
        return this.scanner.nextDouble();
    }
    public  int getInteger() {
        this.scanner=new Scanner(System.in);
        int n= this.scanner.nextInt();
        return n;
    }
    public   String getString(){
         this.scanner=new Scanner(System.in);
        String s= this.scanner.next();
        return  s;
    }
}
