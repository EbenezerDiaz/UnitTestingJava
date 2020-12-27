package com.ebdz.testing.util;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringUtilTest {

    @Test
    public void testRepeatThreeTimes() {
        assertEquals( "holaholahola", StringUtil.repeat("hola", 3));
    }

    @Test
    public void testRepeatTwoTimes() {
        assertEquals( "holahola", StringUtil.repeat("hola", 2));
    }

    @Test
    public void testRepeatOneTime() {
        assertEquals( "hola", StringUtil.repeat("hola", 1));
    }

    @Test
    public void testRepeatZeroTimes() {
        assertEquals( "", StringUtil.repeat("hola", 0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRepeatNegativeTimes() {
         StringUtil.repeat("hola", -1);
    }
}