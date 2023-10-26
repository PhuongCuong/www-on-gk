package fit.iuh.edu.vn.ongk.enums;

public enum Roles {

    ADMINISTRATION(1),STAFF(2),MANAGER(3),EXECUTIVE(4);
    private int values;

    Roles(int values) {
        this.values = values;
    }

    public int getValues() {
        return values;
    }

    public void setValues(int values) {
        this.values = values;
    }
}
