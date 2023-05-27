package com.mjc.stage2;

public class ThreadSafeSingleton {
   //Declare a private static instance of the same class.
    //Это означает, что значение переменной будет "всегда читаться".
   // Например, в многопоточных приложениях один поток прочёл значение a=1, передал управление другому потоку,
   // который изменил значение на a=2, потом управление вернулось.
   // Так вот, без volatile значение a у первого потока будет 1, т.к. первый поток "помнит", что a=1,
   // а с volatile - 2, т.к. первый поток снова прочтет значение и получит уже измененное.
    private static volatile ThreadSafeSingleton threadSafe;
    private static Object mutex;

    //Create the private constructor to avoid any new object creation with new operator.
    private ThreadSafeSingleton() {
    }
//Provide a public static method that will return the singleton class instance variable.
// If the variable is not initialized then initialize it or else simply return the instance variable.
    public static ThreadSafeSingleton getInstance(){
        ThreadSafeSingleton result = threadSafe;
        if (result == null){
            synchronized (mutex){
                result = threadSafe;
                if (result == null)
                {threadSafe = result = new ThreadSafeSingleton();
                }
                }
            }

        return result;
    }


    // Write your code here!
}
