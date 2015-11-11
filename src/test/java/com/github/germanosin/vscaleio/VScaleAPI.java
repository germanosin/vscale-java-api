package com.github.germanosin.vscaleio;

import org.junit.Before;

/**
 * Created by germanosin on 10.11.15.
 */
public class VScaleAPI {

    protected VScaleIOAPI api;

    @Before
    public void setUp(){
        String token = System.getenv("VSCALE_TOKEN");
        this.api = VScaleIOFactory.connect(token);
    }
}
