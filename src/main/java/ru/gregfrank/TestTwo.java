package ru.gregfrank;

import org.testng.annotations.Test;

public class TestTwo {

    @Test
    public void firstTestMethodTestTwo(){


    }

    @Test(dependsOnMethods = "firstTestMethodTestTwo")
    public void secondTestMethodTestTwo(){


    }
}
