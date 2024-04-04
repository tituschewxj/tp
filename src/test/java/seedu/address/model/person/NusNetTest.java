package seedu.address.model.person;

import org.junit.jupiter.api.Test;

class NusNetTest {

    @Test
    void isValidNusNet() {
        // EP: E followed by 7 digits
        assert(NusNet.isValidNusNet("E1234567"));

        // EP: e followed by 7 digits
        assert(NusNet.isValidNusNet("e1234567"));

        // EP: non E followed by 7 digits
        assert(!NusNet.isValidNusNet("A1234567"));

        // EP: E followed by 6 digits
        assert(!NusNet.isValidNusNet("E123456"));

        // EP: E followed by 8 digits
        assert(!NusNet.isValidNusNet("E12345678"));
    }

    @Test
    void testToString() {
        String nusnet1 = "E1234567";
        assert(new NusNet(nusnet1).toString().equals(nusnet1));

        String nusnet2 = "e1234567";
        // EP: toString should return the value in uppercase
        assert(new NusNet(nusnet2).toString().equals(nusnet1));
    }

    @Test
    void testEquals() {
        String nusnet1 = "E1234567";
        String nusnet2 = "e1234567";
        NusNet nusNet1 = new NusNet(nusnet1);
        NusNet nusNet2 = new NusNet(nusnet2);

        // EP: case-insensitive
        assert(nusNet1.equals(nusNet2));
    }
}
