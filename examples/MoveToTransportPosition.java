public class MoveToTransportPosition extends RoboticsAPIApplication {
	private LBR lbr;

	public void initialize() {
		lbr = getContext().getDeviceFromType(LBR.class);
	}

	public void run() {
		getLogger().info("Move to the transport position");
		lbr.move(ptp(0, Math.toRadians(25), 0, Math.toRadians(90), 0, 0, 0));
		getLogger().info("App finished");
	}
}
