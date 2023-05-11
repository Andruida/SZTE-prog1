public class SequentialNamer implements Namer {
    private int index;    

    public SequentialNamer() {
        index = 1;
    }

    public void rename(FileSystemEntry entry) {
        entry.setName(entry.getName() + "_" + Integer.toString(index));
        index++;
    }
}
