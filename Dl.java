public class Dl {
    public static final String A = "A";
    public static final String B = "B";

    public static void main(String[] args) {
        Thread first = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A) {
                    System.out.println("first thread get A");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (B) {
                        System.out.println("first thread get B");
                    }
                }
            }
        });

        first.start();
    }
}
