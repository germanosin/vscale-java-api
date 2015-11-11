package com.github.germanosin.vscaleio;

import com.github.germanosin.vscaleio.dto.IpAddress;
import com.github.germanosin.vscaleio.dto.Scalet;
import com.github.germanosin.vscaleio.exceptions.VscaleException;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.assertEquals;

/**
 * Created by germanosin on 11.11.15.
 */
public class ScaletsTest extends VScaleAPI {
    @Test
    public void getTestFailed() {
        Scalet scalet = null;
        Throwable error = null;
        try {
            scalet = this.api.scalet(Long.MAX_VALUE - 1).get();
        } catch (Throwable e) {
            error = e;
        }

        assertNull(scalet);
        assertNotNull(error);
        assertTrue(error instanceof VscaleException);

        VscaleException exception = (VscaleException)error;

        assertEquals(exception.code(), 404);
        assertNotNull(exception.response());
        assertNotNull(exception.getMessage());
    }

    @Test
    public void getListAndFetchOne() throws IOException, VscaleException {
        List<Scalet> scalets = this.api.scalets().get();

        assertNotNull(scalets);
        assertTrue(scalets.size()>0);

        Scalet scalet = scalets.get(0);

        assertNotNull(scalet.getId());

        Scalet newScalet = this.api.scalet(scalet.getId()).get();

        assertTrue(scalet.equals(newScalet));

        assertNotNull(newScalet.getActive());
        assertNotNull(newScalet.getHostname());
        assertNotNull(newScalet.getKeys());
        assertNotNull(newScalet.getLocation());
        assertNotNull(newScalet.getLocked());
        assertNotNull(newScalet.getMadeFrom());
        assertNotNull(newScalet.getName());
        assertNotNull(newScalet.getPlan());
        assertNotNull(newScalet.getPrivateAddress());
        assertNotNull(newScalet.getPublicAddress());
        assertNotNull(newScalet.getStatus());

        IpAddress ipAddress = newScalet.getPublicAddress();

        assertNotNull(ipAddress.getAddress());
        assertNotNull(ipAddress.getGateway());
        assertNotNull(ipAddress.getNetmask());

    }
}
