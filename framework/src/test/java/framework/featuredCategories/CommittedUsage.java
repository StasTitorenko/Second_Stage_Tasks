package framework.featuredCategories;

public enum CommittedUsage {
    NONE {
        @Override
        public String toString() {
            return "None";
        }
    },
    ONE_YEAR {
        @Override
        public String toString() {
            return "1 Year";
        }
    },
    THREE_YEARS {
        @Override
        public String toString() {
            return "3 Years";
        }
    }
}
