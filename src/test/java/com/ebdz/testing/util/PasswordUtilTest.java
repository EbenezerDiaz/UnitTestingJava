package com.ebdz.testing.util;

import org.junit.Test;

import static com.ebdz.testing.util.PasswordUtil.SecurityLevel.*;
import static org.junit.Assert.*;

public class PasswordUtilTest {

    @Test
    public void weak_when_has_less_than_8_letters() {
        assertEquals(WEAK, PasswordUtil.assessPassword("1aa$xs1"));
    }

    @Test
    public void weak_when_has_only_letters() {
        assertEquals(WEAK, PasswordUtil.assessPassword("absfederrdf"));
    }

    @Test
    public void medium_when_has_only_letters_and_numbers() {
        assertEquals(MEDIUM, PasswordUtil.assessPassword("abcd1234"));
    }

    @Test
    public void strong_when_has_letters_numbers_and_symbols() {
        assertEquals(STRONG, PasswordUtil.assessPassword("abcd1234#"));
    }
}