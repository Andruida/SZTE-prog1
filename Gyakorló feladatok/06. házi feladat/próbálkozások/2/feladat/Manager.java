public class Manager {
    private Namer namer;
    private Folder imagesFolder;
    private Folder etcFolder;

    public Manager(Namer namer, Folder rootFolder) {
        this.namer = namer;
        imagesFolder = new Folder(rootFolder, "images");
        etcFolder = new Folder(rootFolder, "etc");
    }

    public File upload(String name, long size) {
        if (name == null || namer == null) {
            return null;
        }

        File file;
        if (name.endsWith(".jpg") || name.endsWith(".png") || name.endsWith(".gif")) {
            file = new File(imagesFolder, name, size);
        } else {
            file = new File(etcFolder, name, size);
        }
        namer.rename(file);
        System.out.println("Stored "+file.getName()+" at "+file.fullPath());
        System.out.println("Images size: "+imagesFolder.size()+" bytes");
        System.out.println("Etc size: "+etcFolder.size()+" bytes");

        return file;
    }
}
