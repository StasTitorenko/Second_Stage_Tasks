package hurtMePlenty.featuredCategories;

public enum NumberOfSSD {
    NULL {
        @Override
        public String toString() {
            return "0";
        }
    },
    ONE_X_375_GB {
        @Override
        public String toString() {
            return "1";
        }
    },
    TWO_X_375_GB {
        @Override
        public String toString() {
            return "2";
        }
    }
}
