package com.github.germanosin.vscaleio;

import com.github.germanosin.vscaleio.dto.*;
import retrofit.Call;

import java.util.Date;
import java.util.List;

/**
 * Created by germanosin on 10.11.15.
 */
public interface VScaleIOAPI {

    String getToken();

    Result<List<Scalet>> scalets();

    Result<Scalet> createScalet(NewScalet newScalet);

    Result<Scalet> scalet(Long id);

    Result<Scalet> restartScalet(Long id);

    Result<Scalet> rebuildScalet(Long id, String newPassword);

    Result<Scalet> stopScalet(Long id);

    Result<Scalet> startScalet(Long id);

    Result<Scalet> upgradeScalet(Long id, String plan);

    Result<Scalet> deleteScalet(Long id);

    Result<List<ScaletTask>> scaletsTasks();

    Result<Scalet> addSshKeysToScalet(Long id, List<Long> keys);

    Result<List<SSHKey>> SshKeys();

    Result<SSHKey> createSshKey(SSHKey sshKey);

    Result<Void> deleteSshKey(Long id);

    Result<List<Plan>> plans();

    Result<List<Location>> locations();

    Result<List<Image>> images();

    Result<Balance> balance();

    Result<Payments> payments();

    Result<ConsumptionList> consumptions(Date from, Date till);

    Result<Account> account();

}
