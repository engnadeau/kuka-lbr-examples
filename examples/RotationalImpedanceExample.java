public class RotationalImpedanceExample extends RoboticsAPIApplication {
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

		// set up impedance control
		// high translational stiffness, low rotational stiffness
		getLogger().info("Hold position in impedance control mode");
		final CartesianImpedanceControlMode controlMode = new CartesianImpedanceControlMode();

		final double stiffnessTrans = 5000.0; // N
		final double stiffnessRot = 10.0; // Nm

		controlMode.parametrize(CartDOF.TRANSL).setStiffness(cartStiffnessTrans);
		controlMode.parametrize(CartDOF.ROT).setStiffness(cartStiffnessRot);

		// hold impedance control until dialog is closed by user
		final IMotionContainer motionContainer = pointer.moveAsync((new PositionHold(controlMode, -1, null)));
		getLogger().info("Show modal dialog while executing position hold");
		getApplicationUI().displayModalDialog(ApplicationDialogType.INFORMATION, "Press ok to finish the application.",
				"OK");
		motionContainer.cancel();
		getLogger().info("App finished");
	}
}
