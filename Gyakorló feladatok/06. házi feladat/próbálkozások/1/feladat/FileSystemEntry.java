public abstract class FileSystemEntry {
    private Folder parent;
    private String name;

    public FileSystemEntry(Folder parent, String name) {
        this.parent = parent;
        this.name = name;
        if (parent != null) {
            parent.addChild(this);
        }
    }

    public abstract long size();

    public String fullPath() {
        if (parent == null) {
            return name;
        }
        return parent.fullPath() + "/" + name;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }
}