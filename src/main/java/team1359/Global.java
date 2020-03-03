package team1359;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import edu.wpi.cscore.VideoSource;

public class Global {
    @SuppressWarnings("MemberName")
    public static class CameraConfig {
      public String name;
      public String path;
      public JsonObject config;
      public JsonElement streamConfig;
    }
  
    @SuppressWarnings("MemberName")
    public static class SwitchedCameraConfig {
      public String name;
      public String key;
    };
    
    public static String configFile = "/boot/frc.json";
    public static int team;
    public static Boolean server;
    public static List<CameraConfig> cameraConfigs = new ArrayList<>();
    public static List<SwitchedCameraConfig> switchedCameraConfigs = new ArrayList<>();
    public List<VideoSource> cameras = new ArrayList<>(); 
}