package com.challenge.back.util;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

@SpringBootTest
public class ConversionUtilsTest {

    @Test
    public void genericToStringWithNullObjectShouldReturnNullString() {
        assert ConversionUtils.genericToString(null).equals("null");
    }

    @Test
    public void genericToStringWithCommonObjectShouldReturnStringWithClassName() {
        CommonObject commonObject = new CommonObject();

        String result = ConversionUtils.genericToString(commonObject);
        assert result.contains(CommonObject.class.getSimpleName());
    }

    @Test
    public void genericToStringWithCommonObjectShouldReturnStringWithAttributeValue() {
        CommonObject commonObject = new CommonObject();
        commonObject.setAttribute("value");

        String result = ConversionUtils.genericToString(commonObject);
        assert result.contains("value");
    }

    class CommonObject {
        private String attribute;

        public String getAttribute() {
            return attribute;
        }

        public void setAttribute(String attribute) {
            this.attribute = attribute;
        }
    }
}