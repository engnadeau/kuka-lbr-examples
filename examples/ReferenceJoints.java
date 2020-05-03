public class ReferenceJoints extends RoboticsAPIApplication {
	private LBR lbr;
	private double referenceAngle = Math.toRadians(20);

	public void initialize() {
		lbr = getContext().getDeviceFromType(LBR.class);
	}

	public void run() {
		getLogger().info("Referencing joints");

		getLogger().info("Moving to zero position");
		lbr.move(ptp(0, 0, 0, 0, 0, 0, 0).setJointVelocityRel(0.25));

		getLogger().info(String.format("Moving all joints to %.2f deg", Math.toDegrees(referenceAngle)));
		lbr.move(ptp(referenceAngle, referenceAngle, referenceAngle, referenceAngle, referenceAngle, referenceAngle,
				referenceAngle).setJointVelocityRel(0.25));

		getLogger().info(String.format("Moving all joints to %.2f deg", Math.toDegrees(-referenceAngle)));
		lbr.move(ptp(-referenceAngle, -referenceAngle, -referenceAngle, -referenceAngle, -referenceAngle,
				-referenceAngle, -referenceAngle).setJointVelocityRel(0.25));

		getLogger().info(String.format("Moving all joints to %.2f deg", Math.toDegrees(referenceAngle)));
		lbr.move(ptp(referenceAngle, referenceAngle, referenceAngle, referenceAngle, referenceAngle, referenceAngle,
				referenceAngle).setJointVelocityRel(0.25));

		getLogger().info("Moving to zero position");
		lbr.move(ptp(0, 0, 0, 0, 0, 0, 0).setJointVelocityRel(0.25));

		getLogger().info("App finished");
	}
}
