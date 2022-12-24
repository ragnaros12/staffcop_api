package org.example;

import org.example.api.Api;
import org.example.input.ConsoleInput;
import org.example.input.DataInput;
import org.example.models.Event;
import org.example.models.EventsContainer;
import org.example.models.QueryParam;
import org.example.other.ApiBuilder;
import org.example.other.Mapper;
import retrofit2.Response;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static DataInput dataInput = new ConsoleInput();
    static Mapper mapper = new Mapper(Map.of(
            "event-admin", "31",
            "event-active", "100500",
            "event-input_keyboard", "1",
            "-computer_name", "agent_agent@computer_name:computer_name"
    ));

    public static void main(String[] args) throws IOException {
        String token = dataInput.getSecret();
        Api api = ApiBuilder.create(dataInput.getConnectionString());


        while (true){
            System.out.println("Постройте свой запрос");
            int limit = dataInput.getInt("введите нужное кол-во записей");
            int page = dataInput.getInt("введите номер нужной страницы");

            List<QueryParam> queryParamList = new ArrayList<>();



            String eventType = dataInput.getString("введите тип событий через запятую. Возможные значения - " + mapper.getByKey("event"));
            if(!eventType.equals(""))
                queryParamList.addAll(Arrays.stream(eventType.split(",")).map(u -> new QueryParam("agent_eventtype@default:agent_eventtype", mapper.getValue("event", u))).toList());

            int countFilters = dataInput.getInt("введите кол-во кастомных фильтров");
            for (int i = 0; i < countFilters; i++) {
                queryParamList.add(new QueryParam(mapper.getValue("-", dataInput.getString("введите тип фльтра")), dataInput.getString("введите значение")));
            }


            Response<EventsContainer> response = api.getEvent(ApiBuilder.buildUrl(queryParamList), token, page, limit).execute();
            System.out.println("состояние запроса к серверу: " + response.code());
            if(response.code() != 200){
                System.out.println("ошибка: " + response.errorBody().string());
                continue;
            }

            assert response.body() != null;
            System.out.println(response.body().getEvents().stream().map(Event::toString).collect(Collectors.joining("\n")));
        }
    }
}
