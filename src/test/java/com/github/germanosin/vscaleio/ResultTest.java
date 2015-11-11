package com.github.germanosin.vscaleio;

import com.github.germanosin.vscaleio.dto.Scalet;
import com.github.germanosin.vscaleio.impl.ResultImpl;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertNotSame;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by germanosin on 11.11.15.
 */
public class ResultTest extends VScaleAPI {
    @Test
    public void successTest() throws InterruptedException {

        final CountDownLatch latch = new CountDownLatch(1);

        Result<List<Scalet>> result = this.api.scalets();

        result.enqueue(new ResultCallback<List<Scalet>>() {
            @Override
            public void onResponse(List<Scalet> result) {
                latch.countDown();
            }

            @Override
            public void onFailure(Throwable error) {
                throw new AssertionError();
            }
        });

        assertTrue(latch.await(2, TimeUnit.SECONDS));
    }

    @Test
    public void failureTest() throws InterruptedException {

        final CountDownLatch latch = new CountDownLatch(1);

        Result<Scalet> result = this.api.scalet(Long.MAX_VALUE - 1);

        result.enqueue(new ResultCallback<Scalet>() {
            @Override
            public void onResponse(Scalet result) {
                throw new AssertionError();
            }

            @Override
            public void onFailure(Throwable error) {
                latch.countDown();
            }
        });

        assertTrue(latch.await(2, TimeUnit.SECONDS));
    }

    @Test
    public void cancelTest() throws InterruptedException {

        final CountDownLatch latch = new CountDownLatch(1);

        Result<List<Scalet>> result = this.api.scalets();

        result.enqueue(new ResultCallback<List<Scalet>>() {
            @Override
            public void onResponse(List<Scalet> result) {
                throw new AssertionError();
            }

            @Override
            public void onFailure(Throwable error) {
                latch.countDown();
            }
        });

        result.cancel();

        assertTrue(latch.await(2, TimeUnit.SECONDS));
    }

    @Test
    public void cloneTest() {
        Result<List<Scalet>> result = this.api.scalets();
        Result<List<Scalet>> otherResult = result.clone();

        ResultImpl result1 = (ResultImpl)result;
        ResultImpl result2 = (ResultImpl)otherResult;

        assertNotSame(result, otherResult);
        assertNotSame(result1.getCall(), result2.getCall());

    }
}
