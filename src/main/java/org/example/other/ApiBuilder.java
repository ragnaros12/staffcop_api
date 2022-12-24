package org.example.other;

import org.example.api.Api;
import org.example.models.QueryParam;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;
import java.util.stream.Collectors;

public class ApiBuilder {

    public static String buildUrl(List<QueryParam> queryParamList){
        return  queryParamList.stream().map(u -> "&dim=" + u.field() + "&filter=" + u.value()).collect(Collectors.joining());
    }

    public static Api create(String connectionString){
        return new Retrofit.Builder().baseUrl(connectionString).addConverterFactory(GsonConverterFactory.create()).build().create(Api.class);
    }
}
