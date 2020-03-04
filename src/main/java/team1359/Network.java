package team1359;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import team1359.Global;

public class Network{
    NetworkTableInstance inst;
    NetworkTable NT;
    NetworkTableEntry Distancevalue;
    NetworkTableEntry[] AngleValues;

    public void init(){
      inst = NetworkTableInstance.getDefault();
      if (Global.server) {
        System.out.println("Setting up NetworkTables server");
        inst.startServer();
      } else {
        System.out.println("Setting up NetworkTables client for team " + Global.team);
        inst.startClientTeam(Global.team);
      }

      NT = inst.getTable("PI");

      Distancevalue = NT.getEntry("Distance");
      AngleValues[0] = NT.getEntry("XAngle");
      AngleValues[1] = NT.getEntry("YAngle");
    }

    public void update(){
        NT = inst.getTable("PI");

        Distancevalue = NT.getEntry("Distance");
        AngleValues[0] = NT.getEntry("XAngle");
        AngleValues[1] = NT.getEntry("YAngle");

        String str = Distancevalue.getString("Nothing RPI") + " " + AngleValues[0].getString("Nothing RPI") + " " + AngleValues[1].getString("Nothing RPI");
        System.out.println(str);
    }

	public void setTable(double dist, double[] angles) {
    Distancevalue.setNumber(dist);
    AngleValues[0].setNumber(angles[0]);
    AngleValues[1].setNumber(angles[1]);
	}
}
