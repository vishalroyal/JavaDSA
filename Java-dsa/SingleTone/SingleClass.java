package SingleTone;

import java.lang.reflect.Constructor;

public class SingleClass {

    private static final SingleClass singleClass = new SingleClass();

        private SingleClass(){
        }

        public static SingleClass getInstance()
        {
            return singleClass;
        }


    public void printMessage() {
        System.out.println("Singleton instance created.");
    }

    public static void main(String args[])
    {
        try {
            singleClass.printMessage();
            System.out.println(singleClass.hashCode());


            //Second instance can be created using reflection api for singleton class
            // starts here
            Constructor<SingleClass> constructor = SingleClass.class.getDeclaredConstructor();
            constructor.setAccessible(true);

            SingleClass instance2 = constructor.newInstance();
            instance2.printMessage();
            System.out.println(instance2.hashCode());
            // reflection exaample ends here
        }
        catch (Exception e)
        {

        }
    }
}
