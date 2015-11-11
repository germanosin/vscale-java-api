package com.github.germanosin.vscaleio;

import com.github.germanosin.vscaleio.dto.SSHKey;
import com.github.germanosin.vscaleio.exceptions.VscaleException;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by germanosin on 10.11.15.
 */
public class SshTest extends VScaleAPI {

    @Test
    public void getKeysTest() throws IOException, VscaleException {
        Result<List<SSHKey>> query = this.api.SshKeys();
        assertNotNull(query);

        List<SSHKey> keys = query.get();
        assertNotNull(keys);
        assertTrue(keys.size() > 0);
    }

    @Test
    public void createKeyTest() throws IOException, VscaleException {
        SSHKey sshKey = new SSHKey("test", "ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQClleNF5kP55FOHSdU+1bPRJ7Q4o+jOeYuM+XpasTOhNYVaZRTQYmas/7FF7YImu34kbF2jQpX2GezxafG8E+BqQyiDa0Cb18jmkHDlZNo62W16tuFMc5rsB6yRJPc9WUMC84xxgxGIVSZZAbv9wFTLyK3k6zRdnNXsfefzh6XL4jEh/I0/gnw9phs3MCSvAjHw6futhybaukEwQI5oq8WNB1JRQoNN95Dt+sAwM4Ur6CdbgLtn5jJdRyOHMM/fNfSwLxbr+Lm4xLpP+Fyuyd6gvUebR7fdCSD+2iBBpaLz5LTAX7XXOB/aizTXIIJbSbZ1PjBUmX/uS1cFLYGVfRYT user@host.local");
        Result<SSHKey> query = this.api.createSshKey(sshKey);

        SSHKey sshKeyResult = query.get();

        assertNotNull(sshKeyResult);
        assertNotNull(sshKeyResult.getId());

        assertEquals(sshKeyResult.getName(), sshKey.getName());
        assertEquals(sshKeyResult.getKey(), sshKey.getKey());

        this.api.deleteSshKey(sshKeyResult.getId());
    }
}
