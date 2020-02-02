package team1359;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import edu.wpi.cscore.MjpegServer;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoSource;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.networktables.EntryListenerFlags;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Cam {
    /**
     * Start running the camera.
     */
    public static VideoSource startCamera(Global.CameraConfig config) {
        System.out.println("Starting camera '" + config.name + "' on " + config.path);
        CameraServer inst = CameraServer.getInstance();
        UsbCamera camera = new UsbCamera(config.name, config.path);
        MjpegServer server = inst.startAutomaticCapture(camera);

        Gson gson = new GsonBuilder().create();

        camera.setConfigJson(gson.toJson(config.config));
        camera.setConnectionStrategy(VideoSource.ConnectionStrategy.kKeepOpen);

        if (config.streamConfig != null) {
        server.setConfigJson(gson.toJson(config.streamConfig));
        }

        return camera;
    }

    /**
     * Start running the switched camera.
     */
    public static MjpegServer startSwitchedCamera(Global.SwitchedCameraConfig config) {
        System.out.println("Starting switched camera '" + config.name + "' on " + config.key);
        MjpegServer server = CameraServer.getInstance().addSwitchedCamera(config.name);

        NetworkTableInstance.getDefault()
            .getEntry(config.key)
            .addListener(event -> {
                if (event.value.isDouble()) {
                    int i = (int) event.value.getDouble();
                    if (i >= 0 && i < Global.cameras.size()) {
                    server.setSource(Global.cameras.get(i));
                    }
                } else if (event.value.isString()) {
                    String str = event.value.getString();
                    for (int i = 0; i < Global.cameraConfigs.size(); i++) {
                    if (str.equals(Global.cameraConfigs.get(i).name)) {
                        server.setSource(Global.cameras.get(i));
                        break;
                    }
                    }
                }
                },
                EntryListenerFlags.kImmediate | EntryListenerFlags.kNew | EntryListenerFlags.kUpdate);

        return server;
    }
}