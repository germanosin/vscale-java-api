package com.github.germanosin.vscaleio;

import org.junit.Test;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

/**
 * Created by germanosin on 10.11.15.
 */
public class FactoryTest {

    @Test
    public void createTest() {
        VScaleIOAPI testApi = VScaleIOFactory.connect("test");
        assertNotNull(testApi);
        assertEquals(testApi.getToken(), "test");
    }
}
