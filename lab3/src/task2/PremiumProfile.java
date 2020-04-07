package task2;

public class PremiumProfile extends ProfilePrototype
{
    private String fontColor;
    public String getFontColor()
    {
        return fontColor;
    }
    public void setFontColor(String value)
    {
        this.fontColor = value;
    }
    @Override
    public void showProfile() {
        super.showProfile();
        System.out.println("font color: " + fontColor);
    }
}
