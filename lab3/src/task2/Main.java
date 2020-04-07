package task2;

public class Main {

    public static void main(String[] args)
    {
        ProfileTypeManager.loadProfiles();
        var clonedTrialProfile = ProfileTypeManager.getProfile("trial");
        clonedTrialProfile.showProfile();
        System.out.println("***");
        var clonedPremiumPrototype = ProfileTypeManager.getProfile("premium");
        clonedPremiumPrototype.showProfile();
        System.out.println("***");
    }
}
