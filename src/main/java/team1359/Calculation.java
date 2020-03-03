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
    private double lengthOfTarget;
    private double areaOfTarget;
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

    public double getAngleFromTarget(){
       return (lengthOfTarget-1)/(angleToTargetRatio*(1/(getDistanceFromTarget())));
    }

    // public void findTarget(ArrayList<RotatedRect> contours){
    //     int correctIndex = -1;
    //     for(int i = 0; i < (contours.size() - 1); i++){
    //         if(contours.get(i).angle > 0 && contours.get(i+1).angle < 0){
    //             correctIndex = i;
    //         }
    //     }
    //     if(correctIndex > -1){
    //         if(initialArea){
    //             initialAreaOfTarget = (contours.get(correctIndex).size.area() + contours.get(correctIndex+1).size.area())/2;
    //             initialArea = false;
    //         }
    //         lengthOfTarget = (contours.get(correctIndex).size.width + contours.get(correctIndex+1).size.width)/2;
    //         areaOfTarget = (contours.get(correctIndex).size.area() + contours.get(correctIndex+1).size.area())/2;
    //         centerOfTarget = (int)((contours.get(correctIndex+1).center.x + contours.get(correctIndex).center.x)/2);
    //     }
    //     else{
    //     }
    // }

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