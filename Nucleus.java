class Nucleus{

  private String type;
  private Nucleon[] core;

  public Nucleus(String type) {
    this.type = type;
    this.core = new Nucleon[9];
  }

  public String getType() {
    return this.type;
  }

  public void setType( String newType ) {
    this.type = newType;
  }

  public int nucleonCount() {
    int count = 0;
    for(Nucleon nucleon : core){
      if(nucleon != null) {
        count++;
      }
    }
    return count;
  }

  public void bind( Nucleon nucleon ) {
    if(atCriticalMass()) return;
    int nucleonCount = nucleonCount();
    core[nucleonCount] = nucleon;
  }

  public boolean atCriticalMass() {
    return nucleonCount() >= core.length;
  }

  public void passTime() {
    for(int i=0; i < core.length; i++) {
      core[i] = null;
    }
  }

}