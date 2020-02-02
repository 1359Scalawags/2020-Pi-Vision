package team1359;

import java.util.ArrayList;
import java.util.List;

public class Updator{
    private ArrayList<Void> events = new ArrayList<Void>();
    public Updator(){
        while(true){
            try{
                for(int i=0; i<events.size(); i++){
                    events.get(i);
                }
            }
            catch(Exception exception){

            }
        }
    }

    void schedule(Void event){
        events.add(event);
    }
}