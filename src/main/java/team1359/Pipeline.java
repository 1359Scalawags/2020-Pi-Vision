package team1359;


import edu.wpi.first.vision.VisionPipeline;

import java.util.ArrayList;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
public class Pipeline{
    public static class GripPipeline implements VisionPipeline {
        //Outputs
        private Mat hsvThresholdOutput = new Mat();
        private Mat processingOutput = new Mat();

        static {
            System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        }

        /**
         * This is the primary method that runs the entire pipeline and updates the outputs. It is required from VisionPipeline
        */
        public void process(Mat source0) {
            // Step HSV_Threshold0:
            // Mat hsvThresholdInput = source0;
            // double[] hsvThresholdHue = {0.0, 180.0};
            // double[] hsvThresholdSaturation = {0.0, 255.0};
            // double[] hsvThresholdValue = {0.0, 133.1569965870307};
            // hsvThreshold(hsvThresholdInput, hsvThresholdHue, hsvThresholdSaturation, hsvThresholdValue, hsvThresholdOutput);
            
            processIMG(source0, processingOutput);
        }

        public void processIMG(Mat img, Mat Output){
            // for(int x=0; x<img.width(); x++){    
            //     for(int y=0; y<img.height(); y++){
            //         img.get(x, y);
            //     }
            // }

            System.out.println("width: " + img.width() + ", Height: "+ img.height());
        }
        public Mat getProcessedImg(){
            return processingOutput;
        }

        /**
         * This method is a generated getter for the output of a HSV_Threshold.
        * @return Mat output from HSV_Threshold.
        */
        public Mat hsvThresholdOutput() {
            return hsvThresholdOutput;
        }

        /**
         * Segment an image based on hue, saturation, and value ranges.
        *
        * @param input The image on which to perform the HSL threshold.
        * @param hue The min and max hue
        * @param sat The min and max saturation
        * @param val The min and max value
        * @param output The image in which to store the output.
        */
        private void hsvThreshold(Mat input, double[] hue, double[] sat, double[] val, Mat out) { //Mat is matrix
            Imgproc.cvtColor(input, out, Imgproc.COLOR_BGR2HSV);
            Core.inRange(out, new Scalar(hue[0], sat[0], val[0]),
            new Scalar(hue[1], sat[1], val[1]), out);
        }


		// public ArrayList<MatOfPoint> filterContoursOutput() {
        //     ArrayList<MatOfPoint> contours = new ArrayList<MatOfPoint>();
        //     return contours;
		// }
    }
}