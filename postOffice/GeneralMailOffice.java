package postOffice;//         _____  __                __     ______
// .-----.|  |  ||  |--.----.---.-.|  |--.|__    |
// |     ||__    |  _  |  __|  _  ||    < |__    |
// |__|__|   |__||_____|____|___._||__|__||______|
//                                       4 project


import java.util.ArrayList;
import java.util.List;

public class GeneralMailOffice {
    private final int MAILBOX_SIZE = 10;
    private final int RANDOM_LATENCY_MAX = 2000;
    private CircBuffer mailbox = new CircBuffer(MAILBOX_SIZE);
    private CircBuffer archive_buffer;
    private List<PostOffice> partners = new ArrayList<PostOffice>();

    public GeneralMailOffice(List<String> partners_offices, CircBuffer archive_buff) {

        this.archive_buffer = archive_buff;

        for (String office : partners_offices)
            new MailThread(
                    new PostOffice(office, mailbox, (int)(Math.random()*RANDOM_LATENCY_MAX)+300)
                    ,"post_office_"+office);


        new ArchivistWork(new Archivists("Tittummin", mailbox, archive_buffer));
        new ArchivistWork(new Archivists("Ello", mailbox, archive_buffer));
    }



}
