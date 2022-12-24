package org.example.api;

import org.example.models.EventsContainer;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {

    @GET("/analytics/facts/agent_event")
    Call<EventsContainer> getEvent(@Query("filter") String filter, @Query("secret") String secret, @Query("page") int page, @Query("limit") int limit);
}
