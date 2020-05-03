public class MoveToMechanicalZeroPosition extends RoboticsAPIApplication {
	private LBR lbr;

	public void initialize() {
		lbr = getContext().getDeviceFromType(LBR.class);
	}

	public void run() {
		getLogger().info("Move to the mechanical zero position");
		lbr.move(ptp(0, 0, 0, 0, 0, 0, 0));
		getLogger().info("App finished");
	}
}
