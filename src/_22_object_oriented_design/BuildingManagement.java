package _22_object_oriented_design;

public class BuildingManagement {

  Asset things[] = new Asset[24];  
  int numItems = 0;

  /** goodNight is called from a timer Thread at 2200, or when we
   * get the "shutdown" command from the security guard.
   */
  public void goodNight() {
    for (int i=0; i<things.length; i++)
      if (things[i] instanceof PowerSwitchable)
        ((PowerSwitchable)things[i]).powerDown();
  }

  // goodMorning() would be the same, but call each one's powerUp().

  /** Add a Asset to this building */
  public void add(Asset thing) {  
    System.out.println("Adding " + thing);
    things[numItems++] = thing;
  }

  /** The main program */
  public static void main(String[] av) {
    BuildingManagement b1 = new BuildingManagement();
    b1.add(new RoomLights(101));  // control lights in room 101
    b1.add(new EmergencyLight(101));  // and emerg. lights.
    // add the computer on desk#4 in room 101
    b1.add(new ComputerCPU(10104));
    // and its monitor
    b1.add(new ComputerMonitor(10104));

    // time passes, and the sun sets...
    b1.goodNight();
  }
}
abstract class BuildingLight extends BuildingAsset {
  // generic info on lighting: flourescent/incandescent, ...
  BuildingLight(int roomNumber) {
    super(roomNumber);
  }
}
abstract class ComputerAsset extends Asset {
  // generic computer component stuff here: location, owner, 
  // warranty expiration date :-), etc.
  int deskNumber;
  ComputerAsset(int deskNumber) {
    this.deskNumber = deskNumber;
  }
}
class ComputerCPU extends ComputerAsset {
  // information about CPU (P5, P6, ...), RAM, etc.
  ComputerCPU(int deskNumber) {
    super(deskNumber);
  }
}
/** Asset is the top level of every Asset */
abstract class Asset extends Object {
  // No fields or methods; it's just the base of everything.
}

class EmergencyLight extends BuildingLight {  // NEVER SWITCH OFF
  EmergencyLight(int roomNumber) {
    super(roomNumber);
  }
}
/**
 * PowerSwitchable is an Interface that will be implemented by things
 * that can safely be turned off at night. Could use X10(tm) or BlueTooth
 * or 802.11 or any similar network technology to turn things on or off.
 *
 * @author  Ian F. Darwin
 */
interface PowerSwitchable {

  /** The technique for turning this unit off */
  public void powerDown();

  /** The technique for turning this unit on */
  public void powerUp();
}
class RoomLights extends BuildingLight implements PowerSwitchable {
  RoomLights(int roomNumber) {
    super(roomNumber);
  }
  public void powerDown() {
    System.out.println("Dousing lights in room " + room);
  }
  public void powerUp() {
    System.out.println("Lighting lights in room " + room);
  }
}
/** The top level of everything that is permanently part of the building */
abstract class BuildingAsset extends Asset {
  protected int room;

  public BuildingAsset(int room) {
    this.room = room;
  }
}
class ComputerMonitor extends ComputerAsset implements PowerSwitchable {
  ComputerMonitor(int roomNumber) {
    super(roomNumber);
  }
  public void powerDown() {
    System.out.println("Dousing monitor at desk " + deskNumber);
    // send the code to the Monitor's X10 box to shut it off
  }
  public void powerUp() {
    System.out.println("Warming up monitor at desk " + deskNumber);
    // send the code to the Monitor's X10 box to turn it on
  }
}