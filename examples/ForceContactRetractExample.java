public class ForceContactRetractExample extends RoboticsAPIApplication {
	private LBR lbr;
	private Tool tool;

	public void initialize() {
		lbr = getContext().getDeviceFromType(LBR.class);
		tool = getApplicationData().createFromTemplate("tool");
	}

	public void run() {
		// load tool
		tool.attachTo(lbr.getFlange());
		getLogger().info("Tool data loaded");

		// move to forward starting pose
		getLogger().info("Moving to start position");
		lbr.move(ptp(0, Math.toRadians(10), 0, Math.toRadians(-80), 0, Math.toRadians(90), 0));

		// get start and set end frame
		Frame startFrame = lbr.getCurrentCartesianPosition(tool.getDefaultMotionFrame());
		Frame endFrame = startFrame.copy();
		endFrame.setZ(0);

		// create force condition
		double maxForce = 10; // N
		ForceCondition forceDetected = ForceCondition.createSpatialForceCondition(tool.getDefaultMotionFrame(),
				maxForce);

		// create motions
		LIN upMotion = lin(startFrame);
		LIN downMotion = lin(endFrame).breakWhen(forceDetected);

		// execute motion loop
		// move down, stop at contact, move back up, repeat
		for (int i = 0; i < 10; i++) {
			tool.move(downMotion);
			tool.move(upMotion);
		}
		getLogger().info("App finished");
	}
}
