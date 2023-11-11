package com.example.EventManagementSystem.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utils {
    public static Map<String, String> getAuthoritiesForUsers(){
        HashMap<String, String> authoritiesMap = new HashMap<>();
        // store authorities as list and later change it to String to pass as value of Map. We are using list here to store authorities b/c later on more authorities may be required to add
        List<String> participantAuthorities = Arrays.asList("PARTICIPANT_SELF_INFO");
        List<String> adminAuthorities = Arrays.asList("PARTICIPANT_INFO_BY_ADMIN", "CREATE_ADMIN_AUTHORITY","CREATE_EVENT_BY_ADMIN");
        String participantAuthoritiesAsString = String.join("::", participantAuthorities); //join() method concatenates the given elements with the delimiter and returns the concatenated string
        String adminAuthoritiesAsString = String.join("::", adminAuthorities);
        authoritiesMap.put("PARTICIPANT_USER", participantAuthoritiesAsString);
        authoritiesMap.put("ADMIN_USER", adminAuthoritiesAsString);
        return authoritiesMap;
    }
}
