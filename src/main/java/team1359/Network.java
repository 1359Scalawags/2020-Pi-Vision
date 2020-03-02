package team1359;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import team1359.Global;

public class Network{


    NetworkTableInstance inst;
    NetworkTable Distance; 
    NetworkTableEntry Distancevalue;

    public Network(){
        inst = NetworkTableInstance.getDefault();
        if (Global.server) {
          System.out.println("Setting up NetworkTables server");
          inst.startServer();
        } else {
          System.out.println("Setting up NetworkTables client for team " + Global.team);
          inst.startClientTeam(Global.team);
        }

        Distance = inst.getTable("DistanceTable");
        Distancevalue = Distance.getEntry("value");

        Distancevalue.setNumber(1);
    }

    public void update(){
        Distance = inst.getTable("DistanceTable");
        Distancevalue = Distance.getEntry("value");
        String str  = Distancevalue.getString("Nothing RPI");

        
        System.out.println(str);
    }
}
