package com.efdevelopment.EXPLODINGFreedomModRevamped;

import java.util.concurrent.*;
import org.json.simple.parser.*;
import com.google.common.collect.*;
import java.net.*;
import org.json.simple.*;
import java.io.*;
import java.util.*;

public class NameFetcher implements Callable<Map<UUID, String>>
{
    private static final String PROFILE_URL = "https://sessionserver.mojang.com/session/minecraft/profile/";
    private final JSONParser jsonParser;
    private final List<UUID> uuids;

    public NameFetcher(final List<UUID> uuids)
    {
        this.jsonParser = new JSONParser();
        this.uuids = (List<UUID>) ImmutableList.copyOf((Collection) uuids);
    }

    @Override
    public Map<UUID, String> call() throws Exception
    {
        final Map<UUID, String> uuidStringMap = new HashMap<UUID, String>();
        for (final UUID uuid : this.uuids)
        {
            final HttpURLConnection connection = (HttpURLConnection) new URL("https://sessionserver.mojang.com/session/minecraft/profile/" + uuid.toString().replace("-", "")).openConnection();
            final JSONObject response = (JSONObject) this.jsonParser.parse((Reader) new InputStreamReader(connection.getInputStream()));
            final String name = (String) response.get((Object) "name");
            if (name == null)
            {
                continue;
            }
            final String cause = (String) response.get((Object) "cause");
            final String errorMessage = (String) response.get((Object) "errorMessage");
            if (cause != null && cause.length() > 0)
            {
                throw new IllegalStateException(errorMessage);
            }
            uuidStringMap.put(uuid, name);
        }
        return uuidStringMap;
    }
}
