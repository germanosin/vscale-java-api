package com.github.germanosin.vscaleio.services;

import com.github.germanosin.vscaleio.Result;
import com.github.germanosin.vscaleio.dto.*;
import retrofit.Call;
import retrofit.http.*;

import java.util.List;

/**
 * Created by germanosin on 10.11.15.
 */
public interface VScaleIOService {
    @GET("/v1/scalets")
    Result<List<Scalet>> getScalets(@Header("X-Token") String token);

    @POST("/v1/scalets")
    Result<Scalet> createScalet(@Header("X-Token") String token, @Body NewScalet newScalet);

    @GET("/v1/scalets/{id}")
    Result<Scalet> getScalet(@Header("X-Token") String token, @Path("id") Long id);

    @PATCH("/v1/scalets/{id}/restart")
    Result<Scalet> restartScalet(@Header("X-Token") String token, @Path("id") Long id, @Body ScaletID scaletID);

    @PATCH("/v1/scalets/{id}/rebuild")
    Result<Scalet> rebuildScalet(@Header("X-Token") String token, @Path("id") Long id, @Body ScaletPassword scaletPassword);

    @PATCH("/v1/scalets/{id}/stop")
    Result<Scalet> stopScalet(@Header("X-Token") String token, @Path("id") Long id, @Body ScaletID scaletID);

    @PATCH("/v1/scalets/{id}/start")
    Result<Scalet> startScalet(@Header("X-Token") String token, @Path("id") Long id, @Body ScaletID scaletID);

    @POST("/v1/scalets/{id}/upgrade")
    Result<Scalet> upgradeScalet(@Header("X-Token") String token, @Path("id") Long id, @Body ScaletPlan scaletPlan);

    @DELETE("/v1/scalets/{id}")
    Result<Scalet> deleteScalet(@Header("X-Token") String token, @Path("id") Long id);

    @GET("/v1/tasks")
    Result<List<ScaletTask>> getScaletsTasks(@Header("X-Token") String token);

    @PATCH("/v1/sshkeys/scalets/{id}")
    Result<Scalet> addSshKeysToScalet(@Header("X-Token") String token, @Path("id") Long id, @Body ScaletKeys scaletKeys);

    @GET("/v1/sshkeys")
    Result<List<SSHKey>> getSSHKeys(@Header("X-Token") String token);

    @POST("/v1/sshkeys")
    Result<SSHKey> createSshKey(@Header("X-Token") String token, @Body SSHKeyCreate sshKeyCreate);

    @DELETE("/v1/sshkeys/{id}")
    Result<Void> deleteSshKey(@Header("X-Token") String token, @Path("id") Long id);

    @GET("/v1/rplans")
    Result<List<Plan>> getPlans(@Header("X-Token") String token);

    @GET("/v1/locations")
    Result<List<Location>> getLocations(@Header("X-Token") String token);

    @GET("/v1/images")
    Result<List<Image>> getImages(@Header("X-Token") String token);

    @GET ("/v1/billing/balance")
    Result<Balance> getBalance(@Header("X-Token") String token);

    @GET ("/v1/billing/payments")
    Result<Payments> getPayments(@Header("X-Token") String token);

    @GET ("/v1/billing/consumption")
    Result<ConsumptionList> getConsumptions(@Header("X-Token") String token, @Query("start") String startDate, @Query("end") String endDate);

    @GET ("/v1/account")
    Result<Account> getAccount(@Header("X-Token") String token);

}
