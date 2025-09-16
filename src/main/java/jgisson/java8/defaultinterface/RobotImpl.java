package jgisson.java8.defaultinterface;

public class RobotImpl implements Robot {

  private int xPos = 0;
  private int yPos = 0;

  @Override
  public boolean move() {
    xPos++;
    yPos++;
    return true;
  }

  public int getxPos() {
    return xPos;
  }

  public int getyPos() {
    return yPos;
  }
}
