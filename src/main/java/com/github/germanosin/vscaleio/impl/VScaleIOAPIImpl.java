package com.github.germanosin.vscaleio.impl;

import com.github.germanosin.vscaleio.Result;
import com.github.germanosin.vscaleio.VScaleIOAPI;
import com.github.germanosin.vscaleio.dto.*;
import com.github.germanosin.vscaleio.services.VScaleIOService;
import retrofit.Call;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by germanosin on 10.11.15.
 */
public class VScaleIOAPIImpl implements VScaleIOAPI {

    private final String token;
    private final VScaleIOService service;

    ThreadLocal<SimpleDateFormat> sdt = new ThreadLocal<SimpleDateFormat>();

    public SimpleDateFormat getDateFormat() {
        SimpleDateFormat result = sdt.get();
        if (result==null) {
            result = new SimpleDateFormat("yyyy-MM-dd");
            sdt.set(result);
        }
        return result;
    }


    public VScaleIOAPIImpl(String token, VScaleIOService service) {
        this.token = token;
        this.service = service;
    }

    @Override
    public String getToken() {
        return this.token;
    }

    @Override
    public Result<List<Scalet>> scalets() {
        return service.getScalets(this.token);
    }

    @Override
    public Result<Scalet> createScalet(NewScalet scalet) {
        return service.createScalet(this.token, scalet);
    }

    @Override
    public Result<Scalet> scalet(Long id) {
        return service.getScalet(this.token, id);
    }

    @Override
    public Result<Scalet> restartScalet(Long id) {
        return service.restartScalet(this.token, id, ScaletID.fromId(id));
    }

    @Override
    public Result<Scalet> rebuildScalet(Long id, String newPassword) {
        return service.rebuildScalet(this.token, id, ScaletPassword.fromString(newPassword));
    }

    @Override
    public Result<Scalet> stopScalet(Long id) {
        return service.stopScalet(this.token, id, ScaletID.fromId(id));
    }

    @Override
    public Result<Scalet> startScalet(Long id) {
        return service.startScalet(this.token, id, ScaletID.fromId(id));
    }

    @Override
    public Result<Scalet> upgradeScalet(Long id, String plan) {
        return service.upgradeScalet(this.token, id, ScaletPlan.fromString(plan));
    }

    @Override
    public Result<Scalet> deleteScalet(Long id) {
        return service.deleteScalet(this.token, id);
    }

    @Override
    public Result<List<ScaletTask>> scaletsTasks() {
        return service.getScaletsTasks(this.token);
    }

    @Override
    public Result<Scalet> addSshKeysToScalet(Long id, List<Long> keys) {
        return null;
    }

    @Override
    public Result<List<SSHKey>> SshKeys() {
        return service.getSSHKeys(this.token);
    }

    @Override
    public Result<SSHKey> createSshKey(SSHKey sshKey) {
        return service.createSshKey(this.token, SSHKeyCreate.fromSshKey(sshKey));
    }

    @Override
    public Result<Void> deleteSshKey(Long id) {
         return service.deleteSshKey(this.token, id);
    }

    @Override
    public Result<List<Plan>> plans() {
        return service.getPlans(this.token);
    }

    @Override
    public Result<List<Location>> locations() {
        return service.getLocations(this.token);
    }

    @Override
    public Result<List<Image>> images() {
        return service.getImages(this.token);
    }

    @Override
    public Result<Balance> balance() {
        return service.getBalance(this.token);
    }

    @Override
    public Result<Payments> payments() {
        return service.getPayments(this.token);
    }

    @Override
    public Result<ConsumptionList> consumptions(Date from, Date till) {
        String startDate = getDateFormat().format(from);
        String endDate = getDateFormat().format(till);
        return this.service.getConsumptions(this.token, startDate, endDate);
    }

    @Override
    public Result<Account> account() {
        return service.getAccount(this.token);
    }

}
