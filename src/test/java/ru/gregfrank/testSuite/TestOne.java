package ru.gregfrank.testSuite;

import org.testng.annotations.Test;

public class TestOne {

    @Test
    public void firstTestMethodTestOne(){


    }

    @Test(dependsOnMethods = "firstTestMethodTestOne")
    public void secondTestMethodTestOne(){


    }
}
