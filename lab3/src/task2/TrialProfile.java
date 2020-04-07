package task2;

public class TrialProfile extends ProfilePrototype
{
    private int trialDaysLeft;
    public int getTrialDaysLeft()
    {
        return trialDaysLeft;
    }
    public void setTrialDaysLeft(int value)
    {
        this.trialDaysLeft = value;
    }
    @Override
    public void showProfile()
    {
        super.showProfile();
        System.out.println("trial days left: " + trialDaysLeft);
    }
}
