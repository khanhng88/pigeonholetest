package utils;

public class EnumHelper {

    public enum SortType {
        Top_voted("Top Voted"),
        Latest;

        private String value;

        SortType(String value) {
            this.value = value;
        }

        SortType() {
            this.value = name();
        }

        public String value() {
            return value;
        }
    }
}
