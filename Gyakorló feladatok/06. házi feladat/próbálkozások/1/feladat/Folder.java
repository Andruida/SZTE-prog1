public class Folder extends FileSystemEntry {
    private FileSystemEntry[] children;

    public Folder(Folder parent, String name) {
        super(parent, name);
        this.children = null;
    }

    public void addChild(FileSystemEntry child) {
        if (children == null) {
            children = new FileSystemEntry[1];
            children[0] = child;
            return;
        }
        FileSystemEntry[] newChildren = new FileSystemEntry[children.length + 1];
        for (int i = 0; i < children.length; i++) {
            newChildren[i] = children[i];
        }
        newChildren[children.length] = child;
        children = newChildren;
    }

    public long size() {
        long size = 0;
        for (int i = 0; i < children.length; i++) {
            size += children[i].size();
        }
        return size;
    }
}
