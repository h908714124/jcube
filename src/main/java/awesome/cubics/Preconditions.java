package awesome.cubics;

 class Preconditions {

     static void checkState(boolean b, String message) {
         if (!b) {
             throw new IllegalStateException(message);
         }
     }
}
