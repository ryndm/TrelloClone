package com.example.ood_project.models;

import java.time.Duration;
import java.util.Map;
import java.util.StringJoiner;

public abstract class Analytics {
    Map<String, String> result;


    public abstract void computeAnalytics(Iterable<Task> tasks);

    public Map<String, String> getAnalytics() {
        return result;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(" ");
        result.forEach((key, value) -> joiner.add(key + " " + value));
        return joiner.toString();
    }

    public static String formatDuration(long seconds) {
        Duration duration = Duration.ofSeconds(seconds);

        long years = duration.toDays() / 365;
        long days = duration.toDays() % 365;
        long months = days / 30;
        days %= 30;
        long weeks = days / 7;
        days %= 7;
        long remainingHours = duration.toHours() % 24;
        long remainingMinutes = duration.toMinutes() % 60;
        long remainingSeconds = duration.getSeconds() % 60;

        StringJoiner joiner = new StringJoiner(" ");
        if (years > 0) {
            joiner.add(years + " year" + (years > 1 ? "s" : ""));
        }
        if (months > 0) {
            joiner.add(months + " month" + (months > 1 ? "s" : ""));
        }
        if (weeks > 0) {
            joiner.add(weeks + " week" + (weeks > 1 ? "s" : ""));
        }
        if (days > 0) {
            joiner.add(days + " day" + (days > 1 ? "s" : ""));
        }
        if (remainingHours > 0) {
            joiner.add(remainingHours + " hour" + (remainingHours > 1 ? "s" : ""));
        }
        if (remainingMinutes > 0) {
            joiner.add(remainingMinutes + " minute" + (remainingMinutes > 1 ? "s" : ""));
        }
        if (remainingSeconds > 0) {
            joiner.add(remainingSeconds + " second" + (remainingSeconds > 1 ? "s" : ""));
        }

        String result = joiner.toString();
        return result.isEmpty() ? "0 seconds" : result;
    }
}
