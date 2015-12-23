package be.ppareit.janstat;

import net.vrallev.android.cat.Cat;

/**
 * Created by ppareit on 17/12/15.
 */
public class Person {

    private String name;
    private int giftCount;
    private boolean special;

    Person(String name) {
        setName(name);
        giftCount = 0;
    }

    public boolean isSpecial() {
        return special;
    }

    public void setSpecial(boolean special) {
        this.special = special;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.toUpperCase().contains("JAN")) {
            setSpecial(true);
            Cat.d("Detected jan");
        }
        this.name = name;
    }

    public int getGiftCount() {
        return giftCount;
    }

    public void setGiftCount(int giftCount) {
        this.giftCount = giftCount;
    }

    public void addGift() {
        giftCount++;
    }
}
