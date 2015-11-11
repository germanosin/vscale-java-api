package com.github.germanosin.vscaleio;

import com.github.germanosin.vscaleio.dto.NewScalet;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

/**
 * Created by germanosin on 11.11.15.
 */
public class ScaletBuilderTest {
    @Test
    public void buildPasswordTest() {
        ScaletBuilder scaletBuilder = new ScaletBuilder();
        assertNotNull(scaletBuilder);

        NewScalet newScalet =scaletBuilder
                .doStart(true)
                .location("spb")
                .makeFrom("ubuntu")
                .name("test")
                .plan("small")
                .password("testpass")
                .build();

        assertEquals(newScalet.getDoStart(), new Boolean(true));
        assertEquals(newScalet.getLocation(), "spb");
        assertEquals(newScalet.getMakeFrom(), "ubuntu");
        assertEquals(newScalet.getName(), "test");
        assertEquals(newScalet.getPlan(), "small");
        assertEquals(newScalet.getPassword(), "testpass");
        assertEquals(newScalet.getKeys(), null);
    }

    @Test
    public void buildKeysTest() {
        ScaletBuilder scaletBuilder = new ScaletBuilder();
        assertNotNull(scaletBuilder);

        List<Long> keys = new ArrayList<Long>();


        NewScalet newScalet =scaletBuilder
                .doStart(true)
                .location("spb")
                .makeFrom("ubuntu")
                .name("test")
                .plan("small")
                .password("testpass")
                .keys(keys)
                .addKey(1L)
                .build();

        assertEquals(newScalet.getDoStart(), new Boolean(true));
        assertEquals(newScalet.getLocation(), "spb");
        assertEquals(newScalet.getMakeFrom(), "ubuntu");
        assertEquals(newScalet.getName(), "test");
        assertEquals(newScalet.getPlan(), "small");
        assertEquals(newScalet.getPassword(), null);
        assertNotNull(newScalet.getKeys());

        List<Long> newkeys = newScalet.getKeys();

        assertEquals(newkeys.size(), 1);
        assertEquals(newkeys.get(0), new Long(1L));
    }
}
