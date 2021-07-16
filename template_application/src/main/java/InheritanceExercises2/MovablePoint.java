package InheritanceExercises2;

public class MovablePoint extends Point {

    private float xSpeed = 0.0f;

    private float ySpeed = 0.0f;

    public MovablePoint() {

    }

    public MovablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;

    }

    public MovablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed() {
        float[] speeds = new float[2];
        speeds[0] = getxSpeed();
        speeds[1] = getySpeed();
        return speeds;
    }

    public void setSpeeds(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    @Override
    public String toString() {
        return "MovablePoint{" + super.toString()+
                "xSpeed=" + xSpeed +
                ", ySpeed=" + ySpeed +
                '}';
    }

    public MovablePoint move() {
        float x = getX();
        System.out.println(x);
        float y = getY();
        System.out.println(y);
        x += xSpeed;
        System.out.println(x);
        y += ySpeed;
        System.out.println(y);
        System.out.println(this);
        return this;
    }


}
