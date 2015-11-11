package com.github.germanosin.vscaleio;

import com.github.germanosin.vscaleio.dto.*;
import com.github.germanosin.vscaleio.exceptions.VscaleException;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by germanosin on 10.11.15.
 */
public class CommonsTest extends VScaleAPI {

    @Test
    public void getTasksTest() throws IOException, VscaleException {
        Result<List<ScaletTask>> query = this.api.scaletsTasks();

        List<ScaletTask> tasks = query.get();
        assertNotNull(tasks);
    }

    @Test
    public void getRplans() throws IOException, VscaleException {
        Result<List<Plan>> query = this.api.plans();

        List<Plan> plans = query.get();
        assertNotNull(plans);
        assertTrue(plans.size() > 0);
        Plan rPlan = plans.get(0);

        assertNotNull(rPlan.getAddresses());
        assertNotNull(rPlan.getCpus());
        assertNotNull(rPlan.getDisk());
        assertNotNull(rPlan.getId());
        assertNotNull(rPlan.getMemory());
        assertNotNull(rPlan.getNetwork());
    }

    @Test
    public void getLocations() throws IOException, VscaleException {
        Result<List<Location>> query = this.api.locations();

        List<Location> locations = query.get();
        assertNotNull(locations);
        assertTrue(locations.size() > 0);
        Location location = locations.get(0);

        assertNotNull(location.getActive());
        assertNotNull(location.getPrivateNetworking());
        assertNotNull(location.getId());
        assertNotNull(location.getDescription());
        assertNotNull(location.getPlans());

        assertTrue(location.getPlans().size() > 0);
    }

    @Test
    public void getImages() throws IOException, VscaleException {
        Result<List<Image>> query = this.api.images();

        List<Image> images = query.get();
        assertNotNull(images);
        assertTrue(images.size() > 0);
        Image image = images.get(0);

        assertNotNull(image.getActive());
        assertNotNull(image.getDescription());
        assertNotNull(image.getId());
        assertNotNull(image.getLocations());
        assertTrue(image.getLocations().size() > 0);
        assertNotNull(image.getPlans());
        assertTrue(image.getPlans().size() > 0);
    }

    @Test
    public void getBalance() throws IOException, VscaleException {
        Result<Balance> query = this.api.balance();

        Balance balance = query.get();
        assertNotNull(balance);

        assertNotNull(balance.getBalance());
        assertNotNull(balance.getBonus());
        assertNotNull(balance.getStatus());
        assertNotNull(balance.getSumm());
        assertNotNull(balance.getUnpaid());
        assertNotNull(balance.getUserId());

    }

    @Test
    public void getPayments() throws IOException, VscaleException {
        Result<Payments> query = this.api.payments();

        Payments payments = query.get();
        assertNotNull(payments);

        assertNotNull(payments.getItems());
        assertNotNull(payments.getStatus());

        assertTrue(payments.getItems().size() > 0);

        Payment payment = payments.getItems().get(0);

        assertNotNull(payment.getCreated());
        assertNotNull(payment.getDescription());
        assertNotNull(payment.getId());
        assertNotNull(payment.isBonus());
        assertNotNull(payment.getPrice());
        assertNotNull(payment.getState());
        assertNotNull(payment.getType());

    }

    @Test
    public void getConsumptions() throws IOException, VscaleException {
        Result<ConsumptionList> query = this.api.consumptions(
                new Date(1443657600000L),
                new Date(1448928000000L));

        ConsumptionList consumptionList = query.get();
        assertNotNull(consumptionList);

        assertNotNull(consumptionList.getConsumptions());

        assertTrue(consumptionList.getConsumptions().size() > 0);

        Map<Long, Consumption> consumptions = consumptionList.getConsumptions();

        for (Map.Entry<Long,Consumption> entry : consumptions.entrySet()) {
            assertNotNull(entry.getKey());
            assertNotNull(entry.getValue());

            Consumption consumption = entry.getValue();

            assertNotNull(consumption.getTotal());
            assertNotNull(consumption.getItems());

            assertTrue(consumption.getItems().size() > 0);

            Map<String,ConsumptionItem> items = consumption.getItems();

            for (Map.Entry<String,ConsumptionItem> itemEntry : items.entrySet()) {
                assertNotNull(itemEntry.getKey());
                assertNotNull(itemEntry.getValue());

                ConsumptionItem consumptionItem = itemEntry.getValue();

                assertNotNull(consumptionItem.getCount());
                assertNotNull(consumptionItem.getSum());
            }
        }

    }

    @Test
    public void getAccountTest() throws IOException, VscaleException {
        Result<Account> query = this.api.account();

        Account account = query.get();

        assertNotNull(account.getActivationDate());
        assertNotNull(account.getCountry());
        assertNotNull(account.getId());
        assertNotNull(account.getEmail());
        assertNotNull(account.getFaceId());
        assertNotNull(account.getState());
        assertNotNull(account.getLocale());
        assertNotNull(account.getMobile());
        assertNotNull(account.getName());
        assertNotNull(account.getSurname());
    }
}
