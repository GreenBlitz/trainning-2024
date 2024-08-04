public  interface IElbow {

    public Rotation2d getCurrentAngle();
    public void setPower(double power);

    public boolean isAtAngle(Rotation2d angle);
    public Rotation2d getCurrentVelocity();
    public void moveToAngle(Rotation2d angle);
    public void stayInPlace();
}
}