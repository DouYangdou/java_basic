public class DeadLockExample {
    public static final String R = "resource";
    public static final String RESOURCE1 = R;
    public static final String RESOURCE2 = R;

    public static void main(String[] args) {
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (RESOURCE1) {
                    System.out.println("a get resource 1");

                    synchronized (RESOURCE2) {
                        System.out.println("a get resource 2");
                    }
                }
                System.out.println("a release all");
            }
        });

        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (RESOURCE2) {
                    System.out.println("b get resource 2");

                    synchronized (RESOURCE1) {
                        System.out.println("b get resource 1");
                    }
                }
                System.out.println("b release all");
            }
        });

        a.start();
        b.start();
    }
}
