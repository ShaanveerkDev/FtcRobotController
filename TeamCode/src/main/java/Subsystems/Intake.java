package Subsystems;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import com.qualcomm.robotcore.hardware.DcMotorEx;


public class Intake {
    DcMotorEx intakeMotor;
    public void init() {intakeMotor = hardwareMap.get(DcMotorEx.class, "intakeMotor");}

    public double intakeSpeed = intakeMotor.getVelocity();
    public void IntakeSetPower(double speed)
    {
        intakeMotor.setPower(speed);
    }

}
