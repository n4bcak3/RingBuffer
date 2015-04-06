package postOffice;
//         _____  __                __     ______
// .-----.|  |  ||  |--.----.---.-.|  |--.|__    |
// |     ||__    |  _  |  __|  _  ||    < |__    |
// |__|__|   |__||_____|____|___._||__|__||______|
//                                       4 project


public class MailThread extends Thread{
    public MailThread(PostOffice office_thread, String s) {
        super(office_thread, s);
        setDaemon(true);
        start();
    }

    @Override
    public void run() {
        super.run();
    }
}
