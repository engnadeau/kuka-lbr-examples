<br />
<p align="center">
<a href="https://github.com/nnadeau/kuka-lbr-examples">
<img src="https://raw.githubusercontent.com/nnadeau/kuka-lbr-examples/master/media/kuka-lbr.jpg" alt="Logo" width="80" height="80">
</a>

<h3 align="center">KUKA LBR iiwa Examples</h3>

<p align="center">
Application and programming examples for the KUKA LBR iiwa robot platform
</p>
</p>


[![Netlify Status](https://api.netlify.com/api/v1/badges/96cf62a7-5c7d-4610-b84f-de0afc34773c/deploy-status)](https://app.netlify.com/sites/competent-panini-00973b/deploys)

[![Release](https://github.com/nnadeau/kuka-lbr-examples/workflows/Release/badge.svg)](https://github.com/nnadeau/kuka-lbr-examples/actions)

[![GitHub issues](https://img.shields.io/github/issues/nnadeau/kuka-lbr-examples)](https://github.com/nnadeau/kuka-lbr-examples/issues)
[![GitHub forks](https://img.shields.io/github/forks/nnadeau/kuka-lbr-examples)](https://github.com/nnadeau/kuka-lbr-examples/network)
[![GitHub stars](https://img.shields.io/github/stars/nnadeau/kuka-lbr-examples)](https://github.com/nnadeau/kuka-lbr-examples/stargazers)
[![GitHub license](https://img.shields.io/github/license/nnadeau/kuka-lbr-examples)](https://github.com/nnadeau/kuka-lbr-examples/blob/master/LICENSE)

[![Twitter](https://img.shields.io/twitter/url?style=social&url=https%3A%2F%2Fgithub.com%2Fnnadeau%2Fkuka-lbr-examples)](https://twitter.com/intent/tweet?text=Wow:&url=https%3A%2F%2Fgithub.com%2Fnnadeau%2Fkuka-lbr-examples)

## Usage

- Copy the code snippets found in [`examples`](examples/) into your Sunrise Controller application

## Examples

### Applications

- [`Data Recorder`](examples/DataRecorderExample.java): how to use the built-in data logger for high-frequency data analysis
- [`Force Contact`](examples/ForceContactRetractExample.java): how to detect and react to force contact events
  - [YouTube demo](https://youtu.be/q5TiEDbcADM?t=7)
- [`Impedance Control`](examples/ImpedanceExample.java): how to set up impedance control
  - [YouTube demo](https://youtu.be/xLpEqh76HUI)
- [`Redundancy Impedance Control`](examples/RedundancyImpedanceExample.java): how to set up null-space (e.g., redundancy) impedance control
- [`Rotational Impedance Control`](examples/RotationalImpedanceExample.java): how to set up rotational impedance control
  - [YouTube demo](https://youtu.be/q5TiEDbcADM?t=17)

### Utilities

- [`Move to Zero Position`](examples/MoveToMechanicalZeroPosition.java): useful helper function for moving the robot to its zero position
- [`Move to Start Position`](examples/MoveToStartPosition.java): useful helper function for moving the robot to a generic starting position
- [`Move to Transport Position`](examples/MoveToTransportPosition.java): useful helper function for moving the robot to its transportation position
- [`Reference Joints`](examples/ReferenceJoints.java): useful helper function for referencing the joint encoders following power-on
