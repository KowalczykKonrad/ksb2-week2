package pl.kowalczyk.ksb2week2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Constant {
    public static final int MAX_RANDOM_PRICE = 300;
    public static final int MIN_RANDOM_PRICE = 50;

    public static final List<String> POSITIVE_ANSWERS = Collections.unmodifiableList(
            Arrays.asList("Y", "YES", "y", "yes"));
    public static final List<String> NEGATIVE_ANSWERS = Collections.unmodifiableList(
            Arrays.asList("N", "NO", "n", "no"));
}
