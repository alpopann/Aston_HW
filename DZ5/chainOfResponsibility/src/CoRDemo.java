public class CoRDemo {
    public static void main(String[] args) {
        Manager mgr = new Manager();
        Director dir = new Director();
        VicePresident vp = new VicePresident();
        mgr.setNext(dir);
        dir.setNext(vp);

        int[] requests = {500, 1500, 7000, 25000};
        for (int req : requests) {
            mgr.handleRequest(req);
        }
    }
}