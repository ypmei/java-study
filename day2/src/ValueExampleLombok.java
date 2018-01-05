import lombok.AccessLevel;
import lombok.experimental.NonFinal;
import lombok.experimental.Value;
import lombok.experimental.Wither;
import lomok.ToString;

@Value public class ValueExampleLombok {
    String name;
    @Wither(AccessLevel.PACKAGE) @NonFinal int age;
    double score;
    protected String[] tags;

    @ToString(includeFieldNames=true)
    @value(staticConstructor="of")
    public static class Exercise<T> {
        String name;
        T value;
    }
}
