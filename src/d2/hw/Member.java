package d2.hw;

import java.util.Objects;

public class Member {
    private int id;
    private String name;

    // def const.
    public Member(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        // safety check
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        // cast
        Member member = (Member) obj;

        // check
        return this.id == member.id && Objects.equals(this.name, member.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name);
    }
}
