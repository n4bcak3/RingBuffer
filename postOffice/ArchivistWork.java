package postOffice;
//         _____  __                __     ______
// .-----.|  |  ||  |--.----.---.-.|  |--.|__    |
// |     ||__    |  _  |  __|  _  ||    < |__    |
// |__|__|   |__||_____|____|___._||__|__||______|
//                                       4 project


public class ArchivistWork extends Thread {
    public ArchivistWork(Archivists runnable) {
        super(runnable, runnable.name);
        setDaemon(true);
        start();
    }
}
