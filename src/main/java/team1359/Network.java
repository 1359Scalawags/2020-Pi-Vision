package team1359;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import team1359.Global;

public class Network{


    NetworkTableInstance inst;
    NetworkTable NT;
    NetworkTableEntry Distancevalue, AngleValue;

    public Network(){
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
        AngleValue = NT.getEntry("Angle");

        Distancevalue.setNumber(1);
    }

    public void update(){
        NT = inst.getTable("PI");

        Distancevalue = NT.getEntry("Distance");
        AngleValue = NT.getEntry("Angle");

        String str = Distancevalue.getString("Nothing RPI") + " " + AngleValue.getString("Nothing RPI");
        System.out.println(str);
    }
}
