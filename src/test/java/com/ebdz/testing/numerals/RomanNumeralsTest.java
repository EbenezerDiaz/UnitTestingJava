package com.ebdz.testing.numerals;

import org.junit.Test;

import static com.ebdz.testing.numerals.RomanNumerals.arabicToRoman;
import static com.ebdz.testing.numerals.RomanNumerals.romanToArabic;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class RomanNumeralsTest {

    @Test
    public void convert_arabic_1_to_roman(){
        assertThat(arabicToRoman(1), is("I"));
    }

    @Test
    public void convert_arabic_2_to_roman(){
        assertThat(arabicToRoman(2), is("II"));
    }

    @Test
    public void convert_arabic_3_to_roman(){
        assertThat(arabicToRoman(3), is("III"));
    }

    @Test
    public void convert_arabic_4_to_roman(){
        assertThat(arabicToRoman(4), is("IV"));
    }

    @Test
    public void convert_arabic_5_to_roman(){
        assertThat(arabicToRoman(5), is("V"));
    }

    @Test
    public void convert_arabic_6_to_roman(){
        assertThat(arabicToRoman(6), is("VI"));
    }

    @Test
    public void convert_arabic_7_to_roman(){
        assertThat(arabicToRoman(7), is("VII"));
    }

    @Test
    public void convert_arabic_8_to_roman(){
        assertThat(arabicToRoman(8), is("VIII"));
    }

    @Test
    public void convert_arabic_9_to_roman(){
        assertThat(arabicToRoman(9), is("IX"));
    }

    @Test
    public void convert_arabic_10_to_roman(){
        assertThat(arabicToRoman(10), is("X"));
    }

    @Test
    public void convert_arabic_11_to_roman(){
        assertThat(arabicToRoman(11), is("XI"));
    }

    @Test
    public void convert_arabic_12_to_roman(){
        assertThat(arabicToRoman(12), is("XII"));
    }

    @Test
    public void convert_arabic_13_to_roman(){
        assertThat(arabicToRoman(13), is("XIII"));
    }

    @Test
    public void convert_arabic_14_to_roman(){
        assertThat(arabicToRoman(14), is("XIV"));
    }

    @Test
    public void convert_arabic_15_to_roman(){
        assertThat(arabicToRoman(15), is("XV"));
    }

    @Test
    public void convert_arabic_16_to_roman(){
        assertThat(arabicToRoman(16), is("XVI"));
    }

    @Test
    public void convert_arabic_17_to_roman(){
        assertThat(arabicToRoman(17), is("XVII"));
    }

    @Test
    public void convert_arabic_18_to_roman(){
        assertThat(arabicToRoman(18), is("XVIII"));
    }

    @Test
    public void convert_arabic_19_to_roman(){
        assertThat(arabicToRoman(19), is("XIX"));
    }

    @Test
    public void convert_arabic_50_to_roman(){
        assertThat(arabicToRoman(50), is("L"));
    }

    @Test
    public void convert_arabic_51_to_roman(){
        assertThat(arabicToRoman(51), is("LI"));
    }

    @Test
    public void convert_arabic_55_to_roman(){
        assertThat(arabicToRoman(55), is("LV"));
    }

    @Test
    public void convert_arabic_56_to_roman(){
        assertThat(arabicToRoman(56), is("LVI"));
    }

    @Test
    public void convert_arabic_60_to_roman(){
        assertThat(arabicToRoman(60), is("LX"));
    }

    @Test
    public void convert_arabic_71_to_roman(){
        assertThat(arabicToRoman(71), is("LXXI"));
    }

    @Test
    public void convert_arabic_85_to_roman(){
        assertThat(arabicToRoman(85), is("LXXXV"));
    }

    @Test
    public void convert_arabic_96_to_roman(){
        assertThat(arabicToRoman(96), is("XCVI"));
    }

    @Test
    public void convert_arabic_126_to_roman() {
        assertThat(arabicToRoman(126), is("CXXVI"));
    }

    @Test
    public void convert_arabic_2507_to_roman() {
        assertThat(arabicToRoman(2507), is("MMDVII"));
    }

    @Test
    public void convert_roman_to_arabic_2507() {
        assertThat(romanToArabic("MMDVII"), is(2507));
    }

}