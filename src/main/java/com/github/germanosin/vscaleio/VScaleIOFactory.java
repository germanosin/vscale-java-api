package com.github.germanosin.vscaleio;

import com.github.germanosin.vscaleio.dto.ConsumptionList;
import com.github.germanosin.vscaleio.impl.ResultCallAdapterFactory;
import com.github.germanosin.vscaleio.impl.VScaleIOAPIImpl;
import com.github.germanosin.vscaleio.serializers.ConsumptionListDeserializer;
import com.github.germanosin.vscaleio.serializers.DateDeserializer;
import com.github.germanosin.vscaleio.serializers.DateSerializer;
import com.github.germanosin.vscaleio.services.VScaleIOService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

import java.util.Date;

/**
 * Connection fabric
 */
public class VScaleIOFactory {
    public static VScaleIOAPI connect(final String token) {

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Date.class, new DateSerializer())
                .registerTypeAdapter(Date.class, new DateDeserializer())
                .registerTypeAdapter(ConsumptionList.class, new ConsumptionListDeserializer())
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.vscale.io")
                .addCallAdapterFactory(new ResultCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return new VScaleIOAPIImpl(token, retrofit.create(VScaleIOService.class));
    }
}
