/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

import edu.wpi.first.vision.VisionThread;

import team1359.Pipeline.GripPipeline;
import team1359.*;

public final class Main {

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

    Network net = new Network();



    // start cameras
    for (Global.CameraConfig config : Global.cameraConfigs) {
      Global.cameras.add(Cam.startCamera(config));
    }

    // start switched cameras
    for (Global.SwitchedCameraConfig config : Global.switchedCameraConfigs) {
      Cam.startSwitchedCamera(config);
    }

    // start image processing on camera 0 if present
    if (Global.cameras.size() >= 1) {
      VisionThread visionThread = new VisionThread(Global.cameras.get(0), new GripPipeline(), pipeline -> {
        // do something with pipeline results

      });
      visionThread.start();
    }
    // FanControl f = new FanControl();

    while(true){
      try{
          // Network net = new Network();
          // net.update();
          System.out.println("test");
      }
      catch(Exception exception){
        System.out.println(exception);
      }
    }
  }
}