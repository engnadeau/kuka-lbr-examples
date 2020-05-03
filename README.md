# KUKA LBR iiwa Examples

> Application and programming examples for the KUKA LBR iiwa robot platform.

## Usage

- Copy the code snippets found in [`examples`](examples/) into your Sunrise Controller application

## Examples

### Applications

- [`Data Recorder`](examples/DataRecorderExample.java): how to use the built-in data logger for high-frequency data analysis
- [`Force Contact`](examples/ForceContactRetractExample.java): how to detect and react to force contact events
- [`Impedance Control`](examples/ImpedanceExample.java): how to set up impedance control
- [`Impedance Control`](examples/RedundancyImpedanceExample.java): how to set up null-space (e.g., redundancy) impedance control
- [`Impedance Control`](examples/RotationalImpedanceExample.java): how to set up rotational impedance control

### Utilities

- [`Move to Zero Position`](examples/MoveToMechanicalZeroPosition.java): useful helper function for moving the robot to its zero position
- [`Move to Start Position`](examples/MoveToStartPosition.java): useful helper function for moving the robot to a generic starting position
- [`Move to Transport Position`](examples/MoveToTransportPosition.java): useful helper function for moving the robot to its transportation position
- [`Reference Joints`](examples/ReferenceJoints.java): useful helper function for referencing the joint encoders following power-on
