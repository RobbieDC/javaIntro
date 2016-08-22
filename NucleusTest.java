import static org.junit.Assert.assertEquals;
import org.junit.*;

public class NucleusTest{
  Nucleus nucleus;
  Nucleon nucleon;

  @Before
  public void before() {
    nucleus = new Nucleus("hydrogen");
    nucleon = new Nucleon();
  }

  @Test
  public void hasType() {
    assertEquals( "hydrogen", nucleus.getType() );
  }

  @Test
  public void canSetType() {
    nucleus.setType("helium");
    assertEquals( "helium", nucleus.getType() );
  }

  @Test
  public void nucleusStartsEmpty() {
    assertEquals( 0, nucleus.nucleonCount() );
  }

  @Test
  public void canBindNucleon() {
    nucleus.bind(nucleon);
    assertEquals( 1, nucleus.nucleonCount() );
  }

  @Test
  public void nucleusAtCriticalMass() {
    for(int i=0; i<9; i++) {
      nucleus.bind(nucleon);
    }
    assertEquals( true, nucleus.atCriticalMass() );
  }

  @Test
  public void cannotBindNucleonsAtCriticalMass() {
    for(int i=0; i<10; i++) {
      nucleus.bind(nucleon);
    }
    assertEquals( 9, nucleus.nucleonCount() );
  }

  @Test
  public void coreShouldDecayOverTime() {
    nucleus.bind(nucleon);
    nucleus.passTime();
    assertEquals( 0, nucleus.nucleonCount() );
  }

}