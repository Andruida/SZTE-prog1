public class Hos extends Ember {
	private int tamadas;
    private int sikerSzam;

    public Hos(String nev, int eletEro, int tamadas, int sikerSzam) {
        super(nev, eletEro);
        this.tamadas = tamadas >= 0 ? tamadas : 0;
        this.sikerSzam = sikerSzam >= 0 ? sikerSzam : 0;
    }

    public int getTamadas() {
        return tamadas;
    }

    public int getSikerSzam() {
        return sikerSzam;
    }

    public void setSikerSzam(int sikerSzam) {
        if (sikerSzam < this.sikerSzam) {
            return;
        }
        this.sikerSzam = sikerSzam;
    }

    @Override
    public void gyogyul(int mennyivel) {
        eletero += mennyivel;
    }

    public void edzes() {
        if (super.vajonElMeg()) {
            tamadas++;
        }
    }

    @Override
    public String toString() {
        return super.toString() + 
        " Ez az ember egy sarkanyolo hos, tamadasa " + 
        tamadas +
        ", es eddig " + sikerSzam + " darab sarkanyt olt meg.";
    }

    public boolean erosebb(Hos[] hosok) {
        boolean erosebb = true;
        for (Hos hos : hosok) {
            if (hos.getTamadas() > this.getTamadas() || (hos.getTamadas() == this.getTamadas() && hos.getEletEro() > this.getEletEro())) {
                erosebb = false;
            }
        }
        return erosebb;
    }
}
