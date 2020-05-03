public class MoveToForwardStartPosition extends RoboticsAPIApplication {
	private LBR lbr;

	public void initialize() {
		lbr = getContext().getDeviceFromType(LBR.class);
	}

	public void run() {
		getLogger().info("Moving to forward start position");
		lbr.move(ptp(0, Math.toRadians(10), 0, Math.toRadians(-80), 0, Math.toRadians(90), 0));
		getLogger().info("App finished");
	}
}
