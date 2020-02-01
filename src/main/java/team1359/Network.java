package team1359;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.networktables.NetworkTableType;
import edu.wpi.first.networktables.NetworkTableValue;
import edu.wpi.first.networktables.TableEntryListener;

public class Network{
    NetworkTableInstance inst;
    NetworkTable Distance; 
    NetworkTableEntry Distancevalue;

    public Network(){
        inst = NetworkTableInstance.getDefault();

        Distance = inst.getTable("DistanceTable");
        Distancevalue = Distance.getEntry("value");
        Distancevalue.setDouble(0);
    }
}