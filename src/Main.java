public class Main {

    private static final int repetitions = 5;
    static Object mon = new Object();
    private static int counter = 1;
    public static void main(String[] args) {

    for (int i = 0; i < repetitions; i++) {

        new Thread(()->{
            synchronized (mon){
                while(counter!=1){
                    try {
                        mon.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print("A");
                counter++;
                mon.notifyAll();
            }
        }).start();

        new Thread(()->{
            synchronized (mon){
                while(counter!=2){
                    try {
                        mon.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print("B");
                counter++;
                mon.notifyAll();
            }
        }).start();

        new Thread(()->{
            synchronized (mon){
                while(counter!=3){
                    try {
                        mon.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print("C");
                counter=counter-2;
                mon.notifyAll();
            }
        }).start();

        }
















    }
}
