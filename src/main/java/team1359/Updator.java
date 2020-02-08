package team1359;

import java.util.ArrayList;
import java.util.List;

public class Updator{
    private ArrayList<Void> events = new ArrayList<Void>();
    public Updator(){
        while(true){
            try{
                // Network net = new Network();
                // net.update();
            }
            catch(Exception exception){

            }
        }
    }

    void schedule(Void event){
        events.add(event);
    }
}