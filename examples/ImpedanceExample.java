public class ImpedanceExample extends RoboticsAPIApplication {
	private LBR lbr;

	public void initialize() {
		lbr = getContext().getDeviceFromType(LBR.class);
	}

	public void run() {
		// move to forward starting pose
		getLogger().info("Moving to start position");
		lbr.move(ptp(0, Math.toRadians(10), 0, Math.toRadians(-80), 0, Math.toRadians(90), 0));

		// set up impedance control
		getLogger().info("Hold position in impedance control mode");
		final CartesianImpedanceControlMode controlMode = new CartesianImpedanceControlMode();

		final int stiffnessX = 1500;
		final int stiffnessY = 700;
		final int stiffnessZ = 2500;

		controlMode.parametrize(CartDOF.X).setStiffness(stiffnessX);
		controlMode.parametrize(CartDOF.Y).setStiffness(stiffnessY);
		controlMode.parametrize(CartDOF.Z).setStiffness(stiffnessZ);

		// hold impedance control until dialog is closed by user
		final IMotionContainer motionContainer = lbr.moveAsync((new PositionHold(controlMode, -1, null)));
		getLogger().info("Show modal dialog while executing position hold");
		getApplicationUI().displayModalDialog(ApplicationDialogType.INFORMATION, "Press ok to finish the application.",
				"OK");
		motionContainer.cancel();
		getLogger().info("App finished");
	}
}
