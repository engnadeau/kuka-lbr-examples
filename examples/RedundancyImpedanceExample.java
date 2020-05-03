public class RedundancyImpedanceExample extends RoboticsAPIApplication {
	private LBR lbr;

	public void initialize() {
		lbr = getContext().getDeviceFromType(LBR.class);
	}

	public void run() {
		// move to forward starting pose
		getLogger().info("Moving to start position");
		lbr.move(ptp(0, Math.toRadians(10), 0, Math.toRadians(-80), 0, Math.toRadians(90), 0));

		// set up impedance control
		// high translational/rotational stiffness, low null-space stiffness
		getLogger().info("Hold position in impedance control mode");
		final CartesianImpedanceControlMode controlMode = new CartesianImpedanceControlMode();

		final double stiffnessTrans = 5000.0; // N
		final double stiffnessRot = 300.0; // Nm
		final double stiffnessNull = 5.0;

		controlMode.parametrize(CartDOF.TRANSL).setStiffness(cartStiffnessTrans);
		controlMode.parametrize(CartDOF.ROT).setStiffness(cartStiffnessRot);
		controlMode.setNullSpaceStiffness(stiffnessNull);

		// hold impedance control until dialog is closed by user
		final IMotionContainer motionContainer = lbr.moveAsync((new PositionHold(controlMode, -1, null)));
		getLogger().info("Show modal dialog while executing position hold");
		getApplicationUI().displayModalDialog(ApplicationDialogType.INFORMATION, "Press ok to finish the application.",
				"OK");
		motionContainer.cancel();
		getLogger().info("App finished");
	}
}
