package team1359;

import team1359.Network;
import team1359.Pipeline.GripPipeline;

import java.util.ArrayList;

import org.opencv.core.*;

public class Calculation {

    public static final float ReflectorAreaAtOneFoot = 100;

    GripPipeline pipeline;
    Network knetwork;

    static int frameWidth = 0;
    static int frameHeight = 0;
    private double areaOfTarget;
    private double lengthOfTarget;
    private double angleToTargetRatio = 8.0/45.0;
    double areaFromMaxDistance = 5;
    double initialAreaOfTarget;

    double expectedTargetArea;
    double TargetArea;

    public Calculation(){

    }

    public void processContours(ArrayList<MatOfPoint> contours){
        if(contours != null){

        }
    }

    public double[] getAnglesFromTarget(){
        double[] angles = new double[2];
        
        return angles;
    //    return (lengthOfTarget-1)/(angleToTargetRatio*(1/(getDistanceFromTarget())));
    }

    public double getDistanceFromTarget(){

        return Math.sqrt(areaFromMaxDistance/areaOfTarget);
    }

    public double TargetDistanceError(){
        return Math.abs(TargetArea - expectedTargetArea);
    }

    public float findTargetAngle(){
        return 1;
    }
}