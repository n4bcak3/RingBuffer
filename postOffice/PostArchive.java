package postOffice;
//         _____  __                __     ______
// .-----.|  |  ||  |--.----.---.-.|  |--.|__    |
// |     ||__    |  _  |  __|  _  ||    < |__    |
// |__|__|   |__||_____|____|___._||__|__||______|
//                                       4 project


import java.util.ArrayList;
import java.util.List;

public class PostArchive {
    private final int ARCHIVE_SIZE = 10;
    private GeneralMailOffice central_office;
    private CircBuffer archive = new CircBuffer(ARCHIVE_SIZE);
    private String mail = null;
    private int times_mail_printed = 1;

    GeneralMailOffice main_office;

    public PostArchive() {

        // 5 mail office partners
        List<String> partners = new ArrayList<String>();
        partners.add("UA");
        partners.add("FR");
        partners.add("UK");
        partners.add("US");
        partners.add("PO");

        main_office = new GeneralMailOffice(partners, archive);

    }

    public boolean noNewMailReceived(){
        return (this.mail == null);
    }

    public void checkNewMailReceived(){
        this.mail = archive.read();
    }


    public void printMail(){
        if (noNewMailReceived())
            return;

        System.out.println(String.format(
                    "[Mail #%d] - %s",
                times_mail_printed++,
                    this.mail
            ));
        this.mail = null;
    }
}
