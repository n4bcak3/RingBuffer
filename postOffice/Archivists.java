package postOffice;
//         _____  __                __     ______
// .-----.|  |  ||  |--.----.---.-.|  |--.|__    |
// |     ||__    |  _  |  __|  _  ||    < |__    |
// |__|__|   |__||_____|____|___._||__|__||______|
//                                       4 project


public class Archivists implements Runnable{
    public String name;

    private final CircBuffer main_mailbox;
    private final CircBuffer archive_buffer;

    public Archivists(String name, CircBuffer mainmailbox ,CircBuffer archive_buff) {
        this.name = name;
        this.main_mailbox = mainmailbox;
        this.archive_buffer = archive_buff;
    }

    @Override
    public void run() {
        try{
            while (true) {
                while (NotSuccessArchiveStore()) {
                    Thread.sleep(50);
                }
                Thread.sleep(50);
            }
        } catch (Exception e){}
    }

    private boolean NotSuccessArchiveStore() {
        String main_mailbox_letter = this.main_mailbox.read();

        return ((main_mailbox_letter == null) || !archive_buffer.store(
                String.format("\u001B[34m%s\u001B[0m | served: \u001B[33m%s\u001B[0m",
                        main_mailbox_letter, this.name)
        ));

    }
}
