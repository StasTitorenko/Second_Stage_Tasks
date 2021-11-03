package hurtMePlenty.featuredCategories;

public enum DataCenter {
    IOWA {
        @Override
        public String toString() {
            return "Iowa";
        }
    },
    SOUTH_CAROLINA {
        @Override
        public String toString() {
            return "South Carolina";
        }
    },
    NORTHERN_VIRGINIA {
        @Override
        public String toString() {
            return "Northern Virginia";
        }
    }
}
