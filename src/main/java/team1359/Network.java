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
        NetworkTableInstance ntinst = NetworkTableInstance.getDefault();
        if (Global.server) {
            ntinst.startServer();
        }
        else {
            ntinst.startClientTeam(Global.team);
        }

        Distance = ntinst.getTable("DistanceTable");
        Distancevalue = Distance.getEntry("value");
        Distancevalue.setString("awsomeness");
    }

    public void update(){
        Distance = inst.getTable("DistanceTable");
        Distancevalue = Distance.getEntry("value");
    }
}