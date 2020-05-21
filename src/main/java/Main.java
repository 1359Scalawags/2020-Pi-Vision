/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
// package team1359;

import edu.wpi.first.vision.VisionThread;
import team1359.Pipeline.GripPipeline;
import team1359.*;

public final class Main {
  
  public static Network net = new Network();
  public static Global global = new Global();

  private Main() {
  }

  /**
   * Main.
   */
  public static void main(String... args) {
    
    if (args.length > 0) {
      Global.configFile = args[0];
    }

    // read configuration
    if (!Configs.readConfig()) {
      return;
    }

    // net.init();
    
    // start cameras
    for (Global.CameraConfig config : Global.cameraConfigs) {
      global.cameras.add(Cam.startCamera(config));
    }

    // start switched cameras
    for (Global.SwitchedCameraConfig config : Global.switchedCameraConfigs) {
      Cam.startSwitchedCamera(config);
    }

    // start image processing on camera 0 if present
    if (global.cameras.size() >= 1) {
      VisionThread visionThread = new VisionThread(global.cameras.get(0), new GripPipeline(), pipeline -> {
        // calc.processContours(pipeline.filterContoursOutput());
        // calc.processIMG(global.cameras.get(0));

        // calc.processIMG(new Mat());
        // net.setTable(calc.getDistanceFromTarget(), calc.getAnglesFromTarget());
      });

      visionThread.start();
    }

    while(true){
      try{
        // net.update();
      }
      catch(Exception exception){
        System.out.println(exception);
      }
    }
  }
}