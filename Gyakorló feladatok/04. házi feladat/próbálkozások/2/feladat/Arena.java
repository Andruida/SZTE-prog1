public class Arena {
  private Sarkany ellenfel;
  private Hos[] hosok;
  
  public Arena(Sarkany ellenfel, int hosSzam) {
    this.ellenfel = ellenfel;
    if (hosSzam < 1) hosSzam = 1;
    this.hosok = new Hos[hosSzam];
  }

  public boolean hosErkezik(Hos hos) {
    for (int i = 0; i < hosok.length; i++) {
      if (hosok[i] == null) {
        hosok[i] = hos;
        return true;
      }
    }
    System.err.println("az arena megtelt");
    return false;
  }

  public boolean gyoztunk() {
    return !ellenfel.vajonElMeg();
  }

  public boolean hosTamad(Hos hos) {
    if (hos.vajonElMeg()) {
      return false;
    }
    if (this.gyoztunk()) {
      return true;
    }
    
    ellenfel.setEletero(
      ellenfel.getEletero() - hos.getTamadas());
    
    if (this.gyoztunk()) {
      hos.setSikerSzam(hos.getSikerSzam() + 1);
      return true;
    } else {
      ellenfel.eszik(hos.getEletEro());
      hos.setEletEro(0);
      return false;
    }
  }

  public int altalanosTamadas() {
    int aldozatok = 0;
    for (Hos hos : hosok) {
      if (hos == null) continue;
      if (!this.hosTamad(hos)) aldozatok++;
    }
    return aldozatok;
  }

  public int eroTamadas() {
    int aldozatok = 0;
    while (!this.gyoztunk()) {
      if (hosok[0] == null) break;
      Hos legerosebb = hosok[0];
      boolean talalt = false;
      for (Hos hos : hosok) {
        if (hos == null || !hos.vajonElMeg()) continue;
        if (hos.getTamadas() > legerosebb.getTamadas()) {
          legerosebb = hos;
          talalt = true;
        }
      }
      if (!talalt) break;
      if (!this.hosTamad(legerosebb)) aldozatok++;
    }
    return aldozatok;
  }

  public int strategiaiTamadas() {
    int aldozatok = 0;

    for (Hos hos : hosok) {
      if (hos == null || !hos.vajonElMeg() || hos.getTamadas() <= hos.getEletEro()) continue;
      if (!this.hosTamad(hos)) aldozatok++;
    }

    return aldozatok;
  }

}