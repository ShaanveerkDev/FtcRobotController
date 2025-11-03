package Subsystem;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import com.qualcomm.robotcore.hardware.DcMotorEx;

public class Shooter {
    DcMotorEx shooterMotor;
    public void init() {shooterMotor = hardwareMap.get(DcMotorEx.class, "shooterMotor");}

    public void ShooterSetPower(double speed)
    {
        shooterMotor.setPower(speed);
    }
}
