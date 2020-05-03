public class DataRecorderExample extends RoboticsAPIApplication {
    private static DataRecorder createDataRecorder() {
        // set fname
        final String fmt = "yyyy-MM-dd_HH-mm-ss";
        final String timestamp = new SimpleDateFormat(fmt).format(new Date());
        final String fname = String.format("%s.log", timestamp);

        // recorder intrinsic settings
        final long timeout = 30; // s
        final int sampleRate = 1; // ms

        // data recorder builder
        DataRecorder recorder = new DataRecorder(fname, timeout, TimeUnit.SECONDS, sampleRate) //
                .addInternalJointTorque(lbr) //
                .addExternalJointTorque(lbr) //
                .addCartesianForce(lbr.getFlange(), null) //
                .addCartesianTorque(lbr.getFlange(), null) //
                .addCommandedJointPosition(lbr, AngleUnit.Degree) //
                .addCurrentJointPosition(lbr, AngleUnit.Degree) //
                .addCommandedCartesianPositionXYZ(tool.getDefaultMotionFrame(), lbr.getRootFrame()) //
                .addCurrentCartesianPositionXYZ(tool.getDefaultMotionFrame(), lbr.getRootFrame());
        recorder.enable();
        return recorder;
    }

    public void run() {
        // create recorder object
        final DataRecorder recorder = initDataRecorder();
        recorder.startRecording();

        /**
         * DO STUFF
         */

        // fetch data from recorder
        recorder.stopRecording();
        recorder.awaitFileAvailable(3, TimeUnit.SECONDS);

        // get log filename for logging, message queues, etc.
        getLogger().info("Logged data filename: " + recorder.getFileName());
    }
}
