public abstract class Album {
    protected float bevetel;
    protected final String kiado;

    public Album(float bevetel, String kiado) {
        this.bevetel = bevetel;
        this.kiado = kiado;
    }

    public abstract void szponzorKereses();

    public String getKiado() {
        return kiado;
    }

    public void setBevetel(float bevetel) {
        this.bevetel = Math.max(bevetel, 800);
    }

    public float getBevetel() {
        return this.bevetel;
    }
}
