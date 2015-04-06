import postOffice.PostArchive;

public class Lab5App {

    public static void main(String[] args) {
        PostArchive archive = new PostArchive();

        for (int i=0; i<100;i++){
            while (archive.noNewMailReceived())
                archive.checkNewMailReceived();
            archive.printMail();
        }
    }
}
