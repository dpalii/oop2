package task2;

import java.util.Hashtable;

public class ProfileTypeManager {
    private static Hashtable profileMap = new Hashtable<String, ProfilePrototype>();

    public static ProfilePrototype getProfile(String profileType) {
        ProfilePrototype profile = (ProfilePrototype) profileMap.get(profileType);
        return (ProfilePrototype) profile.clone();
    }
    public static void loadProfiles() {
        var premium = new PremiumProfile();
        premium.setFontColor("red");
        premium.setLogin("PremiumUser");
        premium.setPassword("default");
        profileMap.put("premium", premium);
        var trial = new TrialProfile();
        trial.setTrialDaysLeft(30);
        trial.setLogin("TrialUser");
        trial.setPassword("default");
        profileMap.put("trial", trial);
    }
}
