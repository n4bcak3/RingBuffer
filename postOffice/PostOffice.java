package postOffice;//         _____  __                __     ______
// .-----.|  |  ||  |--.----.---.-.|  |--.|__    |
// |     ||__    |  _  |  __|  _  ||    < |__    |
// |__|__|   |__||_____|____|___._||__|__||______|
//                                       4 project


public class PostOffice implements Runnable{
    private final String country;
    private int latency = 1000;
    private int mailnumber = 1;
    private CircBuffer box;
    private String letter_name;

    public PostOffice(String country, CircBuffer mailbox, int latency){
        this.country = country;
        this.box = mailbox;
        this.latency = latency;
    }

    public PostOffice(String country, CircBuffer mailbox) {
        this.country = country;
        this.box = mailbox;
//        setDaemon(true);
    }

    @Override
    public void run() {
        while (true) {
            try {
                while (!reciveMail()) {
                    Thread.sleep(this.latency / 2);
                }
                Thread.sleep(this.latency/2);
        } catch (Exception e){}}
    }

    public String getLetterName() {
        return String.format("letter%06d%s",
                mailnumber(),
                this.country);
    }

    public boolean reciveMail(){
        String letter = getLetterName();
        if (box.store(letter)){
            nextmailnumber();
            return true;
        }
        return false;
    }

    private int mailnumber(){
        return this.mailnumber;
    }

    private void nextmailnumber(){
        this.mailnumber++;
    }
}
