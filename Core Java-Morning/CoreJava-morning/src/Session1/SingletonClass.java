package Session1;

public class SingletonClass {

    private static SingletonClass mysingleton=new SingletonClass( );
    private static int singletonVar;

    private SingletonClass() {
        SingletonClass.singletonVar = 1;
    }

    public static SingletonClass getInstance(){
        return mysingleton;
    }

    public static int getSingletonVar() {
        return singletonVar;
    }

    public static void setSingletonVar(int singletonVar) {
        SingletonClass.singletonVar = singletonVar;
    }

    protected static void exampleFuntion( ) {
        System.out.println("example Function print: "+SingletonClass.getSingletonVar());
    }
}
