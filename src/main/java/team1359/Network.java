package team1359;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.networktables.NetworkTableType;
import edu.wpi.first.networktables.NetworkTableValue;
import edu.wpi.first.networktables.TableEntryListener;
import team1359.Global;

public class Network{


    NetworkTableInstance inst;
    NetworkTable Distance; 
    NetworkTableEntry Distancevalue;

    public Network(){

        inst = NetworkTableInstance.getDefault();
        inst.startServer();
        inst.setServerTeam(1359);
        
        if (Global.server) {
            inst.startServer();
        }
        else {
            inst.startClientTeam(Global.team);
        }


        Distance = inst.getTable("DistanceTable");
        Distancevalue = Distance.getEntry("value");
        Distancevalue.setString("awsomeness");

            
            // NetworkTable.setClientMode();
            // NetworkTable.setTeam(1359);
            // NetworkTable.setIPAddress("roborio-6325-frc.local"); // ip of roborio
            // NetworkTable.initialize();
    }

    public void update(){
        Distance = inst.getTable("DistanceTable");
        Distancevalue = Distance.getEntry("value");
        String str  = Distancevalue.getString("Nothing RPI");

        
        System.out.println(str);
    }
}
