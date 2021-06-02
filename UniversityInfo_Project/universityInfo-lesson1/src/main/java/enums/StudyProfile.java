package enums;

public enum StudyProfile {
    PHYSICS("Физика"),
    COMPUTER_SCIENCE("Информатика"),
    MATHEMATICS("Математика"),
    JURISPRUDENCE("Юриспруденция"),
    MEDICINE("Медицина"),
    LINGUISTICS("Лингвистика");

    private final String profileName;

    private StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return this.profileName;
    }
}
